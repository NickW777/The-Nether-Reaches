package com.nick777.netherreaches.common.registry;


import com.nick777.netherreaches.NetherReaches;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(NetherReaches.MODID)
@Mod.EventBusSubscriber(modid = NetherReaches.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetherReachesItems {

    public static final Item WHITEREACHCRYSTALSHARD = Items.AIR;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        RegUtil.items(event.getRegistry())
                .withProperties(() -> new Item.Properties().group(NetherReachesItemGroups.MATERIALS))

                .add("whitereachcrystalshard", Item::new);
    }
}
