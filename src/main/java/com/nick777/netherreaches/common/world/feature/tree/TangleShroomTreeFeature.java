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

public class TangleShroomTreeFeature extends NetherReachTreeFeature {
    private static final Direction[] HORIZONTALS = new Direction[] {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    private static final Direction[] WEVERTICALS = new Direction[] {Direction.UP, Direction.EAST, Direction.DOWN, Direction.WEST};
    private static final Direction[] NSVERTICALS = new Direction[] {Direction.NORTH, Direction.UP, Direction.SOUTH, Direction.DOWN};

    private static final Direction[] ZFACE = new Direction[] {Direction.WEST, Direction.EAST, Direction.DOWN};
    private static final Direction[] ZDOWNROT = new Direction[] { Direction.EAST, Direction.WEST};

    private static final Direction[] XFACE = new Direction[] {Direction.NORTH, Direction.SOUTH, Direction.DOWN};
    private static final Direction[] XDOWNROT = new Direction[] { Direction.NORTH, Direction.SOUTH};

    private static final BlockState LOG = NetherReachesBlocks.TANGLE_SHROOM_STEM.getDefaultState();
    private static final BlockState LEAVES = NetherReachesBlocks.TANGLE_SHROOM_CAP.getDefaultState();

    private static final int BRANCH_SPACING = 3;

    public TangleShroomTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> deserialize) {
        super(deserialize);
        this.setSapling((IPlantable) NetherReachesBlocks.TANGLE_SHROOM_SAPLING);
    }

    @Override
    protected boolean place(IWorld world, Random random, BlockPos origin) {
        int height = random.nextInt(7) + 8;
        double trunkSlope = getSlopeNoDip(height, random);
        Set<BlockPos> leafPositions = new HashSet<>();
        BlockState blockstate = getSapling().getPlant(world, origin).getBlockState();
        DirectionProperty FACING = BlockStateProperties.FACING;
        Direction facing = blockstate.get(FACING);

        if (isSoil(world, origin.offset(facing.getOpposite()), this.getSapling())) {
            this.setDirtAt(world, origin.offset(facing.getOpposite()), origin);

            //Get the trunk
            Trunk trunk = this.getTrunk(height, trunkSlope, origin, facing, random, world);
            //Get the branches
            Branch branches = this.collectBranches(world, random, origin, height, facing, trunkSlope);
            //Get leaf positions for the trunk
            for (EndLog endlog : trunk.endlogs)
                { leafPositions.addAll(this.collectCapPositions(endlog, random)); }
            //Get leaf positions for branches
            for (EndLog endlog : branches.endlogs)
                { leafPositions.addAll(this.collectCapPositions(endlog, random)); }

            //Place the logs in the trunk
            for (Log log: trunk.logs) {
                if (!this.canFit(world,log.pos)) {
                    return false;
                }
                this.setBlockState(world, log.pos, LOG.with(LogBlock.AXIS, log.direction.getAxis()));
            }
            //Place the roots around the trunk
            this.generateRoots(world, random, origin, facing);
            //Place the logs in the branches
            for (Log log: branches.logs)
                { this.setBlockState(world, log.pos, LOG.with(LogBlock.AXIS, log.direction.getAxis())); }
            //Place the cap blocks
            for (BlockPos leafPos : leafPositions) {
                if (canGrowInto(world, leafPos))
                { this.setBlockState(world, leafPos, LEAVES); }
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
                switch (direction) {
                    case UP:
                    case DOWN:
                        availableSides = Lists.newArrayList(HORIZONTALS);
                        break;
                    case NORTH:
                    case SOUTH:
                        availableSides = Lists.newArrayList(WEVERTICALS);
                        break;
                    case EAST:
                    case WEST:
                        availableSides = Lists.newArrayList(NSVERTICALS);
                        break;
                    default:
                        availableSides = null;
                        break;
                }
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
                        switch (direction) {
                            case NORTH:
                                mutablePos.setPos(rootOrigin.getX(), rootOrigin.getY(), rootOrigin.getZ() - height);
                                break;
                            case SOUTH:
                                mutablePos.setPos(rootOrigin.getX(), rootOrigin.getY(), rootOrigin.getZ() + height);
                                break;
                            case EAST:
                                mutablePos.setPos(rootOrigin.getX() + height, rootOrigin.getY(), rootOrigin.getZ());
                                break;
                            case WEST:
                                mutablePos.setPos(rootOrigin.getX() - height, rootOrigin.getY(), rootOrigin.getZ());
                                break;
                            case UP:
                                mutablePos.setPos(rootOrigin.getX(), rootOrigin.getY() + height, rootOrigin.getZ());
                                break;
                            case DOWN:
                                mutablePos.setPos(rootOrigin.getX(), rootOrigin.getY() - height, rootOrigin.getZ());
                                break;
                        }
                        //Place the part of the root
                        this.setBlockState(world, mutablePos, LOG.with(LogBlock.AXIS, direction.getAxis()));
                    }
                }
    }

    private Trunk getTrunk(int trunkHeight, double trunkSlope, BlockPos origin, Direction direction, Random random, IWorldGenerationReader world) {

        Set<Log> logs = new HashSet<>();
        Set<EndLog> endlogs = new HashSet<>();

        BlockPos blockpos;
        Direction orient;

        switch (direction) {
            case UP:
            case DOWN:
                for (int height = 0; height < trunkHeight; height++) {
                    blockpos = origin.offset(direction, height);
                    orient = Direction.UP;
                    if (height == trunkHeight - 1 && direction == Direction.UP) {
                        endlogs.add(new EndLog(blockpos));
                    }
                    logs.add(new Log(blockpos, orient));
                }
                if (direction == Direction.DOWN) {
                    int endTrunkCurveReach = random.nextInt(1) + 3;
                    double endTrunkDip = getDip(endTrunkCurveReach, random) - 0.4;
                    Direction rot = HORIZONTALS[random.nextInt(HORIZONTALS.length)];
                    BlockPos endTrunkOrigin = origin.down(trunkHeight - 1);
                    BlockPos trunkpos;
                    for( int height = 0; height < endTrunkCurveReach - 1; height++) {

                    }
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
                                    endlogs.add(new EndLog(trunkpos));
                                }
                                logs.add(new Log(trunkpos, orient));
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
                                    endlogs.add(new EndLog(trunkpos));
                                }
                                //Add the log to the branch
                                logs.add(new Log(trunkpos, orient));
                            }
                        } else {
                            trunkpos = endTrunkOrigin.up(newY).offset(rot, log);
                            orient = rot;
                            if (!isAirOrLeaves(world, trunkpos)) {
                                continue;
                            }
                            if (log == endTrunkCurveReach + 1) {
                                endlogs.add(new EndLog(trunkpos));
                            }
                            //Add the log to the branch
                            logs.add(new Log(trunkpos, orient));
                        }
                    }

                }
            break;
            case NORTH:
            case SOUTH:
            case EAST:
            case WEST:
                for (int height = 0; height < trunkHeight - 1; height++) {

                    int newY = getYFromLocationNoDip(height, trunkSlope);
                    int oldY = getYFromLocationNoDip(height - 1, trunkSlope);

                    if (newY > 2) {
                        for (int i = oldY; i <= newY; i++) {
                            blockpos = origin.up(i).offset(direction, height);

                            if ((newY - oldY) > 1) {
                                orient = Direction.UP;
                            } else {
                                orient = direction;
                            }
                            if (height == trunkHeight - 2 && i == newY) {
                                endlogs.add(new EndLog(blockpos));
                            }
                            logs.add(new Log(blockpos,orient));
                        }
                    } else {
                        orient = direction;
                        blockpos = origin.up(newY).offset(direction, height);
                        if (height == trunkHeight - 2) {
                            endlogs.add(new EndLog(blockpos));
                        }
                        logs.add(new Log(blockpos,orient));
                    }
                }
                break;
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

    private Branch collectBranches(IWorldGenerationReader world, Random random, BlockPos origin, int height, Direction direction, double trunkSlope) {
        //Declare and initilize variables
        int minBranchHeight = 2;
        int maxBranchHeight = height - 2;
        int heightRange = maxBranchHeight - minBranchHeight;
        int branchCount = heightRange / BRANCH_SPACING;
        int branchHeight;
        double normalizedSpacing = (double) heightRange / branchCount;
        Direction orient;

        Set<Log> logs = new HashSet<>();
        Set<EndLog> endlogs = new HashSet<>();

        Direction lastDirection = null;
        Direction lastRotation = null;

        //Get log positions and rotation based on the direction of the shroom
        switch (direction) {
            case UP:
            case DOWN:
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
            break;
            case NORTH:
            case SOUTH:
            case EAST:
            case WEST:
                //Get each branch until the branch count is reached
                for (int branch = 0; branch < branchCount; branch++) {
                    //Set variables
                    int branchLength = random.nextInt(3) + 4;
                    double branchSlope = getSlopeNoDip(branchLength,random);
                    int branchZ = MathHelper.ceil(minBranchHeight + 1 + branch * normalizedSpacing);

                    BlockPos branchPos;
                    //Set the position of the start of the branch
                    BlockPos branchOrigin = origin.offset(direction, branchZ).up(getYFromLocationNoDip(branchZ, trunkSlope));
                    //Choose the direction of the branch
                    Direction dir = null;
                    Direction rot = null;
                    Direction branchDir1 = null;
                    Direction branchDir2 = null;
                    switch (direction) {
                        case NORTH:
                        case SOUTH:
                            while (dir == null || dir == lastDirection) {
                                dir = TangleShroomTreeFeature.ZFACE[random.nextInt(TangleShroomTreeFeature.ZFACE.length)];
                            }
                            lastDirection = dir;

                            while (rot == null || rot == lastRotation) {
                                rot = ZDOWNROT[random.nextInt(ZDOWNROT.length)];
                            }
                            lastRotation = rot;

                            branchDir1 = Direction.EAST;
                            branchDir2 = Direction.WEST;
                            break;
                        case EAST:
                        case WEST:
                            while (dir == null || dir == lastDirection) {
                                dir = TangleShroomTreeFeature.XFACE[random.nextInt(TangleShroomTreeFeature.XFACE.length)];
                            }
                            lastDirection = dir;

                            while (rot == null || rot == lastRotation) {
                                rot = XDOWNROT[random.nextInt(XDOWNROT.length)];
                            }
                            lastRotation = rot;

                            branchDir1 = Direction.NORTH;
                            branchDir2 = Direction.SOUTH;
                            break;
                    }

                    if (dir == branchDir1 || dir == branchDir2) {
                        //Get and add the locations of each log to the branch until the end of the branch is reached
                        for (int log = 0; log < branchLength; log++) {

                            //Set the y value of the log and the log before it
                            int newY = getYFromLocationNoDip(log, branchSlope);
                            int oldY = getYFromLocationNoDip(log - 1, branchSlope);

                            //If the branch is steep
                            if (newY > 2) {
                                //Get the positions of all the logs going upwards until they reach the top one
                                for (int i = oldY; i <= newY; i++) {
                                    branchPos = branchOrigin.up(i).offset(dir, log);
                                    //Set the axis of the log depending on steepness of the branch
                                    if ((newY - oldY) > 1 || log > (branchLength / 2)) {
                                        orient = Direction.UP;
                                    } else {
                                        orient = dir;
                                    }
                                    if (!isAirOrLeaves(world, branchPos)) {
                                        continue;
                                    }
                                    //Add the log to the branch
                                    if (log == branchLength - 1 && i == newY) {
                                        endlogs.add(new EndLog(branchPos));
                                    }
                                    logs.add(new Log(branchPos, orient));
                                }
                            } else {
                                //Set the position and axis of the log
                                branchPos = branchOrigin.up(newY).offset(dir, log);
                                orient = dir;
                                if (!isAirOrLeaves(world, branchPos)) {
                                    continue;
                                }
                                //Add the log to the branch
                                if (log == (branchLength - 1)) {
                                    endlogs.add(new EndLog(branchPos));
                                }
                                logs.add(new Log(branchPos, orient));
                            }
                        }
                    } else if (dir == Direction.DOWN) {
                        int reach = random.nextInt(6) + 3;
                        double dip = getDip(reach, random);
                        for (int log = 0; log < branchLength + 2; log++) {
                            int newY = getYFromLocationWithDip(log, dip, reach);
                            int oldY = getYFromLocationWithDip(log - 1, dip, reach);
                            if (newY > (branchOrigin.getY() + 6)) {
                                break;
                            }
                            if ((newY - oldY) >= 2) {
                                for (int i = oldY; i <= newY; i++) {
                                    branchPos = branchOrigin.up(i).offset(rot, log);
                                    //Set the axis of the log depending on steepness of the branch
                                    if (Math.abs(newY - oldY) > 1) {
                                        orient = Direction.UP;
                                    } else {
                                        orient = rot;
                                    }
                                    if (!isAirOrLeaves(world, branchPos)) {
                                        continue;
                                    }
                                    //Add the log to the branch
                                    if (log == branchLength + 1 && i == newY) {
                                        endlogs.add(new EndLog(branchPos));
                                    }
                                    logs.add(new Log(branchPos, orient));
                                }
                            } else if ((newY - oldY) <= -2) {
                                for (int i = oldY; i >= newY; i--) {
                                    branchPos = branchOrigin.up(i).offset(rot, log);
                                    //Set the axis of the log depending on steepness of the branch
                                    if ( i >= 0) {
                                        continue;
                                    }
                                    if (Math.abs(newY - oldY) > 1) {
                                        orient = Direction.DOWN;
                                    } else {
                                        orient = rot;
                                    }
                                    if (!isAirOrLeaves(world, branchPos)) {
                                        continue;
                                    }
                                    if (log == branchLength + 1 && i == newY) {
                                        endlogs.add(new EndLog(branchPos));
                                    }
                                    //Add the log to the branch
                                    logs.add(new Log(branchPos, orient));
                                }
                            } else {
                                branchPos = branchOrigin.up(newY).offset(rot, log);
                                orient = rot;
                                if (!isAirOrLeaves(world, branchPos)) {
                                    continue;
                                }
                                if (log == branchLength + 1) {
                                    endlogs.add(new EndLog(branchPos));
                                }
                                //Add the log to the branch
                                logs.add(new Log(branchPos, orient));
                            }
                        }
                    }
                }
            break;
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

    private Set<BlockPos> collectCapPositions(EndLog endlog, Random random) {
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
            return obj instanceof Log && ((Log) obj).pos.equals(this.pos);
        }
    }

    private static class EndLog {
        final BlockPos pos;

        private EndLog(BlockPos pos) {
            this.pos = pos;
        }
    }

    private static class Branch {
        Set<Log> logs;
        Set<EndLog> endlogs;

        private Branch(Set<Log> logs, Set<EndLog> endlogs) {
            this.logs = logs;
            this.endlogs = endlogs;
        }
    }

    private static class Trunk {
        Set<Log> logs;
        Set<EndLog> endlogs;

        private Trunk(Set<Log> logs, Set<EndLog> endlogs) {
            this.logs = logs;
            this.endlogs = endlogs;
        }
    }
}
