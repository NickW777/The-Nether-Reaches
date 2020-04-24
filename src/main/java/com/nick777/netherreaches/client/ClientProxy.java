package com.nick777.netherreaches.client;

import com.nick777.netherreaches.common.util.IProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class ClientProxy implements IProxy {
    private static final Minecraft MC = Minecraft.getInstance();

    @Override
    public boolean isClientPlayer(Entity entity) {
        return entity == MC.player;
    }

}
