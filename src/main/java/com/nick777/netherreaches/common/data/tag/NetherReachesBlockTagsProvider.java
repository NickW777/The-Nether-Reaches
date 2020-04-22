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
        this.getBuilder(NetherReachesTags.Blocks.SHADE_SHROOM).add(
                NetherReachesBlocks.SHADE_SHROOM_BUTTON,
                NetherReachesBlocks.SHADE_SHROOM_CAP,
                NetherReachesBlocks.SHADE_SHROOM_DOOR,
                NetherReachesBlocks.SHADE_SHROOM_FENCE,
                NetherReachesBlocks.SHADE_SHROOM_FENCE_GATE,
                NetherReachesBlocks.SHADE_SHROOM_PLANKS,
                NetherReachesBlocks.SHADE_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.SHADE_SHROOM_SAPLING,
                NetherReachesBlocks.SHADE_SHROOM_SLAB,
                NetherReachesBlocks.SHADE_SHROOM_STAIRS,
                NetherReachesBlocks.SHADE_SHROOM_STEM,
                NetherReachesBlocks.SHADE_SHROOM_TRAPDOOR
        );

        this.getBuilder(NetherReachesTags.Blocks.SHOCK_SHROOM).add(
                NetherReachesBlocks.SHOCK_SHROOM_BUTTON,
                NetherReachesBlocks.SHOCK_SHROOM_CAP,
                NetherReachesBlocks.SHOCK_SHROOM_DOOR,
                NetherReachesBlocks.SHOCK_SHROOM_FENCE,
                NetherReachesBlocks.SHOCK_SHROOM_FENCE_GATE,
                NetherReachesBlocks.SHOCK_SHROOM_PLANKS,
                NetherReachesBlocks.SHOCK_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.SHOCK_SHROOM_SAPLING,
                NetherReachesBlocks.SHOCK_SHROOM_SLAB,
                NetherReachesBlocks.SHOCK_SHROOM_STAIRS,
                NetherReachesBlocks.SHOCK_SHROOM_STEM,
                NetherReachesBlocks.SHOCK_SHROOM_TRAPDOOR
        );

        this.getBuilder(NetherReachesTags.Blocks.CAN_HOLD_ORES).add(
                NetherReachesBlocks.SHADE_STONE
        );

        this.getBuilder(NetherReachesTags.Blocks.STONES).add(
                NetherReachesBlocks.SHADE_STONE
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
                NetherReachesBlocks.SHADE_SHROOM_CAP,
                NetherReachesBlocks.SHOCK_SHROOM_CAP
        );

        this.getBuilder(NetherReachesTags.Blocks.SHADE_SHROOM_STEMS).add(
                NetherReachesBlocks.SHADE_SHROOM_STEM
        );

        this.getBuilder(NetherReachesTags.Blocks.SHOCK_SHROOM_STEMS).add(
                NetherReachesBlocks.SHOCK_SHROOM_STEM
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_BUTTONS).add(
                NetherReachesBlocks.SHADE_SHROOM_BUTTON,
                NetherReachesBlocks.SHOCK_SHROOM_BUTTON
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_DOORS).add(
                NetherReachesBlocks.SHADE_SHROOM_DOOR,
                NetherReachesBlocks.SHADE_SHROOM_DOOR
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_FENCES).add(
                NetherReachesBlocks.SHADE_SHROOM_FENCE,
                NetherReachesBlocks.SHOCK_SHROOM_FENCE
        );
        this.getBuilder(NetherReachesTags.Blocks.SHROOM_FENCE_GATES).add(
                NetherReachesBlocks.SHADE_SHROOM_FENCE_GATE,
                NetherReachesBlocks.SHOCK_SHROOM_FENCE_GATE
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_PLANKS).add(
                NetherReachesBlocks.SHADE_SHROOM_PLANKS,
                NetherReachesBlocks.SHOCK_SHROOM_PLANKS
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_PRESSURE_PLATES).add(
                NetherReachesBlocks.SHADE_SHROOM_PRESSURE_PLATE,
                NetherReachesBlocks.SHOCK_SHROOM_PRESSURE_PLATE
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_SAPLINGS).add(
                NetherReachesBlocks.SHADE_SHROOM_SAPLING,
                NetherReachesBlocks.SHOCK_SHROOM_SAPLING
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_SLABS).add(
                NetherReachesBlocks.SHADE_SHROOM_SLAB,
                NetherReachesBlocks.SHOCK_SHROOM_SLAB
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_STAIRS).add(
                NetherReachesBlocks.SHADE_SHROOM_STAIRS,
                NetherReachesBlocks.SHOCK_SHROOM_STAIRS
        );

        this.getBuilder(NetherReachesTags.Blocks.SHROOM_TRAPDOORS).add(
                NetherReachesBlocks.SHADE_SHROOM_TRAPDOOR,
                NetherReachesBlocks.SHOCK_SHROOM_TRAPDOOR
        );
    }

    @Override
    public String getName() {
        return "Nether Reaches Block Tags";
    }
}
