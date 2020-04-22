package com.nick777.netherreaches.common.registry;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.*;
import net.minecraft.util.ResourceLocation;

import static com.nick777.netherreaches.NetherReaches.MODID;

public class NetherReachesTags {

    public static class Blocks {
        public static final Tag<Block> CAN_HOLD_ORES = tag("can_hold_ores");
        public static final Tag<Block> SHADE_SHROOM = tag("shade_shroom");
        public static final Tag<Block> SHOCK_SHROOM = tag("shock_shroom");
        public static final Tag<Block> SHROOM_BUTTONS = tag("shroom_buttons");
        public static final Tag<Block> SHROOM_CAPS = tag("shroom_caps");
        public static final Tag<Block> SHROOM_DOORS = tag("shroom_doors");
        public static final Tag<Block> SHROOM_FENCES = tag("shroom_fences");
        public static final Tag<Block> SHROOM_FENCE_GATES = tag("shroom_fence_gates");
        public static final Tag<Block> SHROOM_PLANKS = tag("shroom_planks");
        public static final Tag<Block> SHROOM_PRESSURE_PLATES = tag("shroom_pressure_plates");
        public static final Tag<Block> SHROOM_SAPLINGS = tag("shroom_saplings");
        public static final Tag<Block> SHROOM_SLABS = tag("shroom_slabs");
        public static final Tag<Block> SHROOM_STAIRS = tag("shroom_stairs");
        public static final Tag<Block> SHADE_SHROOM_STEMS = tag("shade_shroom_stems");
        public static final Tag<Block> SHOCK_SHROOM_STEMS = tag("shock_shroom_stems");
        public static final Tag<Block> SHROOM_TRAPDOORS = tag("shroom_trapdoors");
        public static final Tag<Block> REACHCRYSTALS = tag("reachcrystals");
        public static final Tag<Block> STONES = tag("stones");

        private static Tag<Block> tag(String name) {
            return new BlockTags.Wrapper(new ResourceLocation(MODID, name));
        }
    }

    public static class Items {

        public static final Tag<Item> SHADE_SHROOM = tag("shade_shroom");
        public static final Tag<Item> SHOCK_SHROOM = tag("shock_shroom");
        public static final Tag<Item> SHROOM_BUTTONS = tag("shroom_buttons");
        public static final Tag<Item> SHROOM_CAPS = tag("shroom_caps");
        public static final Tag<Item> SHROOM_DOORS = tag("shroom_doors");
        public static final Tag<Item> SHROOM_FENCES = tag("shroom_fences");
        public static final Tag<Item> SHROOM_FENCE_GATES = tag("shroom_fence_gates");
        public static final Tag<Item> SHROOM_PLANKS = tag("shroom_planks");
        public static final Tag<Item> SHROOM_PRESSURE_PLATES = tag("shroom_pressure_plates");
        public static final Tag<Item> SHROOM_SAPLINGS = tag("shroom_saplings");
        public static final Tag<Item> SHROOM_SLABS = tag("shroom_slabs");
        public static final Tag<Item> SHROOM_STAIRS = tag("shroom_stairs");
        public static final Tag<Item> SHADE_SHROOM_STEMS = tag("shade_shroom_stems");
        public static final Tag<Item> SHOCK_SHROOM_STEMS = tag("shock_shroom_stems");
        public static final Tag<Item> SHROOM_TRAPDOORS = tag("shroom_trapdoors");
        public static final Tag<Item> REACHCHRYSTALS = tag("reachcrystals");
        public static final Tag<Item> REACHCRYSTAL_SHARDS = tag("reachcrystal_shards");
        public static final Tag<Item> STONES = tag("stones");
        public static final Tag<Item> SHROOM_STICKS = tag("shroom_sticks");
        public static final Tag<Item> GEMS = tag("gems");

        private static Tag<Item> tag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation(MODID, name));
        }
    }

    public static class Fluids {
        public static final Tag<Fluid> MIASMA = tag("miasma");
        public static final Tag<Fluid> DARK_WATER = tag("dark_water");

        private static Tag<Fluid> tag(String name) {
            return new FluidTags.Wrapper(new ResourceLocation(MODID, name));
        }
    }

    public static class EntityTypes {
        public static final Tag<EntityType<?>> IGNORE_MUD = tag("ignore_mud");

        private static Tag<EntityType<?>> tag(String name) {
            return new EntityTypeTags.Wrapper(new ResourceLocation(MODID, name));
        }
    }
}
