package com.nick777.netherreaches.common.biome;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesFeatures;
import com.nick777.netherreaches.common.registry.NetherReachesPlacements;
import com.nick777.netherreaches.common.world.feature.config.NetherReachesOreConfig;
import com.nick777.netherreaches.common.world.feature.config.ReachCrystalFeatureConfig;
import com.nick777.netherreaches.common.world.feature.config.ShelfShroomConfig;
import com.nick777.netherreaches.common.world.feature.config.ShroomTreeConfig;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class NetherReachesHangingConfigurator {

    public static void addGlobalOres(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.BERNEG_ORE.getDefaultState(), 14),
                Placement.COUNT_RANGE, new CountRangeConfig(8, 100, 0, 256)
        ));

        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.FARON_ORE.getDefaultState(), 4),
                Placement.COUNT_RANGE, new CountRangeConfig(6, 100, 0, 256)
        ));

        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.ILLIA_ORE.getDefaultState(), 4),
                Placement.COUNT_RANGE, new CountRangeConfig(4, 100, 0, 256)
        ));

        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.REGITE_ORE.getDefaultState(), 6),
                Placement.COUNT_RANGE, new CountRangeConfig(4, 100, 0, 256)
        ));

        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.SHARNIK_ORE.getDefaultState(), 6),
                Placement.COUNT_RANGE, new CountRangeConfig(4, 100, 0, 256)
        ));
    }

    public static void addReachCrystalCeilingClump(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(
                Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(
                        new Feature[] {NetherReachesFeatures.REACHCRYSTAL_CEILING_CLUMP, NetherReachesFeatures.REACHCRYSTAL_CEILING_CLUMP, NetherReachesFeatures.REACHCRYSTAL_CEILING_CLUMP, NetherReachesFeatures.REACHCRYSTAL_CEILING_CLUMP, NetherReachesFeatures.REACHCRYSTAL_CEILING_CLUMP, NetherReachesFeatures.REACHCRYSTAL_CEILING_CLUMP},
                        new IFeatureConfig[] {new ReachCrystalFeatureConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(), NetherReachesBlocks.BLACK_REACHCRYSTAL.getDefaultState()),
                        new ReachCrystalFeatureConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(), NetherReachesBlocks.BROWN_REACHCRYSTAL.getDefaultState()),
                        new ReachCrystalFeatureConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(), NetherReachesBlocks.GRAY_REACHCRYSTAL.getDefaultState()),
                        new ReachCrystalFeatureConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(), NetherReachesBlocks.LIGHT_GRAY_REACHCRYSTAL.getDefaultState()),
                        new ReachCrystalFeatureConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(), NetherReachesBlocks.PINK_REACHCRYSTAL.getDefaultState()),
                        new ReachCrystalFeatureConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(), NetherReachesBlocks.WHITE_REACHCRYSTAL.getDefaultState())},
                        new float[] {0.167F, 0.167F, 0.167F, 0.167F, 0.167F, 0.167F},
                        NetherReachesFeatures.REACHCRYSTAL_CEILING_CLUMP,
                        new ReachCrystalFeatureConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(), NetherReachesBlocks.WHITE_REACHCRYSTAL.getDefaultState())
                ),
                NetherReachesPlacements.COUNT_HANGING_CEILING, new FrequencyConfig(1)
        ));
    }

    public static void addShelfShrooms(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(
                        new Feature[] {NetherReachesFeatures.SHELF_SHROOM, NetherReachesFeatures.SHELF_SHROOM, NetherReachesFeatures.SHELF_SHROOM, NetherReachesFeatures.SHELF_SHROOM,NetherReachesFeatures.SHELF_SHROOM},
                        new IFeatureConfig[] {new ShelfShroomConfig(NetherReachesBlocks.AQUANE_SHELF_SHROOM_CORE.getDefaultState(),NetherReachesBlocks.AQUANE_SHELF_SHROOM_CRUST.getDefaultState()),
                new ShelfShroomConfig(NetherReachesBlocks.CRELENOR_SHELF_SHROOM_CORE.getDefaultState(),NetherReachesBlocks.CRELENOR_SHELF_SHROOM_CRUST.getDefaultState()),
                new ShelfShroomConfig(NetherReachesBlocks.GREJAR_SHELF_SHROOM_CORE.getDefaultState(),NetherReachesBlocks.GREJAR_SHELF_SHROOM_CRUST.getDefaultState()),
                new ShelfShroomConfig(NetherReachesBlocks.MOISE_SHELF_SHROOM_CORE.getDefaultState(),NetherReachesBlocks.MOISE_SHELF_SHROOM_CRUST.getDefaultState()),
                new ShelfShroomConfig(NetherReachesBlocks.SABLE_SHELF_SHROOM_CORE.getDefaultState(),NetherReachesBlocks.SABLE_SHELF_SHROOM_CRUST.getDefaultState())},
        new float[] {0.2F, 0.2F, 0.2F, 0.2F, 0.2F},
        NetherReachesFeatures.SHELF_SHROOM,
        new ShelfShroomConfig(NetherReachesBlocks.SABLE_SHELF_SHROOM_CORE.getDefaultState(), NetherReachesBlocks.SABLE_SHELF_SHROOM_CRUST.getDefaultState())
                ),
        NetherReachesPlacements.COUNT_HANGING_CEILING, new FrequencyConfig(1)
        ));
    }

    public static void addShroomForestCeilingShrooms(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(
                        new Feature[] {NetherReachesFeatures.DOWNWARDS_TREE_SHROOM, NetherReachesFeatures.DOWNWARDS_TREE_SHROOM, NetherReachesFeatures.DOWNWARDS_TREE_SHROOM, NetherReachesFeatures.DOWNWARDS_TREE_SHROOM, NetherReachesFeatures.DOWNWARDS_TREE_SHROOM},
                        new IFeatureConfig[] {new ShroomTreeConfig(NetherReachesBlocks.BLIGHT_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.BLIGHT_SHROOM_STEM.getDefaultState(), NetherReachesBlocks.BLIGHT_SHROOM_SAPLING.getDefaultState()),
                                new ShroomTreeConfig(NetherReachesBlocks.SHADE_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.SHADE_SHROOM_STEM.getDefaultState(), NetherReachesBlocks.SHADE_SHROOM_SAPLING.getDefaultState()),
                                new ShroomTreeConfig(NetherReachesBlocks.SHOCK_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.SHOCK_SHROOM_STEM.getDefaultState(), NetherReachesBlocks.SHOCK_SHROOM_SAPLING.getDefaultState()),
                                new ShroomTreeConfig(NetherReachesBlocks.TANGLE_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.TANGLE_SHROOM_STEM.getDefaultState(), NetherReachesBlocks.TANGLE_SHROOM_SAPLING.getDefaultState()),
                                new ShroomTreeConfig(NetherReachesBlocks.TOXIC_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.TOXIC_SHROOM_STEM.getDefaultState(), NetherReachesBlocks.TOXIC_SHROOM_SAPLING.getDefaultState())},
                        new float[] {0.2F, 0.2F, 0.2F, 0.2F, 0.2F},
                        NetherReachesFeatures.DOWNWARDS_TREE_SHROOM,
                        new ShroomTreeConfig(NetherReachesBlocks.SHADE_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.SHADE_SHROOM_STEM.getDefaultState(), NetherReachesBlocks.SHADE_SHROOM_SAPLING.getDefaultState())
                ),
                NetherReachesPlacements.COUNT_HANGING_CEILING, new FrequencyConfig(1)
        ));
    }
}
