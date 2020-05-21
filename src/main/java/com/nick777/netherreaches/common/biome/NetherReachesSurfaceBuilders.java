package com.nick777.netherreaches.common.biome;

import com.mojang.datafixers.Dynamic;
import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.world.gen.surfacebuilder.HangingSurfaceBuilder;
import com.nick777.netherreaches.common.world.gen.surfacebuilder.HeatedSurfaceBuilder;
import com.nick777.netherreaches.common.world.gen.surfacebuilder.NetherReachesSurfaceBuilderConfig;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import java.util.Random;
import java.util.function.Function;

public final class NetherReachesSurfaceBuilders {
    public static final SurfaceBuilder<NetherReachesSurfaceBuilderConfig> HANGING = new HangingSurfaceBuilder(NetherReachesSurfaceBuilderConfig::deserialize, 0, 1);

    public static final SurfaceBuilder<NetherReachesSurfaceBuilderConfig> HEATED = new HeatedSurfaceBuilder(NetherReachesSurfaceBuilderConfig::deserialize, 0, 10).withMinY(180);

    public static final NetherReachesSurfaceBuilderConfig SHADE_STONE_CONFIG = new NetherReachesSurfaceBuilderConfig(
            NetherReachesBlocks.SHADE_STONE.getDefaultState(),
            NetherReachesBlocks.SHADE_STONE.getDefaultState(),
            NetherReachesBlocks.SHADE_STONE.getDefaultState(),
            NetherReachesBlocks.MAGMA.getDefaultState()
    );

    public static final NetherReachesSurfaceBuilderConfig WET_HEATED_DIRT_CONFIG = new NetherReachesSurfaceBuilderConfig(
            NetherReachesBlocks.HEATED_GRASS_BLOCK.getDefaultState(),
            NetherReachesBlocks.HEATED_DIRT.getDefaultState(),
            NetherReachesBlocks.SHADE_STONE.getDefaultState(),
            NetherReachesBlocks.MAGMA.getDefaultState()
    );

    public static final NetherReachesSurfaceBuilderConfig DRY_HEATED_DIRT_CONFIG = new NetherReachesSurfaceBuilderConfig(
            NetherReachesBlocks.HEATED_GRASS_BLOCK.getDefaultState(),
            NetherReachesBlocks.HEATED_DIRT.getDefaultState(),
            NetherReachesBlocks.SHADE_STONE.getDefaultState(),
            NetherReachesBlocks.HEATED_GRASS_BLOCK.getDefaultState()
    );

    public static final SurfaceBuilder<NetherReachesSurfaceBuilderConfig> PATCHED_SHADE_STONE = new PatchedSurfaceBuilder(NetherReachesSurfaceBuilderConfig::deserialize, SHADE_STONE_CONFIG, 0.05);

    private static class PatchedSurfaceBuilder extends SurfaceBuilder<NetherReachesSurfaceBuilderConfig> {
        private final NetherReachesSurfaceBuilderConfig patchConfig;
        private final double threshold;

        public PatchedSurfaceBuilder(Function<Dynamic<?>, ? extends NetherReachesSurfaceBuilderConfig> deserialize, NetherReachesSurfaceBuilderConfig patchConfig, double threshold) {
            super(deserialize);
            this.patchConfig = patchConfig;
            this.threshold = threshold;
        }

        @Override
        public void buildSurface(Random random, IChunk chunk, Biome biome, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, NetherReachesSurfaceBuilderConfig config) {
            noise += (random.nextDouble() - 0.5) * 0.1;
            if (noise < this.threshold) {
                config = this.patchConfig;
            }

            HANGING.buildSurface(random, chunk, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
            HEATED.buildSurface(random,chunk,biome,x,z, startHeight, noise, defaultBlock, NetherReachesBlocks.MAGMA.getDefaultState(),seaLevel,seed,config);
        }
    }
}
