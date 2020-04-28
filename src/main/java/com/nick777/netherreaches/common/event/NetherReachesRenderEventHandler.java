package com.nick777.netherreaches.common.event;


import com.nick777.netherreaches.common.registry.NetherReachesEffects;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class NetherReachesRenderEventHandler {
    public static final NetherReachesRenderEventHandler instance = new NetherReachesRenderEventHandler();

    private NetherReachesRenderEventHandler() {}

    @SubscribeEvent
    public static void onFOVUpdateEvent(FOVUpdateEvent event) {
        if (event.getEntity().getActivePotionEffect(NetherReachesEffects.SHOCKED) != null) {
            float f = event.getNewfov();
            event.setNewfov(f * 2.15F);
        }

    }
}
