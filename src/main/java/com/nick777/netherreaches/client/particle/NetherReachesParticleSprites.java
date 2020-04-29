package com.nick777.netherreaches.client.particle;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

import java.util.EnumMap;

import static com.nick777.netherreaches.NetherReaches.MODID;

@Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class NetherReachesParticleSprites {
    public enum SpriteTypes {
        BLIGHT_SHROOM, CINDER_SHROOM, SHADE_SHROOM, SHOCK_SHROOM, TANGLE_SHROOM, TOXIC_SHROOM;
    }

    private static final EnumMap<SpriteTypes, TextureAtlasSprite> sprites = new EnumMap<>(SpriteTypes.class);

    public static final ResourceLocation BLIGHT_SHROOM = new ResourceLocation(MODID, "textures/particles/blight_shroom.png");
    public static final ResourceLocation CINDER_SHROOM = new ResourceLocation(MODID, "textures/particles/cinder_shroom.png");
    public static final ResourceLocation SHADE_SHROOM = new ResourceLocation(MODID, "textures/particles/shade_shroom.png");
    public static final ResourceLocation SHOCK_SHROOM = new ResourceLocation(MODID, "textures/particles/shock_shroom.png");
    public static final ResourceLocation TANGLE_SHROOM = new ResourceLocation(MODID, "textures/particles/tangle_shroom.png");
    public static final ResourceLocation TOXIC_SHROOM = new ResourceLocation(MODID, "textures/particles/toxic_shroom.png");

}
