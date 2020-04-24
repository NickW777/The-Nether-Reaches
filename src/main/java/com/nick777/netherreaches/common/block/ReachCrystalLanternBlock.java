package com.nick777.netherreaches.common.block;

import com.nick777.netherreaches.common.tile.ReachCrystalLanternBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class ReachCrystalLanternBlock extends LanternBlock {
    private final DyeColor color;

    protected final VoxelShape floorLantern = VoxelShapes.or(Block.makeCuboidShape(4.5D,0D,4.5D,11.5D,11D,11.5D), Block.makeCuboidShape(3.5D,9D,3.5D,12.5D,10D,12.5D));
    protected final VoxelShape ceilingLantern = VoxelShapes.or(Block.makeCuboidShape(4.5D,4D,4.5D,11.5D,15D,11.5D), Block.makeCuboidShape(3.5D,13D,3.5D,12.5D,14D,12.5D));

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return state.get(HANGING) ? ceilingLantern : floorLantern;
    }

    public ReachCrystalLanternBlock(DyeColor colorIn, Block.Properties properties) {
        super(properties);
        this.color = colorIn;
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
}
