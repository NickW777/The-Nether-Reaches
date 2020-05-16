package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.NetherReaches;
import com.nick777.netherreaches.common.world.feature.DownwardsShroomFeature;
import com.nick777.netherreaches.common.world.feature.NetherReachesOreFeature;
import com.nick777.netherreaches.common.world.feature.ReachCrystalFeature;
import com.nick777.netherreaches.common.world.feature.UpwardsShroomFeature;
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

    public static final AbstractTreeFeature<ShroomTreeConfig> DOWNWARDS_BLIGHT_SHROOM = new DownwardsShroomFeature(ShroomTreeConfig::deserialize, new ShroomTreeConfig(NetherReachesBlocks.BLIGHT_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.BLIGHT_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.BLIGHT_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> DOWNWARDS_CINDER_SHROOM = new DownwardsShroomFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.CINDER_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.CINDER_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.CINDER_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> DOWNWARDS_SHADE_SHROOM = new DownwardsShroomFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.SHADE_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.SHADE_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.SHADE_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> DOWNWARDS_SHOCK_SHROOM = new DownwardsShroomFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.SHOCK_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.SHOCK_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.SHOCK_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> DOWNWARDS_TANGLE_SHROOM = new DownwardsShroomFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.TANGLE_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.TANGLE_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.TANGLE_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> DOWNWARDS_TOXIC_SHROOM = new DownwardsShroomFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.TOXIC_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.TOXIC_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.TOXIC_SHROOM_SAPLING.getDefaultState()));

    public static final AbstractTreeFeature<ShroomTreeConfig> UPWARDS_BLIGHT_SHROOM = new UpwardsShroomFeature(ShroomTreeConfig::deserialize, new ShroomTreeConfig(NetherReachesBlocks.BLIGHT_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.BLIGHT_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.BLIGHT_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> UPWARDS_CINDER_SHROOM = new UpwardsShroomFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.CINDER_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.CINDER_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.CINDER_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> UPWARDS_SHADE_SHROOM = new UpwardsShroomFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.SHADE_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.SHADE_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.SHADE_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> UPWARDS_SHOCK_SHROOM = new UpwardsShroomFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.SHOCK_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.SHOCK_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.SHOCK_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> UPWARDS_TANGLE_SHROOM = new UpwardsShroomFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.TANGLE_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.TANGLE_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.TANGLE_SHROOM_SAPLING.getDefaultState()));
    public static final AbstractTreeFeature<ShroomTreeConfig> UPWARDS_TOXIC_SHROOM = new UpwardsShroomFeature(ShroomTreeConfig::deserialize,new ShroomTreeConfig(NetherReachesBlocks.TOXIC_SHROOM_CAP.getDefaultState(),NetherReachesBlocks.TOXIC_SHROOM_STEM.getDefaultState(),NetherReachesBlocks.TOXIC_SHROOM_SAPLING.getDefaultState()));

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
                .add("downwards_blight_shroom", DOWNWARDS_BLIGHT_SHROOM)
                .add("downwards_cinder_shroom", DOWNWARDS_CINDER_SHROOM)
                .add("downwards_shade_shroom", DOWNWARDS_SHADE_SHROOM)
                .add("downwards_shock_shroom", DOWNWARDS_SHOCK_SHROOM)
                .add("downwards_tangle_shroom", DOWNWARDS_TANGLE_SHROOM)
                .add("downwards_toxic_shroom", DOWNWARDS_TOXIC_SHROOM)
                .add("upwards_blight_shroom", UPWARDS_BLIGHT_SHROOM)
                .add("upwards_cinder_shroom", UPWARDS_CINDER_SHROOM)
                .add("upwards_shade_shroom", UPWARDS_SHADE_SHROOM)
                .add("upwards_shock_shroom", UPWARDS_SHOCK_SHROOM)
                .add("upwards_tangle_shroom", UPWARDS_TANGLE_SHROOM)
                .add("upwards_toxic_shroom", UPWARDS_TOXIC_SHROOM)
                .add("ore", ORE)
                .add("reachcrystal_clump", REACHCRYSTAL_CLUMP);
    }
}
