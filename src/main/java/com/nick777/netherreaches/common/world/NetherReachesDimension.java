package com.nick777.netherreaches.common.world;

import com.nick777.netherreaches.common.biome.BiomeLayerType;
import com.nick777.netherreaches.common.biome.BiomeLayers;
import com.nick777.netherreaches.common.biome.damp.DampBiome;
import com.nick777.netherreaches.common.biome.heated.HeatedBiome;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class NetherReachesDimension extends Dimension {
    public NetherReachesDimension(World world, DimensionType type) {
        super(world, type);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        long seed = this.world.getSeed();

        BiomeLayers<Biome> hangingLayers = BiomeLayerType.HANGING.make(seed);
        BiomeLayers<HeatedBiome> heatedLayers = BiomeLayerType.HEATED.make(seed);
        BiomeLayers<DampBiome> dampLayers = BiomeLayerType.DAMP.make(seed);

        return new NetherReachesChunkGenerator(this.world, hangingLayers, heatedLayers, dampLayers, NetherReachesChunkGenerator.Config.createDefault());
    }

    @Nullable
    @Override
    public BlockPos findSpawn(ChunkPos chunk, boolean checkValid) {
        return null;
    }

    @Nullable
    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        return null;
    }

    @Override
    public int getActualHeight() {
        return 256;
    }

    @Override
    public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
        return SleepResult.BED_EXPLODES;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public boolean shouldMapSpin(String entity, double x, double z, double rotation) {
        return true;
    }

    @Override
    protected void generateLightBrightnessTable() {
        float baseLight = 0.06F;
        for (int i = 0; i <= 15; ++i) {
            float alpha = 1.0F - i / 15.0F;
            float brightness = (1.0F - alpha) / (alpha * 10.0F + 1.0F);
            this.lightBrightnessTable[i] = (float) (Math.pow(brightness, 2.5F) * 3.0F) + baseLight;
        }
    }

    @Override
    public void getLightmapColors(float partialTicks, float sunBrightness, float skyLight, float blockLight, float[] colors) {
        colors[0] = blockLight * 0.93F + 0.07F;
        colors[1] = blockLight * 0.96F + 0.03F;
        colors[2] = blockLight * 0.94F + 0.16F;
 //       if (this.world.getLastLightningBolt() > 0) {
 //           float undergroundFactor = (float) MidnightAtmosphereController.INSTANCE.getUndergroundFactor();
 //           colors[0] = MathHelper.lerp(undergroundFactor, 0.95F, colors[0]);
 //           colors[1] = MathHelper.lerp(undergroundFactor, 0.3F, colors[1]);
 //           colors[2] = MathHelper.lerp(undergroundFactor, 0.3F, colors[2]);
 //       }
    }

    @Override
    public boolean isDaytime() {
        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public float getSunBrightness(float partialTicks) {
        return 0.0F;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isSkyColored() {
        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return NetherReachesAtmosphereController.INSTANCE.computeSkyColor();
    }

    @Override
    public Vec3d getSkyColor(BlockPos cameraPos, float partialTicks) {
        return NetherReachesAtmosphereController.INSTANCE.computeSkyColor();
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0.5F;
    }

    @Override
    public void calculateInitialWeather() {
    }

    @Override
    public boolean canDoLightning(Chunk chunk) {
        return false;
    }

    @Override
    public boolean canRespawnHere() {
        return true;
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

    @Override
    public double getVoidFogYFactor() {
        return 1.0;
    }

//    @Nullable
//    @Override
//    public IRenderHandler getSkyRenderer() {
//        return MidnightSkyRenderer.INSTANCE;
//    }
}
