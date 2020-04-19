package com.nick777.netherreaches.common.data.recipe;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public final class NetherReachesWoodenRecipes extends NetherReachesRecipeProvider{
    public NetherReachesWoodenRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        StandardRecipes recipes = StandardRecipes.into(consumer);
//        recipes.ofMaterial(NetherReachesBlocks.SHADE_SHROOM_PLANKS)

        recipes.addPlanks(NetherReachesBlocks.SHADE_SHROOM_STEM, NetherReachesBlocks.SHADE_SHROOM_PLANKS);
    }
}
