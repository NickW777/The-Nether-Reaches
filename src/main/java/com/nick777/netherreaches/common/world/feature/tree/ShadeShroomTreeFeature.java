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
    private static final Direction[] HORIZONTALS = new Direction[] {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    private static final Direction[] WEVERTICALS = new Direction[] {Direction.UP, Direction.EAST, Direction.DOWN, Direction.WEST};
    private static final Direction[] NSVERTICALS = new Direction[] {Direction.NORTH, Direction.UP, Direction.SOUTH, Direction.DOWN};
    private static final Direction[] NORTHFACE = new Direction[] {Direction.WEST, Direction.EAST, Direction.DOWN};
    private static final Direction[] NORTHDOWNROT = new Direction[] { Direction.EAST, Direction.WEST};

    private static final BlockState LOG = NetherReachesBlocks.SHADESHROOMSTEM.getDefaultState();
    private static final BlockState LEAVES = NetherReachesBlocks.SHADESHROOMCAP.getDefaultState();

    private static final int BRANCH_SPACING = 3;

    public ShadeShroomTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> deserialize) {
        super(deserialize);
        this.setSapling((IPlantable) NetherReachesBlocks.SHADESHROOMSAPLING);
    }

    @Override
    protected boolean place(IWorld world, Random random, BlockPos origin) {
        int height = random.nextInt(7) + 8;
        double trunkSlope = getSlopeNoDip(height, random);

        BlockState blockstate = getSapling().getPlant(world, origin).getBlockState();
        DirectionProperty FACING = BlockStateProperties.FACING;
        Direction facing = blockstate.get(FACING);

        if (!this.canFit(world, origin, 1, height, facing)) {
            return false;
        }
        switch (facing) {
            case UP:
                if (isSoil(world, origin.down(), this.getSapling())) {
                    this.setDirtAt(world, origin.down(), origin);

                    //Get and then place the trunk facing Up
                    Trunk trunk = this.getTrunk(height, trunkSlope, origin, facing);
                    for (Log log: trunk.logs) {
                        this.setBlockState(world, log.pos, LOG.with(LogBlock.AXIS, log.direction.getAxis()));
                    }

                    //Place the roots around the trunk
                    this.generateRoots(world, random, origin, facing);

                    //Get and then place the branches
                    Branch branches = this.collectBranches(world, random, origin, height, facing, trunkSlope);
                    for (Log log: branches.logs) {
                        this.setBlockState(world, log.pos, LOG.with(LogBlock.AXIS, log.direction.getAxis()));
                    }

                    //Initialize the leaves
                    Set<BlockPos> leafPositions = new HashSet<>();

                    //Get leaf positions for the trunk
                    for (EndLog endlog : trunk.endlogs) {
                        leafPositions.addAll(this.collectCapPositions(endlog, random));
                    }

                    //Get leaf positions for branches
                    for (EndLog endlog : branches.endlogs) {
                        leafPositions.addAll(this.collectCapPositions(endlog, random));
                    }

                    //Place all of the cap blocks
                    for (BlockPos leafPos : leafPositions) {
                        if (canGrowInto(world, leafPos)) {
                            this.setBlockState(world, leafPos, LEAVES);
                        }
                    }

                    return true;
                }
            break;
            case NORTH:
                if (isSoil(world, origin.south(), this.getSapling())) {
                    this.setDirtAt(world, origin.south(), origin);

                    //Get and then place trunk facing north
                    Trunk trunk = this.getTrunk(height, trunkSlope, origin, facing);
                    for(Log log: trunk.logs)
                        this.setBlockState(world,log.pos,LOG.with(LogBlock.AXIS, log.direction.getAxis()));


                    //Place roots around the base of the trunk
                    this.generateRoots(world, random, origin, facing);

                    //Get and then place the branches
                    Branch branches = this.collectBranches(world, random, origin, height, facing, trunkSlope);
                    for(Log log: branches.logs) {
                        this.setBlockState(world, log.pos, LOG.with(LogBlock.AXIS, log.direction.getAxis()));
                    }

                    //Intitialize the leaf positions
                    Set<BlockPos> leafPositions = new HashSet<>();

                    //Get leaf positions for branches
                    for (EndLog endlog : branches.endlogs) {
                        leafPositions.addAll(this.collectCapPositions(endlog, random));
                    }

                    //Get leaf positions for the trunk
                    for (EndLog endlog : trunk.endlogs) {
                        leafPositions.addAll(this.collectCapPositions(endlog, random));
                    }

                    //Place leaves
                    for (BlockPos leafPos : leafPositions) {
                        if (canGrowInto(world, leafPos)) {
                            this.setBlockState(world, leafPos, LEAVES);
                        }
                    }

                    return true;
                }
            break;
        }

        return false;
    }

    private boolean canFit(IWorld world, BlockPos origin, int width, int height, Direction direction) {
        BlockPos min;
        BlockPos max;
        switch (direction) {
            case UP:
                min = origin.add(-width, 0, -width);
                max = origin.add(width, height, width);

                for (BlockPos pos : BlockPos.getAllInBoxMutable(min, max)) {
                    if (!canGrowInto(world, pos)) {
                        return false;
                    }
                }
            break;
            case NORTH:
                min = origin.add(-width, -width, -height);
                max = origin.add(width, width, 0);

                for (BlockPos pos : BlockPos.getAllInBoxMutable(min, max)) {
                    if (!canGrowInto(world, pos)) {
                        return false;
                    }
                }
            break;
        }
        return true;
    }

    //Generate the roots for the shroom
    private void generateRoots(IWorldGenerationReader world, Random random, BlockPos origin, Direction direction) {
        //Declare variables
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        List<Direction> availableSides;

        //Set the number of roots on the tree
        int count = random.nextInt(3) + 1;
        switch (direction) {
            //If the shroom is facing up
            case UP:
                //Make a list of the possible sides for roots
                availableSides = Lists.newArrayList(HORIZONTALS);
                //Place the roots until the number of roots is reached
                for (int i = 0; i < count; i++) {
                    //Choose a side to place a root and remove it from the list
                    Direction side = availableSides.remove(random.nextInt(availableSides.size()));
                    //Set the position of the lowermost part of the root
                    BlockPos rootOrigin = origin.offset(side);

                    //Set the height of the root
                    int height = random.nextInt(3) + 1;
                    //Place each part of the root until the root height is reached
                    for (int localY = 0; localY < height; localY++) {
                        //Set the position of the part of the root
                        mutablePos.setPos(rootOrigin.getX(), rootOrigin.getY() + localY, rootOrigin.getZ());
                        //Place the part of the root
                        this.setBlockState(world, mutablePos, LOG);
                    }
                }
            break;
            //If the shroom is facing north
            case NORTH:
                //Make a list of the available sides
                availableSides = Lists.newArrayList(WEVERTICALS);
                //Place the roots until the number of roots is reached
                for (int i = 0; i < count; i++) {
                    //Choose a side to place a root and remove it from the list
                    Direction side = availableSides.remove(random.nextInt(availableSides.size()));
                    //Set the position of the lowermost part of the root
                    BlockPos rootOrigin = origin.offset(side);
                    //Set the height of the root
                    int height = random.nextInt(4) + 1;
                    //Place each part of the root until the root height is reached
                    for (int localZ = 0; localZ < height; localZ++) {
                        //Set the position of the part of the root
                        mutablePos.setPos(rootOrigin.getX(), rootOrigin.getY(), rootOrigin.getZ() - localZ);
                        //Place the part of the root
                        this.setBlockState(world, mutablePos, LOG.with(LogBlock.AXIS, Direction.Axis.Z));
                    }
                }

            break;
        }
    }

    private Trunk getTrunk(int height, double trunkSlope, BlockPos origin, Direction direction) {

        Set<Log> logs = new HashSet<>();
        Set<EndLog> endlogs = new HashSet<>();

        BlockPos blockpos;
        Direction orient;

        switch (direction) {
            case UP:
                for (int localY = 0; localY < height; localY++) {
                    blockpos = origin.up(localY);
                    orient = Direction.UP;
                    if (localY == height - 1) {
                        endlogs.add(new EndLog(blockpos));
                    }
                    logs.add(new Log(blockpos, orient));
                }
            break;
            case NORTH:
                for (int localZ = 0; localZ < height - 2; localZ++) {

                    int newY = getYFromLocationNoDip(localZ, trunkSlope);
                    int oldY = getYFromLocationNoDip(localZ - 1, trunkSlope);

                    if (newY > 2) {
                        for (int i = oldY; i <= newY; i++) {
                            blockpos = origin.up(i).north(localZ);
                            if ((newY - oldY) > 1) {
                                orient = Direction.UP;

                            } else {
                                orient = Direction.NORTH;
                            }
                            if (localZ == height - 3 && i == newY) {
                                endlogs.add(new EndLog(blockpos));
                            }
                            logs.add(new Log(blockpos,orient));
                        }
                    } else {
                        orient = Direction.NORTH;
                        blockpos = origin.up(newY).north(localZ);
                        if (localZ == height - 3) {
                            endlogs.add(new EndLog(blockpos));
                        }
                        logs.add(new Log(blockpos,orient));
                    }
                }
            break;
        }

        Trunk trunk = new Trunk(logs, endlogs);
        return trunk;
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
                //Get each branch until the branch count is reached
                for (int branch = 0; branch < branchCount; branch++) {
                    //Set the length of the branch
                    int branchLength = random.nextInt(3) + 4;
                    //Set the height of the branch
                    branchHeight = MathHelper.ceil(minBranchHeight + 1 + branch * normalizedSpacing);
                    //Choose the direction of the branch
                    Direction dir = null;
                    while (dir == null || dir == lastDirection) {
                        dir = HORIZONTALS[random.nextInt(HORIZONTALS.length)];
                    }
                    lastDirection = dir;
                    //Place each log in the branch until the branch length is reached
                    for (int log = 0; log < branchLength; log++) {
                        //Set the position of the log
                        BlockPos branchpos = origin.up(branchHeight).offset(dir, log);
                        //Move on to the next log if the position is not ocuppied by air or leaves
                        if (!isAirOrLeaves(world, branchpos)) {
                            continue;
                        }

                        orient = dir;

                        if (log == branchLength - 1) {
                            endlogs.add(new EndLog(branchpos));
                        }
                        //Add the log to the branch
                        logs.add(new Log(branchpos, orient));
                    }
                }
            break;
            case NORTH:
                //Get each branch until the branch count is reached
                for (int branch = 0; branch < branchCount; branch++) {
                    //Set variables
                    int branchLength = random.nextInt(3) + 4;
                    double branchSlope = getSlopeNoDip(branchLength,random);
                    int branchZ = MathHelper.ceil(minBranchHeight + 1 + branch * normalizedSpacing);
                    int reach = random.nextInt(6) + 3;
                    double dip = getDip(reach, random);
                    BlockPos branchPos;
                    //Set the position of the start of the branch
                    BlockPos branchOrigin = origin.north(branchZ).up(getYFromLocationNoDip(branchZ, trunkSlope));
                    //Choose the direction of the branch
                    Direction dir = null;
                    while (dir == null || dir == lastDirection) {
                        dir = NORTHFACE[random.nextInt(NORTHFACE.length)];
                    }
                    lastDirection = dir;

                    Direction rot = null;
                    while (rot == null || rot == lastRotation) {
                        rot = NORTHDOWNROT[random.nextInt(NORTHDOWNROT.length)];
                    }
                    lastRotation = rot;
                    if (dir == Direction.WEST || dir == Direction.EAST) {
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
        Branch branches = new Branch(logs,endlogs);
        return branches;
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

        branchLeaves =  this.produceBlob(endlog.pos, 4, 1);
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
