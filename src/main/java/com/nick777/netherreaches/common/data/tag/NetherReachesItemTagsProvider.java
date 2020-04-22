package com.nick777.netherreaches.common.data.tag;

import com.nick777.netherreaches.common.registry.NetherReachesItems;
import com.nick777.netherreaches.common.registry.NetherReachesTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;

public class NetherReachesItemTagsProvider extends ItemTagsProvider {

    public NetherReachesItemTagsProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerTags() {

        this.copy(NetherReachesTags.Blocks.SHADE_SHROOM, NetherReachesTags.Items.SHADE_SHROOM);
        this.copy(NetherReachesTags.Blocks.SHOCK_SHROOM, NetherReachesTags.Items.SHOCK_SHROOM);
        this.copy(NetherReachesTags.Blocks.STONES, NetherReachesTags.Items.STONES);
        this.copy(NetherReachesTags.Blocks.REACHCRYSTALS, NetherReachesTags.Items.REACHCHRYSTALS);
        this.copy(NetherReachesTags.Blocks.SHROOM_CAPS, NetherReachesTags.Items.SHROOM_CAPS);
        this.copy(NetherReachesTags.Blocks.SHADE_SHROOM_STEMS, NetherReachesTags.Items.SHADE_SHROOM_STEMS);
        this.copy(NetherReachesTags.Blocks.SHOCK_SHROOM_STEMS, NetherReachesTags.Items.SHOCK_SHROOM_STEMS);
        this.copy(NetherReachesTags.Blocks.SHROOM_BUTTONS, NetherReachesTags.Items.SHROOM_BUTTONS);
        this.copy(NetherReachesTags.Blocks.SHROOM_DOORS, NetherReachesTags.Items.SHROOM_DOORS);
        this.copy(NetherReachesTags.Blocks.SHROOM_FENCES, NetherReachesTags.Items.SHROOM_FENCES);
        this.copy(NetherReachesTags.Blocks.SHROOM_FENCE_GATES, NetherReachesTags.Items.SHROOM_FENCE_GATES);
        this.copy(NetherReachesTags.Blocks.SHROOM_PLANKS, NetherReachesTags.Items.SHROOM_PLANKS);
        this.copy(NetherReachesTags.Blocks.SHROOM_PRESSURE_PLATES, NetherReachesTags.Items.SHROOM_PRESSURE_PLATES);
        this.copy(NetherReachesTags.Blocks.SHROOM_SAPLINGS, NetherReachesTags.Items.SHROOM_SAPLINGS);
        this.copy(NetherReachesTags.Blocks.SHROOM_SLABS, NetherReachesTags.Items.SHROOM_SLABS);
        this.copy(NetherReachesTags.Blocks.SHROOM_STAIRS, NetherReachesTags.Items.SHROOM_STAIRS);
        this.copy(NetherReachesTags.Blocks.SHROOM_TRAPDOORS, NetherReachesTags.Items.SHROOM_TRAPDOORS);


        this.getBuilder(NetherReachesTags.Items.REACHCRYSTAL_SHARDS)
                .add(NetherReachesItems.BLACK_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.BLUE_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.BROWN_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.CYAN_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.GRAY_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.GREEN_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.LIGHT_BLUE_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.LIGHT_GRAY_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.LIME_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.MAGENTA_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.ORANGE_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.PINK_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.PURPLE_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.RED_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.WHITE_REACHCRYSTAL_SHARD)
                .add(NetherReachesItems.YELLOW_REACHCRYSTAL_SHARD);

        this.getBuilder(NetherReachesTags.Items.GEMS)
                .add(NetherReachesItems.BERNEG)
                .add(NetherReachesItems.FARON)
                .add(NetherReachesItems.ILLIA)
                .add(NetherReachesItems.REGITE)
                .add(NetherReachesItems.SHARNIK);

        this.getBuilder(NetherReachesTags.Items.SHROOM_STICKS)
                .add(NetherReachesItems.SHADE_STICK)
                .add(NetherReachesItems.SHOCK_STICK);
    }

    @Override
    public String getName() {
        return "Nether Reaches Item Tags";
    }
}
