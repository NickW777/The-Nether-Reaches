package com.nick777.netherreaches.common.biome.hanging;

import com.nick777.netherreaches.common.biome.ConfigurableBiome;
import com.nick777.netherreaches.common.world.NetherReachesChunkGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

public abstract class HangingBiome extends Biome implements ConfigurableBiome {
    private final float ridgeWeight;
    private final float densityScale;

    private final int grassColor;
    private final int foliageColor;
    private final int skyColor;

    private final float fogStart;
    private final float fogEnd;

    protected HangingBiome(Properties properties) {
        super(properties);

        this.ridgeWeight = properties.ridgeWeight;
        this.densityScale = properties.densityScale;

        this.grassColor = properties.grassColor;
        this.foliageColor = properties.foliageColor;
        this.skyColor = properties.skyColor;

        this.fogStart = properties.fogStart;
        this.fogEnd = properties.fogEnd;
    }

    @Override
    public boolean doesWaterFreeze(IWorldReader world, BlockPos pos) {
        return false;
    }

    @Override
    public int getGrassColor(BlockPos pos) {
        return this.grassColor;
    }

    @Override
    public int getFoliageColor(BlockPos pos) {
        return this.foliageColor;
    }

    public float getRidgeWeight() {
        return this.ridgeWeight;
    }

    public float getDensityScale() {
        return this.densityScale;
    }

    public int getSkyColor() {
        return this.skyColor;
    }

    public float getFogStart() {
        return this.fogStart;
    }

    public float getFogEnd() {
        return this.fogEnd;
    }

    @Override
    public int getSkyColorByTemp(float temperature) {
        return this.skyColor;
    }

    @Override
    public void add(GenerationStage.Decoration stage, ConfiguredFeature<?> feature) {
        super.addFeature(stage, feature);
    }

    @Override
    public <C extends ICarverConfig> void add(GenerationStage.Carving stage, ConfiguredCarver<C> carver) {
        super.addCarver(stage, carver);
    }

    @Override
    public <C extends IFeatureConfig> void add(Structure<C> structure, C config) {
        super.addStructure(structure, config);
    }

    @Override
    public void add(EntityClassification classification, SpawnListEntry entry) {
        super.addSpawn(classification, entry);
    }

    @Override
    public void placeFeatures(GenerationStage.Decoration stage, NetherReachesChunkGenerator generator, WorldGenRegion world, long seed, SharedSeedRandom random, BlockPos origin) {
        this.decorate(stage, generator, world, seed, random, origin);
    }

    @Override
    public void generateSurface(SharedSeedRandom random, IChunk chunk, int x, int z, int y, double depth, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
        this.buildSurface(random, chunk, x, z, y, depth, defaultBlock, defaultFluid, seaLevel, seed);
    }

    @Override
    public Collection<ConfiguredCarver<?>> getCarversFor(GenerationStage.Carving stage) {
        return this.carvers.get(stage);
    }

    @Override
    public List<SpawnListEntry> getSpawnsFor(EntityClassification classification) {
        return this.getSpawns(classification);
    }

    public static class Properties extends Biome.Builder {
        private float ridgeWeight = 1.0F;
        private float densityScale = 1.0F;
        private int grassColor = 0x766B9E;
        private int foliageColor = 0x8F6DBC;
        private int skyColor = 0x171B32;

        private float fogStart = 20.0F;
        private float fogEnd = 140.0F;

        public Properties() {
            super.precipitation(RainType.NONE);
            super.downfall(0.0F);
            super.temperature(0.0F);
            super.waterColor(0x361D78);
            super.waterFogColor(0x50533);
        }

        public Properties ridgeWeight(float ridgeWeight) {
            this.ridgeWeight = ridgeWeight;
            return this;
        }

        public Properties densityScale(float densityScale) {
            this.densityScale = densityScale;
            return this;
        }

        public Properties grassColor(int grassColor) {
            this.grassColor = grassColor;
            return this;
        }

        public Properties foliageColor(int foliageColor) {
            this.foliageColor = foliageColor;
            return this;
        }

        public Properties skyColor(int skyColor) {
            this.skyColor = skyColor;
            return this;
        }

        public Properties fog(float start, float end) {
            this.fogStart = start;
            this.fogEnd = end;
            return this;
        }

        @Override
        public <SC extends ISurfaceBuilderConfig> Properties surfaceBuilder(SurfaceBuilder<SC> surface, SC config) {
            super.surfaceBuilder(surface, config);
            return this;
        }

        @Override
        public Properties surfaceBuilder(ConfiguredSurfaceBuilder<?> surface) {
            super.surfaceBuilder(surface);
            return this;
        }

        @Override
        public Properties precipitation(RainType rainType) {
            super.precipitation(rainType);
            return this;
        }

        @Override
        public Properties category(Category category) {
            super.category(category);
            return this;
        }

        @Override
        public Properties depth(float depth) {
            super.depth(depth);
            return this;
        }

        @Override
        public Properties scale(float scale) {
            super.scale(scale);
            return this;
        }

        @Override
        public Properties temperature(float temperature) {
            super.temperature(temperature);
            return this;
        }

        @Override
        public Properties downfall(float downfall) {
            super.downfall(downfall);
            return this;
        }

        @Override
        public Properties waterColor(int waterColor) {
            super.waterColor(waterColor);
            return this;
        }

        @Override
        public Properties waterFogColor(int waterFogColor) {
            super.waterFogColor(waterFogColor);
            return this;
        }

        @Override
        public Properties parent(@Nullable String parent) {
            super.parent(parent);
            return this;
        }
    }
}