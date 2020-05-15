package com.nick777.netherreaches.common.world.feature;

import com.mojang.datafixers.Dynamic;
import com.nick777.netherreaches.common.world.feature.config.ReachCrystalFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.util.Constants;

import java.util.Random;
import java.util.function.Function;

public class ReachCrystalFeature extends Feature<ReachCrystalFeatureConfig> {
    private final int radius;
    private final int maxHeight;

    public ReachCrystalFeature(
            Function<Dynamic<?>, ? extends ReachCrystalFeatureConfig> deserialize,
            int radius,
            int maxHeight
    ) {
        super(deserialize);
        this.radius = radius;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos origin, ReachCrystalFeatureConfig config) {
        int size = (this.radius * 2) + 1;

        int[] heights = new int[size * size];
        BlockPos basePos = this.populateHeights(world, rand, origin, heights, size);

        if (basePos == null || !this.canGenerate(world, origin, heights, size)) {
            return false;
        }

        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        for (int localZ = -this.radius; localZ <= this.radius; localZ++) {
            for (int localX = -this.radius; localX <= this.radius; localX++) {
                int height = heights[(localX + this.radius) + (localZ + this.radius) * size];
                if (height > 0) {
                    mutablePos.setPos(basePos.getX() + localX, basePos.getY(), basePos.getZ() + localZ);
                    this.generatePillar(world, rand, mutablePos, height, config);
                }
            }
        }

        return true;
    }

    private BlockPos populateHeights(IWorld world, Random rand, BlockPos origin, int[] heights, int size) {
        BlockPos.MutableBlockPos basePos = new BlockPos.MutableBlockPos(origin);

        for (int localZ = -this.radius; localZ <= this.radius; localZ++) {
            for (int localX = -this.radius; localX <= this.radius; localX++) {
                int index = (localX + this.radius) + (localZ + this.radius) * size;

                double deltaX = localX + rand.nextDouble() * 2.0 - 1.0;
                double deltaZ = localZ + rand.nextDouble() * 2.0 - 1.0;
                double distance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
                double alpha = (this.radius - distance) / this.radius;

                int height = MathHelper.floor(alpha * this.maxHeight);
                if (height > 0) {
                    BlockPos surfacePos = this.findSurfaceAbove(world, origin.add(localX, 0, localZ), 10);
                    if (surfacePos == null) {
                        return null;
                    }

                    if (surfacePos.getY() > basePos.getY()) {
                        basePos.setY(surfacePos.getY());
                    }

                    heights[index] = height;
                }
            }
        }

        return basePos.toImmutable();
    }

    private boolean canGenerate(IWorld world, BlockPos origin, int[] heights, int size) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos(origin);
        int centerHeight = heights[this.radius + this.radius * size] - 1;
        for (int localY = 0; localY < centerHeight; localY++) {
            mutablePos.setY(origin.getY() - localY);
            if (!world.isAirBlock(mutablePos)) {
                return false;
            }
        }
        return true;
    }

    private void generatePillar(IWorld world, Random rand, BlockPos.MutableBlockPos mutablePos, int height, ReachCrystalFeatureConfig config) {
        int originY = mutablePos.getY();
        for (int offsetY = 0; offsetY < height; offsetY++) {
            mutablePos.setY(originY - offsetY);
            this.trySetBlock(world, mutablePos, config.crystal);
        }
        if (rand.nextInt(2) == 0) {
            mutablePos.setY(originY);
            this.trySetBlock(world, mutablePos, config.rock);
        }
    }

    private BlockPos findSurfaceAbove(IWorld world, BlockPos origin, int maxSteps) {
        BlockState currentState = world.getBlockState(origin);
        BlockPos.MutableBlockPos currentPos = new BlockPos.MutableBlockPos(origin);
        for (int i = 0; i < maxSteps; i++) {
            currentPos.move(Direction.UP);
            BlockState nextState = world.getBlockState(currentPos);
            if (currentState.getBlock() == Blocks.AIR && nextState.isSolid()) {
                currentPos.move(Direction.DOWN);
                return currentPos.toImmutable();
            }
            currentState = nextState;
        }
        return null;
    }

    private void trySetBlock(IWorld world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state, Constants.BlockFlags.BLOCK_UPDATE | Constants.BlockFlags.NOTIFY_NEIGHBORS);
    }
}