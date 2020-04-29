package com.nick777.netherreaches.client.particle;

import net.minecraft.entity.Entity;

import java.util.Random;

public interface ParticleSystem<T extends Entity> {
    void updateParticles(Random random);

    T getEntity();
}
