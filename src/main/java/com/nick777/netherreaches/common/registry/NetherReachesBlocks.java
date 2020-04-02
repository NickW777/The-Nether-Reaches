package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.block.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
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

    public static final Block SHADESHROOMCAP = Blocks.AIR;
    public static final Block SHADESHROOMSTEM = Blocks.AIR;

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

    public static final Block BERNEGORE = Blocks.AIR;
    public static final Block FARONORE = Blocks.AIR;
    public static final Block ILLIAORE = Blocks.AIR;
    public static final Block REGITEORE = Blocks.AIR;
    public static final Block SHARNIKORE = Blocks.AIR;

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
                        .create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA)
                        .hardnessAndResistance(2.0f, 2f)
                        .sound(SoundType.STEM)
                )
                .add("shadeshroomcap", ShroomCapBlock::new)
                .add("shadeshroomstem", props -> new ShroomStemBlock(props));

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.GLASS, MaterialColor.BLUE_TERRACOTTA)
                        .hardnessAndResistance(1.5f, 10f)
                        .sound(SoundType.GLASS)
                        .lightValue(14)
                        .variableOpacity()
                )
                .add("blackreachcrystal", ReachCrystalBlock::new)
                .add("bluereachcrystal", ReachCrystalBlock::new)
                .add("brownreachcrystal", ReachCrystalBlock::new)
                .add("cyanreachcrystal", ReachCrystalBlock::new)
                .add("grayreachcrystal", ReachCrystalBlock::new)
                .add("greenreachcrystal", ReachCrystalBlock::new)
                .add("lightbluereachcrystal", ReachCrystalBlock::new)
                .add("lightgrayreachcrystal", ReachCrystalBlock::new)
                .add("limereachcrystal", ReachCrystalBlock::new)
                .add("magentareachcrystal", ReachCrystalBlock::new)
                .add("orangereachcrystal", ReachCrystalBlock::new)
                .add("pinkreachcrystal", ReachCrystalBlock::new)
                .add("purplereachcrystal", ReachCrystalBlock::new)
                .add("redreachcrystal", ReachCrystalBlock::new)
                .add("whitereachcrystal", ReachCrystalBlock::new)
                .add("yellowreachcrystal", ReachCrystalBlock::new);

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.ROCK)
                        .hardnessAndResistance(3f, 5f)
                        .sound(SoundType.STONE)
                        .harvestTool(ToolType.PICKAXE)
                )
                .add("bernegore", props -> new GemBlock(props.harvestLevel(1)))
                .add("faronore", props -> new GemBlock(props.harvestLevel(1)))
                .add("illiaore", props -> new Block(props.harvestLevel(1)))
                .add("regiteore", props -> new Block(props.harvestLevel(1)))
                .add("sharnikore", props -> new Block(props.harvestLevel(1)));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        RegUtil.items(event.getRegistry())
                .withProperties(() -> new Item.Properties().group(NetherReachesItemGroups.BUILDING))
                .addAll(BlockItem::new,
                    SHADESTONE, SHADESHROOMSTEM, BERNEGORE, FARONORE, ILLIAORE, REGITEORE, SHARNIKORE
                );
        RegUtil.items(event.getRegistry())
                .withProperties(() -> new Item.Properties().group(NetherReachesItemGroups.DECORATION))
                .addAll(BlockItem::new,
                         BLACKREACHCRYSTAL, BLUEREACHCRYSTAL, BROWNREACHCRYSTAL, CYANREACHCRYSTAL, GRAYREACHCRYSTAL, GREENREACHCRYSTAL,
                        LIGHTBLUEREACHCRYSTAL, LIGHTGRAYREACHCRYSTAL, LIMEREACHCRYSTAL, MAGENTAREACHCRYSTAL, ORANGEREACHCRYSTAL, PINKREACHCRYSTAL,
                        PURPLEREACHCRYSTAL, REDREACHCRYSTAL, WHITEREACHCRYSTAL, YELLOWREACHCRYSTAL, SHADESHROOMCAP
                );
    }
}
