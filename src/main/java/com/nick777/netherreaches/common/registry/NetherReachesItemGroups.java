package com.nick777.netherreaches.common.registry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class NetherReachesItemGroups {
    public static final ItemGroup BUILDING = new ItemGroup("netherreaches_building") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(NetherReachesBlocks.SHADESTONE);
        }
    };
    public static final ItemGroup DECORATION = new ItemGroup("netherreaches_decoration") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(NetherReachesBlocks.BLUEREACHCRYSTAL);
        }
    };
    public static final ItemGroup MATERIALS = new ItemGroup("netherreaches_materials") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(NetherReachesItems.WHITEREACHCRYSTALSHARD);
        }
    };
}
