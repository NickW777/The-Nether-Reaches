package com.nick777.netherreaches.common.world.tree;

import com.nick777.netherreaches.common.registry.NetherReachesFeatures;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class ShockShroom extends NetherReachTree {
    @Nullable
    @Override
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return NetherReachesFeatures.SHOCK_SHROOM;
    }
}
