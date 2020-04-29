package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.world.NetherReachesDimension;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.BiFunction;

import static com.nick777.netherreaches.NetherReaches.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetherReachesDimensions {
    public static final ModDimension NETHER_REACHES = new ModDimension() {
        @Override
        public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
            return NetherReachesDimension::new;
        }
    };

    private static final ResourceLocation NETHER_REACHES_ID = new ResourceLocation(MODID, "netherreaches");

    @SubscribeEvent
    public static void registerModDimensions(RegistryEvent.Register<ModDimension> event) {
        RegUtil.generic(event.getRegistry()).add("nether_reaches", NETHER_REACHES);
    }

    public static DimensionType netherreaches() {
        return DimensionType.byName(NETHER_REACHES_ID);
    }

    @Mod.EventBusSubscriber(modid = MODID)
    private static class ForgeEvents {
        @SubscribeEvent
        public static void registerDimensions(RegisterDimensionsEvent event) {
            if (DimensionType.byName(NETHER_REACHES_ID) == null) {
                DimensionManager.registerDimension(NETHER_REACHES_ID, NETHER_REACHES, null, false);
            }
        }
    }
}
