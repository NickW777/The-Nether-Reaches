package com.nick777.netherreaches.common.world.tree;

import com.nick777.netherreaches.common.registry.NetherReachesFeatures;
import com.nick777.netherreaches.common.world.gen.feature.config.ShroomTreeConfig;
import net.minecraft.world.gen.feature.AbstractTreeFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class CinderShroom extends NetherReachTree {
    @Nullable
    @Override
    protected AbstractTreeFeature<ShroomTreeConfig> getTreeFeature(Random random) {
        return NetherReachesFeatures.CINDER_SHROOM;
    }
}
