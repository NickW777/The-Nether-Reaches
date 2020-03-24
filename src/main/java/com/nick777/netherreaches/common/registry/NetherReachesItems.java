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

    public static final Item BLUEREACHCRYSTALSHARD = Items.AIR;
    public static final Item BLACKREACHCRYSTALSHARD = Items.AIR;
    public static final Item BROWNREACHCRYSTALSHARD = Items.AIR;
    public static final Item CYANREACHCRYSTALSHARD = Items.AIR;
    public static final Item GRAYREACHCRYSTALSHARD = Items.AIR;
    public static final Item GREENREACHCRYSTALSHARD = Items.AIR;
    public static final Item LIGHTBLUEREACHCRYSTALSHARD = Items.AIR;
    public static final Item LIGHTGRAYREACHCRYSTALSHARD = Items.AIR;
    public static final Item LIMEREACHCRYSTALSHARD = Items.AIR;
    public static final Item MAGENTAREACHCRYSTALSHARD = Items.AIR;
    public static final Item ORANGEREACHCRYSTALSHARD = Items.AIR;
    public static final Item PINKREACHCRYSTALSHARD = Items.AIR;
    public static final Item PURPLEREACHCRYSTALSHARD = Items.AIR;
    public static final Item REDREACHCRYSTALSHARD = Items.AIR;
    public static final Item WHITEREACHCRYSTALSHARD = Items.AIR;
    public static final Item YELLOWEACHCRYSTALSHARD = Items.AIR;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        RegUtil.items(event.getRegistry())
                .withProperties(() -> new Item.Properties().group(NetherReachesItemGroups.MISCELLANEOUS))

                .add("blackreachcrystalshard", Item::new)
                .add("bluereachcrystalshard", Item::new)
                .add("brownreachcrystalshard", Item::new)
                .add("cyanreachcrystalshard", Item::new)
                .add("grayreachcrystalshard", Item::new)
                .add("greenreachcrystalshard", Item::new)
                .add("lightbluereachcrystalshard", Item::new)
                .add("lightgrayreachcrystalshard", Item::new)
                .add("limereachcrystalshard", Item::new)
                .add("magentareachcrystalshard", Item::new)
                .add("orangereachcrystalshard", Item::new)
                .add("pinkreachcrystalshard", Item::new)
                .add("purplereachcrystalshard", Item::new)
                .add("redreachcrystalshard", Item::new)
                .add("whitereachcrystalshard", Item::new)
                .add("yellowreachcrystalshard", Item::new);
    }
}
