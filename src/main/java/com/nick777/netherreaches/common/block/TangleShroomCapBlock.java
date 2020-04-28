package com.nick777.netherreaches.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class TangleShroomCapBlock extends LeavesBlock {
    public TangleShroomCapBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
        return true;
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && !worldIn.isRemote) {
            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 80, 1, true, false));
            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 80, 1, true, false));
        }
        super.onEntityWalk(worldIn,pos,entityIn);
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