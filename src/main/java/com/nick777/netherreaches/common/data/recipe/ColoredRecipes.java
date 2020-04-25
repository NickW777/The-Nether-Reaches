package com.nick777.netherreaches.common.data.recipe;

import com.nick777.netherreaches.common.data.Triggers;
import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesItems;
import com.nick777.netherreaches.common.util.NetherReachesUtil;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public final class ColoredRecipes {
    private final Consumer<IFinishedRecipe> consumer;

    ColoredRecipes(Consumer<IFinishedRecipe> consumer) {
        this.consumer = consumer;
    }

    public static ColoredRecipes into(Consumer<IFinishedRecipe> consumer) {
        return new ColoredRecipes(consumer);
    }

    public ColoredRecipes addReachCrystalFromShards(IItemProvider crystal, IItemProvider shard) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(crystal.asItem());

        ShapedRecipeBuilder.shapedRecipe(crystal)
                .patternLine("##")
                .patternLine("##")
                .key('#', shard)
                .addCriterion("has_shards", Triggers.hasItem(shard))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(this.consumer, NetherReachesUtil.transformPath(id, path -> path + "_from_shards"));
        return this;
    }

    public ColoredRecipes addReachCrystalFromDyes(IItemProvider crystal, IItemProvider dyeItem) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(crystal.asItem());

        ShapelessRecipeBuilder.shapelessRecipe(crystal)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(dyeItem)
                .addCriterion("has_dye", Triggers.hasItem(dyeItem))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(this.consumer, NetherReachesUtil.transformPath(id, path -> path + "_from_dye"));
        return this;
    }

    public ColoredRecipes addReachCrystalShardFromDyes(IItemProvider shard, IItemProvider dyeItem) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(shard.asItem());

        ShapelessRecipeBuilder.shapelessRecipe(shard)
                .addIngredient(NetherReachesItems.WHITE_REACHCRYSTAL_SHARD)
                .addIngredient(dyeItem)
                .addCriterion("has_dye", Triggers.hasItem(dyeItem))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesItems.WHITE_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(this.consumer, NetherReachesUtil.transformPath(id, path -> path + "_from_dye"));
        return this;
    }

    public ColoredRecipes addReachCrystalLantern(IItemProvider lantern, IItemProvider shard) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(shard.asItem());

        ShapedRecipeBuilder.shapedRecipe(lantern)
                .patternLine("---")
                .patternLine("-#-")
                .patternLine("---")
                .key('-', NetherReachesItems.BERNEG_CHUNK)
                .key('#', shard)
                .addCriterion("has_shard",Triggers.hasItem(shard))
                .addCriterion("has_berneg_chunk", Triggers.hasItem(NetherReachesItems.BERNEG_CHUNK))
                .setGroup("reachcrystal_lanterns")
                .build(this.consumer);
        return this;
    }
}
