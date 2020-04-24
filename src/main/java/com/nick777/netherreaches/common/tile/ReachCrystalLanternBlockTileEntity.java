package com.nick777.netherreaches.common.tile;


import com.nick777.netherreaches.common.registry.NetherReachesTileEntities;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;


public class ReachCrystalLanternBlockTileEntity extends TileEntity implements ITickableTileEntity {

	public ReachCrystalLanternBlockTileEntity() {
		super(NetherReachesTileEntities.REACHCRYSTAL_LANTERN_TILE_ENTITY);
	}

	public long rotation;
	@Override
	public void tick() {
		++this.rotation;
	}
}
