package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.NetherReaches;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.*;
import net.minecraft.util.ResourceLocation;

public class NetherReachesTags {

    public static class Blocks {
        public static final Tag<Block> CAN_HOLD_ORES = tag("can_hold_ores");
        public static final Tag<Block> ORES = tag("ores");
        public static final Tag<Block> STRIPPED = tag("stripped");
        public static final Tag<Block> SHELF_CRUST = tag("shelf_crust");
        public static final Tag<Block> SHELF_CORE = tag("shelf_core");
        public static final Tag<Block> SHELF_PASTE = tag("shelf_paste");
        public static final Tag<Block> BLIGHT_SHROOM = tag("blight_shroom");
        public static final Tag<Block> CINDER_SHROOM = tag("cinder_shroom");
        public static final Tag<Block> SHADE_SHROOM = tag("shade_shroom");
        public static final Tag<Block> SHOCK_SHROOM = tag("shock_shroom");
        public static final Tag<Block> TANGLE_SHROOM = tag("tangle_shroom");
        public static final Tag<Block> TOXIC_SHROOM = tag("toxic_shroom");
        public static final Tag<Block> AQUANE_SHROOM = tag("aquane_shroom");
        public static final Tag<Block> CRELENOR_SHROOM = tag("crelenor_shroom");
        public static final Tag<Block> GREJAR_SHROOM = tag("grejar_shroom");
        public static final Tag<Block> MOISE_SHROOM = tag("moise_shroom");
        public static final Tag<Block> SABLE_SHROOM = tag("sable_shroom");
        public static final Tag<Block> SHROOM_BARK_BLOCKS = tag("shroom_bark_blocks");
        public static final Tag<Block> SHROOM_BUTTONS = tag("shroom_buttons");
        public static final Tag<Block> SHROOM_CAPS = tag("shroom_caps");
        public static final Tag<Block> SHROOM_DOORS = tag("shroom_doors");
        public static final Tag<Block> SHROOM_FENCES = tag("shroom_fences");
        public static final Tag<Block> SHROOM_FENCE_GATES = tag("shroom_fence_gates");
        public static final Tag<Block> SHROOM_LADDERS = tag("shroom_ladders");
        public static final Tag<Block> SHROOM_PLANKS = tag("shroom_planks");
        public static final Tag<Block> SHROOM_PRESSURE_PLATES = tag("shroom_pressure_plates");
        public static final Tag<Block> SHROOM_SAPLINGS = tag("shroom_saplings");
        public static final Tag<Block> SHROOM_SLABS = tag("shroom_slabs");
        public static final Tag<Block> SHROOM_STAIRS = tag("shroom_stairs");
        public static final Tag<Block> SHROOM_STEMS = tag("shroom_stems");
        public static final Tag<Block> SHROOM_TRAPDOORS = tag("shroom_trapdoors");
        public static final Tag<Block> REACHCRYSTALS = tag("reachcrystals");
        public static final Tag<Block> STONES = tag("stones");
        public static final Tag<Block> BRICKS = tag("bricks");
        public static final Tag<Block> MOSSY = tag("mossy");
        public static final Tag<Block> CRACKED = tag("cracked");
        public static final Tag<Block> SHADE_STONE = tag("shade_stone");
        public static final Tag<Block> SHINE_STONE = tag("shine_stone");
        public static final Tag<Block> HEATED = tag("heated");
        public static final Tag<Block> DIRT = tag("dirt");
        public static final Tag<Block> SHROOM_SHELF_GROW_RESISTANT = tag("shelf_shroom_grow_resistant");

        private static Tag<Block> tag(String name) {
            return new BlockTags.Wrapper(new ResourceLocation(NetherReaches.MODID, name));
        }
    }

    public static class Items {

        public static final Tag<Item> STRIPPED = tag("stripped");
        public static final Tag<Item> BLIGHT_SHROOM = tag("blight_shroom");
        public static final Tag<Item> CINDER_SHROOM = tag("cinder_shroom");
        public static final Tag<Item> SHADE_SHROOM = tag("shade_shroom");
        public static final Tag<Item> SHOCK_SHROOM = tag("shock_shroom");
        public static final Tag<Item> TANGLE_SHROOM = tag("tangle_shroom");
        public static final Tag<Item> TOXIC_SHROOM = tag("toxic_shroom");
        public static final Tag<Item> AQUANE_SHROOM = tag("aquane_shroom");
        public static final Tag<Item> CRELENOR_SHROOM = tag("crelenor_shroom");
        public static final Tag<Item> GREJAR_SHROOM = tag("grejar_shroom");
        public static final Tag<Item> MOISE_SHROOM = tag("moise_shroom");
        public static final Tag<Item> SABLE_SHROOM = tag("sable_shroom");
        public static final Tag<Item> SHELF_CRUST = tag("shelf_crust");
        public static final Tag<Item> SHELF_CORE = tag("shelf_core");
        public static final Tag<Item> SHELF_PASTE = tag("shelf_paste");
        public static final Tag<Item> SHROOM_BARK_BLOCKS = tag("shroom_bark_blocks");
        public static final Tag<Item> SHROOM_BUTTONS = tag("shroom_buttons");
        public static final Tag<Item> SHROOM_CAPS = tag("shroom_caps");
        public static final Tag<Item> SHROOM_DOORS = tag("shroom_doors");
        public static final Tag<Item> SHROOM_FENCES = tag("shroom_fences");
        public static final Tag<Item> SHROOM_FENCE_GATES = tag("shroom_fence_gates");
        public static final Tag<Item> SHROOM_LADDERS = tag("shroom_ladders");
        public static final Tag<Item> SHROOM_PLANKS = tag("shroom_planks");
        public static final Tag<Item> SHROOM_PRESSURE_PLATES = tag("shroom_pressure_plates");
        public static final Tag<Item> SHROOM_SAPLINGS = tag("shroom_saplings");
        public static final Tag<Item> SHROOM_SLABS = tag("shroom_slabs");
        public static final Tag<Item> SHROOM_STAIRS = tag("shroom_stairs");
        public static final Tag<Item> SHROOM_STEMS = tag("shroom_stems");
        public static final Tag<Item> SHROOM_TRAPDOORS = tag("shroom_trapdoors");
        public static final Tag<Item> REACHCHRYSTALS = tag("reachcrystals");
        public static final Tag<Item> REACHCRYSTAL_SHARDS = tag("reachcrystal_shards");
        public static final Tag<Item> STONES = tag("stones");
        public static final Tag<Item> BRICKS = tag("bricks");
        public static final Tag<Item> MOSSY = tag("mossy");
        public static final Tag<Item> CRACKED = tag("cracked");
        public static final Tag<Item> SHADE_STONE = tag("shade_stone");
        public static final Tag<Item> SHINE_STONE = tag("shine_stone");
        public static final Tag<Item> ORES = tag("ores");
        public static final Tag<Item> SHROOM_STICKS = tag("shroom_sticks");
        public static final Tag<Item> GEMS = tag("gems");
        public static final Tag<Item> DIRT = tag("dirt");
        public static final Tag<Item> MAGMA_BUCKET = tag("magma_bucket");
        public static final Tag<Item> REACH_WATER_BUCKET = tag("reach_water_bucket");

        private static Tag<Item> tag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation(NetherReaches.MODID, name));
        }
    }

    public static class Fluids {
        public static final Tag<Fluid> MAGMA = tag("magma");
        public static final Tag<Fluid> REACH_WATER = tag("reach_water");

        private static Tag<Fluid> tag(String name) {
            return new FluidTags.Wrapper(new ResourceLocation(NetherReaches.MODID, name));
        }
    }

    public static class EntityTypes {
        public static final Tag<EntityType<?>> IGNORE_MUD = tag("ignore_mud");

        private static Tag<EntityType<?>> tag(String name) {
            return new EntityTypeTags.Wrapper(new ResourceLocation(NetherReaches.MODID, name));
        }
    }
}
