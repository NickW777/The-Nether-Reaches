package com.nick777.netherreaches.common.data.recipe;

import com.nick777.netherreaches.common.registry.NetherReachesItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public final class NetherReachesFurnaceRecipes extends NetherReachesRecipeProvider {
    public NetherReachesFurnaceRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        StandardRecipes recipes = StandardRecipes.into(consumer);

        recipes.addIngot(Items.LAVA_BUCKET, NetherReachesItems.MAGMA_BUCKET);

    }
}
