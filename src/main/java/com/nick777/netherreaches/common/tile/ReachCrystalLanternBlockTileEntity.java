package com.nick777.netherreaches.common.tile;


import com.nick777.netherreaches.common.block.ReachCrystalLanternBlock;
import com.nick777.netherreaches.common.registry.NetherReachesTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class ReachCrystalLanternBlockTileEntity extends TileEntity implements ITickableTileEntity {

	private DyeColor color;
	public long rotation;
	public static final BooleanProperty HANGING = BlockStateProperties.HANGING;
	private boolean isHanging;


	public ReachCrystalLanternBlockTileEntity(BlockState blockstate) {
		super(NetherReachesTileEntities.REACHCRYSTAL_LANTERN_TILE_ENTITY);
		getHangingState(blockstate);
	}

	@OnlyIn(Dist.CLIENT)
	public DyeColor getColor() {
		if (this.color == null) {
			this.color = ((ReachCrystalLanternBlock)this.getBlockState().getBlock()).getColor();
		}

		return this.color;
	}

	private void getHangingState(BlockState blockstate) {
		this.isHanging = blockstate.get(HANGING);
	}

	public boolean isHanging() {
		return this.isHanging;
	}

	@Override
	public void tick() {
		++this.rotation;
	}
}
