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
        int size = this.size - 1 + rand.nextInt(3);
        int layerCount = getLayerCount(size, rand);
        double delta = 1.5 * size / layerCount;
        BlockPos newOrigin = moveToWall(world,origin);
        if (newOrigin == null) {
            return false;
        }
        for (int layer = layerCount; layer > 0; layer--) {
            generateLayer(layerCount,layer,size,newOrigin,world, delta, rand,config);
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
                    return origin.offset(HORIZONTALS[dir], i - 1).up(2);
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

    private boolean testForBlock(IWorld world, BlockPos pos, Block block1, Block block2) {
        if (world.getBlockState(pos).getBlock() == block1 || world.getBlockState(pos).getBlock() == block2) {
            return true;
        }
        return false;
    }

    private boolean testForBlock(IWorld world, BlockPos pos, Block block1, Block block2, Block block3) {
        if (world.getBlockState(pos).getBlock() == block1 || world.getBlockState(pos).getBlock() == block2 || world.getBlockState(pos).getBlock() == block3) {
            return true;
        }
        return false;
    }

    private void generateLayer(int layerCount, int layer, int size, BlockPos origin, IWorld world, double delta, Random rand, ShelfShroomConfig config) {
        Direction facing = HORIZONTALS[rand.nextInt(4)];
        Direction iterDir = facing.rotateY();
        for (int strand = -size; strand < size; strand++) {
            generateStrand(layer,size,world,origin, facing, iterDir,strand, delta,config);
        }
        if (layer == 1) {
            for (int strand = -size; strand < size; strand++) {
                carveTop(layer, size, world, origin, facing, iterDir, strand, delta);
            }
        }
    }

    private void generateStrand(int layer, int size, IWorld world, BlockPos origin, Direction facing, Direction iterDir, int strand, double delta, ShelfShroomConfig config) {
        int length = getStrandLength(size,strand,layer, delta);
        for (int block = 0; block < length; block++) {
            if (!testForBlock(world, origin.offset(facing, block).offset(iterDir, strand).offset(Direction.DOWN, layer), NetherReachesBlocks.SHADE_STONE)) {
                trySetCoreAndCrust(world, origin.offset(facing, block).offset(iterDir, strand).offset(Direction.DOWN, layer), config.core, config.crust);
            }
            if (!testForBlock(world, origin.offset(facing, -block).offset(iterDir, strand).offset(Direction.DOWN, layer), NetherReachesBlocks.SHADE_STONE)) {
                trySetCoreAndCrust(world, origin.offset(facing, -block).offset(iterDir, strand).offset(Direction.DOWN, layer), config.core, config.crust);
            }
        }
    }

    private void carveTop(int layer, int size, IWorld world, BlockPos origin, Direction facing, Direction iterDir, int strand, double delta) {
        int length = getStrandLength(size,strand,layer, delta);
        for (int block = 0; block < length - 2; block++) {
            if (!testForBlock(world,origin.offset(facing, block).offset(iterDir, strand).offset(Direction.DOWN, layer),NetherReachesBlocks.SHADE_STONE)) {
                world.removeBlock(origin.offset(facing, block).offset(iterDir, strand).offset(Direction.DOWN, layer), false);
            }
            if (!testForBlock(world,origin.offset(facing, -block).offset(iterDir, strand).offset(Direction.DOWN, layer),NetherReachesBlocks.SHADE_STONE)) {
                world.removeBlock(origin.offset(facing, -block).offset(iterDir, strand).offset(Direction.DOWN, layer), false);
            }
        }
    }

    private int getLayerCount(int size, Random random) {
        return size - random.nextInt(3);
    }

    private void trySetCoreAndCrust(IWorld world, BlockPos pos, BlockState core, BlockState crust) {
        world.setBlockState(pos, core, Constants.BlockFlags.BLOCK_UPDATE | Constants.BlockFlags.NOTIFY_NEIGHBORS);

        if (!testForBlock(world,pos.down(),NetherReachesBlocks.SHADE_STONE, core.getBlock())) {
            world.setBlockState(pos.down(),crust,Constants.BlockFlags.BLOCK_UPDATE | Constants.BlockFlags.NOTIFY_NEIGHBORS);
        }
        if (!testForBlock(world,pos.north(),NetherReachesBlocks.SHADE_STONE, core.getBlock())) {
            world.setBlockState(pos.north(),crust,Constants.BlockFlags.BLOCK_UPDATE | Constants.BlockFlags.NOTIFY_NEIGHBORS);
        }
        if (!testForBlock(world,pos.south(),NetherReachesBlocks.SHADE_STONE, core.getBlock())) {
            world.setBlockState(pos.south(),crust,Constants.BlockFlags.BLOCK_UPDATE | Constants.BlockFlags.NOTIFY_NEIGHBORS);
        }
        if (!testForBlock(world,pos.east(),NetherReachesBlocks.SHADE_STONE,core.getBlock())) {
            world.setBlockState(pos.east(),crust,Constants.BlockFlags.BLOCK_UPDATE | Constants.BlockFlags.NOTIFY_NEIGHBORS);
        }
        if (!testForBlock(world,pos.west(),NetherReachesBlocks.SHADE_STONE,core.getBlock())) {
            world.setBlockState(pos.west(),crust,Constants.BlockFlags.BLOCK_UPDATE | Constants.BlockFlags.NOTIFY_NEIGHBORS);
        }
    }
}