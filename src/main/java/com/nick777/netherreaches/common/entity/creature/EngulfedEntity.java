package com.nick777.netherreaches.common.entity.creature;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EngulfedEntity extends CreatureEntity {

    public EngulfedEntity(EntityType<? extends EngulfedEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.5d));
        this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0d);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5d);
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, @Nullable CompoundNBT dataTag) {
        return livingdata;
    }

    @Override
    protected void registerData() {
        super.registerData();
        // this.dataManager.register(ANTLER_TYPE, 0);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        //compound.putInt("antler_type", getAntlerType());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        // if (compound.contains("antler_type", Constants.NBT.TAG_INT)) {
        //    int antlerType = compound.getInt("antler_type");
        //   setAntlerType(antlerType >= 0 && antlerType < MAX_ANTLER_TYPE ? antlerType : 0);
        // }
    }
}
