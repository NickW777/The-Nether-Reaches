package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.biome.BiomeSpawnEntry;
import com.nick777.netherreaches.common.biome.NetherReachesBiomeGroup;
import com.nick777.netherreaches.common.biome.damp.DampBiome;
import com.nick777.netherreaches.common.biome.damp.WetForestBiome;
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
public class NetherReachesDampBiomes {
    public static final DampBiome WET_FOREST = RegUtil.injected();

    private static ForgeRegistry<DampBiome> registry;

    @SubscribeEvent
    public static void onNewRegistry(RegistryEvent.NewRegistry event) {
        registry = (ForgeRegistry<DampBiome>) new RegistryBuilder<DampBiome>()
                .setType(DampBiome.class)
                .setName(new ResourceLocation(MODID, "damp_biomes"))
                .setDefaultKey(new ResourceLocation(MODID, "wet_forest"))
                .create();
    }

    @SubscribeEvent
    public static void onRegisterBiomes(RegistryEvent.Register<DampBiome> event) {
        RegUtil.generic(event.getRegistry())
                .add("wet_forest", new WetForestBiome());
    }

    public static void onInit() {
        NetherReachesBiomeGroup.DAMP.add(
                new BiomeSpawnEntry(WET_FOREST, 100)
        );
    }

    public static ForgeRegistry<DampBiome> getRegistry() {
        if (registry == null) {
            throw new IllegalStateException("Registry not yet initialized");
        }
        return registry;
    }

    public static int getId(DampBiome biome) {
        return registry.getID(biome);
    }

    public static DampBiome byId(int id) {
        return registry.getValue(id);
    }
}