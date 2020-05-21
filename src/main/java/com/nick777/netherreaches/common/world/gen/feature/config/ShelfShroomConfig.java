package com.nick777.netherreaches.common.world.gen.feature.config;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class ShelfShroomConfig implements IFeatureConfig {
    public final BlockState core;
    public final BlockState crust;

    public ShelfShroomConfig(BlockState core, BlockState crust) {
        this.core = core;
        this.crust = crust;
    }

    @Override
    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        return new Dynamic<>(ops, ops.createMap(
                ImmutableMap.of(
                        ops.createString("core"), BlockState.serialize(ops, this.core).getValue(),
                        ops.createString("crust"), BlockState.serialize(ops, this.crust).getValue()
                )
        ));
    }

    public static <T> ShelfShroomConfig deserialize(Dynamic<T> dynamic) {
        BlockState core = dynamic.get("core").map(BlockState::deserialize)
                .orElse(Blocks.AIR.getDefaultState());

        BlockState crust = dynamic.get("crust").map(BlockState::deserialize)
                .orElse(Blocks.AIR.getDefaultState());

        return new ShelfShroomConfig(core, crust);
    }
}
