package com.nick777.netherreaches.common.event;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.nick777.netherreaches.NetherReaches.MODID;

@Mod.EventBusSubscriber
public class NetherReachesFuelEventHandler {
    public static final NetherReachesFuelEventHandler instance = new NetherReachesFuelEventHandler();

    private NetherReachesFuelEventHandler() {}

    @SubscribeEvent

    public static void onFurnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
        ItemStack fuelStack = event.getItemStack();
        Item fuel = fuelStack.getItem();

        ResourceLocation shroomButtons = new ResourceLocation(MODID, "shroom_buttons");
        ResourceLocation shroomDoors = new ResourceLocation(MODID, "shroom_doors");
        ResourceLocation shroomFences = new ResourceLocation(MODID, "shroom_fences");
        ResourceLocation shroomFenceGates = new ResourceLocation(MODID, "shroom_fence_gates");
        ResourceLocation shroomPlanks = new ResourceLocation(MODID, "shroom_planks");
        ResourceLocation shroomPressurePlates = new ResourceLocation(MODID, "shroom_pressure_plates");
        ResourceLocation shroomSaplings = new ResourceLocation(MODID, "shroom_saplings");
        ResourceLocation shroomSlabs = new ResourceLocation(MODID, "shroom_slabs");
        ResourceLocation shroomStairs = new ResourceLocation(MODID, "shroom_stairs");
        ResourceLocation shroomSticks = new ResourceLocation(MODID, "shroom_sticks");
        ResourceLocation shroomTrapdoors = new ResourceLocation(MODID, "shroom_trapdoors");
        ResourceLocation shadeShroomStems = new ResourceLocation(MODID, "shade_shroom_stems");
        ResourceLocation shockShroomStems = new ResourceLocation(MODID, "shock_shroom_stems");

        if (ItemTags.getCollection().get(shroomButtons).contains(fuel)) {
            event.setBurnTime(100);
        } else if (ItemTags.getCollection().get(shroomDoors).contains(fuel)) {
            event.setBurnTime(200);
        } else if (ItemTags.getCollection().get(shroomFences).contains(fuel)) {
            event.setBurnTime(300);
        } else if (ItemTags.getCollection().get(shroomFenceGates).contains(fuel)) {
            event.setBurnTime(300);
        } else if (ItemTags.getCollection().get(shroomPlanks).contains(fuel)) {
            event.setBurnTime(300);
        } else if (ItemTags.getCollection().get(shroomPressurePlates).contains(fuel)) {
            event.setBurnTime(300);
        } else if (ItemTags.getCollection().get(shroomSaplings).contains(fuel)) {
            event.setBurnTime(100);
        } else if (ItemTags.getCollection().get(shroomSlabs).contains(fuel)) {
            event.setBurnTime(150);
        } else if (ItemTags.getCollection().get(shroomStairs).contains(fuel)) {
            event.setBurnTime(300);
        } else if (ItemTags.getCollection().get(shroomSticks).contains(fuel)) {
            event.setBurnTime(100);
        } else if (ItemTags.getCollection().get(shroomTrapdoors).contains(fuel)) {
            event.setBurnTime(300);
        } else if (ItemTags.getCollection().get(shadeShroomStems).contains(fuel)) {
            event.setBurnTime(300);
        } else if (ItemTags.getCollection().get(shockShroomStems).contains(fuel)) {
            event.setBurnTime(300);
        } else if (fuel == NetherReachesItems.FARON) {
            event.setBurnTime(2000);
        } else if (fuel == NetherReachesBlocks.FARON_BLOCK.asItem()) {
            event.setBurnTime(20000);
        }
    }
}
