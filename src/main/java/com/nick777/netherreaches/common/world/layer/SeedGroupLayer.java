package com.nick777.netherreaches.common.world.layer;

import com.nick777.netherreaches.common.biome.BiomeSpawnEntry;
import com.nick777.netherreaches.common.biome.NetherReachesBiomeGroup;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class SeedGroupLayer implements IAreaTransformer0 {
    private final NetherReachesBiomeGroup group;

    public SeedGroupLayer(NetherReachesBiomeGroup group) {
        this.group = group;
    }

    @Override
    public int apply(INoiseRandom random, int x, int y) {
        NetherReachesBiomeGroup.Pool pool = this.group.getGlobalPool();

        BiomeSpawnEntry entry = pool.selectWeight(random::random);
        if (entry != null) {
            return entry.getBiomeId();
        } else {
            return 0;
        }
    }
}
