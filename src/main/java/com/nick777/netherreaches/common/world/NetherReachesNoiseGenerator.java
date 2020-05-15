package com.nick777.netherreaches.common.world;

import com.nick777.netherreaches.common.biome.BiomeLayers;
import com.nick777.netherreaches.common.biome.hanging.HangingBiome;
import com.nick777.netherreaches.common.biome.heated.HeatedBiome;
import com.nick777.netherreaches.common.util.Curve;
import com.nick777.netherreaches.common.util.RegionInterpolator;
import com.nick777.netherreaches.common.world.noise.OctaveNoiseSampler;
import com.nick777.netherreaches.common.world.util.BiomeWeightTable;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;

import java.util.Random;

import static com.nick777.netherreaches.common.world.NetherReachesChunkGenerator.*;


public class NetherReachesNoiseGenerator {
    private static final BiomeProperties BIOME_PROPERTIES = new BiomeProperties();

    public static final int HORIZONTAL_GRANULARITY = 4;
    public static final int VERTICAL_GRANULARITY = 4;

    public static final int NOISE_WIDTH = 16 / HORIZONTAL_GRANULARITY;
    public static final int NOISE_HEIGHT = 256 / VERTICAL_GRANULARITY;

    private static final int BUFFER_WIDTH = NOISE_WIDTH + 1;
    private static final int BUFFER_HEIGHT = NOISE_HEIGHT + 1;

    private static final int BIOME_WEIGHT_RADIUS = 2;

    private static final int NOISE_SURFACE_CAVE_BOUNDARY = LOWER_CAVE_BOUNDARY / VERTICAL_GRANULARITY;

    private final OctaveNoiseSampler worldNoise;
    private final OctaveNoiseSampler hangingSurfaceNoise;
    private final OctaveNoiseSampler ceilingNoise;
    private final OctaveNoiseSampler ridgedSurfaceNoise;

    private final BiomeWeightTable weightTable;

    public NetherReachesNoiseGenerator(Random random) {
        this.worldNoise = OctaveNoiseSampler.perlin(random, 3);
        this.worldNoise.setAmplitude(5.0);
        this.worldNoise.setFrequency(0.1);

        this.hangingSurfaceNoise = OctaveNoiseSampler.perlin(random, 8);
        this.hangingSurfaceNoise.setAmplitude(3.0);
        this.hangingSurfaceNoise.setFrequency(0.04);

        this.ceilingNoise = OctaveNoiseSampler.perlin(random, 6);
        this.ceilingNoise.setAmplitude(3.0);
        this.ceilingNoise.setFrequency(0.04);

        this.ridgedSurfaceNoise = OctaveNoiseSampler.ridged(random, 3, 4.0);
        this.ridgedSurfaceNoise.setAmplitude(3.0);
        this.ridgedSurfaceNoise.setFrequency(0.08);

        this.weightTable = new BiomeWeightTable(BIOME_WEIGHT_RADIUS);
    }

    public double[] sampleChunkNoise(ChunkPos chunkPos, BiomeLayers<Biome> surfaceLayers, BiomeLayers<HeatedBiome> undergroundLayers) {
        int globalX = chunkPos.x * NOISE_WIDTH;
        int globalZ = chunkPos.z * NOISE_WIDTH;

        double[] noise = new double[BUFFER_HEIGHT * BUFFER_WIDTH * BUFFER_WIDTH];
        double[] column = new double[BUFFER_HEIGHT];

        int index = 0;
        for (int localZ = 0; localZ < BUFFER_WIDTH; localZ++) {
            for (int localX = 0; localX < BUFFER_WIDTH; localX++) {
                this.populateColumnNoise(column, globalX + localX, globalZ + localZ, surfaceLayers, undergroundLayers);

                System.arraycopy(column, 0, noise, index, column.length);
                index += BUFFER_HEIGHT;
            }
        }

        return noise;
    }

    public void populateColumnNoise(double[] noise, int x, int z, BiomeLayers<Biome> surfaceLayers, BiomeLayers<HeatedBiome> undergroundLayers) {
        BiomeProperties properties = this.computeBiomeProperties(surfaceLayers, undergroundLayers, x, z);

        float heightOrigin = (float) SURFACE_LEVEL / VERTICAL_GRANULARITY;
        float maxHeight = 256.0F / VERTICAL_GRANULARITY + 1;

        float minCaveHeight = (float) MIN_CAVE_HEIGHT / VERTICAL_GRANULARITY;
        float maxCaveHeight = (float) MAX_CAVE_HEIGHT / VERTICAL_GRANULARITY;
        float caveHeightRange = maxCaveHeight - minCaveHeight;

        float baseHeight = heightOrigin - properties.heightDepth;
        float heatedFloorHeight = properties.heatedFloorHeight * caveHeightRange + minCaveHeight;
        float heatedCeilingHeight = properties.heatedCeilingHeight * caveHeightRange + minCaveHeight;

        double heatedCenter = (heatedFloorHeight + heatedCeilingHeight) / 2.0;
        double heatedHeight = heatedCeilingHeight - heatedFloorHeight;

        float heightVariation = properties.heightScale * 0.9F + 0.1F;
        float heatedHeightVariation = properties.heatedHeightScale * 0.9F + 0.1F;

        double perlinHangingSurfaceNoise = (this.hangingSurfaceNoise.get(x, z) + 1.5) / 3.0;
        double perlinCeilingNoise = (this.ceilingNoise.get(x, z) + 1.5) / 3.0;
        double ridgedSurfaceNoise = (this.ridgedSurfaceNoise.get(x, z) + 1.5) / 3.0;

        double hangingSurfaceHeightVariationScale = Math.pow(heightVariation * 2.0, 3.0);
        double heatedHeightVariationScale = Math.pow(heatedHeightVariation * 2.0, 3.0);

        double surfaceHeight = perlinHangingSurfaceNoise + (ridgedSurfaceNoise - perlinHangingSurfaceNoise) * properties.ridgeWeight;
        surfaceHeight = baseHeight - (surfaceHeight * heightVariation * 4.0);

        double heatedRegionStart = heatedFloorHeight + (perlinHangingSurfaceNoise * heatedHeightVariation * 2.0);
        double heatedRegionEnd = heatedCeilingHeight + (perlinCeilingNoise * 0.15);

        double curveRange = 8.0 / VERTICAL_GRANULARITY;
        RegionInterpolator.Region[] regions = new RegionInterpolator.Region[] {
                RegionInterpolator.region(0.0, surfaceHeight,-surfaceHeight,surfaceHeight),
                RegionInterpolator.region(surfaceHeight, heatedRegionStart, 2.5, curveRange),
                RegionInterpolator.region(heatedRegionStart, heatedRegionEnd, properties.heatedDensity, curveRange),
                RegionInterpolator.region(heatedRegionEnd, maxHeight, 3.5, curveRange)
        };

        RegionInterpolator interpolator = new RegionInterpolator(regions, Curve.linear());

        for (int y = 0; y < NOISE_HEIGHT + 1; y++) {
            if (y == NOISE_SURFACE_CAVE_BOUNDARY) {
                noise[y] = 5.0;
                continue;
            }

            double surfaceWeight = MathHelper.clamp((y - heatedRegionEnd) / (surfaceHeight - heatedRegionEnd), 0.0, 1.0);
            double heatedWeight = 1.0 - surfaceWeight;

            double densityBias = interpolator.get(y);

            double heatedCenterDistance = Math.min(Math.abs(y - heatedCenter) / heatedHeight, 1.0);

            double sampledNoise = this.worldNoise.get(x, y, z);

            double surfaceNoiseDensity = sampledNoise * hangingSurfaceHeightVariationScale;
            double heatedNoiseDensity = sampledNoise * heatedHeightVariationScale;
            double noiseDensity = (surfaceNoiseDensity * surfaceWeight) + (heatedNoiseDensity * heatedWeight);

            noise[y] = noiseDensity + densityBias;
        }
    }

    private BiomeProperties computeBiomeProperties(BiomeLayers<Biome> surfaceLayers, BiomeLayers<HeatedBiome> undergroundLayers, int x, int z) {
        BiomeProperties properties = BIOME_PROPERTIES;
        properties.zero();

        float totalWeight = 0.0F;

        Biome originBiome = surfaceLayers.noise.sample(x, z);
        for (int neighborZ = -BIOME_WEIGHT_RADIUS; neighborZ <= BIOME_WEIGHT_RADIUS; neighborZ++) {
            for (int neighborX = -BIOME_WEIGHT_RADIUS; neighborX <= BIOME_WEIGHT_RADIUS; neighborX++) {
                Biome neighborBiome = surfaceLayers.noise.sample(x + neighborX, z + neighborZ);
                HeatedBiome neighborCavernBiome = undergroundLayers.noise.sample(x + neighborX, z + neighborZ);

                float nDepth = neighborBiome.getDepth();
                float nScale = neighborBiome.getScale();

                float nRidgeWeight = 0.0F;
                float nDensityScale = 1.0F;

                if (neighborBiome instanceof HangingBiome) {
                    HangingBiome hangingBiome = (HangingBiome) neighborBiome;
                    nRidgeWeight = hangingBiome.getRidgeWeight();
                    nDensityScale = hangingBiome.getDensityScale();
                }

                float nCavernFloorHeight = neighborCavernBiome.getFloorHeight();
                float nCavernCeilingHeight = neighborCavernBiome.getCeilingHeight();
                float nCavernDensity = neighborCavernBiome.getHeatedDensity();
                float nCavernHeightScale = neighborCavernBiome.getHeightScale();

                float biomeWeight = this.weightTable.get(neighborX, neighborZ) / (nDepth + 2.0F);
                if (neighborBiome.getDepth() > originBiome.getDepth()) {
                    biomeWeight *= 2.0F;
                }

                properties.heightScale += nScale * biomeWeight;
                properties.heightDepth += nDepth * biomeWeight;
                properties.ridgeWeight += nRidgeWeight * biomeWeight;
                properties.densityScale += nDensityScale * biomeWeight;
                properties.heatedFloorHeight += nCavernFloorHeight * biomeWeight;
                properties.heatedCeilingHeight += nCavernCeilingHeight * biomeWeight;
                properties.heatedDensity += nCavernDensity * biomeWeight;
                properties.heatedHeightScale += nCavernHeightScale * biomeWeight;

                totalWeight += biomeWeight;
            }
        }

        properties.normalize(totalWeight);

        return properties;
    }

    private static class BiomeProperties {
        float heightScale;
        float heightDepth;
        float densityScale;
        float ridgeWeight;
        float heatedFloorHeight;
        float heatedCeilingHeight;
        float heatedDensity;
        float heatedHeightScale;

        void zero() {
            this.heightScale = 0.0F;
            this.heightDepth = 0.0F;
            this.ridgeWeight = 0.0F;
            this.densityScale = 0.0F;
            this.heatedFloorHeight = 0.0F;
            this.heatedCeilingHeight = 0.0F;
            this.heatedDensity = 0.0F;
            this.heatedHeightScale = 0.0F;
        }

        void normalize(float weight) {
            this.heightScale /= weight;
            this.heightDepth /= weight;
            this.ridgeWeight /= weight;
            this.densityScale /= weight;
            this.heatedFloorHeight /= weight;
            this.heatedCeilingHeight /= weight;
            this.heatedDensity /= weight;
            this.heatedHeightScale /= weight;
        }
    }
}
