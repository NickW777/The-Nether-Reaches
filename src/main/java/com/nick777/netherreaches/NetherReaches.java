package com.nick777.netherreaches;

import com.nick777.netherreaches.client.ClientProxy;
import com.nick777.netherreaches.client.model.NetherReachesModelRegistry;
import com.nick777.netherreaches.common.ServerProxy;
import com.nick777.netherreaches.common.data.loot.NetherReachesBlockLootProvider;
import com.nick777.netherreaches.common.data.recipe.NetherReachesCrystalRecipes;
import com.nick777.netherreaches.common.data.recipe.NetherReachesMaterialRecipes;
import com.nick777.netherreaches.common.data.recipe.NetherReachesWoodenRecipes;
import com.nick777.netherreaches.common.data.tag.NetherReachesBlockTagsProvider;
import com.nick777.netherreaches.common.data.tag.NetherReachesFluidTagsProvider;
import com.nick777.netherreaches.common.data.tag.NetherReachesItemTagsProvider;
import com.nick777.netherreaches.common.registry.NetherReachesHangingBiomes;
import com.nick777.netherreaches.common.registry.NetherReachesHeatedBiomes;
import com.nick777.netherreaches.common.util.IProxy;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("netherreaches")
public class NetherReaches
{
    public static final String MODID = "netherreaches";
    public static final String NETWORK_PROTOCOL = "1";

    public static final Logger LOGGER = LogManager.getLogger(NetherReaches.class);
    public static final IProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(MODID, "net"))
            .networkProtocolVersion(() -> NETWORK_PROTOCOL)
            .clientAcceptedVersions(NETWORK_PROTOCOL::equals)
            .serverAcceptedVersions(NETWORK_PROTOCOL::equals)
            .simpleChannel();
    public NetherReaches() {
//        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MidnightConfig.CLIENT_SPEC);
//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MidnightConfig.GENERAL_SPEC);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);
        bus.addListener(this::registerModels);
        bus.addListener(this::gatherData);
    }

    private void setup(FMLCommonSetupEvent event) {
    //    CapabilityManager.INSTANCE.register(RiftTraveller.class, new NullStorage<>(), RiftTraveller::new);
    //    CapabilityManager.INSTANCE.register(RifterCapturable.class, new NullStorage<>(), RifterCapturable::new);
    //    CapabilityManager.INSTANCE.register(AnimationCapability.class, new NullStorage<>(), AnimationCapability::new);

   //     EntityUtil.register();

  //      LootConditionManager.registerCondition(new InBiomeLootCondition.Serializer());
   //     LootConditionManager.registerCondition(new InBlockLootCondition.Serializer());
   //     LootConditionManager.registerCondition(new IsChildLootCondition.Serializer());

        NetherReachesHangingBiomes.onInit();
        NetherReachesHeatedBiomes.onInit();

//        BiomeLayerRenderer.renderDebug();
    }

    private void registerModels(ModelRegistryEvent event) {
        NetherReachesModelRegistry.registerModels(event);
    }

    private void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            generator.addProvider(new NetherReachesBlockTagsProvider(generator));
            generator.addProvider( new NetherReachesItemTagsProvider(generator));
            generator.addProvider(new NetherReachesFluidTagsProvider(generator));

            generator.addProvider(new NetherReachesCrystalRecipes(generator));
            generator.addProvider(new NetherReachesMaterialRecipes(generator));
            generator.addProvider(new NetherReachesWoodenRecipes(generator));

            generator.addProvider(new NetherReachesBlockLootProvider(generator));
        }
    }
}
