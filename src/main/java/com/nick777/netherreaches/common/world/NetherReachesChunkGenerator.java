package com.nick777.netherreaches.common.world;
import com.nick777.netherreaches.common.biome.BiomeLayers;
import com.nick777.netherreaches.common.biome.heated.HeatedBiome;
import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.world.feature.placement.HeatedPlacementLevelCeiling;
import com.nick777.netherreaches.common.world.util.NoiseChunkPrimer;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.server.ServerWorld;

import java.util.BitSet;
import java.util.List;
import java.util.Random;

import static com.nick777.netherreaches.common.world.NetherReachesNoiseGenerator.*;

public class NetherReachesChunkGenerator extends NoiseChunkGenerator<NetherReachesChunkGenerator.Config> {
    public static final int SURFACE_LEVEL = 130;

    public static final int MIN_CAVE_HEIGHT = 200;
    public static final int MAX_CAVE_HEIGHT = 235;

    public static final int LOWER_CAVE_BOUNDARY = MIN_CAVE_HEIGHT - 12;

    public static final int SEA_LEVEL = SURFACE_LEVEL + 2;

    private final World world;
    private final NetherReachesNoiseGenerator noiseGenerator;
    private final NoiseChunkPrimer noisePrimer;

    private final BiomeLayers<Biome> surfaceLayers;
    private final BiomeLayers<HeatedBiome> undergroundLayers;

    private final INoiseGenerator surfaceDepthNoise;

    public NetherReachesChunkGenerator(World world, BiomeLayers<Biome> surfaceLayers, BiomeLayers<HeatedBiome> undergroundLayers, Config config) {
        super(world, new NetherReachesBiomeProvider(surfaceLayers), HORIZONTAL_GRANULARITY, VERTICAL_GRANULARITY, 256, config, true);

        this.world = world;
        this.noiseGenerator = new NetherReachesNoiseGenerator(this.randomSeed);
        this.noisePrimer = new NoiseChunkPrimer(HORIZONTAL_GRANULARITY, VERTICAL_GRANULARITY, NOISE_WIDTH, NOISE_HEIGHT);

        this.surfaceLayers = surfaceLayers;
        this.undergroundLayers = undergroundLayers;

        this.surfaceDepthNoise = new PerlinNoiseGenerator(this.randomSeed, 4);
    }

    @Override
    public void makeBase(IWorld world, IChunk chunk) {
        double[] noise = this.noiseGenerator.sampleChunkNoise(chunk.getPos(), this.surfaceLayers, this.undergroundLayers);
        this.noisePrimer.primeChunk((ChunkPrimer) chunk, noise, (density, x, y, z) -> {
            if (density > 0) {
                return this.defaultBlock;
            }
            return null;
        });
    }

    @Override
    public void generateSurface(IChunk chunk) {
        long seed = this.world.getSeed();

        ChunkPos chunkPos = chunk.getPos();
        int chunkX = chunkPos.x;
        int chunkZ = chunkPos.z;

        SharedSeedRandom random = new SharedSeedRandom();
        random.setBaseChunkSeed(chunkX, chunkZ);

        int minChunkX = chunkPos.getXStart();
        int minChunkZ = chunkPos.getZStart();

        Biome[] biomes = chunk.getBiomes();

        for (int localZ = 0; localZ < 16; localZ++) {
            for (int localX = 0; localX < 16; localX++) {
                int globalX = minChunkX + localX;
                int globalZ = minChunkZ + localZ;

                Biome hangingBiome = biomes[localX + localZ * 16];
                HeatedBiome heatedBiome = this.getHeatedBiome(globalX, globalZ);

                int height = chunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE_WG, localX, localZ) + 1;;

                double depth = this.surfaceDepthNoise.noiseAt(globalX * 0.0625, globalZ * 0.0625, 0.0625, localX * 0.0625);

                hangingBiome.buildSurface(random, chunk, globalX, globalZ, height, depth, this.defaultBlock, this.defaultFluid, SEA_LEVEL, seed);
                heatedBiome.generateSurface(random, chunk, globalX, globalZ, height, depth, this.defaultBlock, this.defaultFluid, SEA_LEVEL, seed);
            }
        }

        makeBedrock(chunk, random);
    }

    @Override
    protected void makeBedrock(IChunk chunkIn, Random rand) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        int x = chunkIn.getPos().getXStart();
        int z = chunkIn.getPos().getZStart();

        for (BlockPos pos : BlockPos.getAllInBoxMutable(x, 256, z, x + 15, 256, z + 15)) {
            for (int y = 256; y > 251; y--) {
                if (y >= rand.nextInt(5) + 251) {
                    chunkIn.setBlockState(mutable.setPos(pos.getX(), y, pos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
                }
            }
        }

    }

//    @Override
//    public void carve(IChunk chunk, GenerationStage.Carving stage) {
//        Collection<ConfiguredCarver<?>> surfaceCarvers = this.getBiome(chunk).getCarvers(stage);
//        Collection<ConfiguredCarver<?>> undergroundCarvers = this.getCavernousBiome(chunk).getCarversFor(stage);
//
//        this.applyCarvers(chunk, stage, Iterables.concat(surfaceCarvers, undergroundCarvers));
//    }

    private void applyCarvers(IChunk chunk, GenerationStage.Carving stage, Iterable<ConfiguredCarver<?>> carvers) {
        ChunkPos chunkPos = chunk.getPos();
        int chunkX = chunkPos.x;
        int chunkZ = chunkPos.z;

        SharedSeedRandom random = new SharedSeedRandom();
        BitSet mask = chunk.getCarvingMask(stage);

        for (int nz = chunkZ - 8; nz <= chunkZ + 8; nz++) {
            for (int nx = chunkX - 8; nx <= chunkX + 8; nx++) {
                int i = 0;

                for (ConfiguredCarver<?> carver : carvers) {
                    random.setLargeFeatureSeed(this.seed + i, nx, nz);
                    if (carver.shouldCarve(random, nx, nz)) {
                        carver.carve(chunk, random, this.getSeaLevel(), nx, nz, chunkX, chunkZ, mask);
                    }

                    i++;
                }
            }
        }
    }

    @Override
    public void decorate(WorldGenRegion world) {
        super.decorate(world);

        int chunkX = world.getMainChunkX();
        int chunkZ = world.getMainChunkZ();

        int minX = chunkX * 16;
        int minZ = chunkZ * 16;

        BlockPos origin = new BlockPos(minX, 220, minZ);
        HeatedBiome heatedBiome = this.getHeatedBiome(origin.getX() + 8, origin.getZ() + 8);

        SharedSeedRandom random = new SharedSeedRandom();

        long seed = random.setDecorationSeed(world.getSeed(), minX, minZ);
        for (GenerationStage.Decoration stage : GenerationStage.Decoration.values()) {
            heatedBiome.placeFeatures(stage, this, world, seed, random, origin);
        }
    }

    // TODO: spawning for cavernous biomes

    @Override
    public void spawnMobs(WorldGenRegion region) {
        int chunkX = region.getMainChunkX();
        int chunkZ = region.getMainChunkZ();

        SharedSeedRandom random = new SharedSeedRandom();
        random.setDecorationSeed(region.getSeed(), chunkX << 4, chunkZ << 4);

        // TODO: Worldgen spawning
//        if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
//            this.world.getCapability(Midnight.WORLD_SPAWNERS_CAP).ifPresent(MidnightWorldSpawners::populateChunk);
//        }
    }

    @Override
    public void func_203222_a(ServerWorld world, boolean spawnHostileMobs, boolean spawnPeacefulMobs) {
        if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
            //this.world.getCapability(Midnight.WORLD_SPAWNERS_CAP).ifPresent(MidnightWorldSpawners::spawnAroundPlayers);
        }
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EntityClassification classification, BlockPos pos) {
        if (HeatedPlacementLevelCeiling.INSTANCE.containsY(this.world, pos.getY())) {
            HeatedBiome biome = this.getHeatedBiome(pos.getX(), pos.getZ());
            return biome.getSpawnsFor(classification);
        }
        return super.getPossibleCreatures(classification, pos);
    }

    @Override
    protected void fillNoiseColumn(double[] noise, int x, int z) {
        this.noiseGenerator.populateColumnNoise(noise, x, z, this.surfaceLayers, this.undergroundLayers);
    }

    @Override
    protected double func_222545_a(double x, double z, int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected double[] getBiomeNoiseColumn(int x, int z) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getGroundHeight() {
        return this.world.getSeaLevel() + 1;
    }

    @Override
    public int getSeaLevel() {
        return SEA_LEVEL;
    }

    protected HeatedBiome getHeatedBiome(IChunk chunk) {
        ChunkPos pos = chunk.getPos();
        return this.undergroundLayers.block.sample(pos.getXStart(), pos.getZStart());
    }

    protected HeatedBiome getHeatedBiome(int x, int z) {
        return this.undergroundLayers.block.sample(x, z);
    }

    public static class Config extends GenerationSettings {
        public static Config createDefault() {
            Config config = new Config();
            config.setDefaultBlock(NetherReachesBlocks.SHADE_STONE.getDefaultState());
            config.setDefaultFluid(Blocks.WATER.getDefaultState());

            return config;
        }
    }
}
