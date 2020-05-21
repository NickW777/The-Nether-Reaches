package com.nick777.netherreaches.common.world.gen.feature.config;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class PoolConfig implements IFeatureConfig {
    public final BlockState fluid;

    public PoolConfig(BlockState fluid) {
        this.fluid = fluid;
    }

    @Override
    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        return new Dynamic<>(ops, ops.createMap(
                ImmutableMap.of(
                        ops.createString("fluid"), BlockState.serialize(ops, this.fluid).getValue()
                )
        ));
    }

    public static <T> PoolConfig deserialize(Dynamic<T> dynamic) {
        BlockState fluid = dynamic.get("fluid").map(BlockState::deserialize)
                .orElse(Blocks.AIR.getDefaultState());

        return new PoolConfig(fluid);
    }
}
