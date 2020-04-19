package com.nick777.netherreaches.common.data.recipe;

import com.nick777.netherreaches.common.data.Triggers;
import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static com.nick777.netherreaches.NetherReaches.MODID;

public final class NetherReachesCrystalRecipes extends NetherReachesRecipeProvider{
    public NetherReachesCrystalRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.BLACK_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.BLACK_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.BLACK_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "black_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.BLUE_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.BLUE_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.BLUE_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "blue_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.BROWN_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.BROWN_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.BROWN_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "brown_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.CYAN_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.CYAN_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.CYAN_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "cyan_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.GRAY_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.GRAY_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.GRAY_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "gray_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.GREEN_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.GREEN_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.GREEN_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "green_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.LIGHT_BLUE_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.LIGHT_BLUE_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.LIGHT_BLUE_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "light_blue_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.LIGHT_GRAY_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.LIGHT_GRAY_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.LIGHT_GRAY_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "light_gray_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.LIME_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.LIME_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.LIME_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "lime_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.MAGENTA_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.MAGENTA_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.MAGENTA_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "magenta_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.ORANGE_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.ORANGE_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.ORANGE_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "orange_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.PINK_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.PINK_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.PINK_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "pink_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.PURPLE_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.PURPLE_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.PURPLE_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "purple_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.RED_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.RED_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.RED_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "red_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.WHITE_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.WHITE_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "white_reachcrystal_from_shards"));

        ShapedRecipeBuilder.shapedRecipe(NetherReachesBlocks.YELLOW_REACHCRYSTAL)
                .patternLine("##")
                .patternLine("##")
                .key('#', NetherReachesItems.YELLOW_REACHCRYSTAL_SHARD)
                .addCriterion("has_shards", Triggers.hasItem(NetherReachesItems.YELLOW_REACHCRYSTAL_SHARD))
                .setGroup("reachcrystal_blocks_from_shards")
                .build(consumer, new ResourceLocation(MODID, "yellow_reachcrystal_from_shards"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.BLACK_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Tags.Items.DYES_BLACK)
                .addCriterion("has_dye", Triggers.hasItem(Items.BLACK_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "black_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.BLUE_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.BLUE_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.BLUE_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "blue_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.BROWN_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.BROWN_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.BROWN_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "brown_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.CYAN_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.CYAN_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.CYAN_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "cyan_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.GRAY_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.GRAY_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.GRAY_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "gray_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.GREEN_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.GREEN_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.GREEN_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "green_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.LIGHT_BLUE_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.LIGHT_BLUE_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.LIGHT_BLUE_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "light_blue_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.LIGHT_GRAY_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.LIGHT_GRAY_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.LIGHT_GRAY_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "light_gray_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.LIME_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.LIME_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.LIME_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "lime_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.MAGENTA_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.MAGENTA_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.MAGENTA_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "magenta_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.ORANGE_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.ORANGE_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.ORANGE_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "orange_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.PINK_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.PINK_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.PINK_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "pink_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.PURPLE_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.PURPLE_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.PURPLE_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "purple_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.RED_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.RED_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.RED_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "red_reachcrystal_from_dye"));

        ShapelessRecipeBuilder.shapelessRecipe(NetherReachesBlocks.YELLOW_REACHCRYSTAL)
                .addIngredient(NetherReachesBlocks.WHITE_REACHCRYSTAL)
                .addIngredient(Items.YELLOW_DYE)
                .addCriterion("has_dye", Triggers.hasItem(Items.YELLOW_DYE))
                .addCriterion("has_shard", Triggers.hasItem(NetherReachesBlocks.WHITE_REACHCRYSTAL))
                .setGroup("reachcrystal_blocks_from_dyes")
                .build(consumer, new ResourceLocation(MODID, "yellow_reachcrystal_from_dye"));

    }
}
