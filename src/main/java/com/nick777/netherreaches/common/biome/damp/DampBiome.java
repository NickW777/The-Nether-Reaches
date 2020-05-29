package com.nick777.netherreaches.common.biome.damp;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.nick777.netherreaches.common.biome.ConfigurableBiome;
import com.nick777.netherreaches.common.world.NetherReachesChunkGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.*;

public abstract class DampBiome extends ForgeRegistryEntry<DampBiome> implements ConfigurableBiome {
    protected final ConfiguredSurfaceBuilder<?> surfaceBuilder;
    protected final float dampDensity;
    protected final float floorHeight;
    protected final float ceilingHeight;
    protected final float heightScale;
    protected final float supportWeight;
    protected final float lakeSize;

    protected final Multimap<GenerationStage.Carving, ConfiguredCarver<?>> carvers = HashMultimap.create();
    protected final Multimap<GenerationStage.Decoration, ConfiguredFeature<?>> features = HashMultimap.create();
    protected final List<ConfiguredFeature<?>> flowers = new ArrayList<>();
    protected final Map<Structure<?>, IFeatureConfig> structures = new HashMap<>();
    protected final Map<EntityClassification, List<Biome.SpawnListEntry>> spawns = new HashMap<>();

    public DampBiome(Properties properties) {
        Preconditions.checkNotNull(properties.surfaceBuilder, "must have surfacebuilder");

        this.surfaceBuilder = properties.surfaceBuilder;
        this.dampDensity = properties.dampDensity;
        this.floorHeight = properties.floorHeight;
        this.ceilingHeight = properties.ceilingHeight;
        this.heightScale = properties.heightScale;
        this.supportWeight = properties.supportWeight;
        this.lakeSize = properties.lakeSize;
    }

    @Override
    public void add(GenerationStage.Decoration stage, ConfiguredFeature<?> feature) {
        if (feature.feature == Feature.DECORATED_FLOWER) {
            this.flowers.add(feature);
        }
        this.features.put(stage, feature);
    }

    @Override
    public <C extends ICarverConfig> void add(GenerationStage.Carving stage, ConfiguredCarver<C> carver) {
        this.carvers.put(stage, carver);
    }

    @Override
    public <C extends IFeatureConfig> void add(Structure<C> structure, C config) {
        this.structures.put(structure, config);
    }

    @Override
    public void add(EntityClassification classification, Biome.SpawnListEntry entry) {
        this.getSpawnsFor(classification).add(entry);
    }

    @Override
    public void placeFeatures(GenerationStage.Decoration stage, NetherReachesChunkGenerator generator, WorldGenRegion world, long seed, SharedSeedRandom random, BlockPos origin) {
        int index = 0;

        for (ConfiguredFeature<?> feature : this.features.get(stage)) {
            random.setFeatureSeed(seed, index, stage.ordinal());
            feature.place(world, generator, random, origin);

            index++;
        }
    }

    @Override
    public void generateSurface(SharedSeedRandom random, IChunk chunk, int x, int z, int startY, double depth, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
        this.surfaceBuilder.setSeed(seed);
        this.surfaceBuilder.buildSurface(random, chunk, Biomes.DEFAULT, x, z, startY, depth, defaultBlock, defaultFluid, seaLevel, seed);
    }

    @Override
    public Collection<ConfiguredCarver<?>> getCarversFor(GenerationStage.Carving stage) {
        return this.carvers.get(stage);
    }

    @Override
    public List<Biome.SpawnListEntry> getSpawnsFor(EntityClassification classification) {
        return this.spawns.computeIfAbsent(classification, c -> new ArrayList<>());
    }

    public float getDampDensity() {
        return this.dampDensity;
    }

    public float getFloorHeight() {
        return this.floorHeight;
    }

    public float getCeilingHeight() {
        return this.ceilingHeight;
    }

    public float getHeightScale() {
        return this.heightScale;
    }

    public float getLakeSize() {
        return this.lakeSize;
    }

    public float getSupportWeight() {
        return this.supportWeight;
    }

    public static class Properties {
        public float lakeSize = 1;
        private ConfiguredSurfaceBuilder<?> surfaceBuilder;
        private float dampDensity = -5.0F;
        private float floorHeight = 0.0F;
        private float ceilingHeight = 1.0F;
        private float heightScale = 0.1F;
        private float supportWeight = 1.0F;

        protected Properties() {
        }

        public <SC extends ISurfaceBuilderConfig> Properties surfaceBuilder(SurfaceBuilder<SC> surface, SC config) {
            this.surfaceBuilder = new ConfiguredSurfaceBuilder<>(surface, config);
            return this;
        }

        public Properties dampDensity(float density) {
            this.dampDensity = density;
            return this;
        }

        public Properties floorHeight(float floorHeight) {
            this.floorHeight = floorHeight;
            return this;
        }

        public Properties ceilingHeight(float ceilingHeight) {
            this.ceilingHeight = ceilingHeight;
            return this;
        }

        public Properties heightScale(float heightScale) {
            this.heightScale = heightScale;
            return this;
        }

        public Properties supportWeight(float supportWeight) {
            this.supportWeight = supportWeight;
            return this;
        }

        public Properties lakeSize(float lakeSize) {
            this.lakeSize = lakeSize;
            return this;
        }
    }
}
