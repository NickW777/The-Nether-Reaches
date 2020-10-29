package com.nick777.netherreaches.common.world;

import com.nick777.netherreaches.common.biome.BiomeLayers;
import com.nick777.netherreaches.common.biome.damp.DampBiome;
import com.nick777.netherreaches.common.biome.hanging.HangingBiome;
import com.nick777.netherreaches.common.biome.heated.HeatedBiome;
import com.nick777.netherreaches.common.biome.island.IslandBiome;
import com.nick777.netherreaches.common.util.Curve;
import com.nick777.netherreaches.common.util.RegionInterpolator;
import com.nick777.netherreaches.common.world.noise.OctaveNoiseSampler;
import com.nick777.netherreaches.common.world.noise.PerlinNoiseSampler;
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
    private final OctaveNoiseSampler heatedSurfaceNoise;
    private final OctaveNoiseSampler dampSurfaceNoise;
    private final OctaveNoiseSampler ridgedHangingNoise;
    private final OctaveNoiseSampler islandNoise;
    private final PerlinNoiseSampler heatedSupportNoise;
    private final PerlinNoiseSampler dampSupportNoise;

    private final BiomeWeightTable weightTable;

    public NetherReachesNoiseGenerator(Random random) {
        this.worldNoise = OctaveNoiseSampler.perlin(random, 3);
        this.worldNoise.setAmplitude(5.0);
        this.worldNoise.setFrequency(0.1);

        this.hangingSurfaceNoise = OctaveNoiseSampler.perlin(random, 8);
        this.hangingSurfaceNoise.setAmplitude(3.0);
        this.hangingSurfaceNoise.setFrequency(0.04);

        this.heatedSurfaceNoise = OctaveNoiseSampler.perlin(random, 6);
        this.heatedSurfaceNoise.setAmplitude(3.0);
        this.heatedSurfaceNoise.setFrequency(0.04);

        this.dampSurfaceNoise = OctaveNoiseSampler.perlin(random, 6);
        this.dampSurfaceNoise.setAmplitude(3.0);
        this.dampSurfaceNoise.setFrequency(0.04);

        this.ridgedHangingNoise = OctaveNoiseSampler.ridged(random, 3, 4.0);
        this.ridgedHangingNoise.setAmplitude(3.0);
        this.ridgedHangingNoise.setFrequency(0.08);

        this.islandNoise = OctaveNoiseSampler.perlin(random, 8);
        this.islandNoise.setAmplitude(3.0);
        this.islandNoise.setFrequency(0.06);

        this.heatedSupportNoise = new PerlinNoiseSampler(random);
        this.heatedSupportNoise.setFrequency(0.2);

        this.dampSupportNoise = new PerlinNoiseSampler(random);
        this.dampSupportNoise.setFrequency(0.2);

        this.weightTable = new BiomeWeightTable(BIOME_WEIGHT_RADIUS);
    }

    public double[] sampleChunkNoise(ChunkPos chunkPos, BiomeLayers<Biome> hangingLayers, BiomeLayers<HeatedBiome> heatedLayers, BiomeLayers<DampBiome> dampLayers, BiomeLayers<IslandBiome> islandLayers) {
        int globalX = chunkPos.x * NOISE_WIDTH;
        int globalZ = chunkPos.z * NOISE_WIDTH;

        double[] noise = new double[BUFFER_HEIGHT * BUFFER_WIDTH * BUFFER_WIDTH];
        double[] column = new double[BUFFER_HEIGHT];

        int index = 0;
        for (int localZ = 0; localZ < BUFFER_WIDTH; localZ++) {
            for (int localX = 0; localX < BUFFER_WIDTH; localX++) {
                this.populateColumnNoise(column, globalX + localX, globalZ + localZ, hangingLayers, heatedLayers, dampLayers, islandLayers);

                System.arraycopy(column, 0, noise, index, column.length);
                index += BUFFER_HEIGHT;
            }
        }

        return noise;
    }

    public void populateColumnNoise(double[] noise, int x, int z, BiomeLayers<Biome> hangingLayers, BiomeLayers<HeatedBiome> heatedLayers, BiomeLayers<DampBiome> dampLayers, BiomeLayers<IslandBiome> islandLayers) {
        BiomeProperties properties = this.computeBiomeProperties(hangingLayers, heatedLayers, dampLayers, islandLayers, x, z);

        float heightOrigin = (float) SURFACE_LEVEL / VERTICAL_GRANULARITY;
        float maxHeight = 256.0F / VERTICAL_GRANULARITY + 1;

        float minHeatedHeight = (float) MIN_HEATED_HEIGHT / VERTICAL_GRANULARITY;
        float maxHeatedHeight = (float) MAX_HEATED_HEIGHT / VERTICAL_GRANULARITY;
        float heatedHeightRange = maxHeatedHeight - minHeatedHeight;

        float minDampHeight = (float) MIN_DAMP_HEIGHT / VERTICAL_GRANULARITY;
        float maxDampHeight = (float) MAX_DAMP_HEIGHT / VERTICAL_GRANULARITY;
        float dampHeightRange = maxDampHeight - minDampHeight;

        float minIslandHeight = (float) MIN_ISLAND_HEIGHT / VERTICAL_GRANULARITY;
        float maxIslandHeight = (float) MAX_ISLAND_HEIGHT / VERTICAL_GRANULARITY;
        float islandHeightRange = maxIslandHeight - minIslandHeight;

        float hangingSurfaceHeight = heightOrigin - properties.hangingHeightDepth;
        float heatedFloorHeight = properties.heatedFloorHeight * heatedHeightRange + minHeatedHeight;
        float heatedCeilingHeight = properties.heatedCeilingHeight * heatedHeightRange + minHeatedHeight;
        float dampFloorHeight = properties.dampFloorHeight * dampHeightRange + minDampHeight;
        float dampCeilingHeight = properties.dampCeilingHeight * dampHeightRange + minDampHeight;

        double heatedCenter = (heatedFloorHeight + heatedCeilingHeight) / 2.0;
        double heatedHeight = heatedCeilingHeight - heatedFloorHeight;

        double dampCenter = (dampFloorHeight + dampCeilingHeight) / 2.0;
        double dampHeight = dampCeilingHeight - dampFloorHeight;

        float hangingHeightVariation = properties.hangingHeightScale * 0.9F + 0.1F;
        float heatedHeightVariation = properties.heatedHeightScale * 0.9F + 0.1F;
        float dampHeightVariation = properties.dampHeightScale * 0.9F + 0.1F;

        double perlinHangingSurfaceNoise = (this.hangingSurfaceNoise.get(x - 500, z - 500) + 1.5) / 3.0;
        double perlinHeatedSurfaceNoise = (this.heatedSurfaceNoise.get(x, z) + 1.5) / 3.0;
        double perlinDampSurfaceNoise = (this.dampSurfaceNoise.get(x + 500, z + 500) + 1.5) / 3.0;
        double ridgedHangingNoise = (this.ridgedHangingNoise.get(x, z) + 1.5) / 3.0;

        double heatedSupportDensity = Math.pow((this.heatedSupportNoise.get(x, z) + 1.0) * 0.5, 4.0);
        double dampSupportDensity = Math.pow((this.dampSupportNoise.get(x + 678, z + 1234) + 1.0) * 0.5, 4.0);

        double hangingHeightVariationScale = Math.pow(hangingHeightVariation * 2.0, 3.0);
        double heatedHeightVariationScale = Math.pow(heatedHeightVariation * 2.0, 3.0);
        double dampHeightVariationScale = Math.pow(dampHeightVariation * 2.0, 3.0);

        double surfaceHeight = perlinHangingSurfaceNoise + (ridgedHangingNoise - perlinHangingSurfaceNoise) * properties.hangingRidgeWeight;
        surfaceHeight = hangingSurfaceHeight - (surfaceHeight * hangingHeightVariation * 4.0);

        double heatedRegionStart = heatedFloorHeight + (perlinHangingSurfaceNoise * heatedHeightVariation * 2.0);
        double heatedRegionEnd = heatedCeilingHeight + (perlinHeatedSurfaceNoise * 0.15);

        double dampRegionStart = dampFloorHeight + (perlinDampSurfaceNoise * dampHeightVariation * 2.0);
        double dampRegionEnd = dampCeilingHeight + (perlinDampSurfaceNoise * 0.15);

        double curveRange = 8.0 / VERTICAL_GRANULARITY;
        RegionInterpolator.Region[] regions = new RegionInterpolator.Region[]{
                RegionInterpolator.region(0.0, surfaceHeight, -surfaceHeight, surfaceHeight),
                RegionInterpolator.region(surfaceHeight, dampRegionStart, 2.5, curveRange),
                RegionInterpolator.region(dampRegionStart, dampRegionEnd, properties.dampDensity, curveRange),
                RegionInterpolator.region(dampRegionEnd, heatedRegionStart, 3.0, curveRange),
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
            double dampWeight = 1.0 - heatedWeight;

            double densityBias = interpolator.get(y);

            double heatedCenterDistance = Math.min(Math.abs(y - heatedCenter) / heatedHeight, 1.0);
            double heatedSupportFalloff = Math.max(1.0 - Math.pow(heatedCenterDistance, 2.0), 0.0) * 0.125;

            double dampCenterDistance = Math.min(Math.abs(y - dampCenter) / dampHeight, 1.0);
            double dampSupportFalloff = Math.max(1.0 - Math.pow(dampCenterDistance, 2.0), 0.0) * 0.125;

            densityBias += (Math.max(heatedSupportDensity * 3.5 - heatedSupportFalloff, 0.0) * heatedWeight * 5.0) * properties.heatedSupportWeight;
            densityBias += (Math.max(dampSupportDensity * 3.5 - dampSupportFalloff, 0.0) * dampWeight * 5.0) * properties.dampSupportWeight;

            double sampledNoise = this.worldNoise.get(x, y, z);

            double surfaceNoiseDensity = sampledNoise * hangingHeightVariationScale;
            double heatedNoiseDensity = sampledNoise * heatedHeightVariationScale;
            double dampNoiseDensity = sampledNoise * dampHeightVariationScale;
            double noiseDensity = (surfaceNoiseDensity * surfaceWeight) + (heatedNoiseDensity * heatedWeight) + (dampNoiseDensity * dampWeight);

            noise[y] = noiseDensity + densityBias;
        }
    }

    private BiomeProperties computeBiomeProperties(BiomeLayers<Biome> hangingLayers, BiomeLayers<HeatedBiome> heatedLayers, BiomeLayers<DampBiome> dampLayers, BiomeLayers<IslandBiome> islandLayers, int x, int z) {
        BiomeProperties properties = BIOME_PROPERTIES;
        properties.zero();

        float totalWeight = 0.0F;

        Biome originBiome = hangingLayers.noise.sample(x, z);
        for (int neighborZ = -BIOME_WEIGHT_RADIUS; neighborZ <= BIOME_WEIGHT_RADIUS; neighborZ++) {
            for (int neighborX = -BIOME_WEIGHT_RADIUS; neighborX <= BIOME_WEIGHT_RADIUS; neighborX++) {
                Biome neighborBiome = hangingLayers.noise.sample(x + neighborX, z + neighborZ);
                HeatedBiome neighborHeatedBiome = heatedLayers.noise.sample(x + neighborX, z + neighborZ);
                DampBiome neighborDampBiome = dampLayers.noise.sample(x + neighborX, z + neighborZ);
                IslandBiome neighborIslandBiome = islandLayers.noise.sample(x + neighborX, z + neighborZ);

                float nDepth = neighborBiome.getDepth();
                float nScale = neighborBiome.getScale();

                float nRidgeWeight = 0.0F;
                float nDensityScale = 1.0F;

                if (neighborBiome instanceof HangingBiome) {
                    HangingBiome hangingBiome = (HangingBiome) neighborBiome;
                    nRidgeWeight = hangingBiome.getRidgeWeight();
                    nDensityScale = hangingBiome.getDensityScale();
                }

                float nHeatedFloorHeight = neighborHeatedBiome.getFloorHeight();
                float nHeatedCeilingHeight = neighborHeatedBiome.getCeilingHeight();
                float nHeatedDensity = neighborHeatedBiome.getHeatedDensity();
                float nHeatedHeightScale = neighborHeatedBiome.getHeightScale();
                float nHeatedSupportWeight = neighborHeatedBiome.getSupportWeight();

                float nDampFloorHeight = neighborDampBiome.getFloorHeight();
                float nDampCeilingHeight = neighborDampBiome.getCeilingHeight();
                float nDampDensity = neighborDampBiome.getDampDensity();
                float nDampHeightScale = neighborDampBiome.getHeightScale();
                float nDampSupportWeight = neighborDampBiome.getSupportWeight();

                float nIslandSurfaceHeight = neighborIslandBiome.getSurfaceHeight();
                float nIslandBottomHeight = neighborIslandBiome.getBottomHeight();
                float nIslandDensity = neighborIslandBiome.getIslandDensity();
                float nIslandHeightScale = neighborIslandBiome.getHeightScale();

                float biomeWeight = this.weightTable.get(neighborX, neighborZ) / (nDepth + 2.0F);
                if (neighborBiome.getDepth() > originBiome.getDepth()) {
                    biomeWeight *= 2.0F;
                }

                properties.hangingHeightScale += nScale * biomeWeight;
                properties.hangingHeightDepth += nDepth * biomeWeight;
                properties.hangingRidgeWeight += nRidgeWeight * biomeWeight;
                properties.hangingDensityScale += nDensityScale * biomeWeight;
                properties.heatedFloorHeight += nHeatedFloorHeight * biomeWeight;
                properties.heatedCeilingHeight += nHeatedCeilingHeight * biomeWeight;
                properties.heatedDensity += nHeatedDensity * biomeWeight;
                properties.heatedHeightScale += nHeatedHeightScale * biomeWeight;
                properties.heatedSupportWeight += nHeatedSupportWeight * biomeWeight;
                properties.dampFloorHeight += nDampFloorHeight * biomeWeight;
                properties.dampCeilingHeight += nDampCeilingHeight * biomeWeight;
                properties.dampDensity += nDampDensity * biomeWeight;
                properties.dampHeightScale += nDampHeightScale * biomeWeight;
                properties.dampSupportWeight += nDampSupportWeight * biomeWeight;
                properties.islandSurfaceHeight += nIslandSurfaceHeight * biomeWeight;
                properties.islandBottomHeight += nIslandBottomHeight * biomeWeight;
                properties.islandDensity += nIslandDensity * biomeWeight;
                properties.islandHeightScale += nIslandHeightScale * biomeWeight;

                totalWeight += biomeWeight;
            }
        }

        properties.normalize(totalWeight);

        return properties;
    }

    private static class BiomeProperties {
        float hangingHeightScale;
        float hangingHeightDepth;
        float hangingDensityScale;
        float hangingRidgeWeight;
        float heatedFloorHeight;
        float heatedCeilingHeight;
        float heatedDensity;
        float heatedHeightScale;
        float heatedSupportWeight;
        float dampFloorHeight;
        float dampCeilingHeight;
        float dampDensity;
        float dampHeightScale;
        float dampSupportWeight;
        float islandSurfaceHeight;
        float islandBottomHeight;
        float islandDensity;
        float islandHeightScale;


        void zero() {
            this.hangingHeightScale = 0.0F;
            this.hangingHeightDepth = 0.0F;
            this.hangingRidgeWeight = 0.0F;
            this.hangingDensityScale = 0.0F;
            this.heatedFloorHeight = 0.0F;
            this.heatedCeilingHeight = 0.0F;
            this.heatedDensity = 0.0F;
            this.heatedHeightScale = 0.0F;
            this.heatedSupportWeight = 0.0F;
            this.dampFloorHeight = 0.0F;
            this.dampCeilingHeight = 0.0F;
            this.dampDensity = 0.0F;
            this.dampHeightScale = 0.0F;
            this.dampSupportWeight = 0.0F;
            this.islandSurfaceHeight = 0.0F;
            this.islandBottomHeight = 0.0F;
            this.islandDensity = 0.0F;
            this.islandHeightScale = 0.0F;
        }

        void normalize(float weight) {
            this.hangingHeightScale /= weight;
            this.hangingHeightDepth /= weight;
            this.hangingRidgeWeight /= weight;
            this.hangingDensityScale /= weight;
            this.heatedFloorHeight /= weight;
            this.heatedCeilingHeight /= weight;
            this.heatedDensity /= weight;
            this.heatedHeightScale /= weight;
            this.heatedSupportWeight /= weight;
            this.dampFloorHeight /= weight;
            this.dampCeilingHeight /= weight;
            this.dampDensity /= weight;
            this.dampHeightScale /= weight;
            this.dampSupportWeight /= weight;
            this.islandSurfaceHeight /= weight;
            this.islandBottomHeight /= weight;
            this.islandDensity /= weight;
            this.islandHeightScale /= weight;
        }
    }
}
