package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.biome.BiomeSpawnEntry;
import com.nick777.netherreaches.common.biome.NetherReachesBiomeGroup;
import com.nick777.netherreaches.common.biome.island.IslandBiome;
import com.nick777.netherreaches.common.biome.island.RuinedBiome;
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
public class NetherReachesIslandBiomes {
    public static final IslandBiome RUINED = RegUtil.injected();

    private static ForgeRegistry<IslandBiome> registry;

    @SubscribeEvent
    public static void onNewRegistry(RegistryEvent.NewRegistry event) {
        registry = (ForgeRegistry<IslandBiome>) new RegistryBuilder<IslandBiome>()
                .setType(IslandBiome.class)
                .setName(new ResourceLocation(MODID, "island_biomes"))
                .setDefaultKey(new ResourceLocation(MODID, "ruined"))
                .create();
    }

    @SubscribeEvent
    public static void onRegisterBiomes(RegistryEvent.Register<IslandBiome> event) {
        RegUtil.generic(event.getRegistry())
                .add("ruined", new RuinedBiome());
    }

    public static void onInit() {
        NetherReachesBiomeGroup.ISLAND.add(
                new BiomeSpawnEntry(RUINED, 100)
        );
    }

    public static ForgeRegistry<IslandBiome> getRegistry() {
        if (registry == null) {
            throw new IllegalStateException("Registry not yet initialized");
        }
        return registry;
    }

    public static int getId(IslandBiome biome) {
        return registry.getID(biome);
    }

    public static IslandBiome byId(int id) {
        return registry.getValue(id);
    }
}