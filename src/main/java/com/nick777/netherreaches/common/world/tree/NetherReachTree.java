package com.nick777.netherreaches.common.world.tree;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.world.gen.feature.config.ShroomTreeConfig;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class NetherReachTree {
    @Nullable
    protected abstract AbstractTreeFeature<ShroomTreeConfig> getTreeFeature(Random random);

    public boolean spawn(IWorld worldIn, BlockPos pos, BlockState blockUnder, Random random) {
        AbstractTreeFeature<ShroomTreeConfig> abstracttreefeature = this.getTreeFeature(random);
        if (abstracttreefeature == null) {
            return false;
        } else {
            if (abstracttreefeature.place(worldIn, worldIn.getChunkProvider().getChunkGenerator(), random, pos, new ShroomTreeConfig(NetherReachesBlocks.SHADE_STONE.getDefaultState(),NetherReachesBlocks.SHADE_STONE.getDefaultState() , NetherReachesBlocks.SHADE_STONE.getDefaultState()))) {
                return true;
            } else {
                worldIn.setBlockState(pos, blockUnder, 4);
                return false;
            }
        }
    }
}

