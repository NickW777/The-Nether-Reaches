package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.NetherReaches;
import com.nick777.netherreaches.common.world.feature.NetherReachesOreFeature;
import com.nick777.netherreaches.common.world.feature.ReachCrystalFeature;
import com.nick777.netherreaches.common.world.feature.config.NetherReachesOreConfig;
import com.nick777.netherreaches.common.world.feature.config.ReachCrystalFeatureConfig;
import com.nick777.netherreaches.common.world.feature.config.ShroomTreeConfig;
import com.nick777.netherreaches.common.world.feature.tree.ShroomTreeFeature;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(NetherReaches.MODID)
public class NetherReachesFeatures {
    public static final AbstractTreeFeature<ShroomTreeConfig> BLIGHT_SHROOM = new ShroomTreeFeature(ShroomTreeConfig::deserialize, new ShroomTreeConfig(NetherReachesBlocks.BLIGHT_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.BLIGHT_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.BLIGHT_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> CINDER_SHROOM = new ShroomTreeFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.CINDER_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.CINDER_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.CINDER_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> SHADE_SHROOM = new ShroomTreeFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.SHADE_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.SHADE_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.SHADE_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> SHOCK_SHROOM = new ShroomTreeFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.SHOCK_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.SHOCK_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.SHOCK_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> TANGLE_SHROOM = new ShroomTreeFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.TANGLE_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.TANGLE_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.TANGLE_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> TOXIC_SHROOM = new ShroomTreeFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.TOXIC_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.TOXIC_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.TOXIC_SHROOM_SAPLING.getDefaultState()));

    public static final Feature<NetherReachesOreConfig> ORE = new NetherReachesOreFeature(NetherReachesOreConfig::deserialize);
    public static final Feature<ReachCrystalFeatureConfig> REACHCRYSTAL_CLUMP = new ReachCrystalFeature(ReachCrystalFeatureConfig::deserialize,2,4);

    @SubscribeEvent
    public static void registerFeatures(IForgeRegistry<Feature<?>> event) {
        RegUtil.generic(event)
                .add("blight_shroom", BLIGHT_SHROOM)
                .add("cinder_shroom", CINDER_SHROOM)
                .add("shade_shroom", SHADE_SHROOM)
                .add("shock_shroom", SHOCK_SHROOM)
                .add("tangle_shroom", TANGLE_SHROOM)
                .add("toxic_shroom", TOXIC_SHROOM)
                .add("ore", ORE)
                .add("reachcrystal_clump", REACHCRYSTAL_CLUMP);
    }
}
