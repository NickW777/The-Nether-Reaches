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

    public static final Item BLUE_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item BLACK_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item BROWN_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item CYAN_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item GRAY_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item GREEN_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item LIGHT_BLUE_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item LIGHT_GRAY_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item LIME_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item MAGENTA_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item ORANGE_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item PINK_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item PURPLE_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item RED_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item WHITE_REACHCRYSTAL_SHARD = Items.DIRT;
    public static final Item YELLOW_REACHCRYSTAL_SHARD = Items.DIRT;

    public static final Item BERNEG = Items.DIRT;
    public static final Item FARON = Items.DIRT;
    public static final Item ILLIA = Items.DIRT;
    public static final Item REGITE = Items.DIRT;
    public static final Item SHARNIK = Items.DIRT;

    public static final Item SHADE_STICK = Items.DIRT;
    public static final Item SHOCK_STICK = Items.DIRT;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        RegUtil.items(event.getRegistry())
                .withProperties(() -> new Item.Properties().group(NetherReachesItemGroups.ITEM))

                .add("black_reachcrystal_shard", Item::new)
                .add("blue_reachcrystal_shard", Item::new)
                .add("brown_reachcrystal_shard", Item::new)
                .add("cyan_reachcrystal_shard", Item::new)
                .add("gray_reachcrystal_shard", Item::new)
                .add("green_reachcrystal_shard", Item::new)
                .add("light_blue_reachcrystal_shard", Item::new)
                .add("light_gray_reachcrystal_shard", Item::new)
                .add("lime_reachcrystal_shard", Item::new)
                .add("magenta_reachcrystal_shard", Item::new)
                .add("orange_reachcrystal_shard", Item::new)
                .add("pink_reachcrystal_shard", Item::new)
                .add("purple_reachcrystal_shard", Item::new)
                .add("red_reachcrystal_shard", Item::new)
                .add("white_reachcrystal_shard", Item::new)
                .add("yellow_reachcrystal_shard", Item::new)

                .add("berneg", Item::new)
                .add("faron", Item::new)
                .add("illia", Item::new)
                .add("regite", Item::new)
                .add("sharnik", Item::new)

                .add("shade_stick", Item::new)
                .add("shock_stick", Item::new);
    }
}
