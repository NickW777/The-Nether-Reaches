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
        public static final Tag<Block> FUNGI_STEMS = tag("fungi_stems");
        public static final Tag<Block> FUNGI_CAPS = tag("fungi_caps");
        public static final Tag<Block> SHADESHROOM = tag("shade_shroom");
        public static final Tag<Block> PLANKS = tag("planks");
        public static final Tag<Block> SAPLINGS = tag("saplings");

        private static Tag<Block> tag(String name) {
            return new BlockTags.Wrapper(new ResourceLocation(MODID, name));
        }
    }

    public static class Items {
        public static final Tag<Item> FUNGI_STEMS = tag("fungi_stems");
        public static final Tag<Item> STEMS = tag("stems");
        public static final Tag<Item> STICKS = tag("sticks");
        public static final Tag<Item> SHADESHROOM = tag("shade_shroom");
        public static final Tag<Item> PLANKS = tag("planks");

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
