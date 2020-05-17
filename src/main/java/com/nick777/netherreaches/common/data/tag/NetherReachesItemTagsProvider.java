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

        this.copy(NetherReachesTags.Blocks.BLIGHT_SHROOM, NetherReachesTags.Items.BLIGHT_SHROOM);
        this.copy(NetherReachesTags.Blocks.CINDER_SHROOM, NetherReachesTags.Items.CINDER_SHROOM);
        this.copy(NetherReachesTags.Blocks.SHADE_SHROOM, NetherReachesTags.Items.SHADE_SHROOM);
        this.copy(NetherReachesTags.Blocks.SHOCK_SHROOM, NetherReachesTags.Items.SHOCK_SHROOM);
        this.copy(NetherReachesTags.Blocks.TANGLE_SHROOM, NetherReachesTags.Items.TANGLE_SHROOM);
        this.copy(NetherReachesTags.Blocks.TOXIC_SHROOM, NetherReachesTags.Items.TOXIC_SHROOM);
        this.copy(NetherReachesTags.Blocks.AQUANE_SHROOM, NetherReachesTags.Items.AQUANE_SHROOM);
        this.copy(NetherReachesTags.Blocks.CRELENOR_SHROOM, NetherReachesTags.Items.CRELENOR_SHROOM);
        this.copy(NetherReachesTags.Blocks.GREJAR_SHROOM, NetherReachesTags.Items.GREJAR_SHROOM);
        this.copy(NetherReachesTags.Blocks.MOISE_SHROOM, NetherReachesTags.Items.MOISE_SHROOM);
        this.copy(NetherReachesTags.Blocks.SABLE_SHROOM, NetherReachesTags.Items.SABLE_SHROOM);
        this.copy(NetherReachesTags.Blocks.STONES, NetherReachesTags.Items.STONES);
        this.copy(NetherReachesTags.Blocks.SHADE_STONE, NetherReachesTags.Items.SHADE_STONE);
        this.copy(NetherReachesTags.Blocks.SHINE_STONE, NetherReachesTags.Items.SHINE_STONE);
        this.copy(NetherReachesTags.Blocks.BRICKS, NetherReachesTags.Items.BRICKS);
        this.copy(NetherReachesTags.Blocks.MOSSY, NetherReachesTags.Items.MOSSY);
        this.copy(NetherReachesTags.Blocks.CRACKED, NetherReachesTags.Items.CRACKED);
        this.copy(NetherReachesTags.Blocks.ORES, NetherReachesTags.Items.ORES);
        this.copy(NetherReachesTags.Blocks.STRIPPED, NetherReachesTags.Items.STRIPPED);
        this.copy(NetherReachesTags.Blocks.REACHCRYSTALS, NetherReachesTags.Items.REACHCHRYSTALS);
        this.copy(NetherReachesTags.Blocks.SHELF_CORE, NetherReachesTags.Items.SHELF_CORE);
        this.copy(NetherReachesTags.Blocks.SHELF_CRUST, NetherReachesTags.Items.SHELF_CRUST);
        this.copy(NetherReachesTags.Blocks.SHELF_PASTE, NetherReachesTags.Items.SHELF_PASTE);
        this.copy(NetherReachesTags.Blocks.SHROOM_BARK_BLOCKS, NetherReachesTags.Items.SHROOM_BARK_BLOCKS);
        this.copy(NetherReachesTags.Blocks.SHROOM_BUTTONS, NetherReachesTags.Items.SHROOM_BUTTONS);
        this.copy(NetherReachesTags.Blocks.SHROOM_CAPS, NetherReachesTags.Items.SHROOM_CAPS);
        this.copy(NetherReachesTags.Blocks.SHROOM_DOORS, NetherReachesTags.Items.SHROOM_DOORS);
        this.copy(NetherReachesTags.Blocks.SHROOM_FENCES, NetherReachesTags.Items.SHROOM_FENCES);
        this.copy(NetherReachesTags.Blocks.SHROOM_FENCE_GATES, NetherReachesTags.Items.SHROOM_FENCE_GATES);
        this.copy(NetherReachesTags.Blocks.SHROOM_LADDERS, NetherReachesTags.Items.SHROOM_LADDERS);
        this.copy(NetherReachesTags.Blocks.SHROOM_PLANKS, NetherReachesTags.Items.SHROOM_PLANKS);
        this.copy(NetherReachesTags.Blocks.SHROOM_PRESSURE_PLATES, NetherReachesTags.Items.SHROOM_PRESSURE_PLATES);
        this.copy(NetherReachesTags.Blocks.SHROOM_SAPLINGS, NetherReachesTags.Items.SHROOM_SAPLINGS);
        this.copy(NetherReachesTags.Blocks.SHROOM_SLABS, NetherReachesTags.Items.SHROOM_SLABS);
        this.copy(NetherReachesTags.Blocks.SHROOM_STAIRS, NetherReachesTags.Items.SHROOM_STAIRS);
        this.copy(NetherReachesTags.Blocks.SHROOM_STEMS, NetherReachesTags.Items.SHROOM_STEMS);
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
                .add(NetherReachesItems.BLIGHT_STICK)
                .add(NetherReachesItems.CINDER_STICK)
                .add(NetherReachesItems.SHADE_STICK)
                .add(NetherReachesItems.SHOCK_STICK)
                .add(NetherReachesItems.TANGLE_STICK)
                .add(NetherReachesItems.TOXIC_STICK);
    }

    @Override
    public String getName() {
        return "Nether Reaches Item Tags";
    }
}
