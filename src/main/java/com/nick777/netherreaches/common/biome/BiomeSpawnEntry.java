package com.nick777.netherreaches.common.biome;

import com.nick777.netherreaches.common.biome.damp.DampBiome;
import com.nick777.netherreaches.common.biome.heated.HeatedBiome;
import com.nick777.netherreaches.common.biome.island.IslandBiome;
import com.nick777.netherreaches.common.registry.NetherReachesDampBiomes;
import com.nick777.netherreaches.common.registry.NetherReachesHeatedBiomes;
import com.nick777.netherreaches.common.registry.NetherReachesIslandBiomes;
import com.nick777.netherreaches.common.util.SessionLocal;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.util.function.IntPredicate;

// TODO: Initialize along with GenLayers to avoid need for SessionLocal?
public final class BiomeSpawnEntry {
    private final SessionLocal<Integer> biomeId;
    private IntPredicate canReplace;

    private final int value;

    public BiomeSpawnEntry(Biome biome, int value) {
        this.biomeId = SessionLocal.register(() -> Registry.BIOME.getId(biome));
        this.value = value;
    }

    public BiomeSpawnEntry(HeatedBiome biome, int value) {
        this.biomeId = SessionLocal.register(() -> NetherReachesHeatedBiomes.getId(biome));
        this.value = value;
    }

    public BiomeSpawnEntry(DampBiome biome, int value) {
        this.biomeId = SessionLocal.register(() -> NetherReachesDampBiomes.getId(biome));
        this.value = value;
    }

    public BiomeSpawnEntry(IslandBiome biome, int value) {
        this.biomeId = SessionLocal.register(() -> NetherReachesIslandBiomes.getId(biome));
        this.value = value;
    }

    public BiomeSpawnEntry canReplace(IntPredicate predicate) {
        this.canReplace = predicate;
        return this;
    }

    public BiomeSpawnEntry canReplace(Biome... biomes) {
        SessionLocal<IntSet> biomeIds = SessionLocal.register(() -> {
            IntSet ids = new IntOpenHashSet();
            for (Biome biome : biomes) {
                ids.add(Registry.BIOME.getId(biome));
            }
            return ids;
        });

        this.canReplace = id -> biomeIds.get().contains(id);

        return this;
    }

    public BiomeSpawnEntry canReplace(HeatedBiome... biomes) {
        SessionLocal<IntSet> biomeIds = SessionLocal.register(() -> {
            IntSet ids = new IntOpenHashSet();
            for (HeatedBiome biome : biomes) {
                ids.add(NetherReachesHeatedBiomes.getId(biome));
            }
            return ids;
        });

        this.canReplace = id -> biomeIds.get().contains(id);

        return this;
    }

    public int getBiomeId() {
        return this.biomeId.get();
    }

    public boolean canReplace(int biome) {
        if (this.canReplace == null) {
            return true;
        }
        return this.canReplace.test(biome);
    }

    public int getValue() {
        return this.value;
    }
}
