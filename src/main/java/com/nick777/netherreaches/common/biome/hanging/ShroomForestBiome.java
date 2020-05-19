package com.nick777.netherreaches.common.biome.hanging;

import com.nick777.netherreaches.common.biome.NetherReachesHangingConfigurator;
import com.nick777.netherreaches.common.biome.NetherReachesSurfaceBuilders;

public class ShroomForestBiome extends HangingBiome {
    public ShroomForestBiome() {
        super(new Properties()
                .surfaceBuilder(NetherReachesSurfaceBuilders.HANGING, NetherReachesSurfaceBuilders.SHADE_STONE_CONFIG)
                .category(Category.FOREST)
                .grassColor(0x695F8C)
                .depth(1.0F)
                .scale(0.1F)
                .fog(0.1F, 80.0F)
                .ridgeWeight(6.0F)
        );

        NetherReachesHangingConfigurator.addGlobalOres(this);
        NetherReachesHangingConfigurator.addReachCrystalCeilingClump(this);

        NetherReachesHangingConfigurator.addShroomForestCeilingShrooms(this);
        NetherReachesHangingConfigurator.addShelfShrooms(this);
    }
}
