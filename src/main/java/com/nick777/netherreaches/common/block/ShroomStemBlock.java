package com.nick777.netherreaches.common.block;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class ShroomStemBlock extends LogBlock {

    public ShroomStemBlock(Block.Properties properties) {
        super(MaterialColor.BLUE_TERRACOTTA, properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.Y));
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack itemstack = player.getHeldItem(handIn);
        Block target = worldIn.getBlockState(pos).getBlock();
        Block STRIPPED_BLOCK = null;
        if (target == NetherReachesBlocks.SHADE_SHROOM_STEM) {
            STRIPPED_BLOCK = NetherReachesBlocks.STRIPPED_SHADE_SHROOM_STEM;
        } else if (target == NetherReachesBlocks.SHADE_SHROOM_BARK) {
            STRIPPED_BLOCK = NetherReachesBlocks.STRIPPED_SHADE_SHROOM_BARK;
        } else if (target == NetherReachesBlocks.SHOCK_SHROOM_STEM) {
            STRIPPED_BLOCK = NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_STEM;
        } else if (target == NetherReachesBlocks.SHOCK_SHROOM_BARK) {
            STRIPPED_BLOCK = NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_BARK;
        } else if (target == NetherReachesBlocks.BLIGHT_SHROOM_STEM) {
            STRIPPED_BLOCK = NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_STEM;
        } else if (target == NetherReachesBlocks.BLIGHT_SHROOM_BARK) {
            STRIPPED_BLOCK = NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_BARK;
        } else if (target == NetherReachesBlocks.CINDER_SHROOM_STEM) {
            STRIPPED_BLOCK = NetherReachesBlocks.STRIPPED_CINDER_SHROOM_STEM;
        } else if (target == NetherReachesBlocks.CINDER_SHROOM_BARK) {
            STRIPPED_BLOCK = NetherReachesBlocks.STRIPPED_CINDER_SHROOM_BARK;
        } else if (target == NetherReachesBlocks.TANGLE_SHROOM_STEM) {
            STRIPPED_BLOCK = NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_STEM;
        } else if (target == NetherReachesBlocks.TANGLE_SHROOM_BARK) {
            STRIPPED_BLOCK = NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_BARK;
        } else if (target == NetherReachesBlocks.TOXIC_SHROOM_STEM) {
            STRIPPED_BLOCK = NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_STEM;
        } else if (target == NetherReachesBlocks.TOXIC_SHROOM_BARK) {
            STRIPPED_BLOCK = NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_BARK;
        }
        if (itemstack.getItem() == Items.WOODEN_AXE || itemstack.getItem() == Items.STONE_AXE || itemstack.getItem() == Items.IRON_AXE || itemstack.getItem() == Items.GOLDEN_AXE || itemstack.getItem() == Items.DIAMOND_AXE) {
            if (!worldIn.isRemote && STRIPPED_BLOCK != null) {
                Direction.Axis axis = worldIn.getBlockState(pos).get(LogBlock.AXIS);
                worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                worldIn.setBlockState(pos, STRIPPED_BLOCK.getDefaultState().with(LogBlock.AXIS, axis), 11);
                itemstack.damageItem(1, player, (p_220282_1_) -> {
                    p_220282_1_.sendBreakAnimation(handIn);
                });
            }

            return true;
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.AXIS);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(AXIS, context.getFace().getAxis());
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return 0;
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.AXE;
    }
}
