package com.nick777.netherreaches.common.world.gen.surfacebuilder;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import java.util.Random;
import java.util.function.Function;

public class HeatedSurfaceBuilder extends SurfaceBuilder<NetherReachesSurfaceBuilderConfig> {
    private final int startLayer;
    private final int endLayer;

    private int minY = 0;

    public HeatedSurfaceBuilder(Function<Dynamic<?>, ? extends NetherReachesSurfaceBuilderConfig> deserialize, int startLayer, int endLayer) {
        super(deserialize);
        this.startLayer = startLayer;
        this.endLayer = endLayer;
    }

    public HeatedSurfaceBuilder withMinY(int minY) {
        this.minY = minY;
        return this;
    }

    @Override
    public void buildSurface( Random random, IChunk chunk, Biome biome, int x, int z, int minY, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, NetherReachesSurfaceBuilderConfig config) {
        BlockState top = config.getTop();
        BlockState under = config.getUnder();
        BlockState underWater = config.getUnderWaterMaterial();
        BlockState water = config.getWater();

        boolean hasLakes = true;

        if (top == water) {
            hasLakes = false;
        }

        int depth = (int) (noise + 3.0 + random.nextDouble() * 0.25);

        int currentDepth = -1;
        int localX = x & 15;
        int localZ = z & 15;

        boolean wet = false;
        int surfaceLayer = 0;

        for (int localY = 225; localY > this.minY; localY--) {

            BlockPos pos = new BlockPos(localX, localY, localZ);
            BlockState state = chunk.getBlockState(pos);
            Material material = state.getMaterial();

            if (material == Material.WATER) {
                wet = true;
            } else if (material == Material.AIR) {
                wet = false;
            }

            if (hasLakes) {
                if (localY < 196 + seaLevel && material == Material.AIR) {
                    chunk.setBlockState(pos, water, false);
                }
            }

            if (material != Material.ROCK) {
                currentDepth = -1;
                continue;
            }

            if (currentDepth >= depth) {
                wet = false;
                if (surfaceLayer++ > this.endLayer) {
                    break;
                } else {
                    continue;
                }
            }

            currentDepth++;

            if (surfaceLayer >= this.startLayer && surfaceLayer <= this.endLayer) {
                if (currentDepth == 0) {
                    chunk.setBlockState(pos, wet ? underWater : top, false);
                } else {
                    chunk.setBlockState(pos, wet ? underWater : under, false);
                }
            }
        }
    }
}
