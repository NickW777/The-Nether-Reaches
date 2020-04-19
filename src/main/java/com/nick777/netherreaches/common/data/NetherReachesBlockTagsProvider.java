package com.nick777.netherreaches.common.data;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesTags;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;

public class NetherReachesBlockTagsProvider extends BlockTagsProvider{
    public NetherReachesBlockTagsProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    public void registerTags() {
        this.getBuilder(NetherReachesTags.Blocks.SHADESHROOM).add(
                NetherReachesBlocks.SHADE_SHROOM_SAPLING,
                NetherReachesBlocks.SHADE_SHROOM_CAP,
                NetherReachesBlocks.SHADE_SHROOM_STEM,
                NetherReachesBlocks.SHADE_SHROOM_PLANKS
        );

        this.getBuilder(NetherReachesTags.Blocks.CAN_HOLD_ORES).add(
                NetherReachesBlocks.SHADE_STONE
        );

        this.getBuilder(NetherReachesTags.Blocks.SAPLINGS).add(
                NetherReachesBlocks.SHADE_STONE
        );

        this.getBuilder(NetherReachesTags.Blocks.FUNGI_CAPS).add(
                NetherReachesBlocks.SHADE_SHROOM_CAP
        );

        this.getBuilder(NetherReachesTags.Blocks.FUNGI_STEMS).add(
                NetherReachesBlocks.SHADE_SHROOM_STEM
        );

        this.getBuilder(NetherReachesTags.Blocks.PLANKS).add(
                NetherReachesBlocks.SHADE_SHROOM_PLANKS
        );
    }

    @Override
    public String getName() {
        return "Midnight Block Tags";
    }
}
