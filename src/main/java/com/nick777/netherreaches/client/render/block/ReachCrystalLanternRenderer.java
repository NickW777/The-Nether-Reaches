package com.nick777.netherreaches.client.render.block;

import com.mojang.blaze3d.platform.GlStateManager;
import com.nick777.netherreaches.client.model.ReachCrystalShardModel;
import com.nick777.netherreaches.common.tile.ReachCrystalLanternBlockTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.DyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.nick777.netherreaches.NetherReaches.MODID;

@OnlyIn(Dist.CLIENT)
public class ReachCrystalLanternRenderer extends TileEntityRenderer<ReachCrystalLanternBlockTileEntity> {
    private static final ResourceLocation BLACK = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/black_reachcrystal_shard.png");
    private static final ResourceLocation BLUE = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/blue_reachcrystal_shard.png");
    private static final ResourceLocation BROWN = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/brown_reachcrystal_shard.png");
    private static final ResourceLocation CYAN = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/cyan_reachcrystal_shard.png");
    private static final ResourceLocation GRAY = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/gray_reachcrystal_shard.png");
    private static final ResourceLocation GREEN = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/green_reachcrystal_shard.png");
    private static final ResourceLocation LIGHT_BLUE = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/light_blue_reachcrystal_shard.png");
    private static final ResourceLocation LIGHT_GRAY = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/light_gray_reachcrystal_shard.png");
    private static final ResourceLocation LIME = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/lime_reachcrystal_shard.png");
    private static final ResourceLocation MAGENTA = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/magenta_reachcrystal_shard.png");
    private static final ResourceLocation ORANGE = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/orange_reachcrystal_shard.png");
    private static final ResourceLocation PINK = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/pink_reachcrystal_shard.png");
    private static final ResourceLocation PURPLE = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/purple_reachcrystal_shard.png");
    private static final ResourceLocation RED = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/red_reachcrystal_shard.png");
    private static final ResourceLocation WHITE = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/white_reachcrystal_shard.png");
    private static final ResourceLocation YELLOW = new ResourceLocation(MODID,"textures/entity/reachcrystal_shard/yellow_reachcrystal_shard.png");
    private final ReachCrystalShardModel model = new ReachCrystalShardModel();

    @Override
    public void render(ReachCrystalLanternBlockTileEntity tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage) {
        GlStateManager.pushMatrix();
        GlStateManager.translatef((float) (x + 0.5), (float) (y - 0.82), (float) (z + 0.5));
        this.bindTexture(getTexture(tileEntityIn.getColor()));
        GlStateManager.enableRescaleNormal();
        GlStateManager.scalef(0.0625F, 0.0625F, 0.0625F);


        float rot = tileEntityIn.rotation + partialTicks;
        this.model.renderShard(rot / 40, 1);
        GlStateManager.popMatrix();
    }

    public ReachCrystalLanternRenderer() {
    }

    public ResourceLocation getTexture(DyeColor color) {
        switch (color) {
            case BLACK:
                return BLACK;
            case BLUE:
                return BLUE;
            case BROWN:
                return BROWN;
            case CYAN:
                return CYAN;
            case GRAY:
                return GRAY;
            case GREEN:
                return GREEN;
            case LIGHT_BLUE:
                return LIGHT_BLUE;
            case LIGHT_GRAY:
                return LIGHT_GRAY;
            case LIME:
                return LIME;
            case MAGENTA:
                return MAGENTA;
            case ORANGE:
                return ORANGE;
            case PINK:
                return PINK;
            case PURPLE:
                return PURPLE;
            case RED:
                return RED;
            case YELLOW:
                return YELLOW;
            default:
                return WHITE;
        }
    }
}
