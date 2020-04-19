package com.nick777.netherreaches.common.util;

import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

import javax.annotation.Nullable;
import java.util.function.Function;

//import com.nick777.netherreaches.common.registry.NetherReachesDimensions;

public final class NetherReachesUtil {
    public static ResourceLocation transformPath(ResourceLocation identifier, Function<String, String> function) {
        Preconditions.checkNotNull(identifier);
        return new ResourceLocation(identifier.getNamespace(), function.apply(identifier.getPath()));
    }
/*
    public static boolean isMidnightDimension(@Nullable World world) {
        if (world == null) return false;
        return world.dimension.getType().getModType() == MidnightDimensions.MIDNIGHT;
    }
*/
    public static boolean isNotFakePlayer(@Nullable Entity entity) {
        return !(entity instanceof FakePlayer);
    }

    public static float[] getRGBColorF(int color) {
        float[] rgb = new float[3];
        rgb[0] = ((color >> 16) & 255) / 255f;
        rgb[1] = ((color >> 8) & 255) / 255f;
        rgb[2] = (color & 255) / 255f;
        return rgb;
    }

    public static ItemEntity spawnItemStack(World world, BlockPos pos, Block block) {
        return spawnItemStack(world, pos, block.asItem());
    }

    public static ItemEntity spawnItemStack(World world, BlockPos pos, Item item) {
        return spawnItemStack(world, pos.getX() + 0.5d, pos.getY(), pos.getZ() + 0.5d, item);
    }

    public static ItemEntity spawnItemStack(World world, double x, double y, double z, Item item) {
        return spawnItemStack(world, x, y, z, new ItemStack(item, 1));
    }

    public static ItemEntity spawnItemStack(World world, BlockPos pos, ItemStack stack) {
        return spawnItemStack(world, pos.getX() + 0.5d, pos.getY(), pos.getZ() + 0.5d, stack);
    }

    public static ItemEntity spawnItemStack(World world, double x, double y, double z, ItemStack stack) {
        ItemEntity itemEntity = new ItemEntity(world, x, y, z, stack);
        world.addEntity(itemEntity);
        return itemEntity;
    }

    public static Vec3d lerp(Vec3d a, Vec3d b, double alpha) {
        if (alpha <= 0.0) return a;
        if (alpha >= 1.0) return b;

        return new Vec3d(
                a.x + (b.x - a.x) * alpha,
                a.y + (b.y - a.y) * alpha,
                a.z + (b.z - a.z) * alpha
        );
    }
}
