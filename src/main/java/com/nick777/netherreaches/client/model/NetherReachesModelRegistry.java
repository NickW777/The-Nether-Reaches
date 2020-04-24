package com.nick777.netherreaches.client.model;


import com.nick777.netherreaches.client.render.block.NetherReachesSignTileEntityRenderer;
import com.nick777.netherreaches.client.render.block.ReachCrystalLanternRenderer;
import com.nick777.netherreaches.common.tile.NetherReachesSignTileEntity;
import com.nick777.netherreaches.common.tile.ReachCrystalLanternBlockTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;

@OnlyIn(Dist.CLIENT)
public class NetherReachesModelRegistry {
    private static final Minecraft MC = Minecraft.getInstance();

    public static void registerModels(ModelRegistryEvent event) {
        ClientRegistry.bindTileEntitySpecialRenderer(NetherReachesSignTileEntity.class, new NetherReachesSignTileEntityRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(ReachCrystalLanternBlockTileEntity.class, new ReachCrystalLanternRenderer());
    }

}
