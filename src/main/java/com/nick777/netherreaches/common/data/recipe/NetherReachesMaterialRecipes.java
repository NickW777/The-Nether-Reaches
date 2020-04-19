package com.nick777.netherreaches.common.data.recipe;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public final class NetherReachesMaterialRecipes extends NetherReachesRecipeProvider {
    public NetherReachesMaterialRecipes (DataGenerator generator) {
        super (generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        StandardRecipes recipes = StandardRecipes.into(consumer);

        recipes.ofMaterial(NetherReachesItems.BERNEG)
                .addStorageBlock(NetherReachesBlocks.BERNEG_BLOCK);

        recipes.ofMaterial(NetherReachesItems.FARON)
                .addStorageBlock(NetherReachesBlocks.FARON_BLOCK);

        recipes.ofMaterial(NetherReachesItems.ILLIA)
                .addStorageBlock(NetherReachesBlocks.ILLIA_BLOCK);

        recipes.ofMaterial(NetherReachesItems.REGITE)
                .addStorageBlock(NetherReachesBlocks.REGITE_BLOCK);

        recipes.ofMaterial(NetherReachesItems.SHARNIK)
                .addStorageBlock(NetherReachesBlocks.SHARNIK_BLOCK);



        recipes.addIngot(NetherReachesBlocks.ILLIA_ORE, NetherReachesItems.ILLIA);
        recipes.addIngot(NetherReachesBlocks.REGITE_ORE, NetherReachesItems.REGITE);
        recipes.addIngot(NetherReachesBlocks.SHARNIK_ORE, NetherReachesItems.SHARNIK);
    }
}
