package com.nick777.netherreaches.client.render.block;

import com.mojang.blaze3d.platform.GlStateManager;
import com.nick777.netherreaches.client.model.ReachCrystalShardModel;
import com.nick777.netherreaches.common.tile.ReachCrystalLanternBlockTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.nick777.netherreaches.NetherReaches.MODID;

@OnlyIn(Dist.CLIENT)
public class ReachCrystalLanternRenderer extends TileEntityRenderer<ReachCrystalLanternBlockTileEntity> {
    private static final ResourceLocation WHITE = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/white_reachcrystal_shard.png");
    private final ReachCrystalShardModel model = new ReachCrystalShardModel();

    @Override
    public void render(ReachCrystalLanternBlockTileEntity tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage) {
        GlStateManager.pushMatrix();
        GlStateManager.translatef((float) (x + 0.5), (float) (y - 0.82), (float) (z + 0.5));
        this.bindTexture(getTexture());
        GlStateManager.enableRescaleNormal();
        GlStateManager.scalef(0.0625F, 0.0625F, 0.0625F);


        float rot = tileEntityIn.rotation + partialTicks;
        this.model.renderShard(rot / 60, 1);
        GlStateManager.popMatrix();
    }

    public ReachCrystalLanternRenderer() {
    }

    public ResourceLocation getTexture() {
        return WHITE;
    }
}
