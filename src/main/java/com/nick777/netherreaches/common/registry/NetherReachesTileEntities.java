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

    @SubscribeEvent
    public static void registerTileEntity(final RegistryEvent.Register<TileEntityType<?>> event) {
        event.getRegistry().registerAll(
        TileEntityType.Builder.create(NetherReachesSignTileEntity::new,
                        NetherReachesBlocks.SHADE_SHROOM_SIGN
                )
                .build(null).setRegistryName(MODID, "nether_reaches_sign")
        );
    }
}
