package com.nick777.netherreaches.common.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.Arrays;
import java.util.List;

import static com.nick777.netherreaches.common.registry.NetherReachesBlocks.*;
import static com.nick777.netherreaches.common.registry.NetherReachesItems.*;

public class NetherReachesItemGroups {



    public static final ItemGroup BUILDING = new ItemGroup("netherreaches_building") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(NetherReachesBlocks.SHADE_SHROOM_STEM);
        }

        @Override
        public void fill(NonNullList<ItemStack> items) {
            List<Item> building = Arrays.asList(SHADE_STONE.asItem(), SHINE_STONE.asItem(), SHADE_STONE_BRICKS.asItem(), SHINE_STONE_BRICKS.asItem(),
                    CRACKED_SHADE_STONE_BRICKS.asItem(), CRACKED_SHINE_STONE_BRICKS.asItem(), MOSSY_SHADE_STONE_BRICKS.asItem(), MOSSY_SHINE_STONE_BRICKS.asItem(),
                    MOSSY_CRACKED_SHADE_STONE_BRICKS.asItem(), MOSSY_CRACKED_SHINE_STONE_BRICKS.asItem(), BLIGHT_SHROOM_STEM.asItem(), CINDER_SHROOM_STEM.asItem(),
                    SHADE_SHROOM_STEM.asItem(), SHOCK_SHROOM_STEM.asItem(), TANGLE_SHROOM_STEM.asItem(), TOXIC_SHROOM_STEM.asItem(), STRIPPED_BLIGHT_SHROOM_STEM.asItem(),
                    STRIPPED_CINDER_SHROOM_STEM.asItem(), STRIPPED_SHADE_SHROOM_STEM.asItem(), STRIPPED_SHOCK_SHROOM_STEM.asItem(), STRIPPED_TANGLE_SHROOM_STEM.asItem(),
                    STRIPPED_TOXIC_SHROOM_STEM.asItem(), BLIGHT_SHROOM_BARK.asItem(), CINDER_SHROOM_BARK.asItem(), SHADE_SHROOM_BARK.asItem(), SHOCK_SHROOM_BARK.asItem(),
                    TANGLE_SHROOM_BARK.asItem(), TOXIC_SHROOM_BARK.asItem(), STRIPPED_BLIGHT_SHROOM_BARK.asItem(), STRIPPED_CINDER_SHROOM_BARK.asItem(),
                    STRIPPED_SHADE_SHROOM_BARK.asItem(), STRIPPED_SHOCK_SHROOM_BARK.asItem(), STRIPPED_TANGLE_SHROOM_BARK.asItem(), STRIPPED_TOXIC_SHROOM_BARK.asItem(),
                    BERNEG_ORE.asItem(), FARON_ORE.asItem(), ILLIA_ORE.asItem(), REGITE_ORE.asItem(), SHARNIK_ORE.asItem(), BERNEG_BLOCK.asItem(), FARON_BLOCK.asItem(),
                    ILLIA_BLOCK.asItem(), REGITE_BLOCK.asItem(), SHARNIK_BLOCK.asItem(), BLIGHT_SHROOM_PLANKS.asItem(), CINDER_SHROOM_PLANKS.asItem(),
                    SHADE_SHROOM_PLANKS.asItem(), SHOCK_SHROOM_PLANKS.asItem(), TANGLE_SHROOM_PLANKS.asItem(), TOXIC_SHROOM_PLANKS.asItem(), BLIGHT_SHROOM_SLAB.asItem(),
                    CINDER_SHROOM_SLAB.asItem(), SHADE_SHROOM_SLAB.asItem(), SHOCK_SHROOM_SLAB.asItem(), TANGLE_SHROOM_SLAB.asItem(), TOXIC_SHROOM_SLAB.asItem(),
                    BLIGHT_SHROOM_STAIRS.asItem(), CINDER_SHROOM_STAIRS.asItem(), SHADE_SHROOM_STAIRS.asItem(), TANGLE_SHROOM_STAIRS.asItem(), TOXIC_SHROOM_STAIRS.asItem(),
                    SHOCK_SHROOM_STAIRS.asItem());
            items.clear();

            for (Item item : building) {
                if(item.getCreativeTabs().contains(BUILDING))
                {
                    items.add(new ItemStack(item));
                }
            }
        }
    };
    public static final ItemGroup DECORATION = new ItemGroup("netherreaches_decoration") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(NetherReachesBlocks.BLUE_REACHCRYSTAL);
        }

        @Override
        public void fill(NonNullList<ItemStack> items) {
            List<Item> decoration = Arrays.asList(BLACK_REACHCRYSTAL.asItem(), BLUE_REACHCRYSTAL.asItem(), BROWN_REACHCRYSTAL.asItem(), CYAN_REACHCRYSTAL.asItem(),
                    GRAY_REACHCRYSTAL.asItem(), GREEN_REACHCRYSTAL.asItem(), LIGHT_BLUE_REACHCRYSTAL.asItem(), LIGHT_GRAY_REACHCRYSTAL.asItem(), LIME_REACHCRYSTAL.asItem(),
                    MAGENTA_REACHCRYSTAL.asItem(), ORANGE_REACHCRYSTAL.asItem(), PINK_REACHCRYSTAL.asItem(), PURPLE_REACHCRYSTAL.asItem(), RED_REACHCRYSTAL.asItem(),
                    WHITE_REACHCRYSTAL.asItem(), YELLOW_REACHCRYSTAL.asItem(), BLIGHT_SHROOM_CAP.asItem(), CINDER_SHROOM_CAP.asItem(), SHADE_SHROOM_CAP.asItem(),
                    SHOCK_SHROOM_CAP.asItem(), TANGLE_SHROOM_CAP.asItem(), TOXIC_SHROOM_CAP.asItem(), BLIGHT_SHROOM_SAPLING.asItem(), CINDER_SHROOM_SAPLING.asItem(),
                    SHADE_SHROOM_SAPLING.asItem(), SHOCK_SHROOM_SAPLING.asItem(), TANGLE_SHROOM_SAPLING.asItem(), TOXIC_SHROOM_SAPLING.asItem(), BLIGHT_SHROOM_FENCE.asItem(),
                    CINDER_SHROOM_FENCE.asItem(), SHADE_SHROOM_FENCE.asItem(), SHOCK_SHROOM_FENCE.asItem(), TANGLE_SHROOM_FENCE.asItem(), TOXIC_SHROOM_FENCE.asItem(),
                    BLACK_REACHCRYSTAL_LANTERN.asItem(), BLUE_REACHCRYSTAL_LANTERN.asItem(), BROWN_REACHCRYSTAL_LANTERN.asItem(),
                    CYAN_REACHCRYSTAL_LANTERN.asItem(), GRAY_REACHCRYSTAL_LANTERN.asItem(), GREEN_REACHCRYSTAL_LANTERN.asItem(), LIGHT_BLUE_REACHCRYSTAL_LANTERN.asItem(),
                    LIGHT_GRAY_REACHCRYSTAL_LANTERN.asItem(), LIME_REACHCRYSTAL_LANTERN.asItem(), MAGENTA_REACHCRYSTAL_LANTERN.asItem(), ORANGE_REACHCRYSTAL_LANTERN.asItem(),
                    PINK_REACHCRYSTAL_LANTERN.asItem(), PURPLE_REACHCRYSTAL_LANTERN.asItem(), RED_REACHCRYSTAL_LANTERN.asItem(), WHITE_REACHCRYSTAL_LANTERN.asItem(),
                    YELLOW_REACHCRYSTAL_LANTERN.asItem(), BLIGHT_SHROOM_LADDER.asItem(), CINDER_SHROOM_LADDER.asItem(), SHADE_SHROOM_LADDER.asItem(), SHOCK_SHROOM_LADDER.asItem(),
                    TANGLE_SHROOM_LADDER.asItem(), TOXIC_SHROOM_LADDER.asItem());
            items.clear();
            for (Item item : decoration) {
                if(item.getCreativeTabs().contains(DECORATION))
                {
                    items.add(new ItemStack(item));
                }
            }

        }
    };
    public static final ItemGroup REDSTONES = new ItemGroup("netherreaches_redstone") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(NetherReachesBlocks.SHADE_SHROOM_BUTTON);
        }

        @Override
        public void fill(NonNullList<ItemStack> items) {
            List<Item> redstone = Arrays.asList(BLIGHT_SHROOM_DOOR.asItem(), CINDER_SHROOM_DOOR.asItem(), SHADE_SHROOM_DOOR.asItem(), SHOCK_SHROOM_DOOR.asItem(),
                    TANGLE_SHROOM_DOOR.asItem(), TOXIC_SHROOM_DOOR.asItem(), BLIGHT_SHROOM_BUTTON.asItem(), CINDER_SHROOM_BUTTON.asItem(), SHADE_SHROOM_BUTTON.asItem(),
                    SHOCK_SHROOM_BUTTON.asItem(), TANGLE_SHROOM_BUTTON.asItem(), TOXIC_SHROOM_BUTTON.asItem(), BLIGHT_SHROOM_TRAPDOOR.asItem(),
                    CINDER_SHROOM_TRAPDOOR.asItem(), SHADE_SHROOM_TRAPDOOR.asItem(), SHOCK_SHROOM_TRAPDOOR.asItem(), TANGLE_SHROOM_TRAPDOOR.asItem(),
                    TOXIC_SHROOM_TRAPDOOR.asItem(), BLIGHT_SHROOM_PRESSURE_PLATE.asItem(), CINDER_SHROOM_PRESSURE_PLATE.asItem(), SHADE_SHROOM_PRESSURE_PLATE.asItem(),
                    SHOCK_SHROOM_PRESSURE_PLATE.asItem(), TANGLE_SHROOM_PRESSURE_PLATE.asItem(), TOXIC_SHROOM_PRESSURE_PLATE.asItem(), BLIGHT_SHROOM_FENCE_GATE.asItem(),
                    CINDER_SHROOM_FENCE_GATE.asItem(), SHADE_SHROOM_FENCE_GATE.asItem(), SHOCK_SHROOM_FENCE_GATE.asItem(), TANGLE_SHROOM_FENCE_GATE.asItem(),
                    TOXIC_SHROOM_FENCE_GATE.asItem());
            items.clear();
            for (Item item : redstone) {
                if(item.getCreativeTabs().contains(REDSTONES))
                {
                    items.add(new ItemStack(item));
                }
            }
        }
    };
    public static final ItemGroup ITEM = new ItemGroup("netherreaches_item") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(NetherReachesItems.WHITE_REACHCRYSTAL_SHARD);
        }

        @Override
        public void fill(NonNullList<ItemStack> items) {
            List<Item> itemList = Arrays.asList(BLACK_REACHCRYSTAL_SHARD, BLUE_REACHCRYSTAL_SHARD, BROWN_REACHCRYSTAL_SHARD, CYAN_REACHCRYSTAL_SHARD,
                    GRAY_REACHCRYSTAL_SHARD, GREEN_REACHCRYSTAL_SHARD, LIGHT_BLUE_REACHCRYSTAL_SHARD, LIGHT_GRAY_REACHCRYSTAL_SHARD, LIME_REACHCRYSTAL_SHARD,
                    MAGENTA_REACHCRYSTAL_SHARD, ORANGE_REACHCRYSTAL_SHARD, PINK_REACHCRYSTAL_SHARD, PURPLE_REACHCRYSTAL_SHARD, RED_REACHCRYSTAL_SHARD,
                    WHITE_REACHCRYSTAL_SHARD, YELLOW_REACHCRYSTAL_SHARD, BERNEG, FARON, ILLIA, REGITE, SHARNIK, BERNEG_CHUNK, BLIGHT_STICK, CINDER_STICK,
                    SHADE_STICK, SHOCK_STICK, TANGLE_STICK, TOXIC_STICK);
            items.clear();
            for (Item item : itemList) {
                if(item.getCreativeTabs().contains(ITEM))
                {
                    items.add(new ItemStack(item));
                }
            }
        }
    };
}
