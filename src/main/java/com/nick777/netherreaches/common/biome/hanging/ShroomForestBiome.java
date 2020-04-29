package com.nick777.netherreaches.common.biome.hanging;

import com.nick777.netherreaches.common.biome.NetherReachesHangingConfigurator;
import com.nick777.netherreaches.common.biome.NetherReachesSurfaceBuilders;

public class ShroomForestBiome extends HangingBiome {
    public ShroomForestBiome() {
        super(new Properties()
                .surfaceBuilder(NetherReachesSurfaceBuilders.HANGING, NetherReachesSurfaceBuilders.SHADE_STONE_CONFIG)
                .category(Category.FOREST)
                .grassColor(0x695F8C)
                .depth(0.155F)
                .scale(0.07F)
                .fog(0.1F, 80.0F)
        );

        NetherReachesHangingConfigurator.addGlobalOres(this);

        NetherReachesHangingConfigurator.addBlightShroom(this);
        NetherReachesHangingConfigurator.addShadeShroom(this);
        NetherReachesHangingConfigurator.addShockShroom(this);
        NetherReachesHangingConfigurator.addTangleShroom(this);
        NetherReachesHangingConfigurator.addToxicShroom(this);
    }
}
