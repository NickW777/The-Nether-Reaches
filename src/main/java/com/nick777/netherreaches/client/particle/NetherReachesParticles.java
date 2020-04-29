package com.nick777.netherreaches.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum NetherReachesParticles {
    BLIGHT_SHROOM, CINDER_SHROOM, SHADE_SHROOM, SHOCK_SHROOM, TANGLE_SHROOM, TOXIC_SHROOM;

    NetherReachesParticles () {
    }

    @OnlyIn(Dist.CLIENT)
    public Particle create(World world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, int... params) {
        return getFactory().makeParticle(world, x, y, z, velocityX, velocityY, velocityZ, params);
    }

    @OnlyIn(Dist.CLIENT)
    public IParticle getFactory() {
        switch (this) {
            case BLIGHT_SHROOM:
                return new BlightShroomParticle.Factory();
            case CINDER_SHROOM:
                return new CinderShroomParticle.Factory();
            case SHADE_SHROOM:
                return new ShadeShroomParticle.Factory();
            case SHOCK_SHROOM:
                return new ShockShroomParticle.Factory();
            case TANGLE_SHROOM:
                return new TangleShroomParticle.Factory();
            case TOXIC_SHROOM:
                return new ToxicShroomParticle.Factory();

        }
        return new ShockShroomParticle.Factory();
    }

    public static NetherReachesParticles getDefaultParticle() {
        return SHADE_SHROOM;
    }

    public void spawn(World world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, int... parameters) {
        if (world.isRemote) {
            spawn(create(world, x, y, z, velocityX, velocityY, velocityZ, parameters));
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void spawn(Particle particle) {
        Minecraft.getInstance().particles.addEffect(particle);
    }

    public static NetherReachesParticles fromId(int id) {
        return values()[MathHelper.clamp(id, 0, values().length - 1)];
    }
}
