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
                .addStorageBlock(NetherReachesBlocks.BERNEG_BLOCK)
                .addNugget(NetherReachesItems.BERNEG_CHUNK);

        recipes.ofMaterial(NetherReachesItems.FARON)
                .addStorageBlock(NetherReachesBlocks.FARON_BLOCK);

        recipes.ofMaterial(NetherReachesItems.ILLIA)
                .addStorageBlock(NetherReachesBlocks.ILLIA_BLOCK);

        recipes.ofMaterial(NetherReachesItems.REGITE)
                .addStorageBlock(NetherReachesBlocks.REGITE_BLOCK);

        recipes.ofMaterial(NetherReachesItems.SHARNIK)
                .addStorageBlock(NetherReachesBlocks.SHARNIK_BLOCK);

        recipes.ofMaterial(NetherReachesBlocks.SHADE_STONE)
                .addBricks(NetherReachesBlocks.SHADE_STONE_BRICKS);
//        recipes.addMossyBricks(NetherReachesBlocks.SHADE_STONE_BRICKS, NetherReachesBlocks.MOSSY_SHADE_STONE_BRICKS);
        recipes.addCrackedBricks(NetherReachesBlocks.SHADE_STONE_BRICKS, NetherReachesBlocks.CRACKED_SHADE_STONE_BRICKS);
        recipes.addMossyCrackedBricks(NetherReachesBlocks.MOSSY_SHADE_STONE_BRICKS, NetherReachesBlocks.MOSSY_CRACKED_SHADE_STONE_BRICKS);

        recipes.ofMaterial(NetherReachesBlocks.SHINE_STONE)
                .addBricks(NetherReachesBlocks.SHINE_STONE_BRICKS);
//        recipes.addMossyBricks(NetherReachesBlocks.SHINE_STONE_BRICKS, NetherReachesBlocks.MOSSY_SHINE_STONE_BRICKS);
        recipes.addCrackedBricks(NetherReachesBlocks.SHINE_STONE_BRICKS, NetherReachesBlocks.CRACKED_SHINE_STONE_BRICKS);
        recipes.addMossyCrackedBricks(NetherReachesBlocks.MOSSY_SHINE_STONE_BRICKS, NetherReachesBlocks.MOSSY_CRACKED_SHINE_STONE_BRICKS);


        recipes.addIngot(NetherReachesBlocks.BERNEG_ORE, NetherReachesItems.BERNEG);
        recipes.addIngot(NetherReachesBlocks.FARON_ORE, NetherReachesItems.FARON);
        recipes.addIngot(NetherReachesBlocks.ILLIA_ORE, NetherReachesItems.ILLIA);
        recipes.addIngot(NetherReachesBlocks.REGITE_ORE, NetherReachesItems.REGITE);
        recipes.addIngot(NetherReachesBlocks.SHARNIK_ORE, NetherReachesItems.SHARNIK);
    }
}
