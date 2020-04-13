package com.nick777.netherreaches.common.block;

import net.minecraft.block.*;
import net.minecraft.block.trees.Tree;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class ShroomSaplingBlock extends SaplingBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public ShroomSaplingBlock(Tree tree, Properties properties) {
        super(tree, properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(STAGE, Integer.valueOf(0)));
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Direction[] directions = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST, Direction.UP, Direction.DOWN};
        BlockPos[] blockpos = {pos.south(), pos.north(), pos.west(), pos.east(), pos.down(), pos.up()};
        for (int i = 0; i < 6; i++) {
            if (worldIn.getBlockState(blockpos[i]).canSustainPlant(worldIn, blockpos[i], directions[i], this)) {
                return true;
            }
        }
        return this.isValidGround(worldIn.getBlockState(pos.up()), worldIn, pos.up());
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction direction = context.getFace();
        BlockState blockstate = context.getWorld().getBlockState(context.getPos().offset(direction.getOpposite()));
        return blockstate.getBlock() == this && blockstate.get(FACING) == direction ? this.getDefaultState().with(FACING, direction.getOpposite()) : this.getDefaultState().with(FACING, direction);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, STAGE);
    }

}
