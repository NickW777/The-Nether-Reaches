package com.nick777.netherreaches.common.world.gen.feature.config;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class ShroomTreeConfig implements IFeatureConfig {
    public final BlockState cap;
    public final BlockState stem;
    public final BlockState sapling;

    public ShroomTreeConfig(BlockState cap, BlockState stem, BlockState sapling) {
        this.cap = cap;
        this.stem = stem;
        this.sapling = sapling;
    }

    @Override
    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        return new Dynamic<>(ops, ops.createMap(
                ImmutableMap.of(
                        ops.createString("cap"), BlockState.serialize(ops, this.cap).getValue(),
                        ops.createString("stem"), BlockState.serialize(ops, this.stem).getValue(),
                        ops.createString("sapling"), BlockState.serialize(ops, this.sapling).getValue()
                )
        ));
    }

    public static <T> ShroomTreeConfig deserialize(Dynamic<T> dynamic) {
        BlockState cap = dynamic.get("cap").map(BlockState::deserialize)
                .orElse(Blocks.AIR.getDefaultState());

        BlockState stem = dynamic.get("stem").map(BlockState::deserialize)
                .orElse(Blocks.AIR.getDefaultState());

        BlockState sapling = dynamic.get("sapling").map(BlockState::deserialize)
                .orElse(Blocks.AIR.getDefaultState());

        return new ShroomTreeConfig(cap, stem, sapling);
    }
}
