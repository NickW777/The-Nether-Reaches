package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.biome.BiomeSpawnEntry;
import com.nick777.netherreaches.common.biome.NetherReachesBiomeGroup;
import com.nick777.netherreaches.common.biome.heated.FlameForestBiome;
import com.nick777.netherreaches.common.biome.heated.HeatedBiome;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.RegistryBuilder;

import static com.nick777.netherreaches.NetherReaches.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(MODID)
public class NetherReachesHeatedBiomes {
    public static final HeatedBiome FLAME_FOREST = RegUtil.injected();

    private static ForgeRegistry<HeatedBiome> registry;

    @SubscribeEvent
    public static void onNewRegistry(RegistryEvent.NewRegistry event) {
        registry = (ForgeRegistry<HeatedBiome>) new RegistryBuilder<HeatedBiome>()
                .setType(HeatedBiome.class)
                .setName(new ResourceLocation(MODID, "heated_biomes"))
                .setDefaultKey(new ResourceLocation(MODID, "flame_forest"))
                .create();
    }

    @SubscribeEvent
    public static void onRegisterBiomes(RegistryEvent.Register<HeatedBiome> event) {
        RegUtil.generic(event.getRegistry())
                .add("flame_forest", new FlameForestBiome());
    }

    public static void onInit() {
        NetherReachesBiomeGroup.HEATED.add(
                new BiomeSpawnEntry(FLAME_FOREST, 100)
        );
    }

    public static ForgeRegistry<HeatedBiome> getRegistry() {
        if (registry == null) {
            throw new IllegalStateException("Registry not yet initialized");
        }
        return registry;
    }

    public static int getId(HeatedBiome biome) {
        return registry.getID(biome);
    }

    public static HeatedBiome byId(int id) {
        return registry.getValue(id);
    }
}