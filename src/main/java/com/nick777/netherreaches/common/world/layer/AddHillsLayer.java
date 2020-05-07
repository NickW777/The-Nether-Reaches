package com.nick777.netherreaches.common.world.layer;

import com.nick777.netherreaches.common.biome.BiomeSpawnEntry;
import com.nick777.netherreaches.common.biome.NetherReachesBiomeGroup;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC1Transformer;

public class AddHillsLayer implements IC1Transformer {
    private final NetherReachesBiomeGroup group;
    private final int chance;

    public AddHillsLayer(NetherReachesBiomeGroup group, int chance) {
        this.group = group;
        this.chance = chance;
    }

    @Override
    public int apply(INoiseRandom random, int value) {
        if (random.random(this.chance) == 0) {
            NetherReachesBiomeGroup.Pool pool = this.group.getPoolForBiome(value);
            BiomeSpawnEntry entry = pool.selectWeight(random::random);
            if (entry != null) {
                return entry.getBiomeId();
            }
        }
        return value;
    }
}
