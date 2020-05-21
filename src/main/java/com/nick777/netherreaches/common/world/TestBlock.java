package com.nick777.netherreaches.common.world;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class TestBlock {

    public static boolean isSolid(IWorld world, BlockPos pos) {
        if (world.isAirBlock(pos) || isLiquid(world, pos)) {
            return false;
        }
        return true;
    }

    public static boolean isSolidExcluding(IWorld world, BlockPos pos, BlockState excluded) {
        if (world.getBlockState(pos) != excluded) {
            if (isSolid(world,pos)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLiquid(IWorld world, BlockPos pos) {
        if (world.getBlockState(pos) == NetherReachesBlocks.MAGMA.getDefaultState() ||
                world.getBlockState(pos) == NetherReachesBlocks.REACH_WATER.getDefaultState() ||
                world.getBlockState(pos) == Blocks.LAVA.getDefaultState() ||
                world.getBlockState(pos) == Blocks.WATER.getDefaultState()) {
            return true;
        }
        return false;
    }
}
