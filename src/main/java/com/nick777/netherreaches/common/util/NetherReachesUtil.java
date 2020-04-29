package com.nick777.netherreaches.common.util;

import com.google.common.base.Preconditions;
import com.nick777.netherreaches.common.registry.NetherReachesDimensions;
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

public final class NetherReachesUtil {
    public static ResourceLocation transformPath(ResourceLocation identifier, Function<String, String> function) {
        Preconditions.checkNotNull(identifier);
        return new ResourceLocation(identifier.getNamespace(), function.apply(identifier.getPath()));
    }

    public static boolean isNetherReachesDimension(@Nullable World world) {
        if (world == null) return false;
        return world.dimension.getType().getModType() == NetherReachesDimensions.NETHER_REACHES;
    }

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

    /** linearly interpolate for y between [x1, y1] to [x2, y2] using x
     *  y = y1 + (y2 - y1) * (x - x1) / (x2 - x1)
     *  For example:  if [x1, y1] is [0, 100], and [x2,y2] is [1, 200], then as x increases from 0 to 1, this function
     *    will increase from 100 to 200
     * @param x  the x value to linearly interpolate on
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return linearly interpolated value.  If x is outside the range, clip it to the nearest end
     */
    public static double interpolate_with_clipping(double x, double x1, double x2, double y1, double y2)
    {
        if (x1 > x2) {
            double temp = x1; x1 = x2; x2 = temp;
            temp = y1; y1 = y2; y2 = temp;
        }

        if (x <= x1) return y1;
        if (x >= x2) return y2;
        double xFraction = (x - x1) / (x2 - x1);
        return y1 + xFraction * (y2 - y1);
    }

    public static Vec3d scalarMultiply(Vec3d source, double multiplier)
    {
        return new Vec3d(source.x * multiplier, source.y * multiplier, source.z * multiplier);
    }


}


