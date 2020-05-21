package com.nick777.netherreaches.common.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import com.nick777.netherreaches.common.world.gen.feature.config.PoolConfig;
import com.nick777.netherreaches.common.world.noise.FeatureNoise;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.util.Constants;

import java.util.Random;
import java.util.function.Function;

public class PoolFeature extends Feature<PoolConfig> {

    private final int size;

    public PoolFeature(Function<Dynamic<?>, ? extends PoolConfig> deserialize, int size) {
        super(deserialize);
        this.size = size;
    }

    @Override
    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, PoolConfig config) {
        for (int row = 0; row < 12; row++) {
            float length = FeatureNoise.PerlinNoise1D(row, 1, 8);
            for (int block = 0; block < length; block++) {
                world.setBlockState(pos.offset(Direction.NORTH, row).offset(Direction.EAST, block), config.fluid, Constants.BlockFlags.BLOCK_UPDATE | Constants.BlockFlags.NOTIFY_NEIGHBORS);
            }
        }
        return true;
    }
}
