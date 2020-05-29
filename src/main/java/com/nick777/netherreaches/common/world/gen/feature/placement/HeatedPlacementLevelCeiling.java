package com.nick777.netherreaches.common.world.gen.feature.placement;

import com.nick777.netherreaches.common.world.PlacementLevel;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;

import java.util.function.Predicate;

import static com.nick777.netherreaches.common.world.NetherReachesChunkGenerator.MAX_HEATED_HEIGHT;

public class HeatedPlacementLevelCeiling implements PlacementLevel {
    public static final PlacementLevel INSTANCE = new HeatedPlacementLevelCeiling();

    private HeatedPlacementLevelCeiling() {
    }

    @Override
    public BlockPos getSurfacePos(IWorld world, Heightmap.Type heightmap, BlockPos pos) {
        IChunk chunk = world.getChunk(pos);
        Predicate<BlockState> predicate = heightmap.getHeightLimitPredicate();

        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos(pos);

        for (int y = MAX_HEATED_HEIGHT + 15; y > 200; y--) {
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
        return y > 200;
    }
}
