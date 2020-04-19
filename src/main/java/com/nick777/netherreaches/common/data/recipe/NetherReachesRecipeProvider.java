package com.nick777.netherreaches.common.data.recipe;

import com.google.gson.JsonObject;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;

import java.nio.file.Path;
import java.util.function.Consumer;

public abstract class NetherReachesRecipeProvider extends RecipeProvider {
    public NetherReachesRecipeProvider (DataGenerator generator) {
        super(generator);
    }

    protected abstract void registerRecipes(Consumer<IFinishedRecipe> consumer);

    @Override
    protected void saveRecipeAdvancement(DirectoryCache cache, JsonObject advancementJson, Path path) {
        if (path.getFileName().toString().equals("root.json")) return;
        super.saveRecipeAdvancement(cache, advancementJson, path);
    }

    @Override
    public String getName() {
        return "Nether Reaches Recipes";
    }
}
