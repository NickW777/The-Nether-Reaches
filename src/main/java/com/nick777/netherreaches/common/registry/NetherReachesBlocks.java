package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.block.*;
import com.nick777.netherreaches.common.world.tree.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
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

    public static final Block BLIGHT_SHROOM_BARK = Blocks.OAK_LOG;
    public static final Block CINDER_SHROOM_BARK = Blocks.OAK_LOG;
    public static final Block SHADE_SHROOM_BARK = Blocks.OAK_LOG;
    public static final Block SHOCK_SHROOM_BARK = Blocks.OAK_LOG;
    public static final Block TANGLE_SHROOM_BARK = Blocks.OAK_LOG;
    public static final Block TOXIC_SHROOM_BARK = Blocks.OAK_LOG;

    public static final Block STRIPPED_BLIGHT_SHROOM_BARK = Blocks.OAK_LOG;
    public static final Block STRIPPED_CINDER_SHROOM_BARK = Blocks.OAK_LOG;
    public static final Block STRIPPED_SHADE_SHROOM_BARK = Blocks.OAK_LOG;
    public static final Block STRIPPED_SHOCK_SHROOM_BARK = Blocks.OAK_LOG;
    public static final Block STRIPPED_TANGLE_SHROOM_BARK = Blocks.OAK_LOG;
    public static final Block STRIPPED_TOXIC_SHROOM_BARK = Blocks.OAK_LOG;

    public static final Block BLIGHT_SHROOM_BUTTON = Blocks.DIRT;
    public static final Block CINDER_SHROOM_BUTTON = Blocks.DIRT;
    public static final Block SHADE_SHROOM_BUTTON = Blocks.DIRT;
    public static final Block SHOCK_SHROOM_BUTTON = Blocks.DIRT;
    public static final Block TANGLE_SHROOM_BUTTON = Blocks.DIRT;
    public static final Block TOXIC_SHROOM_BUTTON = Blocks.DIRT;

    public static final Block BLIGHT_SHROOM_CAP = Blocks.DIRT;
    public static final Block CINDER_SHROOM_CAP = Blocks.DIRT;
    public static final Block SHADE_SHROOM_CAP = Blocks.DIRT;
    public static final Block SHOCK_SHROOM_CAP = Blocks.DIRT;
    public static final Block TANGLE_SHROOM_CAP = Blocks.DIRT;
    public static final Block TOXIC_SHROOM_CAP = Blocks.DIRT;

    public static final Block BLIGHT_SHROOM_DOOR = Blocks.DIRT;
    public static final Block CINDER_SHROOM_DOOR = Blocks.DIRT;
    public static final Block SHADE_SHROOM_DOOR = Blocks.DIRT;
    public static final Block SHOCK_SHROOM_DOOR = Blocks.DIRT;
    public static final Block TANGLE_SHROOM_DOOR = Blocks.DIRT;
    public static final Block TOXIC_SHROOM_DOOR = Blocks.DIRT;

    public static final Block BLIGHT_SHROOM_FENCE = Blocks.DIRT;
    public static final Block CINDER_SHROOM_FENCE = Blocks.DIRT;
    public static final Block SHADE_SHROOM_FENCE = Blocks.DIRT;
    public static final Block SHOCK_SHROOM_FENCE = Blocks.DIRT;
    public static final Block TANGLE_SHROOM_FENCE = Blocks.DIRT;
    public static final Block TOXIC_SHROOM_FENCE = Blocks.DIRT;

    public static final Block BLIGHT_SHROOM_FENCE_GATE = Blocks.DIRT;
    public static final Block CINDER_SHROOM_FENCE_GATE = Blocks.DIRT;
    public static final Block SHADE_SHROOM_FENCE_GATE = Blocks.DIRT;
    public static final Block SHOCK_SHROOM_FENCE_GATE = Blocks.DIRT;
    public static final Block TANGLE_SHROOM_FENCE_GATE = Blocks.DIRT;
    public static final Block TOXIC_SHROOM_FENCE_GATE = Blocks.DIRT;

    public static final Block BLIGHT_SHROOM_LADDER = Blocks.DIRT;
    public static final Block CINDER_SHROOM_LADDER = Blocks.DIRT;
    public static final Block SHADE_SHROOM_LADDER = Blocks.DIRT;
    public static final Block SHOCK_SHROOM_LADDER = Blocks.DIRT;
    public static final Block TANGLE_SHROOM_LADDER = Blocks.DIRT;
    public static final Block TOXIC_SHROOM_LADDER = Blocks.DIRT;

    public static final Block BLIGHT_SHROOM_PLANKS = Blocks.DIRT;
    public static final Block CINDER_SHROOM_PLANKS = Blocks.DIRT;
    public static final Block SHADE_SHROOM_PLANKS = Blocks.DIRT;
    public static final Block SHOCK_SHROOM_PLANKS = Blocks.DIRT;
    public static final Block TANGLE_SHROOM_PLANKS = Blocks.DIRT;
    public static final Block TOXIC_SHROOM_PLANKS = Blocks.DIRT;

    public static final Block BLIGHT_SHROOM_PRESSURE_PLATE = Blocks.DIRT;
    public static final Block CINDER_SHROOM_PRESSURE_PLATE = Blocks.DIRT;
    public static final Block SHADE_SHROOM_PRESSURE_PLATE = Blocks.DIRT;
    public static final Block SHOCK_SHROOM_PRESSURE_PLATE = Blocks.DIRT;
    public static final Block TANGLE_SHROOM_PRESSURE_PLATE = Blocks.DIRT;
    public static final Block TOXIC_SHROOM_PRESSURE_PLATE = Blocks.DIRT;

    public static final Block BLIGHT_SHROOM_SAPLING = Blocks.DIRT;
    public static final Block CINDER_SHROOM_SAPLING = Blocks.DIRT;
    public static final Block SHADE_SHROOM_SAPLING = Blocks.DIRT;
    public static final Block SHOCK_SHROOM_SAPLING = Blocks.DIRT;
    public static final Block TANGLE_SHROOM_SAPLING = Blocks.DIRT;
    public static final Block TOXIC_SHROOM_SAPLING = Blocks.DIRT;

    public static final Block SHADE_SHROOM_SIGN = Blocks.DIRT;

    public static final Block BLIGHT_SHROOM_SLAB = Blocks.DIRT;
    public static final Block CINDER_SHROOM_SLAB = Blocks.DIRT;
    public static final Block SHADE_SHROOM_SLAB = Blocks.DIRT;
    public static final Block SHOCK_SHROOM_SLAB = Blocks.DIRT;
    public static final Block TANGLE_SHROOM_SLAB = Blocks.DIRT;
    public static final Block TOXIC_SHROOM_SLAB = Blocks.DIRT;

    public static final Block BLIGHT_SHROOM_STAIRS = Blocks.DIRT;
    public static final Block CINDER_SHROOM_STAIRS = Blocks.DIRT;
    public static final Block SHADE_SHROOM_STAIRS = Blocks.DIRT;
    public static final Block SHOCK_SHROOM_STAIRS = Blocks.DIRT;
    public static final Block TANGLE_SHROOM_STAIRS = Blocks.DIRT;
    public static final Block TOXIC_SHROOM_STAIRS = Blocks.DIRT;

    public static final Block BLIGHT_SHROOM_STEM = Blocks.OAK_LOG;
    public static final Block CINDER_SHROOM_STEM = Blocks.OAK_LOG;
    public static final Block SHADE_SHROOM_STEM = Blocks.OAK_LOG;
    public static final Block SHOCK_SHROOM_STEM = Blocks.OAK_LOG;
    public static final Block TANGLE_SHROOM_STEM = Blocks.OAK_LOG;
    public static final Block TOXIC_SHROOM_STEM = Blocks.OAK_LOG;

    public static final Block STRIPPED_BLIGHT_SHROOM_STEM = Blocks.OAK_LOG;
    public static final Block STRIPPED_CINDER_SHROOM_STEM = Blocks.OAK_LOG;
    public static final Block STRIPPED_SHADE_SHROOM_STEM = Blocks.OAK_LOG;
    public static final Block STRIPPED_SHOCK_SHROOM_STEM = Blocks.OAK_LOG;
    public static final Block STRIPPED_TANGLE_SHROOM_STEM = Blocks.OAK_LOG;
    public static final Block STRIPPED_TOXIC_SHROOM_STEM = Blocks.OAK_LOG;

    public static final Block BLIGHT_SHROOM_TRAPDOOR = Blocks.DIRT;
    public static final Block CINDER_SHROOM_TRAPDOOR = Blocks.DIRT;
    public static final Block SHADE_SHROOM_TRAPDOOR = Blocks.DIRT;
    public static final Block SHOCK_SHROOM_TRAPDOOR = Blocks.DIRT;
    public static final Block TANGLE_SHROOM_TRAPDOOR = Blocks.DIRT;
    public static final Block TOXIC_SHROOM_TRAPDOOR = Blocks.DIRT;

    public static final Block SHADE_SHROOM_WALL_SIGN = Blocks.DIRT;

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

    public static final Block BLACK_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block BLUE_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block BROWN_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block CYAN_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block GRAY_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block GREEN_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block LIGHT_BLUE_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block LIGHT_GRAY_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block LIME_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block MAGENTA_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block ORANGE_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block PINK_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block PURPLE_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block RED_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block WHITE_REACHCRYSTAL_LANTERN = Blocks.DIRT;
    public static final Block YELLOW_REACHCRYSTAL_LANTERN = Blocks.DIRT;

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
                        .hardnessAndResistance(2.0f)
                        .sound(SoundType.STEM)
                )
                .add("blight_shroom_stem", ShroomStemBlock::new)
                .add("cinder_shroom_stem", ShroomStemBlock::new)
                .add("shade_shroom_stem", ShroomStemBlock::new)
                .add("shock_shroom_stem", ShroomStemBlock::new)
                .add("tangle_shroom_stem", ShroomStemBlock::new)
                .add("toxic_shroom_stem", ShroomStemBlock::new)

                .add("stripped_blight_shroom_stem", ShroomStemBlock::new)
                .add("stripped_cinder_shroom_stem", ShroomStemBlock::new)
                .add("stripped_shade_shroom_stem", ShroomStemBlock::new)
                .add("stripped_shock_shroom_stem", ShroomStemBlock::new)
                .add("stripped_tangle_shroom_stem", ShroomStemBlock::new)
                .add("stripped_toxic_shroom_stem", ShroomStemBlock::new)

                .add("blight_shroom_bark", ShroomStemBlock::new)
                .add("cinder_shroom_bark", ShroomStemBlock::new)
                .add("shade_shroom_bark", ShroomStemBlock::new)
                .add("shock_shroom_bark", ShroomStemBlock::new)
                .add("tangle_shroom_bark", ShroomStemBlock::new)
                .add("toxic_shroom_bark", ShroomStemBlock::new)

                .add("stripped_blight_shroom_bark", ShroomStemBlock::new)
                .add("stripped_cinder_shroom_bark", ShroomStemBlock::new)
                .add("stripped_shade_shroom_bark", ShroomStemBlock::new)
                .add("stripped_shock_shroom_bark", ShroomStemBlock::new)
                .add("stripped_tangle_shroom_bark", ShroomStemBlock::new)
                .add("stripped_toxic_shroom_bark", ShroomStemBlock::new);

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                    .create(Material.ORGANIC, MaterialColor.BLUE_TERRACOTTA)
                    .hardnessAndResistance(0.2f)
                    .sound(SoundType.PLANT)
                )
                .add("blight_shroom_cap", BlightShroomCapBlock::new)
                .add("cinder_shroom_cap", CinderShroomCapBlock::new)
                .add("shade_shroom_cap", ShadeShroomCapBlock::new)
                .add("shock_shroom_cap", ShockShroomCapBlock::new)
                .add("tangle_shroom_cap", TangleShroomCapBlock::new)
                .add("toxic_shroom_cap", ToxicShroomCapBlock::new);

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.WOOD, MaterialColor.WOOD)
                        .hardnessAndResistance(2.0f,3.0f)
                        .sound(SoundType.WOOD)
                )
                .add("blight_shroom_planks", Block::new)
                .add("cinder_shroom_planks", Block::new)
                .add("shade_shroom_planks", Block::new)
                .add("shock_shroom_planks", Block::new)
                .add("tangle_shroom_planks", Block::new)
                .add("toxic_shroom_planks", Block::new)


                .add("blight_shroom_slab", SlabBlock::new)
                .add("cinder_shroom_slab", SlabBlock::new)
                .add("shade_shroom_slab", SlabBlock::new)
                .add("shock_shroom_slab", SlabBlock::new)
                .add("tangle_shroom_slab", SlabBlock::new)
                .add("toxic_shroom_slab", SlabBlock::new)


                .add("blight_shroom_stairs", props -> new StairsBlock(BLIGHT_SHROOM_PLANKS::getDefaultState, props))
                .add("cinder_shroom_stairs", props -> new StairsBlock(CINDER_SHROOM_PLANKS::getDefaultState, props))
                .add("shade_shroom_stairs", props -> new StairsBlock(SHADE_SHROOM_PLANKS::getDefaultState, props))
                .add("shock_shroom_stairs", props -> new StairsBlock(SHADE_SHROOM_PLANKS::getDefaultState, props))
                .add("tangle_shroom_stairs", props -> new StairsBlock(TANGLE_SHROOM_PLANKS::getDefaultState, props))
                .add("toxic_shroom_stairs", props -> new StairsBlock(TOXIC_SHROOM_PLANKS::getDefaultState, props))


                .add("blight_shroom_fence", FenceBlock::new)
                .add("cinder_shroom_fence", FenceBlock::new)
                .add("shade_shroom_fence", FenceBlock::new)
                .add("shock_shroom_fence", FenceBlock::new)
                .add("tangle_shroom_fence", FenceBlock::new)
                .add("toxic_shroom_fence", FenceBlock::new)


                .add("blight_shroom_fence_gate", FenceGateBlock::new)
                .add("cinder_shroom_fence_gate", FenceGateBlock::new)
                .add("shade_shroom_fence_gate", FenceGateBlock::new)
                .add("shock_shroom_fence_gate", FenceGateBlock::new)
                .add("tangle_shroom_fence_gate", FenceGateBlock::new)
                .add("toxic_shroom_fence_gate", FenceGateBlock::new);

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.WOOD, MaterialColor.WOOD)
                        .doesNotBlockMovement()
                        .hardnessAndResistance(1.0f)
                        .sound(SoundType.WOOD)
                )
                .add("shade_shroom_sign", props -> new NetherReachesStandingSignBlock(props) {});

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.WOOD, MaterialColor.WOOD)
                        .doesNotBlockMovement()
                        .hardnessAndResistance(1.0f)
                        .sound(SoundType.WOOD)
                        .lootFrom(SHADE_SHROOM_SIGN)
                )
                .add("shade_shroom_wall_sign", props -> new NetherReachesWallSignBlock(props) {});


        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.WOOD, MaterialColor.WOOD)
                        .hardnessAndResistance(3f)
                        .sound(SoundType.WOOD)
                )
                .add("blight_shroom_door", props -> new DoorBlock(props) {})
                .add("cinder_shroom_door", props -> new DoorBlock(props) {})
                .add("shade_shroom_door", props -> new DoorBlock(props) {})
                .add("shock_shroom_door", props -> new DoorBlock(props) {})
                .add("tangle_shroom_door", props -> new DoorBlock(props) {})
                .add("toxic_shroom_door", props -> new DoorBlock(props) {})


                .add("blight_shroom_trapdoor", props -> new TrapDoorBlock(props) {})
                .add("cinder_shroom_trapdoor", props -> new TrapDoorBlock(props) {})
                .add("shade_shroom_trapdoor", props -> new TrapDoorBlock(props) {})
                .add("shock_shroom_trapdoor", props -> new TrapDoorBlock(props) {})
                .add("tangle_shroom_trapdoor", props -> new TrapDoorBlock(props) {})
                .add("toxic_shroom_trapdoor", props -> new TrapDoorBlock(props) {});

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.WOOD, MaterialColor.WOOD)
                        .hardnessAndResistance(0.5f)
                        .sound(SoundType.WOOD)
                )
                .add("blight_shroom_pressure_plate", props -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, props) {})
                .add("cinder_shroom_pressure_plate", props -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, props) {})
                .add("shade_shroom_pressure_plate", props -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, props) {})
                .add("shock_shroom_pressure_plate", props -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, props) {})
                .add("tangle_shroom_pressure_plate", props -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, props) {})
                .add("toxic_shroom_pressure_plate", props -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, props) {});

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.MISCELLANEOUS, MaterialColor.WOOD)
                        .doesNotBlockMovement()
                        .hardnessAndResistance(0.5f)
                        .sound(SoundType.WOOD)
                )
                .add("blight_shroom_button", props -> new WoodButtonBlock(props) {})
                .add("cinder_shroom_button", props -> new WoodButtonBlock(props) {})
                .add("shade_shroom_button", props -> new WoodButtonBlock(props) {})
                .add("shock_shroom_button", props -> new WoodButtonBlock(props) {})
                .add("tangle_shroom_button", props -> new WoodButtonBlock(props) {})
                .add("toxic_shroom_button", props -> new WoodButtonBlock(props) {});

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties
                        .create(Material.MISCELLANEOUS)
                        .hardnessAndResistance(0.4f)
                        .sound(SoundType.LADDER)
                )
                .add("blight_shroom_ladder", props -> new LadderBlock(props) {})
                .add("cinder_shroom_ladder", props -> new LadderBlock(props) {})
                .add("shade_shroom_ladder", props -> new LadderBlock(props) {})
                .add("shock_shroom_ladder", props -> new LadderBlock(props) {})
                .add("tangle_shroom_ladder", props -> new LadderBlock(props) {})
                .add("toxic_shroom_ladder", props -> new LadderBlock(props) {});

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
                .add("blight_shroom_sapling", props -> new ShroomSaplingBlock(new BlightShroom(),props))
                .add("cinder_shroom_sapling", props -> new ShroomSaplingBlock(new CinderShroom(),props))
                .add("shade_shroom_sapling", props -> new ShroomSaplingBlock(new ShadeShroom(),props))
                .add("shock_shroom_sapling", props -> new ShroomSaplingBlock(new ShockShroom(),props))
                .add("tangle_shroom_sapling", props -> new ShroomSaplingBlock(new TangleShroom(),props))
                .add("toxic_shroom_sapling", props -> new ShroomSaplingBlock(new ToxicShroom(),props));

        RegUtil.blocks(event.getRegistry())
                .withProperties(() -> Block.Properties.create(Material.IRON)
                        .hardnessAndResistance(3.5f)
                        .lightValue(15)
                        .sound(SoundType.LANTERN)
                )
                .add("black_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.BLACK, props))
                .add("blue_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.BLUE, props))
                .add("brown_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.BROWN, props))
                .add("cyan_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.CYAN, props))
                .add("gray_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.GRAY, props))
                .add("green_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.GREEN, props))
                .add("light_blue_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.LIGHT_BLUE, props))
                .add("light_gray_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.LIGHT_GRAY, props))
                .add("lime_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.LIME, props))
                .add("magenta_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.MAGENTA, props))
                .add("orange_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.ORANGE, props))
                .add("pink_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.PINK, props))
                .add("purple_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.PURPLE, props))
                .add("red_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.RED, props))
                .add("white_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.WHITE, props))
                .add("yellow_reachcrystal_lantern", props -> new ReachCrystalLanternBlock(DyeColor.YELLOW, props));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        RegUtil.items(event.getRegistry())
                .withProperties(() -> new Item.Properties().group(NetherReachesItemGroups.BUILDING))
                .addAll(BlockItem::new,
                SHADE_STONE, BLIGHT_SHROOM_STEM, CINDER_SHROOM_STEM, SHADE_SHROOM_STEM, SHOCK_SHROOM_STEM, TANGLE_SHROOM_STEM, TOXIC_SHROOM_STEM,
                        STRIPPED_BLIGHT_SHROOM_STEM, STRIPPED_CINDER_SHROOM_STEM, STRIPPED_SHADE_SHROOM_STEM, STRIPPED_SHOCK_SHROOM_STEM, STRIPPED_TANGLE_SHROOM_STEM,
                        STRIPPED_TOXIC_SHROOM_STEM, BLIGHT_SHROOM_BARK, CINDER_SHROOM_BARK, SHADE_SHROOM_BARK, SHOCK_SHROOM_BARK, TANGLE_SHROOM_BARK, TOXIC_SHROOM_BARK,
                        STRIPPED_BLIGHT_SHROOM_BARK, STRIPPED_CINDER_SHROOM_BARK, STRIPPED_SHADE_SHROOM_BARK, STRIPPED_SHOCK_SHROOM_BARK, STRIPPED_TANGLE_SHROOM_BARK,
                        STRIPPED_TOXIC_SHROOM_BARK, BERNEG_ORE, FARON_ORE, ILLIA_ORE, REGITE_ORE, SHARNIK_ORE, BERNEG_BLOCK, FARON_BLOCK, ILLIA_BLOCK, REGITE_BLOCK,
                        SHARNIK_BLOCK, BLIGHT_SHROOM_PLANKS, CINDER_SHROOM_PLANKS, SHADE_SHROOM_PLANKS, SHOCK_SHROOM_PLANKS, TANGLE_SHROOM_PLANKS, TOXIC_SHROOM_PLANKS,
                        BLIGHT_SHROOM_SLAB, CINDER_SHROOM_SLAB, SHADE_SHROOM_SLAB, SHOCK_SHROOM_SLAB, TANGLE_SHROOM_SLAB, TOXIC_SHROOM_SLAB, BLIGHT_SHROOM_STAIRS,
                        CINDER_SHROOM_STAIRS, SHADE_SHROOM_STAIRS, TANGLE_SHROOM_STAIRS, TOXIC_SHROOM_STAIRS, SHOCK_SHROOM_STAIRS
                );
        RegUtil.items(event.getRegistry())
                .withProperties(() -> new Item.Properties().group(NetherReachesItemGroups.DECORATION))
                .addAll(BlockItem::new, BLACK_REACHCRYSTAL, BLUE_REACHCRYSTAL, BROWN_REACHCRYSTAL, CYAN_REACHCRYSTAL, GRAY_REACHCRYSTAL, GREEN_REACHCRYSTAL,
                        LIGHT_BLUE_REACHCRYSTAL, LIGHT_GRAY_REACHCRYSTAL, LIME_REACHCRYSTAL, MAGENTA_REACHCRYSTAL, ORANGE_REACHCRYSTAL, PINK_REACHCRYSTAL,
                        PURPLE_REACHCRYSTAL, RED_REACHCRYSTAL, WHITE_REACHCRYSTAL, YELLOW_REACHCRYSTAL, BLIGHT_SHROOM_CAP, CINDER_SHROOM_CAP, SHADE_SHROOM_CAP,
                        SHOCK_SHROOM_CAP, TANGLE_SHROOM_CAP, TOXIC_SHROOM_CAP, BLIGHT_SHROOM_SAPLING, CINDER_SHROOM_SAPLING, SHADE_SHROOM_SAPLING, SHOCK_SHROOM_SAPLING,
                        TANGLE_SHROOM_SAPLING, TOXIC_SHROOM_SAPLING, BLIGHT_SHROOM_FENCE, CINDER_SHROOM_FENCE, SHADE_SHROOM_FENCE, SHOCK_SHROOM_FENCE, TANGLE_SHROOM_FENCE,
                        TOXIC_SHROOM_FENCE, SHADE_SHROOM_SIGN, BLACK_REACHCRYSTAL_LANTERN, BLUE_REACHCRYSTAL_LANTERN, BROWN_REACHCRYSTAL_LANTERN, CYAN_REACHCRYSTAL_LANTERN,
                        GRAY_REACHCRYSTAL_LANTERN, GREEN_REACHCRYSTAL_LANTERN, LIGHT_BLUE_REACHCRYSTAL_LANTERN, LIGHT_GRAY_REACHCRYSTAL_LANTERN, LIME_REACHCRYSTAL_LANTERN,
                        MAGENTA_REACHCRYSTAL_LANTERN, ORANGE_REACHCRYSTAL_LANTERN, PINK_REACHCRYSTAL_LANTERN, PURPLE_REACHCRYSTAL_LANTERN, RED_REACHCRYSTAL_LANTERN,
                        WHITE_REACHCRYSTAL_LANTERN, YELLOW_REACHCRYSTAL_LANTERN, BLIGHT_SHROOM_LADDER, CINDER_SHROOM_LADDER, SHADE_SHROOM_LADDER, SHOCK_SHROOM_LADDER,
                        TANGLE_SHROOM_LADDER, TOXIC_SHROOM_LADDER
                );

        RegUtil.items(event.getRegistry())
                .withProperties(() -> new Item.Properties().group(NetherReachesItemGroups.REDSTONES))
                .addAll(BlockItem::new,  BLIGHT_SHROOM_DOOR, CINDER_SHROOM_DOOR, SHADE_SHROOM_DOOR, SHOCK_SHROOM_DOOR, TANGLE_SHROOM_DOOR, TOXIC_SHROOM_DOOR,
                        BLIGHT_SHROOM_BUTTON, CINDER_SHROOM_BUTTON, SHADE_SHROOM_BUTTON, SHOCK_SHROOM_BUTTON, TANGLE_SHROOM_BUTTON, TOXIC_SHROOM_BUTTON, BLIGHT_SHROOM_TRAPDOOR,
                        CINDER_SHROOM_TRAPDOOR, SHADE_SHROOM_TRAPDOOR, SHOCK_SHROOM_TRAPDOOR, TANGLE_SHROOM_TRAPDOOR, TOXIC_SHROOM_TRAPDOOR, BLIGHT_SHROOM_PRESSURE_PLATE,
                        CINDER_SHROOM_PRESSURE_PLATE, SHADE_SHROOM_PRESSURE_PLATE, SHOCK_SHROOM_PRESSURE_PLATE, TANGLE_SHROOM_PRESSURE_PLATE, TOXIC_SHROOM_PRESSURE_PLATE,
                        BLIGHT_SHROOM_FENCE_GATE, CINDER_SHROOM_FENCE_GATE, SHADE_SHROOM_FENCE_GATE, SHOCK_SHROOM_FENCE_GATE, TANGLE_SHROOM_FENCE_GATE, TOXIC_SHROOM_FENCE_GATE
                );
    }
/*
    @OnlyIn(Dist.CLIENT)
    private static Callable<ItemStackTileEntityRenderer> getSignRenderer(Block block) {
        return () -> new MidnightChestItemRenderer(block);
    }

 */
}
