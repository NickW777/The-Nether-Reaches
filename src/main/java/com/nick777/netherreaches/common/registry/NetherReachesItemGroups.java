package com.nick777.netherreaches.common.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.Arrays;
import java.util.List;

import static com.nick777.netherreaches.common.registry.NetherReachesBlocks.*;

public class NetherReachesItemGroups {



    public static final ItemGroup BUILDING = new ItemGroup("netherreaches_building") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(NetherReachesBlocks.SHADE_SHROOM_STEM);
        }

        @Override
        public void fill(NonNullList<ItemStack> items) {
            List<Item> building = Arrays.asList(SHADE_STONE.asItem(), BLIGHT_SHROOM_STEM.asItem(), CINDER_SHROOM_STEM.asItem(), SHADE_SHROOM_STEM.asItem(), SHOCK_SHROOM_STEM.asItem(), TANGLE_SHROOM_STEM.asItem(), TOXIC_SHROOM_STEM.asItem(),
                    STRIPPED_BLIGHT_SHROOM_STEM.asItem(), STRIPPED_CINDER_SHROOM_STEM.asItem(), STRIPPED_SHADE_SHROOM_STEM.asItem(), STRIPPED_SHOCK_SHROOM_STEM.asItem(), STRIPPED_TANGLE_SHROOM_STEM.asItem(),
                    STRIPPED_TOXIC_SHROOM_STEM.asItem(), BLIGHT_SHROOM_BARK.asItem(), CINDER_SHROOM_BARK.asItem(), SHADE_SHROOM_BARK.asItem(), SHOCK_SHROOM_BARK.asItem(), TANGLE_SHROOM_BARK.asItem(), TOXIC_SHROOM_BARK.asItem(),
                    STRIPPED_BLIGHT_SHROOM_BARK.asItem(), STRIPPED_CINDER_SHROOM_BARK.asItem(), STRIPPED_SHADE_SHROOM_BARK.asItem(), STRIPPED_SHOCK_SHROOM_BARK.asItem(), STRIPPED_TANGLE_SHROOM_BARK.asItem(),
                    STRIPPED_TOXIC_SHROOM_BARK.asItem(), BERNEG_ORE.asItem(), FARON_ORE.asItem(), ILLIA_ORE.asItem(), REGITE_ORE.asItem(), SHARNIK_ORE.asItem(), BERNEG_BLOCK.asItem(), FARON_BLOCK.asItem(), ILLIA_BLOCK.asItem(), REGITE_BLOCK.asItem(),
                    SHARNIK_BLOCK.asItem(), BLIGHT_SHROOM_PLANKS.asItem(), CINDER_SHROOM_PLANKS.asItem(), SHADE_SHROOM_PLANKS.asItem(), SHOCK_SHROOM_PLANKS.asItem(), TANGLE_SHROOM_PLANKS.asItem(), TOXIC_SHROOM_PLANKS.asItem(),
                    BLIGHT_SHROOM_SLAB.asItem(), CINDER_SHROOM_SLAB.asItem(), SHADE_SHROOM_SLAB.asItem(), SHOCK_SHROOM_SLAB.asItem(), TANGLE_SHROOM_SLAB.asItem(), TOXIC_SHROOM_SLAB.asItem(), BLIGHT_SHROOM_STAIRS.asItem(),
                    CINDER_SHROOM_STAIRS.asItem(), SHADE_SHROOM_STAIRS.asItem(), TANGLE_SHROOM_STAIRS.asItem(), TOXIC_SHROOM_STAIRS.asItem(), SHOCK_SHROOM_STAIRS.asItem());
            items.clear();

            for (Item item : building)
            {
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
    };
    public static final ItemGroup REDSTONE = new ItemGroup("netherreaches_redstone") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(NetherReachesBlocks.SHADE_SHROOM_BUTTON);
        }
    };
    public static final ItemGroup ITEM = new ItemGroup("netherreaches_item") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(NetherReachesItems.WHITE_REACHCRYSTAL_SHARD);
        }
    };
}
