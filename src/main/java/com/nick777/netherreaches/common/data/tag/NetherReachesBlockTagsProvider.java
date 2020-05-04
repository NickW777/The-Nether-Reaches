package com.nick777.netherreaches.common.data.tag;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;

public class NetherReachesBlockTagsProvider extends BlockTagsProvider{
    public NetherReachesBlockTagsProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    public void registerTags() {
        this.getBuilder(NetherReachesTags.Blocks.BLIGHT_SHROOM).add(
                NetherReachesBlocks.BLIGHT_SHROOM_BARK,
                NetherReachesBlocks.BLIGHT_SHROOM_BUTTON,
                NetherReachesBlocks.BLIGHT_SHROOM_CAP,
                NetherReachesBlocks.BLIGHT_SHROOM_DOOR,
                NetherReachesBlocks.BLIGHT_SHROOM_FENCE,
                NetherReachesBlocks.BLIGHT_SHROOM_FENCE_GATE,
                NetherReachesBlocks.BLIGHT_SHROOM_LADDER,
                NetherReachesBlocks.BLIGHT_SHROOM_PLANKS,
                NetherReachesBlocks.BLIGHT_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.BLIGHT_SHROOM_SAPLING,
                NetherReachesBlocks.BLIGHT_SHROOM_SLAB,
                NetherReachesBlocks.BLIGHT_SHROOM_STAIRS,
                NetherReachesBlocks.BLIGHT_SHROOM_STEM,
                NetherReachesBlocks.BLIGHT_SHROOM_TRAPDOOR,
                NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_STEM
        );

        this.getBuilder(NetherReachesTags.Blocks.CINDER_SHROOM).add(
                NetherReachesBlocks.CINDER_SHROOM_BARK,
                NetherReachesBlocks.CINDER_SHROOM_BUTTON,
                NetherReachesBlocks.CINDER_SHROOM_CAP,
                NetherReachesBlocks.CINDER_SHROOM_DOOR,
                NetherReachesBlocks.CINDER_SHROOM_FENCE,
                NetherReachesBlocks.CINDER_SHROOM_FENCE_GATE,
                NetherReachesBlocks.CINDER_SHROOM_LADDER,
                NetherReachesBlocks.CINDER_SHROOM_PLANKS,
                NetherReachesBlocks.CINDER_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.CINDER_SHROOM_SAPLING,
                NetherReachesBlocks.CINDER_SHROOM_SLAB,
                NetherReachesBlocks.CINDER_SHROOM_STAIRS,
                NetherReachesBlocks.CINDER_SHROOM_STEM,
                NetherReachesBlocks.CINDER_SHROOM_TRAPDOOR,
                NetherReachesBlocks.STRIPPED_CINDER_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_CINDER_SHROOM_STEM
        );

        this.getBuilder(NetherReachesTags.Blocks.SHADE_SHROOM).add(
                NetherReachesBlocks.SHADE_SHROOM_BARK,
                NetherReachesBlocks.SHADE_SHROOM_BUTTON,
                NetherReachesBlocks.SHADE_SHROOM_CAP,
                NetherReachesBlocks.SHADE_SHROOM_DOOR,
                NetherReachesBlocks.SHADE_SHROOM_FENCE,
                NetherReachesBlocks.SHADE_SHROOM_FENCE_GATE,
                NetherReachesBlocks.SHADE_SHROOM_LADDER,
                NetherReachesBlocks.SHADE_SHROOM_PLANKS,
                NetherReachesBlocks.SHADE_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.SHADE_SHROOM_SAPLING,
                NetherReachesBlocks.SHADE_SHROOM_SLAB,
                NetherReachesBlocks.SHADE_SHROOM_STAIRS,
                NetherReachesBlocks.SHADE_SHROOM_STEM,
                NetherReachesBlocks.SHADE_SHROOM_TRAPDOOR,
                NetherReachesBlocks.STRIPPED_SHADE_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_SHADE_SHROOM_STEM
        );

        this.getBuilder(NetherReachesTags.Blocks.SHOCK_SHROOM).add(
                NetherReachesBlocks.SHOCK_SHROOM_BARK,
                NetherReachesBlocks.SHOCK_SHROOM_BUTTON,
                NetherReachesBlocks.SHOCK_SHROOM_CAP,
                NetherReachesBlocks.SHOCK_SHROOM_DOOR,
                NetherReachesBlocks.SHOCK_SHROOM_FENCE,
                NetherReachesBlocks.SHOCK_SHROOM_FENCE_GATE,
                NetherReachesBlocks.SHOCK_SHROOM_LADDER,
                NetherReachesBlocks.SHOCK_SHROOM_PLANKS,
                NetherReachesBlocks.SHOCK_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.SHOCK_SHROOM_SAPLING,
                NetherReachesBlocks.SHOCK_SHROOM_SLAB,
                NetherReachesBlocks.SHOCK_SHROOM_STAIRS,
                NetherReachesBlocks.SHOCK_SHROOM_STEM,
                NetherReachesBlocks.SHOCK_SHROOM_TRAPDOOR,
                NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_STEM
        );

        this.getBuilder(NetherReachesTags.Blocks.TANGLE_SHROOM).add(
                NetherReachesBlocks.TANGLE_SHROOM_BARK,
                NetherReachesBlocks.TANGLE_SHROOM_BUTTON,
                NetherReachesBlocks.TANGLE_SHROOM_CAP,
                NetherReachesBlocks.TANGLE_SHROOM_DOOR,
                NetherReachesBlocks.TANGLE_SHROOM_FENCE,
                NetherReachesBlocks.TANGLE_SHROOM_FENCE_GATE,
                NetherReachesBlocks.TANGLE_SHROOM_LADDER,
                NetherReachesBlocks.TANGLE_SHROOM_PLANKS,
                NetherReachesBlocks.TANGLE_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.TANGLE_SHROOM_SAPLING,
                NetherReachesBlocks.TANGLE_SHROOM_SLAB,
                NetherReachesBlocks.TANGLE_SHROOM_STAIRS,
                NetherReachesBlocks.TANGLE_SHROOM_STEM,
                NetherReachesBlocks.TANGLE_SHROOM_TRAPDOOR,
                NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_STEM
        );

        this.getBuilder(NetherReachesTags.Blocks.TOXIC_SHROOM).add(
                NetherReachesBlocks.TOXIC_SHROOM_BARK,
                NetherReachesBlocks.TOXIC_SHROOM_BUTTON,
                NetherReachesBlocks.TOXIC_SHROOM_CAP,
                NetherReachesBlocks.TOXIC_SHROOM_DOOR,
                NetherReachesBlocks.TOXIC_SHROOM_FENCE,
                NetherReachesBlocks.TOXIC_SHROOM_FENCE_GATE,
                NetherReachesBlocks.TOXIC_SHROOM_LADDER,
                NetherReachesBlocks.TOXIC_SHROOM_PLANKS,
                NetherReachesBlocks.TOXIC_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.TOXIC_SHROOM_SAPLING,
                NetherReachesBlocks.TOXIC_SHROOM_SLAB,
                NetherReachesBlocks.TOXIC_SHROOM_STAIRS,
                NetherReachesBlocks.TOXIC_SHROOM_STEM,
                NetherReachesBlocks.TOXIC_SHROOM_TRAPDOOR,
                NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_STEM
        );

        this.getBuilder(NetherReachesTags.Blocks.CAN_HOLD_ORES).add(
                NetherReachesBlocks.SHADE_STONE
        );

        this.getBuilder(NetherReachesTags.Blocks.STRIPPED).add(
                NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_STEM,
                NetherReachesBlocks.STRIPPED_CINDER_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_CINDER_SHROOM_STEM,
                NetherReachesBlocks.STRIPPED_SHADE_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_SHADE_SHROOM_STEM,
                NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_STEM,
                NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_STEM,
                NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_STEM
        );

        this.getBuilder(NetherReachesTags.Blocks.STONES).add(
                NetherReachesBlocks.SHADE_STONE,
                NetherReachesBlocks.SHINE_STONE
        );

        this.getBuilder(NetherReachesTags.Blocks.BRICKS).add(
                NetherReachesBlocks.SHADE_STONE_BRICKS,
                NetherReachesBlocks.SHINE_STONE_BRICKS,
                NetherReachesBlocks.CRACKED_SHADE_STONE_BRICKS,
                NetherReachesBlocks.CRACKED_SHINE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_SHADE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_SHINE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_CRACKED_SHADE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_CRACKED_SHINE_STONE_BRICKS
        );

        this.getBuilder(NetherReachesTags.Blocks.MOSSY).add(
                NetherReachesBlocks.MOSSY_SHADE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_SHINE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_CRACKED_SHADE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_CRACKED_SHINE_STONE_BRICKS
        );

        this.getBuilder(NetherReachesTags.Blocks.CRACKED).add(
                NetherReachesBlocks.CRACKED_SHADE_STONE_BRICKS,
                NetherReachesBlocks.CRACKED_SHINE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_CRACKED_SHADE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_CRACKED_SHINE_STONE_BRICKS
        );

        this.getBuilder(NetherReachesTags.Blocks.SHADE_STONE).add(
                NetherReachesBlocks.SHADE_STONE,
                NetherReachesBlocks.SHADE_STONE_BRICKS,
                NetherReachesBlocks.CRACKED_SHADE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_SHADE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_CRACKED_SHADE_STONE_BRICKS
        );

        this.getBuilder(NetherReachesTags.Blocks.SHINE_STONE).add(
                NetherReachesBlocks.SHINE_STONE,
                NetherReachesBlocks.SHINE_STONE_BRICKS,
                NetherReachesBlocks.CRACKED_SHINE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_SHINE_STONE_BRICKS,
                NetherReachesBlocks.MOSSY_CRACKED_SHINE_STONE_BRICKS
        );

        this.getBuilder(NetherReachesTags.Blocks.ORES).add(
                NetherReachesBlocks.BERNEG_ORE,
                NetherReachesBlocks.FARON_ORE,
                NetherReachesBlocks.ILLIA_ORE,
                NetherReachesBlocks.REGITE_ORE,
                NetherReachesBlocks.SHARNIK_ORE
        );

        this.getBuilder(NetherReachesTags.Blocks.REACHCRYSTALS).add(
                NetherReachesBlocks.BLACK_REACHCRYSTAL,
                NetherReachesBlocks.BLUE_REACHCRYSTAL,
                NetherReachesBlocks.BROWN_REACHCRYSTAL,
                NetherReachesBlocks.CYAN_REACHCRYSTAL,
                NetherReachesBlocks.GRAY_REACHCRYSTAL,
                NetherReachesBlocks.GREEN_REACHCRYSTAL,
                NetherReachesBlocks.LIGHT_BLUE_REACHCRYSTAL,
                NetherReachesBlocks.LIGHT_GRAY_REACHCRYSTAL,
                NetherReachesBlocks.LIME_REACHCRYSTAL,
                NetherReachesBlocks.MAGENTA_REACHCRYSTAL,
                NetherReachesBlocks.ORANGE_REACHCRYSTAL,
                NetherReachesBlocks.PINK_REACHCRYSTAL,
                NetherReachesBlocks.PURPLE_REACHCRYSTAL,
                NetherReachesBlocks.RED_REACHCRYSTAL,
                NetherReachesBlocks.WHITE_REACHCRYSTAL,
                NetherReachesBlocks.YELLOW_REACHCRYSTAL
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_CAPS).add(
                NetherReachesBlocks.BLIGHT_SHROOM_CAP,
                NetherReachesBlocks.CINDER_SHROOM_CAP,
                NetherReachesBlocks.SHADE_SHROOM_CAP,
                NetherReachesBlocks.SHOCK_SHROOM_CAP,
                NetherReachesBlocks.TANGLE_SHROOM_CAP,
                NetherReachesBlocks.TOXIC_SHROOM_CAP
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_STEMS).add(
                NetherReachesBlocks.BLIGHT_SHROOM_STEM,
                NetherReachesBlocks.CINDER_SHROOM_STEM,
                NetherReachesBlocks.SHADE_SHROOM_STEM,
                NetherReachesBlocks.SHOCK_SHROOM_STEM,
                NetherReachesBlocks.TANGLE_SHROOM_STEM,
                NetherReachesBlocks.TOXIC_SHROOM_STEM,
                NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_STEM,
                NetherReachesBlocks.STRIPPED_CINDER_SHROOM_STEM,
                NetherReachesBlocks.STRIPPED_SHADE_SHROOM_STEM,
                NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_STEM,
                NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_STEM,
                NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_STEM
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_BARK_BLOCKS).add(
                NetherReachesBlocks.BLIGHT_SHROOM_BARK,
                NetherReachesBlocks.CINDER_SHROOM_BARK,
                NetherReachesBlocks.SHADE_SHROOM_BARK,
                NetherReachesBlocks.SHOCK_SHROOM_BARK,
                NetherReachesBlocks.TANGLE_SHROOM_BARK,
                NetherReachesBlocks.TOXIC_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_CINDER_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_SHADE_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_BARK,
                NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_BARK
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_BUTTONS).add(
                NetherReachesBlocks.BLIGHT_SHROOM_BUTTON,
                NetherReachesBlocks.CINDER_SHROOM_BUTTON,
                NetherReachesBlocks.SHADE_SHROOM_BUTTON,
                NetherReachesBlocks.SHOCK_SHROOM_BUTTON,
                NetherReachesBlocks.TANGLE_SHROOM_BUTTON,
                NetherReachesBlocks.TOXIC_SHROOM_BUTTON
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_DOORS).add(
                NetherReachesBlocks.BLIGHT_SHROOM_DOOR,
                NetherReachesBlocks.CINDER_SHROOM_DOOR,
                NetherReachesBlocks.SHADE_SHROOM_DOOR,
                NetherReachesBlocks.SHOCK_SHROOM_DOOR,
                NetherReachesBlocks.TANGLE_SHROOM_DOOR,
                NetherReachesBlocks.TOXIC_SHROOM_DOOR
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_FENCES).add(
                NetherReachesBlocks.BLIGHT_SHROOM_FENCE,
                NetherReachesBlocks.CINDER_SHROOM_FENCE,
                NetherReachesBlocks.SHADE_SHROOM_FENCE,
                NetherReachesBlocks.SHOCK_SHROOM_FENCE,
                NetherReachesBlocks.TANGLE_SHROOM_FENCE,
                NetherReachesBlocks.TOXIC_SHROOM_FENCE
        );
        this.getBuilder(NetherReachesTags.Blocks.SHROOM_FENCE_GATES).add(
                NetherReachesBlocks.BLIGHT_SHROOM_FENCE_GATE,
                NetherReachesBlocks.CINDER_SHROOM_FENCE_GATE,
                NetherReachesBlocks.SHADE_SHROOM_FENCE_GATE,
                NetherReachesBlocks.SHOCK_SHROOM_FENCE_GATE,
                NetherReachesBlocks.TANGLE_SHROOM_FENCE_GATE,
                NetherReachesBlocks.TOXIC_SHROOM_FENCE_GATE
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_LADDERS).add(
                NetherReachesBlocks.BLIGHT_SHROOM_LADDER,
                NetherReachesBlocks.CINDER_SHROOM_LADDER,
                NetherReachesBlocks.SHADE_SHROOM_LADDER,
                NetherReachesBlocks.SHOCK_SHROOM_LADDER,
                NetherReachesBlocks.TANGLE_SHROOM_LADDER,
                NetherReachesBlocks.TOXIC_SHROOM_LADDER
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_PLANKS).add(
                NetherReachesBlocks.BLIGHT_SHROOM_PLANKS,
                NetherReachesBlocks.CINDER_SHROOM_PLANKS,
                NetherReachesBlocks.SHADE_SHROOM_PLANKS,
                NetherReachesBlocks.SHOCK_SHROOM_PLANKS,
                NetherReachesBlocks.TANGLE_SHROOM_PLANKS,
                NetherReachesBlocks.TOXIC_SHROOM_PLANKS
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_PRESSURE_PLATES).add(
                NetherReachesBlocks.BLIGHT_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.CINDER_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.SHADE_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.SHOCK_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.TANGLE_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.TOXIC_SHROOM_PRESSURE_PLATE
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_SAPLINGS).add(
                NetherReachesBlocks.BLIGHT_SHROOM_SAPLING,
                NetherReachesBlocks.CINDER_SHROOM_SAPLING,
                NetherReachesBlocks.SHADE_SHROOM_SAPLING,
                NetherReachesBlocks.SHOCK_SHROOM_SAPLING,
                NetherReachesBlocks.TANGLE_SHROOM_SAPLING,
                NetherReachesBlocks.TOXIC_SHROOM_SAPLING
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_SLABS).add(
                NetherReachesBlocks.BLIGHT_SHROOM_SLAB,
                NetherReachesBlocks.CINDER_SHROOM_SLAB,
                NetherReachesBlocks.SHADE_SHROOM_SLAB,
                NetherReachesBlocks.SHOCK_SHROOM_SLAB,
                NetherReachesBlocks.TANGLE_SHROOM_SLAB,
                NetherReachesBlocks.TOXIC_SHROOM_SLAB
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_STAIRS).add(
                NetherReachesBlocks.BLIGHT_SHROOM_STAIRS,
                NetherReachesBlocks.CINDER_SHROOM_STAIRS,
                NetherReachesBlocks.SHADE_SHROOM_STAIRS,
                NetherReachesBlocks.SHOCK_SHROOM_STAIRS,
                NetherReachesBlocks.TANGLE_SHROOM_STAIRS,
                NetherReachesBlocks.TOXIC_SHROOM_STAIRS
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_TRAPDOORS).add(
                NetherReachesBlocks.BLIGHT_SHROOM_TRAPDOOR,
                NetherReachesBlocks.CINDER_SHROOM_TRAPDOOR,
                NetherReachesBlocks.SHADE_SHROOM_TRAPDOOR,
                NetherReachesBlocks.SHOCK_SHROOM_TRAPDOOR,
                NetherReachesBlocks.TANGLE_SHROOM_TRAPDOOR,
                NetherReachesBlocks.TOXIC_SHROOM_TRAPDOOR
        );
    }

    @Override
    public String getName() {
        return "Nether Reaches Block Tags";
    }
}
