package com.nick777.netherreaches.common.world.feature.placement;

import com.nick777.netherreaches.common.world.NetherReachesChunkGenerator;
import com.nick777.netherreaches.common.world.PlacementLevel;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.Heightmap;

public class HangingPlacementLevel implements PlacementLevel {
    public static final PlacementLevel INSTANCE = new HangingPlacementLevel();

    private HangingPlacementLevel() {
    }

    @Override
    public BlockPos getSurfacePos(IWorld world, Heightmap.Type type, BlockPos pos) {
        return world.getHeight(type, pos);
    }

    @Override
    public boolean containsY(IWorld world, int y) {
        return y > NetherReachesChunkGenerator.SURFACE_CAVE_BOUNDARY;
    }
}
