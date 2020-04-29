package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.biome.BiomeSpawnEntry;
import com.nick777.netherreaches.common.biome.NetherReachesBiomeGroup;
import com.nick777.netherreaches.common.biome.hanging.ShroomForestBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

import java.util.Map;
import java.util.stream.Stream;

import static com.nick777.netherreaches.NetherReaches.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(MODID)
public class NetherReachesHangingBiomes {
    public static final Biome SHROOM_FOREST = Biomes.DEFAULT;

    @SubscribeEvent
    public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
        // TODO: Thank you Forge, very cool
        NetherReachesPlacements.registerPlacements(ForgeRegistries.DECORATORS);
        NetherReachesFeatures.registerFeatures(ForgeRegistries.FEATURES);
//        NetherReachesStructures.registerStructures(ForgeRegistries.FEATURES);
//        NetherReachesCarvers.registerCarvers(ForgeRegistries.WORLD_CARVERS);

        RegUtil.generic(event.getRegistry())
                .add("shroom_forest", new ShroomForestBiome());
    }


    public static void onInit() {
        BiomeDictionary.addTypes(SHROOM_FOREST, BiomeDictionary.Type.FOREST);

        NetherReachesBiomeGroup.HANGING.add(
                new BiomeSpawnEntry(SHROOM_FOREST, 100)
        );
    }

    public static Stream<Biome> allBiomes() {
        return ForgeRegistries.BIOMES.getEntries().stream()
                .filter(entry -> entry.getKey().getNamespace().equals(MODID))
                .map(Map.Entry::getValue);
    }
}
