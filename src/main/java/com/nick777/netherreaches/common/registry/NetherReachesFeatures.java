package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.NetherReaches;
import com.nick777.netherreaches.common.world.feature.tree.ShadeShroomTreeFeature;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(NetherReaches.MODID)
public class NetherReachesFeatures {
    public static final AbstractTreeFeature<NoFeatureConfig> SHADE_SHROOM = new ShadeShroomTreeFeature(NoFeatureConfig::deserialize);

    @SubscribeEvent
    public static void registerFeatures(IForgeRegistry<Feature<?>> event) {
        RegUtil.generic(event)
                .add("shade_shroom", SHADE_SHROOM);
    }
}
