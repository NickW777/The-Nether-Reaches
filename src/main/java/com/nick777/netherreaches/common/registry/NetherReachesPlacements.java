package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.world.gen.feature.placement.*;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import static com.nick777.netherreaches.NetherReaches.MODID;

@ObjectHolder(MODID)
public class NetherReachesPlacements {

    public static final Placement<FrequencyConfig> COUNT_HEATED_FLOOR = new CountHeatedPlacement(FrequencyConfig::deserialize, HeatedPlacementLevelFloor.INSTANCE);
    public static final Placement<FrequencyConfig> COUNT_HEATED_CEILING = new CountHeatedPlacement(FrequencyConfig::deserialize, HeatedPlacementLevelCeiling.INSTANCE);

    public static final Placement<FrequencyConfig> COUNT_HANGING_FLOOR = new CountHangingPlacement(FrequencyConfig::deserialize, HangingPlacementLevelFloor.INSTANCE);
    public static final Placement<FrequencyConfig> COUNT_HANGING_CEILING = new CountHangingPlacement(FrequencyConfig::deserialize, HangingPlacementLevelCeiling.INSTANCE);


    public static void registerPlacements(IForgeRegistry<Placement<?>> registry) {
        RegUtil.generic(registry)
                .add("count_heated_floor", COUNT_HEATED_FLOOR)
                .add("count_heated_ceiling", COUNT_HEATED_CEILING)
                .add("count_hanging_floor", COUNT_HANGING_FLOOR)
                .add("count_hanging_ceiling", COUNT_HANGING_CEILING);
    }
}
