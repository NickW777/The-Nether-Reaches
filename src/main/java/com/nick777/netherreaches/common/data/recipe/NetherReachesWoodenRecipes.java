package com.nick777.netherreaches.common.data.recipe;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public final class NetherReachesWoodenRecipes extends NetherReachesRecipeProvider {
    public NetherReachesWoodenRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        StandardRecipes recipes = StandardRecipes.into(consumer);
        recipes.ofMaterial(NetherReachesBlocks.SHADE_SHROOM_PLANKS)
                .addButton(NetherReachesBlocks.SHADE_SHROOM_BUTTON)
                .addDoor(NetherReachesBlocks.SHADE_SHROOM_DOOR)
                .addFence(NetherReachesBlocks.SHADE_SHROOM_FENCE)
                .addFenceGate(NetherReachesBlocks.SHADE_SHROOM_FENCE_GATE)
                .addPressurePlate(NetherReachesBlocks.SHADE_SHROOM_PRESSURE_PLATE)
                .addSign(NetherReachesBlocks.SHADE_SHROOM_SIGN)
                .addSlab(NetherReachesBlocks.SHADE_SHROOM_SLAB)
                .addStairs(NetherReachesBlocks.SHADE_SHROOM_STAIRS)
                .addTrapDoor(NetherReachesBlocks.SHADE_SHROOM_TRAPDOOR)
                .addStick(NetherReachesItems.SHADE_STICK);

        recipes.ofMaterial(NetherReachesBlocks.SHOCK_SHROOM_PLANKS)
                .addButton(NetherReachesBlocks.SHOCK_SHROOM_BUTTON)
                .addDoor(NetherReachesBlocks.SHOCK_SHROOM_DOOR)
                .addFence(NetherReachesBlocks.SHOCK_SHROOM_FENCE)
                .addFenceGate(NetherReachesBlocks.SHOCK_SHROOM_FENCE_GATE)
                .addPressurePlate(NetherReachesBlocks.SHOCK_SHROOM_PRESSURE_PLATE)
                .addSlab(NetherReachesBlocks.SHOCK_SHROOM_SLAB)
                .addStairs(NetherReachesBlocks.SHOCK_SHROOM_STAIRS)
                .addTrapDoor(NetherReachesBlocks.SHOCK_SHROOM_TRAPDOOR)
                .addStick(NetherReachesItems.SHOCK_STICK);


        recipes.addPlanks(NetherReachesBlocks.SHADE_SHROOM_STEM, NetherReachesBlocks.SHADE_SHROOM_PLANKS);
        recipes.addPlanks(NetherReachesBlocks.SHOCK_SHROOM_STEM, NetherReachesBlocks.SHOCK_SHROOM_PLANKS);
    }
}
