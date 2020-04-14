package com.nick777.netherreaches.common.event;


import net.minecraft.block.BlockState;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.event.world.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class TerrainGenEventHandler {

    @SubscribeEvent(priority=EventPriority.NORMAL)
    public static void onShroomGrow(SaplingGrowTreeEvent event) {
        System.out.println("Sapling Grown!");

        BlockPos pos = event.getPos();
        IWorld world = event.getWorld();
        BlockState blockstate = world.getBlockState(pos);

        DirectionProperty FACING = BlockStateProperties.FACING;
        Direction facing = blockstate.get(FACING);

    }
}
