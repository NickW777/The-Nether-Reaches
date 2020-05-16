package com.nick777.netherreaches.common.block;

import com.nick777.netherreaches.client.particle.NetherReachesParticles;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.Random;

public class ShadeShroomCapBlock extends LeavesBlock {
    public ShadeShroomCapBlock(Block.Properties properties) {
        super(properties);
    }

    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
    }

    public int tickRate(IWorldReader worldIn) {
        return 20;
    }

    @Override
    public void randomTick(BlockState state, World worldIn, BlockPos pos, Random random) {
    }

    @Override
    public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
        return true;
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && !worldIn.isRemote) {
            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 80, 1, true, false));
        }
        super.onEntityWalk(worldIn,pos,entityIn);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
        if (rand.nextInt(8) == 0) {
            NetherReachesParticles.SHADE_SHROOM.spawn(world, pos.getX() + 1d, pos.getY() + 1d, pos.getZ() + 1d, rand.nextFloat() * 0.1d - 0.05d, rand.nextFloat() * 0.03d, rand.nextFloat() * 0.1d - 0.05d);
        }
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
