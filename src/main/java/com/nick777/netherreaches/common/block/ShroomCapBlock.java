package com.nick777.netherreaches.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class ShroomCapBlock extends Block {
    public ShroomCapBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return 0;
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.AXE;
    }
}
