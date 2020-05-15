package com.nick777.netherreaches.common.biome.heated;

import com.nick777.netherreaches.common.biome.NetherReachesHeatedConfigurator;
import com.nick777.netherreaches.common.biome.NetherReachesSurfaceBuilders;

public class FlameForestBiome extends HeatedBiome {
    public FlameForestBiome() {
        super(new Properties()
                .surfaceBuilder(NetherReachesSurfaceBuilders.HEATED, NetherReachesSurfaceBuilders.BERNEG_CONFIG)
                .heightScale(0.4F)

        );

        NetherReachesHeatedConfigurator.addStructureFeatures(this);

        NetherReachesHeatedConfigurator.addGlobalOres(this);

        NetherReachesHeatedConfigurator.addFlameForestTrees(this);
    }
}

