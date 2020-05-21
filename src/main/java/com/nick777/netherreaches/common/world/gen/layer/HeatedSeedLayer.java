package com.nick777.netherreaches.common.world.gen.layer;

import com.nick777.netherreaches.common.biome.BiomeSpawnEntry;
import com.nick777.netherreaches.common.biome.NetherReachesBiomeGroup;
import com.nick777.netherreaches.common.registry.NetherReachesHeatedBiomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class HeatedSeedLayer implements IAreaTransformer0 {
    private final NetherReachesBiomeGroup group;
    private final int heatedId;

    public HeatedSeedLayer(NetherReachesBiomeGroup group) {
        this.group = group;
        this.heatedId = NetherReachesHeatedBiomes.getId(NetherReachesHeatedBiomes.FLAME_FOREST);
    }

    @Override
    public int apply(INoiseRandom random, int x, int y) {
        if (random.random(50) == 0) {
            BiomeSpawnEntry entry = this.group.getGlobalPool().selectWeight(random::random);
            if (entry != null) {
                return entry.getBiomeId();
            }
        }
        return this.heatedId;
    }
}