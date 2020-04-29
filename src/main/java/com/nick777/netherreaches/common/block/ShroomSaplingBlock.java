package com.nick777.netherreaches.common.block;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.world.tree.NetherReachTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class ShroomSaplingBlock extends NetherReachesSaplingBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public ShroomSaplingBlock(NetherReachTree tree, Properties properties) {
        super(tree, properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(STAGE, Integer.valueOf(0)));
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND || block == NetherReachesBlocks.SHADE_STONE;
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

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos, Direction facing) {
        if (isValidGround(state,worldIn,pos.offset(facing))) {
            return true;
        }
        return false;
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !isValidPosition(stateIn, worldIn, currentPos, facing) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction direction = context.getFace();
        BlockState blockstate = context.getWorld().getBlockState(context.getPos().offset(direction.getOpposite()));
        if (isValidGround(blockstate,context.getWorld(),context.getPos().offset(direction.getOpposite()))) {
            return blockstate.getBlock() == this && blockstate.get(FACING) == direction ? this.getDefaultState().with(FACING, direction.getOpposite()) : this.getDefaultState().with(FACING, direction);
        }
        return Blocks.AIR.getDefaultState();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, STAGE);
    }

}
