package com.nick777.netherreaches.common.biome;

import com.mojang.datafixers.Dynamic;
import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.world.HangingSurfaceBuilder;
import com.nick777.netherreaches.common.world.HeatedSurfaceBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public final class NetherReachesSurfaceBuilders {
    public static final SurfaceBuilder<SurfaceBuilderConfig> HANGING = new HangingSurfaceBuilder(SurfaceBuilderConfig::deserialize, 0, 1);

    public static final SurfaceBuilder<SurfaceBuilderConfig> HEATED = new HeatedSurfaceBuilder(SurfaceBuilderConfig::deserialize, 0, 10).withMinY(180);

    public static final SurfaceBuilderConfig SHADE_STONE_CONFIG = new SurfaceBuilderConfig(
            NetherReachesBlocks.SHADE_STONE.getDefaultState(),
            NetherReachesBlocks.SHADE_STONE.getDefaultState(),
            NetherReachesBlocks.SHADE_STONE.getDefaultState()
    );

    public static final SurfaceBuilderConfig HEATED_DIRT_CONFIG = new SurfaceBuilderConfig(
            NetherReachesBlocks.HEATED_GRASS_BLOCK.getDefaultState(),
            NetherReachesBlocks.HEATED_DIRT.getDefaultState(),
            NetherReachesBlocks.SHADE_STONE.getDefaultState()
    );

    public static final SurfaceBuilder<SurfaceBuilderConfig> PATCHED_SHADE_STONE = new PatchedSurfaceBuilder(SurfaceBuilderConfig::deserialize, SHADE_STONE_CONFIG, 0.05);

    private static class PatchedSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
        private final SurfaceBuilderConfig patchConfig;
        private final double threshold;

        public PatchedSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> deserialize, SurfaceBuilderConfig patchConfig, double threshold) {
            super(deserialize);
            this.patchConfig = patchConfig;
            this.threshold = threshold;
        }

        @Override
        public void buildSurface(Random random, IChunk chunk, Biome biome, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
            noise += (random.nextDouble() - 0.5) * 0.1;
            if (noise < this.threshold) {
                config = this.patchConfig;
            }

            HANGING.buildSurface(random, chunk, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
            HEATED.buildSurface(random,chunk,biome,x,z, startHeight, noise, defaultBlock, defaultFluid,seaLevel,seed,config);
        }
    }
}
