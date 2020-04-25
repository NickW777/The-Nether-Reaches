package com.nick777.netherreaches.common.block;

import com.nick777.netherreaches.common.tile.ReachCrystalLanternBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.PushReaction;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class ReachCrystalLanternBlock extends Block {
    public static final DirectionProperty SURFACE = BlockStateProperties.FACING;
    private final DyeColor color;

    protected final VoxelShape floorLantern = VoxelShapes.or(Block.makeCuboidShape(4.5D,5D,4.5D,11.5D,14D,11.5D), Block.makeCuboidShape(3.5D,13D,3.5D,12.5D,14D,12.5D));
    protected final VoxelShape ceilingLantern = VoxelShapes.or(Block.makeCuboidShape(4.5D,1D,4.5D,11.5D,10D,11.5D), Block.makeCuboidShape(3.5D,9D,3.5D,12.5D,10D,12.5D));
    protected final VoxelShape northMountedLantern = VoxelShapes.or(Block.makeCuboidShape(4.5D,4D,3.5D,11.5D,13D,10.5D), Block.makeCuboidShape(3.5D,12D,2.5D,12.5D,13D,11.5D));
    protected final VoxelShape southMountedLantern = VoxelShapes.or(Block.makeCuboidShape(4.5D,4D,5.5D,11.5D,13D,12.5D), Block.makeCuboidShape(3.5D,12D,4.5D,12.5D,13D,13.5D));
    protected final VoxelShape eastMountedLantern = VoxelShapes.or(Block.makeCuboidShape(5.5D,4D,4.5D,12.5D,13D,11.5D), Block.makeCuboidShape(4.5D,12D,3.5D,13.5D,13D,12.5D));
    protected final VoxelShape westMountedLantern = VoxelShapes.or(Block.makeCuboidShape(3.5D,4D,4.5D,10.5D,13D,11.5D), Block.makeCuboidShape(2.5D,12D,3.5D,11.5D,13D,12.5D));

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(SURFACE)) {
            case UP:
                return ceilingLantern;
            case NORTH:
                return northMountedLantern;
            case SOUTH:
                return southMountedLantern;
            case EAST:
                return eastMountedLantern;
            case WEST:
                return westMountedLantern;
            default:
                return floorLantern;
        }
    }

    public ReachCrystalLanternBlock(DyeColor colorIn, Block.Properties properties) {
        super(properties);
        this.color = colorIn;
        this.setDefaultState(this.stateContainer.getBaseState().with(SURFACE, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction direction = context.getFace();
        BlockState blockstate = context.getWorld().getBlockState(context.getPos().offset(direction.getOpposite()));
        return blockstate.getBlock() == this && blockstate.get(SURFACE) == direction ? this.getDefaultState().with(SURFACE, direction) : this.getDefaultState().with(SURFACE, direction);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(SURFACE);
    }

    @OnlyIn(Dist.CLIENT)
    public DyeColor getColor() {
        return this.color;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ReachCrystalLanternBlockTileEntity(state);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Direction direction = getDirection(state).getOpposite();
        return Block.hasEnoughSolidSide(worldIn, pos.offset(direction), direction);
    }

    @Override
    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return getDirection(stateIn).getOpposite() == facing && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    @Override
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    protected static Direction getDirection(BlockState state) {
        return state.get(SURFACE);
    }
}
