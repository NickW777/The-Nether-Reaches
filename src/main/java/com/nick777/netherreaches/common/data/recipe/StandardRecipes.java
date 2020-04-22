package com.nick777.netherreaches.common.data.recipe;

import com.nick777.netherreaches.common.data.Triggers;
import com.nick777.netherreaches.common.registry.NetherReachesTags;
import com.nick777.netherreaches.common.util.NetherReachesUtil;
import net.minecraft.data.*;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public final class StandardRecipes {
    private final Consumer<IFinishedRecipe> consumer;

    StandardRecipes(Consumer<IFinishedRecipe> consumer) {
        this.consumer = consumer;
    }

    public static StandardRecipes into(Consumer<IFinishedRecipe> consumer) {
        return new StandardRecipes(consumer);
    }

    public Material ofMaterial(IItemProvider material) {
        return new Material(this.consumer, material);
    }

    public StandardRecipes addPlanks(IItemProvider material, IItemProvider planks) {
        ShapelessRecipeBuilder.shapelessRecipe(planks, 4)
                .addIngredient(material)
                .addCriterion("has_log", Triggers.hasItem(material))
                .build(this.consumer);

        return this;
    }

    public StandardRecipes addFood(IItemProvider raw, IItemProvider cooked) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(cooked.asItem());

        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(raw), cooked, 0.35F, 200)
                .addCriterion("has_raw", Triggers.hasItem(raw))
                .build(this.consumer);

        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(raw), cooked, 0.35F, 100, IRecipeSerializer.SMOKING)
                .addCriterion("has_raw", Triggers.hasItem(raw))
                .build(this.consumer, NetherReachesUtil.transformPath(id, path -> path + "_from_smoking"));

        CookingRecipeBuilder.cookingRecipe(Ingredient.fromItems(raw), cooked, 0.35F, 400, IRecipeSerializer.CAMPFIRE_COOKING)
                .addCriterion("has_raw", Triggers.hasItem(raw))
                .build(this.consumer, NetherReachesUtil.transformPath(id, path -> path + "_from_campfire_cooking"));

        return this;
    }

    public StandardRecipes addIngot(IItemProvider ore, IItemProvider ingot) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(ingot.asItem());

        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ore), ingot, 1.0F, 200)
                .addCriterion("has_ore", Triggers.hasItem(ore))
                .build(this.consumer);

        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(ore), ingot, 1.0F, 100)
                .addCriterion("has_ore", Triggers.hasItem(ore))
                .build(this.consumer, NetherReachesUtil.transformPath(id, path -> path + "_from_blasting"));

        return this;
    }

    public static class Material {
        private final Consumer<IFinishedRecipe> consumer;
        private final IItemProvider material;

        private Material(Consumer<IFinishedRecipe> consumer, IItemProvider material) {
            this.consumer = consumer;
            this.material = material;
        }

        public Material addStick(IItemProvider stick) {
            ShapedRecipeBuilder.shapedRecipe(stick)
                    .patternLine("#")
                    .patternLine("#")
                    .key('#', this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);
            return this;
        }

        public Material addButton(IItemProvider button) {
            ShapelessRecipeBuilder.shapelessRecipe(button)
                    .addIngredient(this.material)
                    .setGroup("nether_reaches_buttons")
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addChest(IItemProvider chest) {
            ShapedRecipeBuilder.shapedRecipe(chest)
                    .patternLine("###")
                    .patternLine("# #")
                    .patternLine("###")
                    .key('#', this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addCraftingTable(IItemProvider craftingTable) {
            ShapedRecipeBuilder.shapedRecipe(craftingTable)
                    .patternLine("##")
                    .patternLine("##")
                    .key('#', this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addDoor(IItemProvider door) {
            ShapedRecipeBuilder.shapedRecipe(door, 3)
                    .patternLine("##")
                    .patternLine("##")
                    .patternLine("##")
                    .key('#', this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .setGroup("nether_reaches_doors")
                    .build(this.consumer);

            return this;
        }

        public Material addFence(IItemProvider fence) {
            ShapedRecipeBuilder.shapedRecipe(fence, 3)
                    .patternLine("#|#")
                    .patternLine("#|#")
                    .key('#', this.material)
                    .key('|', NetherReachesTags.Items.SHROOM_STICKS)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .setGroup("nether_reaches_fences")
                    .build(this.consumer);

            return this;
        }

        public Material addSign(IItemProvider sign) {
            ShapedRecipeBuilder.shapedRecipe(sign, 3)
                    .patternLine("###")
                    .patternLine("###")
                    .patternLine(" | ")
                    .key('#', this.material)
                    .key('|', NetherReachesTags.Items.SHROOM_STICKS)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .setGroup("nether_reaches_signs")
                    .build(this.consumer);
            return this;
        }

        public Material addFenceGate(IItemProvider fenceGate) {
            ShapedRecipeBuilder.shapedRecipe(fenceGate)
                    .patternLine("|#|")
                    .patternLine("|#|")
                    .key('#', this.material)
                    .key('|', NetherReachesTags.Items.SHROOM_STICKS)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .setGroup("nether_reaches_fence_gates")
                    .build(this.consumer);

            return this;
        }

        public Material addLadder(IItemProvider ladder) {
            ShapedRecipeBuilder.shapedRecipe(ladder, 3)
                    .patternLine("| |")
                    .patternLine("|#|")
                    .patternLine("| |")
                    .key('#', this.material)
                    .key('|', NetherReachesTags.Items.SHROOM_STICKS)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addPressurePlate(IItemProvider pressurePlate) {
            ShapedRecipeBuilder.shapedRecipe(pressurePlate)
                    .patternLine("##")
                    .key('#', this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addSlab(IItemProvider slab) {
            ShapedRecipeBuilder.shapedRecipe(slab, 6)
                    .patternLine("###")
                    .key('#', this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addStoneSlab(IItemProvider slab) {
            this.addSlab(slab);

            ResourceLocation id = ForgeRegistries.ITEMS.getKey(slab.asItem());
            SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(this.material), slab, 2)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer, NetherReachesUtil.transformPath(id, path -> path + "_stonecutting"));

            return this;
        }

        public Material addStairs(IItemProvider stairs) {
            ShapedRecipeBuilder.shapedRecipe(stairs, 4)
                    .patternLine("#  ")
                    .patternLine("## ")
                    .patternLine("###")
                    .key('#', this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addStoneStairs(IItemProvider stairs) {
            this.addStairs(stairs);

            ResourceLocation id = ForgeRegistries.ITEMS.getKey(stairs.asItem());
            SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(this.material), stairs)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer, NetherReachesUtil.transformPath(id, path -> path + "_stonecutting"));

            return this;
        }

        public Material addTrapDoor(IItemProvider trapDoor) {
            ShapedRecipeBuilder.shapedRecipe(trapDoor, 2)
                    .patternLine("###")
                    .patternLine("###")
                    .key('#', this.material)
                    .setGroup("nether_reaches_trapdoors")
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);
            return this;
        }

        public Material addWall(IItemProvider wall) {
            ShapedRecipeBuilder.shapedRecipe(wall, 6)
                    .patternLine("###")
                    .patternLine("###")
                    .key('#', this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            ResourceLocation id = ForgeRegistries.ITEMS.getKey(wall.asItem());

            SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(this.material), wall)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer, NetherReachesUtil.transformPath(id, path -> path + "_stonecutting"));

            return this;
        }

        public Material addPickaxe(IItemProvider pickaxe) {
            ShapedRecipeBuilder.shapedRecipe(pickaxe)
                    .patternLine("###")
                    .patternLine(" | ")
                    .patternLine(" | ")
                    .key('#', this.material)
                    .key('|', NetherReachesTags.Items.SHROOM_STICKS)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addAxe(IItemProvider axe) {
            ShapedRecipeBuilder.shapedRecipe(axe)
                    .patternLine("##")
                    .patternLine("|#")
                    .patternLine("| ")
                    .key('#', this.material)
                    .key('|', NetherReachesTags.Items.SHROOM_STICKS)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addSword(IItemProvider sword) {
            ShapedRecipeBuilder.shapedRecipe(sword)
                    .patternLine("#")
                    .patternLine("#")
                    .patternLine("|")
                    .key('#', this.material)
                    .key('|', NetherReachesTags.Items.SHROOM_STICKS)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);
            return this;
        }

        public Material addShovel(IItemProvider shovel) {
            ShapedRecipeBuilder.shapedRecipe(shovel)
                    .patternLine("#")
                    .patternLine("|")
                    .patternLine("|")
                    .key('#', this.material)
                    .key('|', NetherReachesTags.Items.SHROOM_STICKS)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addHoe(IItemProvider hoe) {
            ShapedRecipeBuilder.shapedRecipe(hoe)
                    .patternLine("##")
                    .patternLine("| ")
                    .patternLine("| ")
                    .key('#', this.material)
                    .key('|', NetherReachesTags.Items.SHROOM_STICKS)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addHelmet(IItemProvider helmet) {
            ShapedRecipeBuilder.shapedRecipe(helmet)
                    .patternLine("###")
                    .patternLine("# #")
                    .key('#', this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addChestPlate(IItemProvider chestPlate) {
            ShapedRecipeBuilder.shapedRecipe(chestPlate)
                    .patternLine("# #")
                    .patternLine("###")
                    .patternLine("###")
                    .key('#', this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addLeggings(IItemProvider leggings) {
            ShapedRecipeBuilder.shapedRecipe(leggings)
                    .patternLine("###")
                    .patternLine("# #")
                    .patternLine("# #")
                    .key('#', this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addBoots(IItemProvider boots) {
            ShapedRecipeBuilder.shapedRecipe(boots)
                    .patternLine("# #")
                    .patternLine("# #")
                    .key('#', this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }

        public Material addStorageBlock(IItemProvider block) {
            ShapedRecipeBuilder.shapedRecipe(block)
                    .patternLine("###")
                    .patternLine("###")
                    .patternLine("###")
                    .key('#', this.material)
                    .setGroup("nether_reaches_storage_block")
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            ResourceLocation id = ForgeRegistries.ITEMS.getKey(this.material.asItem());

            ShapelessRecipeBuilder.shapelessRecipe(this.material, 9)
                    .addIngredient(block)
                    .addCriterion("has_item", Triggers.hasItem(block))
                    .build(this.consumer, NetherReachesUtil.transformPath(id, path -> path + "_from_block"));

            return this;
        }

        public Material addNugget(IItemProvider nugget) {
            ResourceLocation id = ForgeRegistries.ITEMS.getKey(nugget.asItem());

            ShapedRecipeBuilder.shapedRecipe(this.material)
                    .patternLine("###")
                    .patternLine("###")
                    .patternLine("###")
                    .key('#', nugget)
                    .addCriterion("has_nugget", Triggers.hasItem(nugget))
                    .build(this.consumer, NetherReachesUtil.transformPath(id, path -> path + "_from_nuggets"));

            ShapelessRecipeBuilder.shapelessRecipe(nugget, 9)
                    .addIngredient(this.material)
                    .addCriterion("has_item", Triggers.hasItem(this.material))
                    .build(this.consumer);

            return this;
        }


    }
}
