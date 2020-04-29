package com.nick777.netherreaches.common.biome;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesFeatures;
import com.nick777.netherreaches.common.registry.NetherReachesPlacements;
import com.nick777.netherreaches.common.world.feature.config.NetherReachesOreConfig;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class NetherReachesHeatedConfigurator {
    public static void addStructureFeatures(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(
//                MidnightStructures.MOLTEN_CRATER, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG)
//        );
//
//        biome.add(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(
//                MidnightStructures.SHADOWROOT_GUARDTOWER, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG)
//        );
//
//        biome.add(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(
//                MidnightStructures.WELL, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG)
//        );
    }

//    public static void addMoltenCrater(ConfigurableBiome biome) {
//        biome.add(MidnightStructures.MOLTEN_CRATER, IFeatureConfig.NO_FEATURE_CONFIG);
//    }

    public static void addGlobalOres(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.BERNEG_ORE.getDefaultState(), 14),
                Placement.COUNT_RANGE, new CountRangeConfig(8, 0, 0, 56)
        ));

        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.FARON_ORE.getDefaultState(), 4),
                Placement.COUNT_RANGE, new CountRangeConfig(6, 0, 0, 56)
        ));

        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.ILLIA_ORE.getDefaultState(), 4),
                Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 24)
        ));

        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.REGITE_ORE.getDefaultState(), 6),
                Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 24)
        ));

        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.SHARNIK_ORE.getDefaultState(), 6),
                Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 24)
        ));
    }

//    public static void addGlobalFeatures(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(
//                NetherReachesFeatures.HEAP, new UniformCompositionConfig(NetherReachesBlocks.ROCKSHROOM.getDefaultState()),
//                MidnightPlacements.CHANCE_SURFACE, new ChanceConfig(100)
//        ));
//
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                Feature.BUSH, new BushConfig(NetherReachesBlocks.GHOST_PLANT.getDefaultState()),
//                MidnightPlacements.COUNT_CHANCE_SURFACE_DOUBLE, new HeightWithChanceConfig(4, 0.3F)
//        ));
//
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                Feature.BUSH, new BushConfig(NetherReachesBlocks.DRAGON_NEST.getDefaultState()),
//                MidnightPlacements.DRAGON_NEST, IPlacementConfig.NO_PLACEMENT_CONFIG
//        ));
//
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.UNSTABLE_BUSH, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.CHANCE_SURFACE_DOUBLE, new ChanceConfig(2)
//        ));
//    }
//
//    public static void addLumen(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.LUMEN_FLOWERS, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_DOUBLE, new FrequencyConfig(1)
//        ));
//    }
//
//    public static void addNightshroomFlowers(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.NIGHTSHROOM_FLOWERS, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_32, new FrequencyConfig(10)
//        ));
//    }
//
//    public static void addDewshroomFlowers(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.DEWSHROOM_FLOWERS, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_32, new FrequencyConfig(10)
//        ));
//    }
//
//    public static void addViridshroomFlowers(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.VIRIDSHROOM_FLOWERS, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_32, new FrequencyConfig(10)
//        ));
//    }
//
//    public static void addBogshroomFlowers(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.BOGSHROOM_FLOWERS, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_32, new FrequencyConfig(10)
//        ));
//    }
//
//    public static void addMistshroomFlowers(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.MISTSHROOM_FLOWERS, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_32, new FrequencyConfig(10)
//        ));
//    }
//
//    public static void addCrystalFlowers(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.CRYSTAL_FLOWERS, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_32, new FrequencyConfig(8)
//        ));
//    }
//
//    public static void addCrystalClusters(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(
//                NetherReachesFeatures.CRYSTAL_CLUSTER, new CrystalClusterConfig(NetherReachesBlocks.BLOOMCRYSTAL_ROCK.getDefaultState(), NetherReachesBlocks.BLOOMCRYSTAL.getDefaultState()),
//                MidnightPlacements.COUNT_SURFACE, new FrequencyConfig(3)
//        ));
//
//        biome.add(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(
//                NetherReachesFeatures.CRYSTAL_SPIRE, new CrystalClusterConfig(NetherReachesBlocks.BLOOMCRYSTAL_ROCK.getDefaultState(), NetherReachesBlocks.BLOOMCRYSTAL.getDefaultState()),
//                MidnightPlacements.COUNT_SURFACE, new FrequencyConfig(2)
//        ));
//    }
//
//    public static void addGrasses(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                Feature.GRASS, new GrassFeatureConfig(NetherReachesBlocks.GRASS.getDefaultState()),
//                MidnightPlacements.COUNT_SURFACE_DOUBLE, new FrequencyConfig(3)
//        ));
//
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.DOUBLE_PLANT, new DoublePlantConfig(NetherReachesBlocks.TALL_GRASS.getDefaultState()),
//                MidnightPlacements.COUNT_SURFACE_32, new FrequencyConfig(3)
//        ));
//    }
//
//    public static void addFingeredGrass(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.FINGERED_GRASS, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_32, new FrequencyConfig(1)
//        ));
//    }
//
//    public static void addTrenchstoneBoulders(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(
//                NetherReachesFeatures.TRENCHSTONE_BOULDER, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.CHANCE_SURFACE, new ChanceConfig(3)
//        ));
//    }
//
//    public static void addNightstoneSpikesAndBoulders(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(
//                Feature.RANDOM_BOOLEAN_SELECTOR, new TwoFeatureChoiceConfig(
//                        NetherReachesFeatures.NIGHTSTONE_BOULDER, IFeatureConfig.NO_FEATURE_CONFIG,
//                        NetherReachesFeatures.SPIKE, new UniformCompositionConfig(NetherReachesBlocks.NIGHTSTONE.getDefaultState())
//                ),
//                MidnightPlacements.CHANCE_SURFACE, new ChanceConfig(4)
//        ));
//    }
//
//    public static void addSparseShadowrootTrees(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                Feature.RANDOM_BOOLEAN_SELECTOR, new TwoFeatureChoiceConfig(
//                        NetherReachesFeatures.SHADOWROOT_TREE, IFeatureConfig.NO_FEATURE_CONFIG,
//                        NetherReachesFeatures.DEAD_TREE, IFeatureConfig.NO_FEATURE_CONFIG
//                ),
//                MidnightPlacements.CHANCE_SURFACE, new ChanceConfig(5)
//        ));
//    }
//
//    public static void addSparseSuavis(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.SUAVIS, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.CHANCE_SURFACE_DOUBLE, new ChanceConfig(2)
//        ));
//    }
//
//    public static void addCommonSuavis(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.SUAVIS, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_DOUBLE, new FrequencyConfig(8)
//        ));
//    }
//
//    public static void addSparseDeadTrees(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.DEAD_TREE, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.CHANCE_SURFACE, new ChanceConfig(6)
//        ));
//    }
//
//    public static void addVioleafs(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                Feature.BUSH, new BushConfig(NetherReachesBlocks.VIOLEAF.getDefaultState().with(VioleafBlock.IS_GROWN, true)),
//                MidnightPlacements.COUNT_SURFACE_DOUBLE, new FrequencyConfig(2)
//        ));
//    }
//
//    public static void addRunebushes(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                Feature.GRASS, new GrassFeatureConfig(NetherReachesBlocks.RUNEBUSH.getDefaultState()),
//                MidnightPlacements.COUNT_SURFACE_DOUBLE, new FrequencyConfig(32)
//        ));
//    }
//
//    public static void addBogweed(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.BOGWEED_FLOWERS, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_32, new FrequencyConfig(1)
//        ));
//    }
//
//    public static void addFallenDeadLogs(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.FALLEN_DEAD_LOG, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE, new FrequencyConfig(2)
//        ));
//    }
//
    public static void addFlameForestTrees(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                        NetherReachesFeatures.CINDER_SHROOM, IFeatureConfig.NO_FEATURE_CONFIG,
                NetherReachesPlacements.COUNT_HEATED, new FrequencyConfig(8)
        ));
    }
//
//    public static void addBogTrees(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.DARK_WILLOW_TREE, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE, new FrequencyConfig(3)
//        ));
//
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.SHADOWROOT_TREE, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE, new FrequencyConfig(1)
//        ));
//    }
//
//    public static void addBogDeadTrees(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.BOG_DEAD_TREE, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.CHANCE_SURFACE, new ChanceConfig(3)
//        ));
//    }
//
//    public static void addLargeBogshrooms(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                Feature.RANDOM_BOOLEAN_SELECTOR, new TwoFeatureChoiceConfig(
//                        NetherReachesFeatures.LARGE_BOGSHROOM, IFeatureConfig.NO_FEATURE_CONFIG,
//                        NetherReachesFeatures.SMALL_BOGSHROOM, IFeatureConfig.NO_FEATURE_CONFIG
//                ),
//                MidnightPlacements.CHANCE_SURFACE, new ChanceConfig(3)
//        ));
//    }
//
//    public static void addLargeFungis(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                Feature.SIMPLE_RANDOM_SELECTOR, new SingleRandomFeature(
//                        new Feature[] { NetherReachesFeatures.LARGE_NIGHTSHROOM, NetherReachesFeatures.LARGE_DEWSHROOM, NetherReachesFeatures.LARGE_VIRIDSHROOM },
//                        new IFeatureConfig[] { IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG }
//                ),
//                MidnightPlacements.CHANCE_SURFACE, new ChanceConfig(2)
//        ));
//
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                Feature.SIMPLE_RANDOM_SELECTOR, new SingleRandomFeature(
//                        new Feature[] { NetherReachesFeatures.MEDIUM_NIGHTSHROOM, NetherReachesFeatures.MEDIUM_DEWSHROOM, NetherReachesFeatures.MEDIUM_VIRIDSHROOM },
//                        new IFeatureConfig[] { IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG }
//                ),
//                MidnightPlacements.COUNT_SURFACE, new FrequencyConfig(1)
//        ));
//
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                Feature.SIMPLE_RANDOM_SELECTOR, new SingleRandomFeature(
//                        new Feature[] { NetherReachesFeatures.SMALL_NIGHTSHROOM, NetherReachesFeatures.SMALL_DEWSHROOM, NetherReachesFeatures.SMALL_VIRIDSHROOM },
//                        new IFeatureConfig[] { IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG }
//                ),
//                MidnightPlacements.COUNT_SURFACE, new FrequencyConfig(3)
//        ));
//    }
//
//    public static void addBladeshrooms(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.BLADESHROOM, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_32, new FrequencyConfig(2)
//        ));
//    }
//
//    public static void addAlgaeAndMoss(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.DECEITFUL_ALGAE, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_DOUBLE, new FrequencyConfig(10)
//        ));
//
//        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
//                NetherReachesFeatures.DECEITFUL_MOSS, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.COUNT_SURFACE_DOUBLE, new FrequencyConfig(16)
//        ));
//    }
//
//    public static void addWell(ConfigurableBiome biome) {
//        biome.add(MidnightStructures.WELL, IFeatureConfig.NO_FEATURE_CONFIG);
//    }
//
//    public static void addShadowRootGuardTower(ConfigurableBiome biome) {
//        biome.add(MidnightStructures.SHADOWROOT_GUARDTOWER, IFeatureConfig.NO_FEATURE_CONFIG);
//    }
//
//    public static void addDeadViridShroomAndCache(ConfigurableBiome biome) {
//        biome.add(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(
//                NetherReachesFeatures.DEAD_VIRIDSHROOM_AND_CACHE, IFeatureConfig.NO_FEATURE_CONFIG,
//                MidnightPlacements.CHANCE_SURFACE, new ChanceConfig(45)
//        ));
//    }
//
//    public static void addStandardCreatureSpawns(ConfigurableBiome biome) {
//        addCreature(biome, MidnightEntities.NIGHTSTAG, 100, 1, 3);
//    }
//
//    public static void addStandardMonsterSpawns(ConfigurableBiome biome) {
//        addMonster(biome, MidnightEntities.RIFTER, 100, 1, 2);
//        addMonster(biome, EntityType.ENDERMAN, 10, 4, 4);
//    }
//
//    public static void addRockySpawns(ConfigurableBiome biome) {
//        addMonster(biome, MidnightEntities.HUNTER, 5, 1, 2);
//    }
//
//    public static void addForestSpawns(ConfigurableBiome biome) {
//        addMonster(biome, MidnightEntities.SKULK, 100, 1, 2);
////        addCreature(biome, MidnightEntities.SHADE_SQUIRREL, 65, 2, 3);
//    }
//
//    private static void addCreature(ConfigurableBiome biome, EntityType<?> type, int weight, int minGroupSize, int maxGroupSize) {
//        biome.add(EntityClassification.CREATURE, new Biome.SpawnListEntry(type, weight, minGroupSize, maxGroupSize));
//    }
//
//    private static void addMonster(ConfigurableBiome biome, EntityType<?> type, int weight, int minGroupSize, int maxGroupSize) {
//        biome.add(Midnight.MIDNIGHT_MOB, new Biome.SpawnListEntry(type, weight, minGroupSize, maxGroupSize));
//    }
}
