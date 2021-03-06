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

        recipes.addShelfShroomPaste(NetherReachesBlocks.AQUANE_SHELF_SHROOM_CRUST, NetherReachesBlocks.AQUANE_SHELF_SHROOM_CORE, NetherReachesBlocks.AQUANE_SHELF_SHROOM_PASTE);
        recipes.addShelfShroomPaste(NetherReachesBlocks.CRELENOR_SHELF_SHROOM_CRUST, NetherReachesBlocks.CRELENOR_SHELF_SHROOM_CORE, NetherReachesBlocks.CRELENOR_SHELF_SHROOM_PASTE);
        recipes.addShelfShroomPaste(NetherReachesBlocks.GREJAR_SHELF_SHROOM_CRUST, NetherReachesBlocks.GREJAR_SHELF_SHROOM_CORE, NetherReachesBlocks.GREJAR_SHELF_SHROOM_PASTE);
        recipes.addShelfShroomPaste(NetherReachesBlocks.MOISE_SHELF_SHROOM_CRUST, NetherReachesBlocks.MOISE_SHELF_SHROOM_CORE, NetherReachesBlocks.MOISE_SHELF_SHROOM_PASTE);
        recipes.addShelfShroomPaste(NetherReachesBlocks.SABLE_SHELF_SHROOM_CRUST, NetherReachesBlocks.SABLE_SHELF_SHROOM_CORE, NetherReachesBlocks.SABLE_SHELF_SHROOM_PASTE);

        recipes.addPlanksFromLog(NetherReachesBlocks.BLIGHT_SHROOM_STEM, NetherReachesBlocks.BLIGHT_SHROOM_PLANKS);
        recipes.addPlanksFromLog(NetherReachesBlocks.CINDER_SHROOM_STEM, NetherReachesBlocks.CINDER_SHROOM_PLANKS);
        recipes.addPlanksFromLog(NetherReachesBlocks.SHADE_SHROOM_STEM, NetherReachesBlocks.SHADE_SHROOM_PLANKS);
        recipes.addPlanksFromLog(NetherReachesBlocks.SHOCK_SHROOM_STEM, NetherReachesBlocks.SHOCK_SHROOM_PLANKS);
        recipes.addPlanksFromLog(NetherReachesBlocks.TANGLE_SHROOM_STEM, NetherReachesBlocks.TANGLE_SHROOM_PLANKS);
        recipes.addPlanksFromLog(NetherReachesBlocks.TOXIC_SHROOM_STEM, NetherReachesBlocks.TOXIC_SHROOM_PLANKS);

        recipes.addPlanksFromStrippedLog(NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_STEM, NetherReachesBlocks.BLIGHT_SHROOM_PLANKS);
        recipes.addPlanksFromStrippedLog(NetherReachesBlocks.STRIPPED_CINDER_SHROOM_STEM, NetherReachesBlocks.CINDER_SHROOM_PLANKS);
        recipes.addPlanksFromStrippedLog(NetherReachesBlocks.STRIPPED_SHADE_SHROOM_STEM, NetherReachesBlocks.SHADE_SHROOM_PLANKS);
        recipes.addPlanksFromStrippedLog(NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_STEM, NetherReachesBlocks.SHOCK_SHROOM_PLANKS);
        recipes.addPlanksFromStrippedLog(NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_STEM, NetherReachesBlocks.TANGLE_SHROOM_PLANKS);
        recipes.addPlanksFromStrippedLog(NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_STEM, NetherReachesBlocks.TOXIC_SHROOM_PLANKS);

        recipes.addPlanksFromWood(NetherReachesBlocks.BLIGHT_SHROOM_BARK, NetherReachesBlocks.BLIGHT_SHROOM_PLANKS);
        recipes.addPlanksFromWood(NetherReachesBlocks.CINDER_SHROOM_BARK, NetherReachesBlocks.CINDER_SHROOM_PLANKS);
        recipes.addPlanksFromWood(NetherReachesBlocks.SHADE_SHROOM_BARK, NetherReachesBlocks.SHADE_SHROOM_PLANKS);
        recipes.addPlanksFromWood(NetherReachesBlocks.SHOCK_SHROOM_BARK, NetherReachesBlocks.SHOCK_SHROOM_PLANKS);
        recipes.addPlanksFromWood(NetherReachesBlocks.TANGLE_SHROOM_BARK, NetherReachesBlocks.TANGLE_SHROOM_PLANKS);
        recipes.addPlanksFromWood(NetherReachesBlocks.TOXIC_SHROOM_BARK, NetherReachesBlocks.TOXIC_SHROOM_PLANKS);

        recipes.addPlanksFromStrippedWood(NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_BARK, NetherReachesBlocks.BLIGHT_SHROOM_PLANKS);
        recipes.addPlanksFromStrippedWood(NetherReachesBlocks.STRIPPED_CINDER_SHROOM_BARK, NetherReachesBlocks.CINDER_SHROOM_PLANKS);
        recipes.addPlanksFromStrippedWood(NetherReachesBlocks.STRIPPED_SHADE_SHROOM_BARK, NetherReachesBlocks.SHADE_SHROOM_PLANKS);
        recipes.addPlanksFromStrippedWood(NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_BARK, NetherReachesBlocks.SHOCK_SHROOM_PLANKS);
        recipes.addPlanksFromStrippedWood(NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_BARK, NetherReachesBlocks.TANGLE_SHROOM_PLANKS);
        recipes.addPlanksFromStrippedWood(NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_BARK, NetherReachesBlocks.TOXIC_SHROOM_PLANKS);

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
