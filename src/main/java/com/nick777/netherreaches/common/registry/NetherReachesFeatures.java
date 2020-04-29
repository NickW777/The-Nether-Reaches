package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.NetherReaches;
import com.nick777.netherreaches.common.world.feature.NetherReachesOreFeature;
import com.nick777.netherreaches.common.world.feature.config.NetherReachesOreConfig;
import com.nick777.netherreaches.common.world.feature.tree.*;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(NetherReaches.MODID)
public class NetherReachesFeatures {
    public static final AbstractTreeFeature<NoFeatureConfig> BLIGHT_SHROOM = new BlightShroomTreeFeature(NoFeatureConfig::deserialize);
    public static final AbstractTreeFeature<NoFeatureConfig> CINDER_SHROOM = new CinderShroomTreeFeature(NoFeatureConfig::deserialize);
    public static final AbstractTreeFeature<NoFeatureConfig> SHADE_SHROOM = new ShadeShroomTreeFeature(NoFeatureConfig::deserialize);
    public static final AbstractTreeFeature<NoFeatureConfig> SHOCK_SHROOM = new ShockShroomTreeFeature(NoFeatureConfig::deserialize);
    public static final AbstractTreeFeature<NoFeatureConfig> TANGLE_SHROOM = new TangleShroomTreeFeature(NoFeatureConfig::deserialize);
    public static final AbstractTreeFeature<NoFeatureConfig> TOXIC_SHROOM = new ToxicShroomTreeFeature(NoFeatureConfig::deserialize);

    public static final Feature<NetherReachesOreConfig> ORE = new NetherReachesOreFeature(NetherReachesOreConfig::deserialize);

    @SubscribeEvent
    public static void registerFeatures(IForgeRegistry<Feature<?>> event) {
        RegUtil.generic(event)
                .add("blight_shroom", BLIGHT_SHROOM)
                .add("cinder_shroom", CINDER_SHROOM)
                .add("shade_shroom", SHADE_SHROOM)
                .add("shock_shroom", SHOCK_SHROOM)
                .add("tangle_shroom", TANGLE_SHROOM)
                .add("toxic_shroom", TOXIC_SHROOM)
                .add("ore", ORE);
    }
}
