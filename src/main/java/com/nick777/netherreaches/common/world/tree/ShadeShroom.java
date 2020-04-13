package com.nick777.netherreaches.common.world.tree;

import com.nick777.netherreaches.common.registry.NetherReachesFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class ShadeShroom extends Tree {
    @Nullable
    @Override
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return NetherReachesFeatures.SHADESHROOM;
    }
}
