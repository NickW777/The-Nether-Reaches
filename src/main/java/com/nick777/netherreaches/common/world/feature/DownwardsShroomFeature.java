package com.nick777.netherreaches.common.world.feature;

import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;
import com.nick777.netherreaches.common.world.feature.config.ShroomTreeConfig;
import com.nick777.netherreaches.common.world.feature.tree.NetherReachTreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.IWorldGenerationReader;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class DownwardsShroomFeature extends NetherReachTreeFeature {

    private static final Direction[] HORIZONTALS = new Direction[] {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

    private final BlockState CAP;
    private final BlockState STEM;

    private static final int BRANCH_SPACING = 3;

    public DownwardsShroomFeature(Function<Dynamic<?>, ? extends ShroomTreeConfig> deserialize, ShroomTreeConfig config) {
        super(deserialize);
        this.CAP = config.cap;
        this.STEM = config.stem;
    }

    @Override
    protected boolean place(IWorld world, Random random, BlockPos origin) {
        int height = random.nextInt(7) + 8;
        Set<BlockPos> leafPositions = new HashSet<>();
        Direction facing = Direction.DOWN;

        if (isSoil(world, origin.offset(facing.getOpposite()), this.getSapling())) {
            this.setDirtAt(world, origin.offset(facing.getOpposite()), origin);

            //Get the trunk
            DownwardsShroomFeature.Trunk trunk = this.getTrunk(height, origin, facing, random, world);
            //Get the branches
            DownwardsShroomFeature.Branch branches = this.collectBranches(world, random, origin, height, facing);
            //Get leaf positions for the trunk
            for (DownwardsShroomFeature.EndLog endlog : trunk.endlogs)
            { leafPositions.addAll(this.collectCapPositions(endlog, random)); }
            //Get leaf positions for branches
            for (DownwardsShroomFeature.EndLog endlog : branches.endlogs)
            { leafPositions.addAll(this.collectCapPositions(endlog, random)); }

            //Place the logs in the trunk
            for (DownwardsShroomFeature.Log log: trunk.logs) {
                if (!this.canFit(world,log.pos)) {
                    return false;
                }
                this.setBlockState(world, log.pos, this.STEM.with(LogBlock.AXIS, log.direction.getAxis()));
            }
            //Place the roots around the trunk
            this.generateRoots(world, random, origin, facing);
            //Place the logs in the branches
            for (DownwardsShroomFeature.Log log: branches.logs)
            { this.setBlockState(world, log.pos, this.STEM.with(LogBlock.AXIS, log.direction.getAxis())); }
            //Place the cap blocks
            for (BlockPos leafPos : leafPositions) {
                if (canGrowInto(world, leafPos))
                { this.setBlockState(world, leafPos, this.CAP); }
            }
            return true;
        }
        return false;
    }


    private boolean canFit(IWorld world, BlockPos pos) {
        return canGrowInto(world, pos);
    }

    //Generate the roots for the shroom
    private void generateRoots(IWorldGenerationReader world, Random random, BlockPos origin, Direction direction) {
        //Declare variables
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        List<Direction> availableSides;

        //Set the number of roots on the tree
        int rootCount = random.nextInt(3) + 1;
        //Make a list of the available sides
        availableSides = Lists.newArrayList(HORIZONTALS);

        //Place the roots until the number of roots is reached
        for (int root = 0; root < rootCount; root++) {
            //Choose a side to place a root and remove it from the list
            Direction side = availableSides.remove(random.nextInt(availableSides.size()));
            //Set the position of the lowermost part of the root
            BlockPos rootOrigin = origin.offset(side);
            //Set the height of the root
            int rootHeight = random.nextInt(3) + 1;
            //Place each root part until the root height is reached
            for (int height = 0; height < rootHeight; height++) {
                //Set the position of the root part
                mutablePos.setPos(rootOrigin.getX(), rootOrigin.getY() - height, rootOrigin.getZ());

                //Place the part of the root
                this.setBlockState(world, mutablePos, this.STEM.with(LogBlock.AXIS, direction.getAxis()));
            }
        }
    }

    private DownwardsShroomFeature.Trunk getTrunk(int trunkHeight, BlockPos origin, Direction direction, Random random, IWorldGenerationReader world) {

        Set<DownwardsShroomFeature.Log> logs = new HashSet<>();
        Set<DownwardsShroomFeature.EndLog> endlogs = new HashSet<>();

        BlockPos blockpos;
        Direction orient;
        for (int height = 0; height < trunkHeight; height++) {
            blockpos = origin.offset(direction, height);
            orient = Direction.UP;
            if (height == trunkHeight - 1 && direction == Direction.UP) {
                endlogs.add(new DownwardsShroomFeature.EndLog(blockpos));
            }
            logs.add(new DownwardsShroomFeature.Log(blockpos, orient));
        }
        int endTrunkCurveReach = random.nextInt(1) + 3;
        double endTrunkDip = getDip(endTrunkCurveReach, random) - 0.4;
        Direction rot = HORIZONTALS[random.nextInt(HORIZONTALS.length)];
        BlockPos endTrunkOrigin = origin.down(trunkHeight - 1);
        BlockPos trunkpos;
        for (int log = 0; log < endTrunkCurveReach + 2; log++) {
            int newY = getYFromLocationWithDip(log, endTrunkDip, endTrunkCurveReach);
            int oldY = getYFromLocationWithDip(log - 1, endTrunkDip,endTrunkCurveReach);
            if (newY > (endTrunkOrigin.getY() + 6)) {
                break;
            }
            if ((newY - oldY) >= 2) {
                for (int i = oldY; i <= newY; i++) {
                    trunkpos = endTrunkOrigin.up(i).offset(rot, log);
                    //Set the axis of the log depending on steepness of the branch
                    if (Math.abs(newY - oldY) > 1) {
                        orient = Direction.UP;
                    } else {
                        orient = rot;
                    }
                    if (!isAirOrLeaves(world, trunkpos)) {
                        continue;
                    }
                    //Add the log to the branch
                    if (log == endTrunkCurveReach + 1 && i == newY) {
                        endlogs.add(new DownwardsShroomFeature.EndLog(trunkpos));
                    }
                    logs.add(new DownwardsShroomFeature.Log(trunkpos, orient));
                }
            } else if ((newY - oldY) <= -2) {
                for (int i = oldY; i >= newY; i--) {
                    trunkpos = endTrunkOrigin.up(i).offset(rot, log);
                    //Set the axis of the log depending on steepness of the branch
                    if ( i >= 0) {
                        continue;
                    }
                    if (Math.abs(newY - oldY) > 1) {
                        orient = Direction.DOWN;
                    } else {
                        orient = rot;
                    }
                    if (!isAirOrLeaves(world, trunkpos)) {
                        continue;
                    }
                    if (log == endTrunkCurveReach + 1 && i == newY) {
                        endlogs.add(new DownwardsShroomFeature.EndLog(trunkpos));
                    }
                    //Add the log to the branch
                    logs.add(new DownwardsShroomFeature.Log(trunkpos, orient));
                }
            } else {
                trunkpos = endTrunkOrigin.up(newY).offset(rot, log);
                orient = rot;
                if (!isAirOrLeaves(world, trunkpos)) {
                    continue;
                }
                if (log == endTrunkCurveReach + 1) {
                    endlogs.add(new DownwardsShroomFeature.EndLog(trunkpos));
                }
                //Add the log to the branch
                logs.add(new DownwardsShroomFeature.Log(trunkpos, orient));
            }
        }
        return new Trunk(logs, endlogs);
    }

    private Set<BlockPos> droopLeaves(Set<BlockPos> leafPositions, Random random, int amount) {
        Set<BlockPos> droopedLeaves = new HashSet<>(leafPositions);
        for (BlockPos pos : leafPositions) {
            int droopAmount = random.nextInt(amount);
            for (int i = 0; i < droopAmount; i++) {
                droopedLeaves.add(pos.down(i));
            }
        }
        return droopedLeaves;
    }

    private DownwardsShroomFeature.Branch collectBranches(IWorldGenerationReader world, Random random, BlockPos origin, int height, Direction direction) {
        //Declare and initilize variables
        int minBranchHeight = 2;
        int maxBranchHeight = height - 2;
        int heightRange = maxBranchHeight - minBranchHeight;
        int branchCount = heightRange / BRANCH_SPACING;
        int branchHeight;
        double normalizedSpacing = (double) heightRange / branchCount;
        Direction orient;

        Set<DownwardsShroomFeature.Log> logs = new HashSet<>();
        Set<DownwardsShroomFeature.EndLog> endlogs = new HashSet<>();

        Direction lastDirection = null;

        //Get log positions and rotation based on the direction of the shroom
        //Get each branch until the branch count is reached
        for (int branch = 0; branch < branchCount; branch++) {
            //Set the length of the branch
            int branchLength = random.nextInt(3) + 4;
            double branchSlope = getSlopeNoDip(branchLength,random);
            BlockPos branchpos;
            //Set the height of the branch
            branchHeight = MathHelper.ceil(minBranchHeight + 1 + branch * normalizedSpacing);
            //Set the position of the start of the branch
            BlockPos branchOrigin = origin.offset(direction, branchHeight);

            //Choose the direction of the branch
            Direction dir = null;
            while (dir == null || dir == lastDirection) {
                dir = HORIZONTALS[random.nextInt(HORIZONTALS.length)];
            }
            lastDirection = dir;
            //Place each log in the branch until the branch length is reached
            for (int log = 0; log < branchLength; log++) {
                //Set the y value of the log and the log before it
                int newY = getYFromLocationNoDip(log, branchSlope);
                int oldY = getYFromLocationNoDip(log - 1, branchSlope);

                //If the branch is steep
                if (newY > 2) {
                    //Get the positions of all the logs going upwards until they reach the top one
                    for (int i = oldY; i <= newY; i++) {
                        branchpos = branchOrigin.up(i).offset(dir, log + 1);
                        //Set the axis of the log depending on steepness of the branch
                        if ((newY - oldY) > 1 || log > (branchLength / 2)) {
                            orient = Direction.UP;
                        } else {
                            orient = dir;
                        }
                        if (!isAirOrLeaves(world, branchpos)) {
                            continue;
                        }
                        //Add the log to the branch
                        if (log == branchLength - 1 && i == newY) {
                            endlogs.add(new EndLog(branchpos));
                        }
                        logs.add(new Log(branchpos, orient));
                    }
                } else {
                    //Set the position and axis of the log
                    branchpos = branchOrigin.up(newY).offset(dir, log + 1);
                    orient = dir;
                    if (!isAirOrLeaves(world, branchpos)) {
                        continue;
                    }
                    //Add the log to the branch
                    if (log == (branchLength - 1)) {
                        endlogs.add(new EndLog(branchpos));
                    }
                    logs.add(new Log(branchpos, orient));
                }
            }
        }
        return new Branch(logs,endlogs);
    }

    //Get the y value from the exponential function
    int getYFromLocationNoDip(int location, double slope) {
        return (int) Math.floor(Math.pow(slope, location)) -1;
    }
    //Get the base for the exponential function used to determine the height of blocks in the trunk and branches
    double getSlopeNoDip(int length, Random random) {
        return 1.2 + Math.pow(0.85, length) - random.nextFloat() * 0.17;
    }

    int getYFromLocationWithDip(int location, double dip, int reach) {
        return (int) Math.round(dip * location * location - dip * location * reach);
    }

    double getDip(int reach, Random random) {
        return (random.nextFloat() * 10 + 13) * Math.pow(reach, -2.50205);
    }

    private Set<BlockPos> collectCapPositions(DownwardsShroomFeature.EndLog endlog, Random random) {
        Set<BlockPos> branchLeaves;

        branchLeaves =  this.produceBlob(endlog.pos.up(), 4, 1);
        branchLeaves = this.droopLeaves(branchLeaves, random, 4);
        return branchLeaves;
    }

    private static class Log {
        final BlockPos pos;
        final Direction direction;

        private Log(BlockPos pos, Direction direction) {
            this.pos = pos;
            this.direction = direction;
        }

        @Override
        public int hashCode() {
            return this.pos.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof DownwardsShroomFeature.Log && ((DownwardsShroomFeature.Log) obj).pos.equals(this.pos);
        }
    }

    private static class EndLog {
        final BlockPos pos;

        private EndLog(BlockPos pos) {
            this.pos = pos;
        }
    }

    private static class Branch {
        Set<DownwardsShroomFeature.Log> logs;
        Set<DownwardsShroomFeature.EndLog> endlogs;

        private Branch(Set<DownwardsShroomFeature.Log> logs, Set<DownwardsShroomFeature.EndLog> endlogs) {
            this.logs = logs;
            this.endlogs = endlogs;
        }
    }

    private static class Trunk {
        Set<DownwardsShroomFeature.Log> logs;
        Set<DownwardsShroomFeature.EndLog> endlogs;

        private Trunk(Set<DownwardsShroomFeature.Log> logs, Set<DownwardsShroomFeature.EndLog> endlogs) {
            this.logs = logs;
            this.endlogs = endlogs;
        }
    }
}
