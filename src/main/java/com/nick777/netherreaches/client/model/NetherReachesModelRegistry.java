package com.nick777.netherreaches.client.model;


import com.nick777.netherreaches.client.render.block.ReachCrystalLanternRenderer;
import com.nick777.netherreaches.client.render.entity.EngulfedRenderer;
import com.nick777.netherreaches.common.entity.creature.EngulfedEntity;
import com.nick777.netherreaches.common.tile.ReachCrystalLanternBlockTileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class NetherReachesModelRegistry {

    public static void registerModels(ModelRegistryEvent event) {

        RenderingRegistry.registerEntityRenderingHandler(EngulfedEntity.class, EngulfedRenderer::new);

        ClientRegistry.bindTileEntitySpecialRenderer(ReachCrystalLanternBlockTileEntity.class, new ReachCrystalLanternRenderer());
    }

}
