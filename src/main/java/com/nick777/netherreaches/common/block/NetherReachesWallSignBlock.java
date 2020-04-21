package com.nick777.netherreaches.common.block;

import com.nick777.netherreaches.common.tile.NetherReachesSignTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class NetherReachesWallSignBlock extends WallSignBlock {
    public NetherReachesWallSignBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(final BlockState state) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new NetherReachesSignTileEntity();
    }
}
