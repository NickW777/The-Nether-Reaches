package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.entity.creature.EngulfedEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.LightType;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.ObjectHolder;

import java.util.Random;

import static com.nick777.netherreaches.NetherReaches.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(MODID)
public class NetherReachesEntities {
    public static final EntityType<EngulfedEntity> ENGULFED = EntityType.Builder.create(EngulfedEntity::new, EntityClassification.CREATURE)
            .setTrackingRange(80)
            .setUpdateInterval(3)
            .setShouldReceiveVelocityUpdates(true)
            .size(0.9f, 1.87f)
            .build(MODID + ":engulfed");

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ENGULFED.setRegistryName(MODID, "engulfed");
        event.getRegistry().register(ENGULFED);
        EntitySpawnPlacementRegistry.register(ENGULFED, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, NetherReachesEntities::mobCondition);
    }

    private static boolean fishCondition(EntityType<? extends AbstractFishEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos).getBlock() == NetherReachesBlocks.REACH_WATER && (world.getBlockState(pos.down()).getBlock() == NetherReachesBlocks.REACH_WATER || world.getBlockState(pos.up()).getBlock() == NetherReachesBlocks.REACH_WATER);
    }

    private static boolean monsterCondition(EntityType<? extends MonsterEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getDifficulty() != Difficulty.PEACEFUL && mobCondition(entityType, world, spawnReason, pos, random); // && lightCondition(world, pos, random)
    }

    private static boolean mobCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random) {
        BlockPos blockpos = pos.down();
        return spawnReason == SpawnReason.SPAWNER || world.getWorld().getBlockState(blockpos).canEntitySpawn(world, blockpos, entityType);
    }

    // unused
    private static boolean lightCondition(IWorld world, BlockPos pos, Random random) {
        if (world.getLightFor(LightType.SKY, pos) > random.nextInt(32)) {
            return false;
        } else {
            int i = world.getWorld().isThundering() ? world.getNeighborAwareLightSubtracted(pos, 10) : world.getLight(pos);
            return i <= random.nextInt(8);
        }
    }

    public static Item registerEntitySpawnEgg(EntityType<?> type, int primColor, int secColor, String name) {
        SpawnEggItem item = new SpawnEggItem(type, primColor, secColor, new Item.Properties().group(NetherReachesItemGroups.ITEM));
        item.setRegistryName(GameData.checkPrefix(name, false));
        return item;
    }

    public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                NetherReachesItems.ENGULFED_SPAWN_EGG = registerEntitySpawnEgg(ENGULFED, 0x8a0a01, 0xd9473d, "engulfed_spawn_egg")
        );
    }

    /*
    public static EntityType<?> ENGULFED = EntityType.Builder.create(EngulfedEntity::new, EntityClassification.CREATURE).build(NetherReaches.MODID + ":engulfed").setRegistryName(GameData.checkPrefix("engulfed", false));



    public static void registerEntityWorldSpawns() {
        registerEntityWorldSpawn(ENGULFED,NetherReachesHeatedBiomes.FLAME_FOREST);
    }



    public static void registerEntityWorldSpawn(EntityType<?> entity, HeatedBiome... biomes) {
        for (HeatedBiome biome : biomes) {
            if (biome != null) {
                biome.getSpawnsFor(entity.getClassification()).add(new Biome.SpawnListEntry(entity,100,1,3));
            }
        }
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(
                NetherReachesEntities.ENGULFED
        );
        registerEntityWorldSpawns();
    }
    */
}
