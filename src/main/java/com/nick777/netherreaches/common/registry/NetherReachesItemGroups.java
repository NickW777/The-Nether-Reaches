package com.nick777.netherreaches.common.registry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class NetherReachesItemGroups {
    public static final ItemGroup BUILDING = new ItemGroup("netherreaches_building") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(NetherReachesBlocks.SHADE_SHROOM_STEM);
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
