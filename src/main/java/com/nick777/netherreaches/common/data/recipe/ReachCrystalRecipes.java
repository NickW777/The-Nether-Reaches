package com.nick777.netherreaches.common.data.recipe;

import com.nick777.netherreaches.common.data.Triggers;
import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.util.NetherReachesUtil;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public final class ReachCrystalRecipes {
    private final Consumer<IFinishedRecipe> consumer;

    ReachCrystalRecipes(Consumer<IFinishedRecipe> consumer) {
        this.consumer = consumer;
    }

    public static ReachCrystalRecipes into(Consumer<IFinishedRecipe> consumer) {
        return new ReachCrystalRecipes(consumer);
    }

    public ReachCrystalRecipes addReachCrystalFromShards(IItemProvider crystal, IItemProvider shard) {
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

    public ReachCrystalRecipes addReachCrystalFromDyes(IItemProvider crystal, IItemProvider dyeItem) {
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
}
