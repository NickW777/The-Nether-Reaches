package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.block.*;
import com.nick777.netherreaches.common.world.tree.ShadeShroom;
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
    public static final Block SHADE_STONE = Blocks.DIRT;

    public static final Block SHADE_SHROOM_CAP = Blocks.DIRT;

    public static final Block SHADE_SHROOM_STEM = Blocks.DIRT;

    public static final Block SHADE_SHROOM_PLANKS = Blocks.DIRT;

    public static final Block SHADE_SHROOM_SAPLING = Blocks.DIRT;

    public static final Block BLACK_REACHCRYSTAL = Blocks.DIRT;
    public static final Block BLUE_REACHCRYSTAL = Blocks.DIRT;
    public static final Block BROWN_REACHCRYSTAL = Blocks.DIRT;
    public static final Block CYAN_REACHCRYSTAL = Blocks.DIRT;
    public static final Block GRAY_REACHCRYSTAL = Blocks.DIRT;
    public static final Block GREEN_REACHCRYSTAL = Blocks.DIRT;
    public static final Block LIGHT_BLUE_REACHCRYSTAL = Blocks.DIRT;
    public static final Block LIGHT_GRAY_REACHCRYSTAL = Blocks.DIRT;
    public static final Block LIME_REACHCRYSTAL = Blocks.DIRT;
    public static final Block MAGENTA_REACHCRYSTAL = Blocks.DIRT;
    public static final Block ORANGE_REACHCRYSTAL = Blocks.DIRT;
    public static final Block PINK_REACHCRYSTAL = Blocks.DIRT;
    public static final Block PURPLE_REACHCRYSTAL = Blocks.DIRT;
    public static final Block RED_REACHCRYSTAL = Blocks.DIRT;
    public static final Block WHITE_REACHCRYSTAL = Blocks.DIRT;
    public static final Block YELLOW_REACHCRYSTAL = Blocks.DIRT;

    public static final Block BERNEG_ORE = Blocks.DIRT;
    public static final Block FARON_ORE = Blocks.DIRT;
    public static final Block ILLIA_ORE = Blocks.DIRT;
    public static final Block REGITE_ORE = Blocks.DIRT;
    public static final Block SHARNIK_ORE = Blocks.DIRT;

    public static final Block BERNEG_BLOCK = Blocks.OAK_LOG;
    public static final Block FARON_BLOCK = Blocks.DIRT;
    public static final Block ILLIA_BLOCK = Blocks.DIRT;
    public static final Block REGITE_BLOCK = Blocks.DIRT;
    public static final Block SHARNIK_BLOCK = Blocks.DIRT;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA)
                        .hardnessAndResistance(1.5f, 10f)
                        .sound(SoundType.STONE)
                )
                .add("shade_stone", ShadeStoneBlock::new);

        RegUtil.blocks(event.getRegistry())
                .withProperties( () -> Block.Properties
                        .create(Material.IRON, MaterialColor.BLUE_TERRACOTTA)
                        .hardnessAndResistance(5.0f, 6.0f)
                        .sound(SoundType.METAL)
                )
                .add("berneg_block", props -> new Block(props.harvestLevel(1)))
                .add("faron_block", props -> new Block(props.harvestLevel(1)))
                .add("illia_block", props -> new Block(props.harvestLevel(1)))
                .add("regite_block", props -> new Block(props.harvestLevel(1)))
                .add("sharnik_block", props -> new Block(props.harvestLevel(1)));

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.WOOD, MaterialColor.BLUE_TERRACOTTA)
                        .hardnessAndResistance(2.0f, 2f)
                        .sound(SoundType.STEM)
                )
                .add("shade_shroom_stem", props -> new ShroomStemBlock(props));

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                    .create(Material.ORGANIC, MaterialColor.BLUE_TERRACOTTA)
                    .hardnessAndResistance(0.2f)
                    .sound(SoundType.PLANT)
                )
                .add("shade_shroom_cap", ShroomCapBlock::new);

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.WOOD, MaterialColor.WOOD)
                        .hardnessAndResistance(2,3)
                        .sound(SoundType.WOOD)
                )
                .add("shade_shroom_planks", Block::new);

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.GLASS, MaterialColor.BLUE_TERRACOTTA)
                        .hardnessAndResistance(1.5f, 10f)
                        .sound(SoundType.GLASS)
                        .lightValue(14)
                        .variableOpacity()
                )
                .add("black_reachcrystal", ReachCrystalBlock::new)
                .add("blue_reachcrystal", ReachCrystalBlock::new)
                .add("brown_reachcrystal", ReachCrystalBlock::new)
                .add("cyan_reachcrystal", ReachCrystalBlock::new)
                .add("gray_reachcrystal", ReachCrystalBlock::new)
                .add("green_reachcrystal", ReachCrystalBlock::new)
                .add("light_blue_reachcrystal", ReachCrystalBlock::new)
                .add("light_gray_reachcrystal", ReachCrystalBlock::new)
                .add("lime_reachcrystal", ReachCrystalBlock::new)
                .add("magenta_reachcrystal", ReachCrystalBlock::new)
                .add("orange_reachcrystal", ReachCrystalBlock::new)
                .add("pink_reachcrystal", ReachCrystalBlock::new)
                .add("purple_reachcrystal", ReachCrystalBlock::new)
                .add("red_reachcrystal", ReachCrystalBlock::new)
                .add("white_reachcrystal", ReachCrystalBlock::new)
                .add("yellow_reachcrystal", ReachCrystalBlock::new);

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.ROCK)
                        .hardnessAndResistance(3f, 5f)
                        .sound(SoundType.STONE)
                        .harvestTool(ToolType.PICKAXE)
                )
                .add("berneg_ore", props -> new GemOreBlock(props.harvestLevel(1)))
                .add("faron_ore", props -> new GemOreBlock(props.harvestLevel(1)))
                .add("illia_ore", props -> new Block(props.harvestLevel(1)))
                .add("regite_ore", props -> new Block(props.harvestLevel(1)))
                .add("sharnik_ore", props -> new Block(props.harvestLevel(1)));

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties.create(Material.PLANTS)
                        .hardnessAndResistance(0f)
                        .doesNotBlockMovement()
                        .tickRandomly()
                        .sound(SoundType.PLANT)
                )
                .add("shade_shroom_sapling", props -> new ShroomSaplingBlock(new ShadeShroom(),props));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        RegUtil.items(event.getRegistry())
                .withProperties(() -> new Item.Properties().group(NetherReachesItemGroups.BUILDING))
                .addAll(BlockItem::new,
                SHADE_STONE, SHADE_SHROOM_STEM, BERNEG_ORE, FARON_ORE, ILLIA_ORE, REGITE_ORE, SHARNIK_ORE, BERNEG_BLOCK, FARON_BLOCK, ILLIA_BLOCK,
                        REGITE_BLOCK, SHARNIK_BLOCK, SHADE_SHROOM_PLANKS
                );
        RegUtil.items(event.getRegistry())
                .withProperties(() -> new Item.Properties().group(NetherReachesItemGroups.DECORATION))
                .addAll(BlockItem::new,
                         BLACK_REACHCRYSTAL, BLUE_REACHCRYSTAL, BROWN_REACHCRYSTAL, CYAN_REACHCRYSTAL, GRAY_REACHCRYSTAL, GREEN_REACHCRYSTAL,
                        LIGHT_BLUE_REACHCRYSTAL, LIGHT_GRAY_REACHCRYSTAL, LIME_REACHCRYSTAL, MAGENTA_REACHCRYSTAL, ORANGE_REACHCRYSTAL, PINK_REACHCRYSTAL,
                        PURPLE_REACHCRYSTAL, RED_REACHCRYSTAL, WHITE_REACHCRYSTAL, YELLOW_REACHCRYSTAL, SHADE_SHROOM_CAP, SHADE_SHROOM_SAPLING
                );
    }
}
