package com.nick777.netherreaches.common.biome;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesFeatures;
import com.nick777.netherreaches.common.registry.NetherReachesPlacements;
import com.nick777.netherreaches.common.world.feature.config.NetherReachesOreConfig;
import com.nick777.netherreaches.common.world.feature.config.ReachCrystalFeatureConfig;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

//import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;

public class NetherReachesHangingConfigurator {

    public static void addGlobalOres(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.BERNEG_ORE.getDefaultState(), 14),
                Placement.COUNT_RANGE, new CountRangeConfig(8, 160, 0, 256)
        ));

        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.FARON_ORE.getDefaultState(), 4),
                Placement.COUNT_RANGE, new CountRangeConfig(6, 160, 0, 256)
        ));

        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.ILLIA_ORE.getDefaultState(), 4),
                Placement.COUNT_RANGE, new CountRangeConfig(4, 160, 0, 256)
        ));

        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.REGITE_ORE.getDefaultState(), 6),
                Placement.COUNT_RANGE, new CountRangeConfig(4, 160, 0, 256)
        ));

        biome.add(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                NetherReachesFeatures.ORE, new NetherReachesOreConfig(NetherReachesBlocks.SHARNIK_ORE.getDefaultState(), 6),
                Placement.COUNT_RANGE, new CountRangeConfig(4, 160, 0, 256)
        ));
    }

    public static void addReachCrystalClump(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Biome.createDecoratedFeature(
                NetherReachesFeatures.REACHCRYSTAL_CLUMP, new ReachCrystalFeatureConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(),NetherReachesBlocks.RED_REACHCRYSTAL.getDefaultState()),
                NetherReachesPlacements.COUNT_HANGING, new FrequencyConfig(1)
        ));
    }

    public static void addShroomForestShrooms(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(
                        new Feature[] {NetherReachesFeatures.BLIGHT_SHROOM, NetherReachesFeatures.SHADE_SHROOM, NetherReachesFeatures.SHOCK_SHROOM, NetherReachesFeatures.TANGLE_SHROOM, NetherReachesFeatures.TOXIC_SHROOM},
                        new IFeatureConfig[] {IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG},
                        new float[] {0.2F, 0.2F, 0.2F, 0.2F, 0.2F},
                        NetherReachesFeatures.SHADE_SHROOM,
                        IFeatureConfig.NO_FEATURE_CONFIG
                ),
                NetherReachesPlacements.COUNT_HANGING, new FrequencyConfig(1)
        ));
    }
}
