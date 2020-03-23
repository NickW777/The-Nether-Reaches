package com.nick777.netherreaches.common;

import com.nick777.netherreaches.common.util.IProxy;
import net.minecraft.entity.Entity;

public class ServerProxy implements IProxy {
    @Override
    public boolean isClientPlayer(Entity entity) {
        return false;
    }
}
