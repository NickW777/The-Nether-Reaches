package com.nick777.netherreaches.common.biome;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesFeatures;
import com.nick777.netherreaches.common.registry.NetherReachesPlacements;
import com.nick777.netherreaches.common.world.gen.feature.config.NetherReachesOreConfig;
import com.nick777.netherreaches.common.world.gen.feature.config.ReachCrystalFeatureConfig;
import com.nick777.netherreaches.common.world.gen.feature.config.ShroomTreeConfig;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class NetherReachesHeatedConfigurator {

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

    public static void addReachCrystalFloorClump(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(
                Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(
                        new Feature[] {NetherReachesFeatures.REACHCRYSTAL_FLOOR_CLUMP, NetherReachesFeatures.REACHCRYSTAL_FLOOR_CLUMP, NetherReachesFeatures.REACHCRYSTAL_FLOOR_CLUMP},
                        new IFeatureConfig[] {new ReachCrystalFeatureConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(), NetherReachesBlocks.ORANGE_REACHCRYSTAL.getDefaultState()),
                                new ReachCrystalFeatureConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(), NetherReachesBlocks.RED_REACHCRYSTAL.getDefaultState()),
                                new ReachCrystalFeatureConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(), NetherReachesBlocks.YELLOW_REACHCRYSTAL.getDefaultState())},
                        new float[] {0.334F, 0.334F, 0.334F},
                        NetherReachesFeatures.REACHCRYSTAL_FLOOR_CLUMP,
                        new ReachCrystalFeatureConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(), NetherReachesBlocks.RED_REACHCRYSTAL.getDefaultState())
                ),
                NetherReachesPlacements.COUNT_HEATED_FLOOR, new FrequencyConfig(1)
        ));
    }

    public static void addFlameForestTrees(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                        NetherReachesFeatures.UPWARDS_TREE_SHROOM, new ShroomTreeConfig(NetherReachesBlocks.CINDER_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.CINDER_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.CINDER_SHROOM_SAPLING.getDefaultState()),
                NetherReachesPlacements.COUNT_HEATED_FLOOR, new FrequencyConfig(1)
        ));
    }
}
