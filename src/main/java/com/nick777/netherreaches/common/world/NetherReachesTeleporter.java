package com.nick777.netherreaches.common.world;

import com.google.common.collect.Maps;
import com.nick777.netherreaches.NetherReaches;
import com.nick777.netherreaches.common.block.NetherReachesPortalBlock;
import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import it.unimi.dsi.fastutil.objects.Object2LongMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.*;
import net.minecraft.world.Teleporter;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.function.Supplier;

public class NetherReachesTeleporter extends Teleporter {

    private static final Block NETHER_REACHES_PORTAL = NetherReachesBlocks.NETHER_REACHES_PORTAL;
    protected final Map<ColumnPos, PortalPosition> destinationCoordinateCache = Maps.newHashMapWithExpectedSize(4096);
    private final Object2LongMap<ColumnPos> columnMap = new Object2LongOpenHashMap<>();

    public NetherReachesTeleporter(ServerWorld serverWorld) {
        super(serverWorld);
    }

    @Override
    public boolean placeInPortal(Entity entity, float yaw) {
        return super.placeInPortal(entity, yaw);
    }

    @Override
    public BlockPattern.PortalInfo placeInExistingPortal(BlockPos pos, Vec3d motion, Direction directionIn, double x, double y, boolean isPlayer) {
        boolean isFrame = true;
        BlockPos blockpos = null;
        ColumnPos columnpos = new ColumnPos(pos);
        if (!isPlayer && this.columnMap.containsKey(columnpos)) {
            return null;
        } else {
            NetherReachesTeleporter.PortalPosition teleporter$portalposition = this.destinationCoordinateCache.get(columnpos);
            if (teleporter$portalposition != null) {
                blockpos = teleporter$portalposition.pos;
                teleporter$portalposition.lastUpdateTime = this.world.getGameTime();
                isFrame = false;
            } else {
                double d0 = Double.MAX_VALUE;

                for(int eX = -128; eX <= 128; ++eX) {
                    BlockPos blockpos2;
                    for(int eY = -128; eY <= 128; ++eY) {
                        for(BlockPos blockpos1 = pos.add(eX, this.world.getActualHeight() - 1 - pos.getY(), eY); blockpos1.getY() >= 0; blockpos1 = blockpos2) {
                            blockpos2 = blockpos1.down();
                            if (this.world.getBlockState(blockpos1).getBlock() == NETHER_REACHES_PORTAL) {
                                for(blockpos2 = blockpos1.down(); this.world.getBlockState(blockpos2).getBlock() == NETHER_REACHES_PORTAL; blockpos2 = blockpos2.down()) {
                                    blockpos1 = blockpos2;
                                }

                                double d1 = blockpos1.distanceSq(pos);
                                if (d0 < 0.0D || d1 < d0) {
                                    d0 = d1;
                                    blockpos = blockpos1;
                                }
                            }
                        }
                    }
                }
            }

            if (blockpos == null) {
                long eZ = this.world.getGameTime() + 300L;
                this.columnMap.put(columnpos, eZ);
                return null;
            } else {
                if (isFrame) {
                    this.destinationCoordinateCache.put(columnpos, new NetherReachesTeleporter.PortalPosition(blockpos, this.world.getGameTime()));
                    Logger logger = NetherReaches.LOGGER;
                    Supplier[] asupplier = new Supplier[2];
                    Dimension dimension = this.world.getDimension();
                    asupplier[0] = dimension::getType;
                    asupplier[1] = () -> columnpos;
                    logger.debug("Adding nether reaches portal ticket for {}:{}", asupplier[0], asupplier[1]);
                    this.world.getChunkProvider().func_217228_a(TicketType.PORTAL, new ChunkPos(blockpos), 3, columnpos);
                }

                BlockPattern.PatternHelper blockpattern$patternhelper = ((NetherReachesPortalBlock)NETHER_REACHES_PORTAL).createPatternHelper(this.world, blockpos);
                return blockpattern$patternhelper.getPortalInfo(directionIn, blockpos, y, motion, x);
            }
        }
    }

    /**
     * Create a portal at the teleport location.
     */
    @Override
    public boolean makePortal(Entity entityIn) {
        double d0 = -1.0D;
        int eX = MathHelper.floor(entityIn.posX);
        int eY = MathHelper.floor(entityIn.posY);
        int eZ = MathHelper.floor(entityIn.posZ);
        int i1 = eX;
        int j1 = eY;
        int k1 = eZ;
        int l1 = 0;
        int i2 = this.random.nextInt(4);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int x = eX - 16; x <= eX + 16; ++x) {
            double d1 = (double)x + 0.5D - entityIn.posX;

            for(int z = eZ - 16; z <= eZ + 16; ++z) {
                double d2 = (double)z + 0.5D - entityIn.posZ;

                label276:
                for(int y = this.world.getActualHeight() - 1; y >= 0; --y) {
                    if (this.world.isAirBlock(blockpos$mutableblockpos.setPos(x, y, z))) {
                        while(y > 0 && this.world.isAirBlock(blockpos$mutableblockpos.setPos(x, y - 1, z))) {
                            --y;
                        }

                        for(int k3 = i2; k3 < i2 + 4; ++k3) {
                            int l3 = k3 % 2;
                            int i4 = 1 - l3;
                            if (k3 % 4 >= 2) {
                                l3 = -l3;
                                i4 = -i4;
                            }

                            for(int j4 = 0; j4 < 3; ++j4) {
                                for(int k4 = 0; k4 < 4; ++k4) {
                                    for(int l4 = -1; l4 < 4; ++l4) {
                                        int bX = x + (k4 - 1) * l3 + j4 * i4;
                                        int bY = y + l4;
                                        int bZ = z + (k4 - 1) * i4 - j4 * l3;
                                        blockpos$mutableblockpos.setPos(bX, bY, bZ);
                                        if (l4 < 0 && !this.world.getBlockState(blockpos$mutableblockpos).getMaterial().isSolid() || l4 >= 0 && !this.world.isAirBlock(blockpos$mutableblockpos)) {
                                            continue label276;
                                        }
                                    }
                                }
                            }

                            double d5 = (double)y + 0.5D - entityIn.posY;
                            double d7 = d1 * d1 + d5 * d5 + d2 * d2;
                            if (d0 < 0.0D || d7 < d0) {
                                d0 = d7;
                                i1 = x;
                                j1 = y;
                                k1 = z;
                                l1 = k3 % 4;
                            }
                        }
                    }
                }
            }
        }

        if (d0 < 0.0D) {
            for(int x = eX - 16; x <= eX + 16; ++x) {
                double d3 = (double)x + 0.5D - entityIn.posX;

                for(int z = eZ - 16; z <= eZ + 16; ++z) {
                    double d4 = (double)z + 0.5D - entityIn.posZ;

                    label214:
                    for(int y = this.world.getActualHeight() - 1; y >= 0; --y) {
                        if (this.world.isAirBlock(blockpos$mutableblockpos.setPos(x, y, z))) {
                            while(y > 0 && this.world.isAirBlock(blockpos$mutableblockpos.setPos(x, y - 1, z))) {
                                --y;
                            }

                            for(int l7 = i2; l7 < i2 + 2; ++l7) {
                                int l8 = l7 % 2;
                                int k9 = 1 - l8;

                                for(int i10 = 0; i10 < 4; ++i10) {
                                    for(int k10 = -1; k10 < 4; ++k10) {
                                        int bX = x + (i10 - 1) * l8;
                                        int bY = y + k10;
                                        int bZ = z + (i10 - 1) * k9;
                                        blockpos$mutableblockpos.setPos(bX, bY, bZ);
                                        if (k10 < 0 && !this.world.getBlockState(blockpos$mutableblockpos).getMaterial().isSolid() || k10 >= 0 && !this.world.isAirBlock(blockpos$mutableblockpos)) {
                                            continue label214;
                                        }
                                    }
                                }

                                double d6 = (double)y + 0.5D - entityIn.posY;
                                double d8 = d3 * d3 + d6 * d6 + d4 * d4;
                                if (d0 < 0.0D || d8 < d0) {
                                    d0 = d8;
                                    i1 = x;
                                    j1 = y;
                                    k1 = z;
                                    l1 = l7 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }

        int i6 = i1;
        int k2 = j1;
        int k6 = k1;
        int l6 = l1 % 2;
        int i3 = 1 - l6;
        if (l1 % 4 >= 2) {
            l6 = -l6;
            i3 = -i3;
        }

        if (d0 < 0.0D) {
            j1 = MathHelper.clamp(j1, 70, this.world.getActualHeight() - 10);
            k2 = j1;

            for(int j7 = -1; j7 <= 1; ++j7) {
                for(int i8 = 1; i8 < 3; ++i8) {
                    for(int i9 = -1; i9 < 3; ++i9) {
                        int bX = i6 + (i8 - 1) * l6 + j7 * i3;
                        int bY = k2 + i9;
                        int bZ = k6 + (i8 - 1) * i3 - j7 * l6;
                        boolean isFrame = i9 < 0;
                        blockpos$mutableblockpos.setPos(bX, bY, bZ);
                        this.world.setBlockState(blockpos$mutableblockpos, isFrame ? NetherReachesBlocks.FLASH_OBSIDIAN.getDefaultState() : Blocks.AIR.getDefaultState());
                    }
                }
            }
        }

        for(int k7 = -1; k7 < 3; ++k7) {
            for(int j8 = -1; j8 < 4; ++j8) {
                if (k7 == -1 || k7 == 2 || j8 == -1 || j8 == 3) {
                    blockpos$mutableblockpos.setPos(i6 + k7 * l6, k2 + j8, k6 + k7 * i3);
                    this.world.setBlockState(blockpos$mutableblockpos, NetherReachesBlocks.FLASH_OBSIDIAN.getDefaultState(), 3);
                }
            }
        }

        BlockState blockstate = NETHER_REACHES_PORTAL.getDefaultState().with(NetherReachesPortalBlock.AXIS, l6 == 0 ? Direction.Axis.Z : Direction.Axis.X);

        for(int k8 = 0; k8 < 2; ++k8) {
            for(int j9 = 0; j9 < 3; ++j9) {
                blockpos$mutableblockpos.setPos(i6 + k8 * l6, k2 + j9, k6 + k8 * i3);
                this.world.setBlockState(blockpos$mutableblockpos, blockstate, 18);
            }
        }

        return true;
    }

    static class PortalPosition {
        public final BlockPos pos;
        public long lastUpdateTime;

        public PortalPosition(BlockPos pos, long time) {
            this.pos = pos;
            this.lastUpdateTime = time;
        }
    }
}