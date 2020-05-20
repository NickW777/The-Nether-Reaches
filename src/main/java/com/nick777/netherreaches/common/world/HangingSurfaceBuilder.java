package com.nick777.netherreaches.common.world;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class HangingSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    private final int lowestLayer;
    private final int highestLayer;

    private int minY = 0;

    public HangingSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> deserialize, int lowestLayer, int highestLayer) {
        super(deserialize);
        this.lowestLayer = lowestLayer;
        this.highestLayer = highestLayer;
    }

    public HangingSurfaceBuilder withMinY(int minY) {
        this.minY = minY;
        return this;
    }

    @Override
    public void buildSurface(Random random, IChunk chunk, Biome biome, int x, int z, int minY, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        BlockState top = config.getTop();
        BlockState under = config.getUnder();
        BlockState underWater = config.getUnderWaterMaterial();

        int startHeight = (int) (noise / 3.0 - 2 + random.nextDouble() * 0.25);

        int currentHeight = -1;
        int localX = x & 15;
        int localZ = z & 15;

        boolean wet = false;
        int surfaceLayer = 0;

        for (int localY = Math.min(this.minY, minY); localY < 256; localY++) {
            BlockPos pos = new BlockPos(localX, localY, localZ);
            BlockState state = chunk.getBlockState(pos);
            Material material = state.getMaterial();

            if (material == Material.WATER) {
                wet = true;
            } else if (material == Material.AIR) {
                wet = false;
            }

            if (material != Material.ROCK) {
                currentHeight = -1;
                continue;
            }

            if (currentHeight < startHeight) {
                wet = false;
                if (surfaceLayer++ > this.highestLayer) {
                    break;
                } else {
                    continue;
                }
            }

            currentHeight++;

            if (surfaceLayer >= this.lowestLayer && surfaceLayer <= this.highestLayer) {
                if (currentHeight == 0) {
                    chunk.setBlockState(pos, wet ? underWater : top, false);
                } else {
                    chunk.setBlockState(pos, wet ? underWater : under, false);
                }
            }
        }
    }
}
