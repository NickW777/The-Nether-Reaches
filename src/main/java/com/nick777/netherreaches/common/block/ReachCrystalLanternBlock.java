package com.nick777.netherreaches.common.block;

import com.nick777.netherreaches.common.tile.ReachCrystalLanternBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class ReachCrystalLanternBlock extends LanternBlock {

    public ReachCrystalLanternBlock(Block.Properties properties) {
        super(properties);
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
