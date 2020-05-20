package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.fluid.MagmaFluid;
import com.nick777.netherreaches.common.fluid.ReachWaterFluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.nick777.netherreaches.NetherReaches.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetherReachesFluids {
    public static final FlowingFluid REACH_WATER = new ReachWaterFluid.Source();
    public static final FlowingFluid MAGMA = new MagmaFluid.Source();
    public static final FlowingFluid FLOWING_REACH_WATER = new ReachWaterFluid.Flowing();
    public static final FlowingFluid FLOWING_MAGMA = new MagmaFluid.Flowing();

    @SubscribeEvent
    public static void registerFluids(RegistryEvent.Register<Fluid> event) {
        RegUtil.generic(event.getRegistry())
                .add("reach_water", REACH_WATER)
                .add("flowing_reach_water", FLOWING_REACH_WATER)
                .add("magma", MAGMA)
                .add("flowing_magma", FLOWING_MAGMA);
    }
}
