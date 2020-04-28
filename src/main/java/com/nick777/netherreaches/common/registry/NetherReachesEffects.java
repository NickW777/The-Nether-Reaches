package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.effect.ShockEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import static com.nick777.netherreaches.NetherReaches.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(MODID)
public class NetherReachesEffects {
    public static final Effect SHOCKED = Effects.BLINDNESS;

    @SubscribeEvent
    public static void onRegisterEffect(RegistryEvent.Register<Effect> event) {
        RegUtil.generic(event.getRegistry())
                .add("shocked",new ShockEffect());
    }
}
