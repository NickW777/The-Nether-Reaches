package com.nick777.netherreaches.common.world.feature;

import com.mojang.datafixers.Dynamic;
import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.world.feature.config.ShelfShroomConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.util.Constants;

import java.util.Random;
import java.util.function.Function;

public class ShelfShroomFeature extends Feature<ShelfShroomConfig> {
    private static final Direction[] HORIZONTALS = new Direction[] {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    private final int size;

    public ShelfShroomFeature(
            Function<Dynamic<?>, ? extends ShelfShroomConfig> deserialize, int size) {
        super(deserialize);
        this.size = size;
    }

    @Override
    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos origin, ShelfShroomConfig config) {
        int layerCount = getLayerCount(this.size, rand);
        double delta = 1.5 * size / layerCount;
        BlockPos newOrigin = moveToWall(world,origin);
        if (newOrigin == null) {
            return false;
        }
        for (int layer = 0; layer < layerCount; layer++) {
            generateLayer(layer,size,newOrigin,world, delta, rand,config);
        }
        return true;
    }

    private int getStrandLength(int size, int strand, int layer, double delta) {
        double length = (size * 1.5 * Math.cos((Math.PI / (size * 2)) * strand)) - layer * delta;
        return (int) Math.floor(length);
    }

    private BlockPos moveToWall(IWorld world, BlockPos origin) {
        for (int i = 1; i < 11; i++) {
            for (int dir = 0; dir < HORIZONTALS.length; dir++) {
                if (testForBlock(world,origin.offset(HORIZONTALS[dir], i),NetherReachesBlocks.SHADE_STONE)) {
                    return origin.offset(HORIZONTALS[dir], i - 1);
                }
            }
        }
        return null;
    }

    private boolean testForBlock(IWorld world, BlockPos pos, Block block) {
        if (world.getBlockState(pos).getBlock() == block) {
            return true;
        }
        return false;
    }

    private void generateLayer(int layer, int size, BlockPos origin, IWorld world, double delta, Random rand, ShelfShroomConfig config) {
        Direction facing = HORIZONTALS[rand.nextInt(4)];
        Direction iterDir = facing.rotateY();
        for (int strand = -size; strand < size; strand++) {

            generateStrand(layer,size,world,origin, facing, iterDir,strand, delta,config);
        }
    }

    private void generateStrand(int layer, int size, IWorld world, BlockPos origin, Direction facing, Direction iterDir, int strand, double delta, ShelfShroomConfig config) {
        int length = getStrandLength(size,strand,layer, delta);
        for (int block = 0; block < length; block++) {
            if (!testForBlock(world, origin.offset(facing,block).offset(iterDir, strand).offset(Direction.DOWN, layer), NetherReachesBlocks.SHADE_STONE)) {
                trySetBlock(world, origin.offset(facing, block).offset(iterDir, strand).offset(Direction.DOWN, layer), config.core);
            }
            if (!testForBlock(world, origin.offset(facing,-block).offset(iterDir, strand).offset(Direction.DOWN, layer), NetherReachesBlocks.SHADE_STONE)) {
                trySetBlock(world, origin.offset(facing, -block).offset(iterDir, strand).offset(Direction.DOWN, layer), config.core);
            }
        }
    }

    private int getLayerCount(int size, Random random) {
        return size - random.nextInt(2) - 2;
    }

    private void trySetBlock(IWorld world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state, Constants.BlockFlags.BLOCK_UPDATE | Constants.BlockFlags.NOTIFY_NEIGHBORS);
    }
}