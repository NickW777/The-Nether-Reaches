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

        recipes.ofMaterial(NetherReachesBlocks.BLIGHT_SHROOM_PLANKS)
                .addButton(NetherReachesBlocks.BLIGHT_SHROOM_BUTTON)
                .addDoor(NetherReachesBlocks.BLIGHT_SHROOM_DOOR)
                .addFence(NetherReachesBlocks.BLIGHT_SHROOM_FENCE)
                .addFenceGate(NetherReachesBlocks.BLIGHT_SHROOM_FENCE_GATE)
                .addPressurePlate(NetherReachesBlocks.BLIGHT_SHROOM_PRESSURE_PLATE)
                .addSlab(NetherReachesBlocks.BLIGHT_SHROOM_SLAB)
                .addStairs(NetherReachesBlocks.BLIGHT_SHROOM_STAIRS)
                .addTrapDoor(NetherReachesBlocks.BLIGHT_SHROOM_TRAPDOOR)
                .addStick(NetherReachesItems.BLIGHT_STICK);

        recipes.ofMaterial(NetherReachesBlocks.CINDER_SHROOM_PLANKS)
                .addButton(NetherReachesBlocks.CINDER_SHROOM_BUTTON)
                .addDoor(NetherReachesBlocks.CINDER_SHROOM_DOOR)
                .addFence(NetherReachesBlocks.CINDER_SHROOM_FENCE)
                .addFenceGate(NetherReachesBlocks.CINDER_SHROOM_FENCE_GATE)
                .addPressurePlate(NetherReachesBlocks.CINDER_SHROOM_PRESSURE_PLATE)
                .addSlab(NetherReachesBlocks.CINDER_SHROOM_SLAB)
                .addStairs(NetherReachesBlocks.CINDER_SHROOM_STAIRS)
                .addTrapDoor(NetherReachesBlocks.CINDER_SHROOM_TRAPDOOR)
                .addStick(NetherReachesItems.CINDER_STICK);

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

        recipes.ofMaterial(NetherReachesBlocks.TANGLE_SHROOM_PLANKS)
                .addButton(NetherReachesBlocks.TANGLE_SHROOM_BUTTON)
                .addDoor(NetherReachesBlocks.TANGLE_SHROOM_DOOR)
                .addFence(NetherReachesBlocks.TANGLE_SHROOM_FENCE)
                .addFenceGate(NetherReachesBlocks.TANGLE_SHROOM_FENCE_GATE)
                .addPressurePlate(NetherReachesBlocks.TANGLE_SHROOM_PRESSURE_PLATE)
                .addSlab(NetherReachesBlocks.TANGLE_SHROOM_SLAB)
                .addStairs(NetherReachesBlocks.TANGLE_SHROOM_STAIRS)
                .addTrapDoor(NetherReachesBlocks.TANGLE_SHROOM_TRAPDOOR)
                .addStick(NetherReachesItems.TANGLE_STICK);

        recipes.ofMaterial(NetherReachesBlocks.TOXIC_SHROOM_PLANKS)
                .addButton(NetherReachesBlocks.TOXIC_SHROOM_BUTTON)
                .addDoor(NetherReachesBlocks.TOXIC_SHROOM_DOOR)
                .addFence(NetherReachesBlocks.TOXIC_SHROOM_FENCE)
                .addFenceGate(NetherReachesBlocks.TOXIC_SHROOM_FENCE_GATE)
                .addPressurePlate(NetherReachesBlocks.TOXIC_SHROOM_PRESSURE_PLATE)
                .addSlab(NetherReachesBlocks.TOXIC_SHROOM_SLAB)
                .addStairs(NetherReachesBlocks.TOXIC_SHROOM_STAIRS)
                .addTrapDoor(NetherReachesBlocks.TOXIC_SHROOM_TRAPDOOR)
                .addStick(NetherReachesItems.TOXIC_STICK);


        recipes.addPlanks(NetherReachesBlocks.BLIGHT_SHROOM_STEM, NetherReachesBlocks.BLIGHT_SHROOM_PLANKS);
        recipes.addPlanks(NetherReachesBlocks.CINDER_SHROOM_STEM, NetherReachesBlocks.CINDER_SHROOM_PLANKS);
        recipes.addPlanks(NetherReachesBlocks.SHADE_SHROOM_STEM, NetherReachesBlocks.SHADE_SHROOM_PLANKS);
        recipes.addPlanks(NetherReachesBlocks.SHOCK_SHROOM_STEM, NetherReachesBlocks.SHOCK_SHROOM_PLANKS);
        recipes.addPlanks(NetherReachesBlocks.TANGLE_SHROOM_STEM, NetherReachesBlocks.TANGLE_SHROOM_PLANKS);
        recipes.addPlanks(NetherReachesBlocks.TOXIC_SHROOM_STEM, NetherReachesBlocks.TOXIC_SHROOM_PLANKS);

        recipes.addPlanksFromStripped(NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_STEM, NetherReachesBlocks.BLIGHT_SHROOM_PLANKS);
        recipes.addPlanksFromStripped(NetherReachesBlocks.STRIPPED_CINDER_SHROOM_STEM, NetherReachesBlocks.CINDER_SHROOM_PLANKS);
        recipes.addPlanksFromStripped(NetherReachesBlocks.STRIPPED_SHADE_SHROOM_STEM, NetherReachesBlocks.SHADE_SHROOM_PLANKS);
        recipes.addPlanksFromStripped(NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_STEM, NetherReachesBlocks.SHOCK_SHROOM_PLANKS);
        recipes.addPlanksFromStripped(NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_STEM, NetherReachesBlocks.TANGLE_SHROOM_PLANKS);
        recipes.addPlanksFromStripped(NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_STEM, NetherReachesBlocks.TOXIC_SHROOM_PLANKS);

        recipes.addWood(NetherReachesBlocks.BLIGHT_SHROOM_STEM,NetherReachesBlocks.BLIGHT_SHROOM_BARK);
        recipes.addWood(NetherReachesBlocks.CINDER_SHROOM_STEM,NetherReachesBlocks.CINDER_SHROOM_BARK);
        recipes.addWood(NetherReachesBlocks.SHADE_SHROOM_STEM,NetherReachesBlocks.SHADE_SHROOM_BARK);
        recipes.addWood(NetherReachesBlocks.SHOCK_SHROOM_STEM,NetherReachesBlocks.SHOCK_SHROOM_BARK);
        recipes.addWood(NetherReachesBlocks.TANGLE_SHROOM_STEM,NetherReachesBlocks.TANGLE_SHROOM_BARK);
        recipes.addWood(NetherReachesBlocks.TOXIC_SHROOM_STEM,NetherReachesBlocks.TOXIC_SHROOM_BARK);

        recipes.addWood(NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_STEM,NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_BARK);
        recipes.addWood(NetherReachesBlocks.STRIPPED_CINDER_SHROOM_STEM,NetherReachesBlocks.STRIPPED_CINDER_SHROOM_BARK);
        recipes.addWood(NetherReachesBlocks.STRIPPED_SHADE_SHROOM_STEM,NetherReachesBlocks.STRIPPED_SHADE_SHROOM_BARK);
        recipes.addWood(NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_STEM,NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_BARK);
        recipes.addWood(NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_STEM,NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_BARK);
        recipes.addWood(NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_STEM,NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_BARK);
    }
}
