package com.nick777.netherreaches.common.fluid;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesFluids;
import com.nick777.netherreaches.common.registry.NetherReachesItems;
import com.nick777.netherreaches.common.registry.NetherReachesTags;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fluids.FluidAttributes;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

import static com.nick777.netherreaches.NetherReaches.MODID;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class MagmaFluid extends LavaFluid implements NeighborReactiveFluid {
    private static final ResourceLocation STILL_TEXTURE = new ResourceLocation(MODID, "blocks/fluid/magma_still");
    private static final ResourceLocation FLOW_TEXTURE = new ResourceLocation(MODID, "blocks/fluid/magma_flow");

    @Override
    public Fluid getFlowingFluid() {
        return NetherReachesFluids.FLOWING_MAGMA;
    }

    @Override
    public Fluid getStillFluid() {
        return NetherReachesFluids.MAGMA;
    }

    @Override
    public Item getFilledBucket() {
        return NetherReachesItems.MAGMA_BUCKET;
    }

    @Override
    public BlockState getBlockState(IFluidState state) {
        return NetherReachesBlocks.MAGMA.getDefaultState().with(FlowingFluidBlock.LEVEL, getLevelFromState(state));
    }

    @OnlyIn(Dist.CLIENT)
    @SuppressWarnings("deprecation")
    public void animateTick(World world, BlockPos pos, IFluidState state, Random random) {
        BlockPos abovePos = pos.up();
        if (world.getBlockState(abovePos).isAir() && !world.getBlockState(abovePos).isOpaqueCube(world, abovePos)) {
            if (random.nextInt(200) == 0) {
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.2f + random.nextFloat() * 0.2f, 0.9f + random.nextFloat() * 0.15f, false);
            }
        }
    }

    @Override
    public boolean isEquivalentTo(Fluid fluid) {
        return fluid.isIn(NetherReachesTags.Fluids.MAGMA);
    }

    @Override
    public int getTickRate(IWorldReader world) {
        return 20;
    }

    @Override
    protected void flowInto(IWorld world, BlockPos intoPos, BlockState intoBlock, Direction direction, IFluidState fluidState) {
        if (direction == Direction.DOWN) {
            IFluidState intoFluid = world.getFluidState(intoPos);
            if (intoFluid.isTagged(NetherReachesTags.Fluids.REACH_WATER) || intoFluid.isTagged(FluidTags.WATER)) {
                this.mixInto(world, intoPos, NetherReachesBlocks.SHINE_STONE.getDefaultState());
                return;
            }
        }
        if (intoBlock.getBlock() instanceof ILiquidContainer) {
            ((ILiquidContainer) intoBlock.getBlock()).receiveFluid(world, intoPos, intoBlock, fluidState);
        } else {
            if (!intoBlock.isAir()) {
                this.beforeReplacingBlock(world, intoPos, intoBlock);
            }
            world.setBlockState(intoPos, fluidState.getBlockState(), 3);
        }
    }

    @Override
    public boolean reactWithNeighbors(World world, BlockPos pos, BlockState state) {
        boolean nearWater = false;
        for (Direction direction : Direction.values()) {
            if (direction == Direction.DOWN) continue;
            IFluidState fluid = world.getFluidState(pos.offset(direction));
            if (fluid.isTagged(FluidTags.WATER)) {
                nearWater = true;
                break;
            }
        }

        if (nearWater) {
            IFluidState fluid = world.getFluidState(pos);
            if (fluid.isSource()) {
                this.mixInto(world, pos, NetherReachesBlocks.SHADE_STONE.getDefaultState());
                return false;
            }

            if (fluid.getActualHeight(world, pos) >= 0.45) {
                this.mixInto(world, pos, NetherReachesBlocks.SHINE_STONE.getDefaultState());
                return false;
            }
        }

        return true;
    }

    private void mixInto(IWorld world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state, Constants.BlockFlags.NOTIFY_NEIGHBORS | Constants.BlockFlags.BLOCK_UPDATE);
        world.playEvent(1501, pos, 0);
    }

    @Override
    protected FluidAttributes createAttributes() {
        return FluidAttributes.builder(STILL_TEXTURE, FLOW_TEXTURE)
                .density(3000)
                .viscosity(3000)
                .luminosity(15)
                .temperature(400)
                .sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA)
                .build(this);
    }

    public static class Flowing extends MagmaFluid {
        public Flowing() {
        }

        @Override
        protected void fillStateContainer(StateContainer.Builder<Fluid, IFluidState> container) {
            super.fillStateContainer(container);
            container.add(LEVEL_1_8);
        }

        @Override
        public int getLevel(IFluidState state) {
            return state.get(LEVEL_1_8);
        }

        @Override
        public boolean isSource(IFluidState state) {
            return false;
        }
    }

    public static class Source extends MagmaFluid {
        public Source() {
        }

        @Override
        public int getLevel(IFluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(IFluidState state) {
            return true;
        }
    }
}
