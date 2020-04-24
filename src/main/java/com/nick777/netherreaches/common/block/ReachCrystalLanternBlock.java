package com.nick777.netherreaches.common.block;

import com.nick777.netherreaches.common.tile.ReachCrystalLanternBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class ReachCrystalLanternBlock extends LanternBlock {

    private final DyeColor color;

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
        return new ReachCrystalLanternBlockTileEntity();
    }
}
