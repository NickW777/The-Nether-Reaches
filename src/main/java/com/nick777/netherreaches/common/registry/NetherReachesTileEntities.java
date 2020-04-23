package com.nick777.netherreaches.common.registry;


import com.nick777.netherreaches.common.tile.NetherReachesSignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import static com.nick777.netherreaches.NetherReaches.MODID;

@ObjectHolder(MODID)
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetherReachesTileEntities {
    public static final TileEntityType<?> NETHER_REACHES_SIGN = TileEntityType.SIGN;
    public static TileEntityType<?> REACHCRYSTAL_LANTERN_TILE_ENTITY;

    @SubscribeEvent
    public static void registerTileEntity(final RegistryEvent.Register<TileEntityType<?>> event) {
        event.getRegistry().register(
                TileEntityType.Builder.create(NetherReachesSignTileEntity::new,
                        NetherReachesBlocks.SHADE_SHROOM_SIGN
                )
                .build(null).setRegistryName(MODID, "nether_reaches_sign")
        );

        REACHCRYSTAL_LANTERN_TILE_ENTITY = TileEntityType.Builder.create(NetherReachesSignTileEntity::new,
                NetherReachesBlocks.WHITE_REACHCRYSTAL_LANTERN
        )
                .build(null);
                REACHCRYSTAL_LANTERN_TILE_ENTITY.setRegistryName(MODID, "reachcrystal_lantern");
                event.getRegistry().register(REACHCRYSTAL_LANTERN_TILE_ENTITY);
    }
}
