package com.nick777.netherreaches.common.biome;

public final class BiomeLayers<T> {
    public final BiomeLayer<T> noise;
    public final BiomeLayer<T> block;

    BiomeLayers(BiomeLayer<T> noise, BiomeLayer<T> block) {
        this.noise = noise;
        this.block = block;
    }
}
