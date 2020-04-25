package com.nick777.netherreaches.common.tile;


import com.nick777.netherreaches.common.block.ReachCrystalLanternBlock;
import com.nick777.netherreaches.common.registry.NetherReachesTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ReachCrystalLanternBlockTileEntity extends TileEntity implements ITickableTileEntity {

	private DyeColor color;
	public long rotation;
	public static final DirectionProperty SURFACE = BlockStateProperties.FACING;
	private Direction surface;


	public ReachCrystalLanternBlockTileEntity(BlockState blockstate) {
		super(NetherReachesTileEntities.REACHCRYSTAL_LANTERN_TILE_ENTITY);
		getBlockSurface(blockstate);
	}

	@OnlyIn(Dist.CLIENT)
	public DyeColor getColor() {
		if (this.color == null) {
			this.color = ((ReachCrystalLanternBlock)this.getBlockState().getBlock()).getColor();
		}

		return this.color;
	}

	private void getBlockSurface(BlockState blockstate) {
		this.surface = blockstate.get(SURFACE);
	}

	public Direction getSurface() {
		return this.surface;
	}

	@Override
	public void tick() {
		++this.rotation;
	}
}
