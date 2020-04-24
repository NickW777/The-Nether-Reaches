package com.nick777.netherreaches.common.tile;


import com.nick777.netherreaches.common.block.ReachCrystalLanternBlock;
import com.nick777.netherreaches.common.registry.NetherReachesTileEntities;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class ReachCrystalLanternBlockTileEntity extends TileEntity implements ITickableTileEntity {

	private DyeColor color;

	public ReachCrystalLanternBlockTileEntity() {
		super(NetherReachesTileEntities.REACHCRYSTAL_LANTERN_TILE_ENTITY);
	}

	@OnlyIn(Dist.CLIENT)
	public DyeColor getColor() {
		if (this.color == null) {
			this.color = ((ReachCrystalLanternBlock)this.getBlockState().getBlock()).getColor();
		}

		return this.color;
	}

	public long rotation;
	@Override
	public void tick() {
		++this.rotation;
	}
}
