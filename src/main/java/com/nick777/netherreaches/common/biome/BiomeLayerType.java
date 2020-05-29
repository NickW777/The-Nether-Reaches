package com.nick777.netherreaches.common.biome;


import com.nick777.netherreaches.common.biome.damp.DampBiome;
import com.nick777.netherreaches.common.biome.heated.HeatedBiome;
import com.nick777.netherreaches.common.registry.NetherReachesDampBiomes;
import com.nick777.netherreaches.common.registry.NetherReachesHangingBiomes;
import com.nick777.netherreaches.common.registry.NetherReachesHeatedBiomes;
import com.nick777.netherreaches.common.world.gen.layer.AddHillsLayer;
import com.nick777.netherreaches.common.world.gen.layer.HeatedSeedLayer;
import com.nick777.netherreaches.common.world.gen.layer.SeedGroupLayer;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.SmoothLayer;
import net.minecraft.world.gen.layer.VoroniZoomLayer;
import net.minecraft.world.gen.layer.ZoomLayer;

import java.util.function.IntFunction;
import java.util.function.LongFunction;

public class BiomeLayerType<T> {
    public static final BiomeLayerType<Biome> HANGING = BiomeLayerType.create(Biome.class, BiomeLayerType::buildHanging, Registry.BIOME::getByValue, Biomes.DEFAULT);
    public static final BiomeLayerType<HeatedBiome> HEATED = BiomeLayerType.create(HeatedBiome.class, BiomeLayerType::buildHeated, NetherReachesHeatedBiomes::byId, NetherReachesHeatedBiomes.FLAME_FOREST);
    public static final BiomeLayerType<DampBiome> DAMP = BiomeLayerType.create(DampBiome.class, BiomeLayerType::buildDamp, NetherReachesDampBiomes::byId, NetherReachesDampBiomes.WET_FOREST);

    private static final int MAX_CACHE_SIZE = 25;

    private final Class<T> type;
    private final ProcedureFactory procedureFactory;
    private final IntFunction<T> function;
    private final T defaultValue;

    private BiomeLayerType(Class<T> type, ProcedureFactory procedureFactory, IntFunction<T> function, T defaultValue) {
        this.type = type;
        this.procedureFactory = procedureFactory;
        this.function = function;
        this.defaultValue = defaultValue;
    }

    public static <T> BiomeLayerType<T> create(Class<T> type, ProcedureFactory procedureFactory, IntFunction<T> function, T defaultValue) {
        return new BiomeLayerType<>(type, procedureFactory, function, defaultValue);
    }

    public BiomeLayers<T> make(long worldSeed) {
        BiomeProcedure<LazyArea> procedure = this.procedureFactory.create(value -> new LazyAreaLayerContext(MAX_CACHE_SIZE, worldSeed, value));
        return new BiomeLayers<>(
                new BiomeLayer<>(this.type, procedure.noise, this.function, this.defaultValue),
                new BiomeLayer<>(this.type, procedure.block, this.function, this.defaultValue)
        );
    }

    public interface ProcedureFactory {
        <A extends IArea, C extends IExtendedNoiseRandom<A>> BiomeProcedure<A> create(LongFunction<C> contextFactory);
    }

    private static <A extends IArea, C extends IExtendedNoiseRandom<A>> BiomeProcedure<A> buildHanging(LongFunction<C> contextFactory) {
        int forestId = Registry.BIOME.getId(NetherReachesHangingBiomes.SHROOM_FOREST);

        IAreaFactory<A> layer = new SeedGroupLayer(NetherReachesBiomeGroup.HANGING).apply(contextFactory.apply(0));
        layer = ZoomLayer.NORMAL.apply(contextFactory.apply(1000), layer);

        layer = new AddHillsLayer(NetherReachesBiomeGroup.HANGING, 10).apply(contextFactory.apply(90000), layer);

        layer = ZoomLayer.NORMAL.apply(contextFactory.apply(11000), layer);
        layer = SmoothLayer.INSTANCE.apply(contextFactory.apply(12000), layer);

        return BiomeProcedure.of(layer, contextFactory);
    }

    private static <A extends IArea, C extends IExtendedNoiseRandom<A>> BiomeProcedure<A> buildHeated(LongFunction<C> contextFactory) {
        int flameForestId = NetherReachesHeatedBiomes.getId(NetherReachesHeatedBiomes.FLAME_FOREST);

        IAreaFactory<A> layer = new HeatedSeedLayer(NetherReachesBiomeGroup.HEATED).apply(contextFactory.apply(0));
        layer = VoroniZoomLayer.INSTANCE.apply(contextFactory.apply(1000), layer);
        layer = ZoomLayer.NORMAL.apply(contextFactory.apply(7000), layer);
        layer = SmoothLayer.INSTANCE.apply(contextFactory.apply(8000), layer);

        return BiomeProcedure.of(layer, contextFactory);
    }

    private static <A extends IArea, C extends IExtendedNoiseRandom<A>> BiomeProcedure<A> buildDamp(LongFunction<C> contextFactory) {
        int flameForestId = NetherReachesDampBiomes.getId(NetherReachesDampBiomes.WET_FOREST);

        IAreaFactory<A> layer = new HeatedSeedLayer(NetherReachesBiomeGroup.HEATED).apply(contextFactory.apply(0));
        layer = VoroniZoomLayer.INSTANCE.apply(contextFactory.apply(1000), layer);
        layer = ZoomLayer.NORMAL.apply(contextFactory.apply(7000), layer);
        layer = SmoothLayer.INSTANCE.apply(contextFactory.apply(8000), layer);

        return BiomeProcedure.of(layer, contextFactory);
    }
}
