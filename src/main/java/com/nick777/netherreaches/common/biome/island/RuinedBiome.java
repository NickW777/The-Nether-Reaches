package com.nick777.netherreaches.common.biome.island;

import com.nick777.netherreaches.common.biome.NetherReachesHeatedConfigurator;
import com.nick777.netherreaches.common.biome.NetherReachesSurfaceBuilders;

public class RuinedBiome extends IslandBiome {
    public RuinedBiome() {
        super(new Properties()
                .surfaceBuilder(NetherReachesSurfaceBuilders.HEATED, NetherReachesSurfaceBuilders.WET_HEATED_DIRT_CONFIG)
                .heightScale(0.4F)
        );

        NetherReachesHeatedConfigurator.addGlobalOres(this);

        NetherReachesHeatedConfigurator.addReachCrystalFloorClump(this);

        NetherReachesHeatedConfigurator.addFlameForestTrees(this);
    }
}

