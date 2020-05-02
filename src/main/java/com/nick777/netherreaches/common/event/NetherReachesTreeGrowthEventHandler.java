package com.nick777.netherreaches.common.event;


import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.world.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class NetherReachesTreeGrowthEventHandler {
    public static final NetherReachesTreeGrowthEventHandler instance = new NetherReachesTreeGrowthEventHandler();

    private NetherReachesTreeGrowthEventHandler() {}

    @SubscribeEvent
    public static void onSaplingGrowTreeEvent(SaplingGrowTreeEvent event) {
        BlockPos origin = event.getPos();
    }
}
