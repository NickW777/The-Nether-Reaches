package com.nick777.netherreaches.common.world.feature.tree;

import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;
import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.IPlantable;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class ShadeShroomTreeFeature extends NetherReachTreeFeature {
    private static final Direction[] HORIZONTALS = new Direction[] { Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST };

    private static final BlockState LOG = NetherReachesBlocks.SHADESHROOMSTEM.getDefaultState();
    private static final BlockState LEAVES = NetherReachesBlocks.SHADESHROOMCAP.getDefaultState();

    private static final int BRANCH_SPACING = 3;

    public ShadeShroomTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> deserialize) {
        super(deserialize);
        this.setSapling((IPlantable) NetherReachesBlocks.SHADESHROOMSAPLING);
    }

    @Override
    protected IPlantable getSapling() {
        return super.getSapling();
    }



    @Override
    protected boolean place(IWorld world, Random random, BlockPos origin) {
        int height = random.nextInt(5) + 10;
        BlockState blockstate = getSapling().getPlant(world, origin).getBlockState();
        DirectionProperty FACING = BlockStateProperties.FACING;
        Direction facing = blockstate.get(FACING);

        System.out.println(facing);

        if (!this.canFit(world, origin, 1, height, facing)) {
            return false;
        }

        if (isSoil(world, origin.down(), this.getSapling())) {
            this.setDirtAt(world, origin.down(), origin);

            BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos(origin);
            for (int localY = 0; localY < height; localY++) {
                mutablePos.setY(origin.getY() + localY);
                this.setBlockState(world, mutablePos, LOG);
            }

            this.generateRoots(world, random, origin, facing);

            Set<Branch> branches = this.collectBranches(world, random, origin, height, facing);
            for (Branch branch : branches) {
                this.setBlockState(world, branch.pos, LOG.with(LogBlock.AXIS, branch.getAxis()));
            }

            Set<BlockPos> leafPositions = this.produceBlob(origin.up(height + 1), 4, 1);
            leafPositions = this.droopLeaves(leafPositions, random, 4, facing);

            for (Branch branch : branches) {
                leafPositions.addAll(this.collectBranchLeaves(branch, random, facing));
            }

            for (BlockPos leafPos : leafPositions) {
                if (canGrowInto(world, leafPos)) {
                    this.setBlockState(world, leafPos, LEAVES);
                }
            }

            return true;
        }

        return false;
    }

    private boolean canFit(IWorld world, BlockPos origin, int width, int height, Direction direction) {
        switch (direction) {
            case UP:
                BlockPos min = origin.add(-width, 0, -width);
                BlockPos max = origin.add(width, height, width);

                for (BlockPos pos : BlockPos.getAllInBoxMutable(min, max)) {
                    if (!canGrowInto(world, pos)) {
                        return false;
                    }
                }
            break;
        }
        return true;
    }

    private void generateRoots(IWorldGenerationReader world, Random random, BlockPos origin, Direction direction) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
                List<Direction> availableSides = Lists.newArrayList(HORIZONTALS);

                int count = random.nextInt(3) + 1;
                switch (direction) {
                    case UP:
                        for (int i = 0; i < count; i++) {
                            Direction side = availableSides.remove(random.nextInt(availableSides.size()));
                            BlockPos rootOrigin = origin.offset(side);

                            int height = random.nextInt(3) + 1;
                            for (int localY = 0; localY < height; localY++) {
                                mutablePos.setPos(rootOrigin.getX(), rootOrigin.getY() + localY, rootOrigin.getZ());
                                this.setBlockState(world, mutablePos, LOG);
                            }
                        }
                    break;
                }
    }

    private Set<BlockPos> droopLeaves(Set<BlockPos> leafPositions, Random random, int amount, Direction direction) {
        Set<BlockPos> droopedLeaves = new HashSet<>(leafPositions);
        switch (direction) {
            case UP:
                for (BlockPos pos : leafPositions) {
                    int droopAmount = random.nextInt(amount);
                    for (int i = 0; i < droopAmount; i++) {
                        droopedLeaves.add(pos.down(i));
                    }
                }
            break;
        }
        return droopedLeaves;
    }

    private Set<Branch> collectBranches(IWorldGenerationReader world, Random random, BlockPos origin, int height, Direction direction) {
        int minBranchHeight = 4;
        int maxBranchHeight = height - 4;
        int heightRange = maxBranchHeight - minBranchHeight;

        Set<Branch> branches = new HashSet<>();

        int branchCount = heightRange / BRANCH_SPACING;
        double normalizedSpacing = (double) heightRange / branchCount;

        Direction lastDirection = null;
        switch (direction) {
            case UP:
                for (int branch = 0; branch < branchCount; branch++) {
                    int y = MathHelper.ceil(minBranchHeight + 1 + branch * normalizedSpacing);

                    Direction dir = null;
                    while (dir == null || dir == lastDirection) {
                        dir = HORIZONTALS[random.nextInt(HORIZONTALS.length)];
                    }
                    lastDirection = dir;
                    for (int i = 0; i < 5; i++) {
                        BlockPos branchPos = origin.up(y).offset(dir, i);
                        if (!isAirOrLeaves(world, branchPos)) {
                            continue;
                        }
                        float outerAngle = dir.getHorizontalAngle();
                        float angle = (random.nextFloat() * 90.0F) + outerAngle - 45.0F;

                        branches.add(new Branch(branchPos, dir, angle));
                    }
                }
            break;
        }
        return branches;
    }

    private Set<BlockPos> collectBranchLeaves(Branch branch, Random random, Direction direction) {
        Set<BlockPos> branchLeaves = new HashSet<>();

        float theta = (float) Math.toRadians(branch.angle);
        float deltaX = -MathHelper.sin(theta);
        float deltaZ = MathHelper.cos(theta);
        switch (direction) {
            case UP:
                for (int step = 0; step < 4; step++) {
                    int droop = -step / 2 - 1;
                    BlockPos origin = branch.pos.add(deltaX, droop + 2, deltaZ);

                    Set<BlockPos> stepLeaves = this.produceBlob(origin, 3, 1);
                    branchLeaves.addAll(stepLeaves);

                }
            break;
        }
        return branchLeaves;
    }

    private static class Branch {
        final BlockPos pos;
        final Direction direction;
        final float angle;

        private Branch(BlockPos pos, Direction direction, float angle) {
            this.pos = pos;
            this.direction = direction;
            this.angle = angle;
        }

        public Direction.Axis getAxis() {
            return this.direction.getAxis();
        }

        @Override
        public int hashCode() {
            return this.pos.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Branch && ((Branch) obj).pos.equals(this.pos);
        }
    }
}
