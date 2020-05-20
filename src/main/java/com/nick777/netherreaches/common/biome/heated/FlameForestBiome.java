package com.nick777.netherreaches.common.biome.heated;

import com.nick777.netherreaches.common.biome.NetherReachesHeatedConfigurator;
import com.nick777.netherreaches.common.biome.NetherReachesSurfaceBuilders;

public class FlameForestBiome extends HeatedBiome {
    public FlameForestBiome() {
        super(new Properties()
                .surfaceBuilder(NetherReachesSurfaceBuilders.HEATED, NetherReachesSurfaceBuilders.HEATED_DIRT_CONFIG)
                .heightScale(0.4F)

        );
        NetherReachesHeatedConfigurator.addGlobalOres(this);

        NetherReachesHeatedConfigurator.addReachCrystalFloorClump(this);

        NetherReachesHeatedConfigurator.addFlameForestTrees(this);
    }
}

