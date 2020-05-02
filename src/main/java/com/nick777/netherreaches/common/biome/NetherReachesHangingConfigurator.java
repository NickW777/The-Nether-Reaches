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

public class NetherReachesHangingConfigurator {

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

    public static void addBlightShroom(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
        NetherReachesFeatures.BLIGHT_SHROOM, IFeatureConfig.NO_FEATURE_CONFIG,
                NetherReachesPlacements.COUNT_HANGING, new FrequencyConfig(1)
        ));
    }

    public static void addShadeShroom(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                NetherReachesFeatures.SHADE_SHROOM, IFeatureConfig.NO_FEATURE_CONFIG,
                NetherReachesPlacements.COUNT_HANGING, new FrequencyConfig(1)
        ));
    }

    public static void addShockShroom(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                NetherReachesFeatures.SHOCK_SHROOM, IFeatureConfig.NO_FEATURE_CONFIG,
                NetherReachesPlacements.COUNT_HANGING, new FrequencyConfig(1)
        ));
    }

    public static void addTangleShroom(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                NetherReachesFeatures.TANGLE_SHROOM, IFeatureConfig.NO_FEATURE_CONFIG,
                NetherReachesPlacements.COUNT_HANGING, new FrequencyConfig(1)
        ));
    }

    public static void addToxicShroom(ConfigurableBiome biome) {
        biome.add(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
                NetherReachesFeatures.TOXIC_SHROOM, IFeatureConfig.NO_FEATURE_CONFIG,
                NetherReachesPlacements.COUNT_HANGING, new FrequencyConfig(1)
        ));
    }
}
