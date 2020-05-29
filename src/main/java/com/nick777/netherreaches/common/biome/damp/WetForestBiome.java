package com.nick777.netherreaches.common.biome.damp;

import com.nick777.netherreaches.common.biome.NetherReachesHeatedConfigurator;
import com.nick777.netherreaches.common.biome.NetherReachesSurfaceBuilders;

public class WetForestBiome extends DampBiome {
    public WetForestBiome() {
        super(new Properties()
                .surfaceBuilder(NetherReachesSurfaceBuilders.HEATED, NetherReachesSurfaceBuilders.DRY_HEATED_DIRT_CONFIG)
                .heightScale(0.4F)
                .lakeSize(1)
        );

        NetherReachesHeatedConfigurator.addGlobalOres(this);

        NetherReachesHeatedConfigurator.addReachCrystalFloorClump(this);

        NetherReachesHeatedConfigurator.addFlameForestTrees(this);
    }
}

