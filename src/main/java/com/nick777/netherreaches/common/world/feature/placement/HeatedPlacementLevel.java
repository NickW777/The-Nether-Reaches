package com.nick777.netherreaches.common.world.feature.placement;

import com.nick777.netherreaches.common.world.NetherReachesChunkGenerator;
import com.nick777.netherreaches.common.world.PlacementLevel;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;

import java.util.function.Predicate;

public class HeatedPlacementLevel implements PlacementLevel {
    public static final PlacementLevel INSTANCE = new HeatedPlacementLevel();

    private HeatedPlacementLevel() {
    }

    @Override
    public BlockPos getSurfacePos(IWorld world, Heightmap.Type heightmap, BlockPos pos) {
        IChunk chunk = world.getChunk(pos);
        Predicate<BlockState> predicate = heightmap.getHeightLimitPredicate();

        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos(pos);

        for (int y = 5; y < NetherReachesChunkGenerator.SURFACE_CAVE_BOUNDARY; y++) {
            mutablePos.setY(y);

            BlockState state = chunk.getBlockState(mutablePos);
            if (!predicate.test(state)) {
                return mutablePos.toImmutable();
            }
        }

        return pos;
    }

    @Override
    public boolean containsY(IWorld world, int y) {
        return y < NetherReachesChunkGenerator.SURFACE_CAVE_BOUNDARY;
    }
}
