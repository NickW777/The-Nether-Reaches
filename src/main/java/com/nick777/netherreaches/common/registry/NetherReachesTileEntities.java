package com.nick777.netherreaches.common.registry;


import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import static com.nick777.netherreaches.NetherReaches.MODID;

@ObjectHolder(MODID)
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetherReachesTileEntities {
    public static TileEntityType<?> REACHCRYSTAL_LANTERN_TILE_ENTITY;

    @SubscribeEvent
    public static void registerTileEntity(final RegistryEvent.Register<TileEntityType<?>> event) {
        REACHCRYSTAL_LANTERN_TILE_ENTITY = TileEntityType.Builder.create(SignTileEntity::new,
                NetherReachesBlocks.BLACK_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.BLUE_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.BROWN_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.CYAN_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.GRAY_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.GREEN_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.LIGHT_BLUE_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.LIGHT_GRAY_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.LIME_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.MAGENTA_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.ORANGE_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.PINK_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.PURPLE_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.RED_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.WHITE_REACHCRYSTAL_LANTERN,
                NetherReachesBlocks.YELLOW_REACHCRYSTAL_LANTERN
        )
                .build(null).setRegistryName(MODID, "reachcrystal_lantern");
        event.getRegistry().register(REACHCRYSTAL_LANTERN_TILE_ENTITY);
    }
}