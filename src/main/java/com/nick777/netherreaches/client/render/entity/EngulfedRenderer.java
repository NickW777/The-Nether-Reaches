package com.nick777.netherreaches.client.render.entity;

import com.mojang.blaze3d.platform.GlStateManager;
import com.nick777.netherreaches.client.model.EngulfedModel;
import com.nick777.netherreaches.common.entity.creature.EngulfedEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

import static com.nick777.netherreaches.NetherReaches.MODID;

@OnlyIn(Dist.CLIENT)
public class EngulfedRenderer extends MobRenderer<EngulfedEntity, EngulfedModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/entity/engulfed/engulfed.png");

    public EngulfedRenderer(EntityRendererManager manager) {
        super(manager, new EngulfedModel(), 0.0F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EngulfedEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void preRenderCallback(EngulfedEntity entity, float partialTicks) {
        super.preRenderCallback(entity, partialTicks);
        if (entity.isChild()) {
            GlStateManager.scalef(0.5F, 0.5F, 0.5F);
        }
    }
}