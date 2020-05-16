package com.nick777.netherreaches.common.registry;

import com.nick777.netherreaches.common.world.feature.placement.CountHangingPlacement;
import com.nick777.netherreaches.common.world.feature.placement.CountHeatedPlacement;
import com.nick777.netherreaches.common.world.feature.placement.HangingPlacementLevelCeiling;
import com.nick777.netherreaches.common.world.feature.placement.HeatedPlacementLevelCeiling;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import static com.nick777.netherreaches.NetherReaches.MODID;

// TODO: Register from correct event when Forge is fixed
@ObjectHolder(MODID)
public class NetherReachesPlacements {

    public static final Placement<FrequencyConfig> COUNT_HEATED = new CountHeatedPlacement(FrequencyConfig::deserialize, HeatedPlacementLevelCeiling.INSTANCE);

    public static final Placement<FrequencyConfig> COUNT_HANGING = new CountHangingPlacement(FrequencyConfig::deserialize, HangingPlacementLevelCeiling.INSTANCE);

    public static void registerPlacements(IForgeRegistry<Placement<?>> registry) {
        RegUtil.generic(registry)
                .add("count_heated", COUNT_HEATED)
                .add("count_hanging", COUNT_HANGING);
    }
}
