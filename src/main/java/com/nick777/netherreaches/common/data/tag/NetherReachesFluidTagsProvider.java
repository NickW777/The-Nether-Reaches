package com.nick777.netherreaches.common.data.tag;

import com.nick777.netherreaches.common.registry.NetherReachesFluids;
import com.nick777.netherreaches.common.registry.NetherReachesTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;

public class NetherReachesFluidTagsProvider extends FluidTagsProvider {
    public NetherReachesFluidTagsProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    public void registerTags() {
        this.getBuilder(NetherReachesTags.Fluids.REACH_WATER).add(NetherReachesFluids.REACH_WATER, NetherReachesFluids.FLOWING_REACH_WATER);
        this.getBuilder(NetherReachesTags.Fluids.MAGMA).add(NetherReachesFluids.MAGMA, NetherReachesFluids.FLOWING_MAGMA);
    }

    @Override
    public String getName() {
        return "Nether Reaches Fluid Tags";
    }
}
