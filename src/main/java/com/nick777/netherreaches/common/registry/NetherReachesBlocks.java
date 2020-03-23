package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.block.reachcrystal.*;
import com.nick777.netherreaches.common.block.ShadeStoneBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import static com.nick777.netherreaches.NetherReaches.MODID;

@ObjectHolder(MODID)
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("WeakerAccess")
public class NetherReachesBlocks {
    public static final Block SHADESTONE = Blocks.AIR;

    public static final Block BLACKREACHCRYSTAL = Blocks.AIR;
    public static final Block BLUEREACHCRYSTAL = Blocks.AIR;
    public static final Block BROWNREACHCRYSTAL = Blocks.AIR;
    public static final Block CYANREACHCRYSTAL = Blocks.AIR;
    public static final Block GRAYREACHCRYSTAL = Blocks.AIR;
    public static final Block GREENREACHCRYSTAL = Blocks.AIR;
    public static final Block LIGHTBLUEREACHCRYSTAL = Blocks.AIR;
    public static final Block LIGHTGRAYREACHCRYSTAL = Blocks.AIR;
    public static final Block LIMEREACHCRYSTAL = Blocks.AIR;
    public static final Block MAGENTAREACHCRYSTAL = Blocks.AIR;
    public static final Block ORANGEREACHCRYSTAL = Blocks.AIR;
    public static final Block PINKREACHCRYSTAL = Blocks.AIR;
    public static final Block PURPLEREACHCRYSTAL = Blocks.AIR;
    public static final Block REDREACHCRYSTAL = Blocks.AIR;
    public static final Block WHITEREACHCRYSTAL = Blocks.AIR;
    public static final Block YELLOWREACHCRYSTAL = Blocks.AIR;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA)
                        .hardnessAndResistance(1.5f, 10f)
                        .sound(SoundType.STONE)
                )
                .add("shadestone", ShadeStoneBlock::new);

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.GLASS, MaterialColor.BLUE_TERRACOTTA)
                        .hardnessAndResistance(1.5f, 10f)
                        .sound(SoundType.GLASS)
                        .lightValue(12)
                        .variableOpacity()
                )
                .add("blackreachcrystal", BlackReachCrystal::new)
                .add("bluereachcrystal", BlueReachCrystal::new)
                .add("brownreachcrystal", BrownReachCrystal::new)
                .add("cyanreachcrystal", CyanReachCrystal::new)
                .add("grayreachcrystal", GrayReachCrystal::new)
                .add("greenreachcrystal", GreenReachCrystal::new)
                .add("lightbluereachcrystal", LightBlueReachCrystal::new)
                .add("lightgrayreachcrystal", LightGrayReachCrystal::new)
                .add("limereachcrystal", LimeReachCrystal::new)
                .add("magentareachcrystal", MagentaReachCrystal::new)
                .add("orangereachcrystal", OrangeReachCrystal::new)
                .add("pinkreachcrystal", PinkReachCrystal::new)
                .add("purplereachcrystal", PurpleReachCrystal::new)
                .add("redreachcrystal", RedReachCrystal::new)
                .add("whitereachcrystal", WhiteReachCrystal::new)
                .add("yellowreachcrystal", YellowReachCrystal::new);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        RegUtil.items(event.getRegistry())
                .withProperties(() -> new Item.Properties().group(NetherReachesItemGroups.BUILDING))
                .addAll(BlockItem::new,
                        SHADESTONE
                );
        RegUtil.items(event.getRegistry())
                .withProperties(() -> new Item.Properties().group(NetherReachesItemGroups.DECORATION))
                .addAll(BlockItem::new,
                         BLACKREACHCRYSTAL, BLUEREACHCRYSTAL, BROWNREACHCRYSTAL, CYANREACHCRYSTAL, GRAYREACHCRYSTAL, GREENREACHCRYSTAL,
                        LIGHTBLUEREACHCRYSTAL, LIGHTGRAYREACHCRYSTAL, LIMEREACHCRYSTAL, MAGENTAREACHCRYSTAL, ORANGEREACHCRYSTAL, PINKREACHCRYSTAL,
                        PURPLEREACHCRYSTAL, REDREACHCRYSTAL, WHITEREACHCRYSTAL, YELLOWREACHCRYSTAL
                );
    }
}
