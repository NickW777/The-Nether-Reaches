package com.nick777.netherreaches.common.data.recipe;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public final class NetherReachesCrystalRecipes extends NetherReachesRecipeProvider{
    public NetherReachesCrystalRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ReachCrystalRecipes recipes = ReachCrystalRecipes.into(consumer);

        recipes.addReachCrystalFromShards(NetherReachesBlocks.BLACK_REACHCRYSTAL, NetherReachesItems.BLACK_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.BLUE_REACHCRYSTAL, NetherReachesItems.BLUE_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.BROWN_REACHCRYSTAL, NetherReachesItems.BROWN_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.CYAN_REACHCRYSTAL, NetherReachesItems.CYAN_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.GRAY_REACHCRYSTAL, NetherReachesItems.GRAY_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.GREEN_REACHCRYSTAL, NetherReachesItems.GREEN_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.LIGHT_BLUE_REACHCRYSTAL, NetherReachesItems.LIGHT_BLUE_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.LIGHT_GRAY_REACHCRYSTAL, NetherReachesItems.LIGHT_GRAY_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.LIME_REACHCRYSTAL, NetherReachesItems.LIME_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.MAGENTA_REACHCRYSTAL, NetherReachesItems.MAGENTA_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.ORANGE_REACHCRYSTAL, NetherReachesItems.ORANGE_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.PINK_REACHCRYSTAL, NetherReachesItems.PINK_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.PURPLE_REACHCRYSTAL, NetherReachesItems.PURPLE_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.RED_REACHCRYSTAL, NetherReachesItems.RED_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.WHITE_REACHCRYSTAL, NetherReachesItems.WHITE_REACHCRYSTAL_SHARD);
        recipes.addReachCrystalFromShards(NetherReachesBlocks.YELLOW_REACHCRYSTAL, NetherReachesItems.YELLOW_REACHCRYSTAL_SHARD);


        recipes.addReachCrystalFromDyes(NetherReachesBlocks.BLACK_REACHCRYSTAL, Items.BLACK_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.BLUE_REACHCRYSTAL, Items.BLUE_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.BROWN_REACHCRYSTAL, Items.BROWN_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.CYAN_REACHCRYSTAL, Items.CYAN_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.GRAY_REACHCRYSTAL, Items.GRAY_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.GREEN_REACHCRYSTAL, Items.GREEN_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.LIGHT_BLUE_REACHCRYSTAL, Items.LIGHT_BLUE_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.LIGHT_GRAY_REACHCRYSTAL, Items.LIGHT_GRAY_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.LIME_REACHCRYSTAL, Items.LIME_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.MAGENTA_REACHCRYSTAL, Items.MAGENTA_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.ORANGE_REACHCRYSTAL, Items.ORANGE_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.PINK_REACHCRYSTAL, Items.PINK_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.PURPLE_REACHCRYSTAL, Items.PURPLE_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.RED_REACHCRYSTAL, Items.RED_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.WHITE_REACHCRYSTAL, Items.WHITE_DYE);
        recipes.addReachCrystalFromDyes(NetherReachesBlocks.YELLOW_REACHCRYSTAL, Items.YELLOW_DYE);
    }
}
