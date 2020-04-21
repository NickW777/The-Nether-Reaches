package com.nick777.netherreaches.common.block;

import com.nick777.netherreaches.common.tile.NetherReachesSignTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class NetherReachesStandingSignBlock extends StandingSignBlock {
    public NetherReachesStandingSignBlock(Properties properties) {
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

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            return true;
        } else {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof NetherReachesSignTileEntity) {
                NetherReachesSignTileEntity signtileentity = (NetherReachesSignTileEntity) tileentity;
                ItemStack itemstack = player.getHeldItem(handIn);
                if (itemstack.getItem() instanceof DyeItem && player.abilities.allowEdit) {
                    boolean flag = signtileentity.setTextColor(((DyeItem)itemstack.getItem()).getDyeColor());
                    if (flag && !player.isCreative()) {
                        itemstack.shrink(1);
                    }
                }

                return signtileentity.executeCommand(player);
            } else {
                return false;
            }
        }
    }
}
