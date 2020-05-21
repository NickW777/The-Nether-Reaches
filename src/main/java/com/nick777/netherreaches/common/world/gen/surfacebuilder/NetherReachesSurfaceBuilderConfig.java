package com.nick777.netherreaches.common.world.gen.surfacebuilder;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;

public class NetherReachesSurfaceBuilderConfig implements ISurfaceBuilderConfig {
    private final BlockState topMaterial;
    private final BlockState underMaterial;
    private final BlockState underWaterMaterial;
    private final BlockState waterMaterial;

    public NetherReachesSurfaceBuilderConfig(BlockState topMaterial, BlockState underMaterial, BlockState underWaterMaterial, BlockState waterMaterial) {
        this.topMaterial = topMaterial;
        this.underMaterial = underMaterial;
        this.underWaterMaterial = underWaterMaterial;
        this.waterMaterial = waterMaterial;
    }

    public BlockState getTop() {
        return this.topMaterial;
    }

    public BlockState getUnder() {
        return this.underMaterial;
    }

    public BlockState getUnderWaterMaterial() {
        return this.underWaterMaterial;
    }

    public BlockState getWater() { return this.waterMaterial;}

    public static NetherReachesSurfaceBuilderConfig deserialize(Dynamic<?> p_215455_0_) {
        BlockState top = p_215455_0_.get("top_material").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        BlockState under = p_215455_0_.get("under_material").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        BlockState underWater = p_215455_0_.get("underwater_material").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        BlockState water = p_215455_0_.get("water").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        return new NetherReachesSurfaceBuilderConfig(top, under, underWater, water);
    }
}
