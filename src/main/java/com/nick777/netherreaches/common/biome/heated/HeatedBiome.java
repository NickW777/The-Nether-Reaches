package com.nick777.netherreaches.common.biome.heated;

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

public abstract class HeatedBiome extends ForgeRegistryEntry<HeatedBiome> implements ConfigurableBiome {
    protected final ConfiguredSurfaceBuilder<?> surfaceBuilder;
    protected final float heatedDensity;
    protected final float floorHeight;
    protected final float ceilingHeight;
    protected final float heightScale;

    protected final Multimap<GenerationStage.Carving, ConfiguredCarver<?>> carvers = HashMultimap.create();
    protected final Multimap<GenerationStage.Decoration, ConfiguredFeature<?>> features = HashMultimap.create();
    protected final List<ConfiguredFeature<?>> flowers = new ArrayList<>();
    protected final Map<Structure<?>, IFeatureConfig> structures = new HashMap<>();
    protected final Map<EntityClassification, List<Biome.SpawnListEntry>> spawns = new HashMap<>();

    public HeatedBiome(Properties properties) {
        Preconditions.checkNotNull(properties.surfaceBuilder, "must have surfacebuilder");

        this.surfaceBuilder = properties.surfaceBuilder;
        this.heatedDensity = properties.heatedDensity;
        this.floorHeight = properties.floorHeight;
        this.ceilingHeight = properties.ceilingHeight;
        this.heightScale = properties.heightScale;
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

    public float getHeatedDensity() {
        return this.heatedDensity;
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

    public static class Properties {
        private ConfiguredSurfaceBuilder<?> surfaceBuilder;
        private float heatedDensity = -5.0F;
        private float floorHeight = 0.0F;
        private float ceilingHeight = 1.0F;
        private float heightScale = 0.1F;
        private float pillarWeight = 1.0F;

        protected Properties() {
        }

        public <SC extends ISurfaceBuilderConfig> Properties surfaceBuilder(SurfaceBuilder<SC> surface, SC config) {
            this.surfaceBuilder = new ConfiguredSurfaceBuilder<>(surface, config);
            return this;
        }

        public Properties heatedDensity(float density) {
            this.heatedDensity = density;
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

        public Properties pillarWeight(float pillarWeight) {
            this.pillarWeight = pillarWeight;
            return this;
        }
    }
}
