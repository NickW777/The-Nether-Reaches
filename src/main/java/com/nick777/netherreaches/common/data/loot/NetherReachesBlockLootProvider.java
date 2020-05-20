package com.nick777.netherreaches.common.data.loot;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesItems;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.*;
import net.minecraft.world.storage.loot.functions.ApplyBonus;
import net.minecraft.world.storage.loot.functions.CopyName;
import net.minecraft.world.storage.loot.functions.ExplosionDecay;
import net.minecraft.world.storage.loot.functions.SetCount;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class NetherReachesBlockLootProvider extends NetherReachesLootTableProvider {
    private static final IRandomRange ONE = ConstantRange.of(1);

    private final Map<Block, LootTable.Builder> lootTables = new HashMap<>();

    public NetherReachesBlockLootProvider(DataGenerator generator) {
        super(generator, LootParameterSets.BLOCK);
    }

    @Override
    protected void addTables(LootConsumer consumer) {
        this.add(NetherReachesBlocks.SHADE_STONE);
        this.add(NetherReachesBlocks.SHADE_STONE_BRICKS);
        this.add(NetherReachesBlocks.CRACKED_SHADE_STONE_BRICKS);
        this.add(NetherReachesBlocks.MOSSY_SHADE_STONE_BRICKS);
        this.add(NetherReachesBlocks.MOSSY_CRACKED_SHADE_STONE_BRICKS);

        this.add(NetherReachesBlocks.SHINE_STONE);
        this.add(NetherReachesBlocks.SHINE_STONE_BRICKS);
        this.add(NetherReachesBlocks.CRACKED_SHINE_STONE_BRICKS);
        this.add(NetherReachesBlocks.MOSSY_SHADE_STONE_BRICKS);
        this.add(NetherReachesBlocks.MOSSY_CRACKED_SHADE_STONE_BRICKS);

        this.add(NetherReachesBlocks.BLIGHT_SHROOM_BARK);
        this.add(NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_BARK);
        this.add(NetherReachesBlocks.BLIGHT_SHROOM_BUTTON);
        this.add(NetherReachesBlocks.BLIGHT_SHROOM_FENCE);
        this.add(NetherReachesBlocks.BLIGHT_SHROOM_FENCE_GATE);
        this.add(NetherReachesBlocks.BLIGHT_SHROOM_LADDER);
        this.add(NetherReachesBlocks.BLIGHT_SHROOM_PLANKS);
        this.add(NetherReachesBlocks.BLIGHT_SHROOM_PRESSURE_PLATE);
        this.add(NetherReachesBlocks.BLIGHT_SHROOM_SAPLING);
        this.add(NetherReachesBlocks.BLIGHT_SHROOM_SLAB);
        this.add(NetherReachesBlocks.BLIGHT_SHROOM_STAIRS);
        this.add(NetherReachesBlocks.BLIGHT_SHROOM_STEM);
        this.add(NetherReachesBlocks.STRIPPED_BLIGHT_SHROOM_STEM);
        this.add(NetherReachesBlocks.BLIGHT_SHROOM_TRAPDOOR);

        this.add(NetherReachesBlocks.CINDER_SHROOM_BARK);
        this.add(NetherReachesBlocks.STRIPPED_CINDER_SHROOM_BARK);
        this.add(NetherReachesBlocks.CINDER_SHROOM_BUTTON);
        this.add(NetherReachesBlocks.CINDER_SHROOM_FENCE);
        this.add(NetherReachesBlocks.CINDER_SHROOM_FENCE_GATE);
        this.add(NetherReachesBlocks.CINDER_SHROOM_LADDER);
        this.add(NetherReachesBlocks.CINDER_SHROOM_PLANKS);
        this.add(NetherReachesBlocks.CINDER_SHROOM_PRESSURE_PLATE);
        this.add(NetherReachesBlocks.CINDER_SHROOM_SAPLING);
        this.add(NetherReachesBlocks.CINDER_SHROOM_SLAB);
        this.add(NetherReachesBlocks.CINDER_SHROOM_STAIRS);
        this.add(NetherReachesBlocks.CINDER_SHROOM_STEM);
        this.add(NetherReachesBlocks.STRIPPED_CINDER_SHROOM_STEM);
        this.add(NetherReachesBlocks.CINDER_SHROOM_TRAPDOOR);

        this.add(NetherReachesBlocks.SHADE_SHROOM_BARK);
        this.add(NetherReachesBlocks.STRIPPED_SHADE_SHROOM_BARK);
        this.add(NetherReachesBlocks.SHADE_SHROOM_BUTTON);
        this.add(NetherReachesBlocks.SHADE_SHROOM_FENCE);
        this.add(NetherReachesBlocks.SHADE_SHROOM_FENCE_GATE);
        this.add(NetherReachesBlocks.SHADE_SHROOM_LADDER);
        this.add(NetherReachesBlocks.SHADE_SHROOM_PLANKS);
        this.add(NetherReachesBlocks.SHADE_SHROOM_PRESSURE_PLATE);
        this.add(NetherReachesBlocks.SHADE_SHROOM_SAPLING);
        this.add(NetherReachesBlocks.SHADE_SHROOM_SLAB);
        this.add(NetherReachesBlocks.SHADE_SHROOM_STAIRS);
        this.add(NetherReachesBlocks.SHADE_SHROOM_STEM);
        this.add(NetherReachesBlocks.STRIPPED_SHADE_SHROOM_STEM);
        this.add(NetherReachesBlocks.SHADE_SHROOM_TRAPDOOR);

        this.add(NetherReachesBlocks.SHOCK_SHROOM_BARK);
        this.add(NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_BARK);
        this.add(NetherReachesBlocks.SHOCK_SHROOM_BUTTON);
        this.add(NetherReachesBlocks.SHOCK_SHROOM_FENCE);
        this.add(NetherReachesBlocks.SHOCK_SHROOM_FENCE_GATE);
        this.add(NetherReachesBlocks.SHOCK_SHROOM_LADDER);
        this.add(NetherReachesBlocks.SHOCK_SHROOM_PLANKS);
        this.add(NetherReachesBlocks.SHOCK_SHROOM_PRESSURE_PLATE);
        this.add(NetherReachesBlocks.SHOCK_SHROOM_SAPLING);
        this.add(NetherReachesBlocks.SHOCK_SHROOM_SLAB);
        this.add(NetherReachesBlocks.SHOCK_SHROOM_STAIRS);
        this.add(NetherReachesBlocks.SHOCK_SHROOM_STEM);
        this.add(NetherReachesBlocks.STRIPPED_SHOCK_SHROOM_STEM);
        this.add(NetherReachesBlocks.SHOCK_SHROOM_TRAPDOOR);

        this.add(NetherReachesBlocks.TANGLE_SHROOM_BARK);
        this.add(NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_BARK);
        this.add(NetherReachesBlocks.TANGLE_SHROOM_BUTTON);
        this.add(NetherReachesBlocks.TANGLE_SHROOM_FENCE);
        this.add(NetherReachesBlocks.TANGLE_SHROOM_FENCE_GATE);
        this.add(NetherReachesBlocks.TANGLE_SHROOM_LADDER);
        this.add(NetherReachesBlocks.TANGLE_SHROOM_PLANKS);
        this.add(NetherReachesBlocks.TANGLE_SHROOM_PRESSURE_PLATE);
        this.add(NetherReachesBlocks.TANGLE_SHROOM_SAPLING);
        this.add(NetherReachesBlocks.TANGLE_SHROOM_SLAB);
        this.add(NetherReachesBlocks.TANGLE_SHROOM_STAIRS);
        this.add(NetherReachesBlocks.TANGLE_SHROOM_STEM);
        this.add(NetherReachesBlocks.STRIPPED_TANGLE_SHROOM_STEM);
        this.add(NetherReachesBlocks.TANGLE_SHROOM_TRAPDOOR);

        this.add(NetherReachesBlocks.TOXIC_SHROOM_BARK);
        this.add(NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_BARK);
        this.add(NetherReachesBlocks.TOXIC_SHROOM_BUTTON);
        this.add(NetherReachesBlocks.TOXIC_SHROOM_FENCE);
        this.add(NetherReachesBlocks.TOXIC_SHROOM_FENCE_GATE);
        this.add(NetherReachesBlocks.TOXIC_SHROOM_LADDER);
        this.add(NetherReachesBlocks.TOXIC_SHROOM_PLANKS);
        this.add(NetherReachesBlocks.TOXIC_SHROOM_PRESSURE_PLATE);
        this.add(NetherReachesBlocks.TOXIC_SHROOM_SAPLING);
        this.add(NetherReachesBlocks.TOXIC_SHROOM_SLAB);
        this.add(NetherReachesBlocks.TOXIC_SHROOM_STAIRS);
        this.add(NetherReachesBlocks.TOXIC_SHROOM_STEM);
        this.add(NetherReachesBlocks.STRIPPED_TOXIC_SHROOM_STEM);
        this.add(NetherReachesBlocks.TOXIC_SHROOM_TRAPDOOR);

        this.add(NetherReachesBlocks.AQUANE_SHELF_SHROOM_CORE);
        this.add(NetherReachesBlocks.AQUANE_SHELF_SHROOM_CRUST);
        this.add(NetherReachesBlocks.AQUANE_SHELF_SHROOM_PASTE);

        this.add(NetherReachesBlocks.CRELENOR_SHELF_SHROOM_CORE);
        this.add(NetherReachesBlocks.CRELENOR_SHELF_SHROOM_CRUST);
        this.add(NetherReachesBlocks.CRELENOR_SHELF_SHROOM_PASTE);

        this.add(NetherReachesBlocks.GREJAR_SHELF_SHROOM_CORE);
        this.add(NetherReachesBlocks.GREJAR_SHELF_SHROOM_CRUST);
        this.add(NetherReachesBlocks.GREJAR_SHELF_SHROOM_PASTE);

        this.add(NetherReachesBlocks.MOISE_SHELF_SHROOM_CORE);
        this.add(NetherReachesBlocks.MOISE_SHELF_SHROOM_CRUST);
        this.add(NetherReachesBlocks.MOISE_SHELF_SHROOM_PASTE);

        this.add(NetherReachesBlocks.SABLE_SHELF_SHROOM_CORE);
        this.add(NetherReachesBlocks.SABLE_SHELF_SHROOM_CRUST);
        this.add(NetherReachesBlocks.SABLE_SHELF_SHROOM_PASTE);

        this.add(NetherReachesBlocks.ILLIA_ORE);
        this.add(NetherReachesBlocks.REGITE_ORE);
        this.add(NetherReachesBlocks.SHARNIK_ORE);
        this.add(NetherReachesBlocks.BERNEG_BLOCK);
        this.add(NetherReachesBlocks.FARON_BLOCK);
        this.add(NetherReachesBlocks.ILLIA_BLOCK);
        this.add(NetherReachesBlocks.REGITE_BLOCK);
        this.add(NetherReachesBlocks.SHARNIK_BLOCK);
        this.add(NetherReachesBlocks.BLACK_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.BLUE_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.BROWN_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.CYAN_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.GRAY_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.GREEN_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.LIGHT_BLUE_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.LIGHT_GRAY_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.LIME_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.MAGENTA_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.ORANGE_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.PINK_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.PURPLE_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.RED_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.WHITE_REACHCRYSTAL_LANTERN);
        this.add(NetherReachesBlocks.YELLOW_REACHCRYSTAL_LANTERN);

        this.addDoubleBlock(NetherReachesBlocks.BLIGHT_SHROOM_DOOR);
        this.addDoubleBlock(NetherReachesBlocks.CINDER_SHROOM_DOOR);
        this.addDoubleBlock(NetherReachesBlocks.SHADE_SHROOM_DOOR);
        this.addDoubleBlock(NetherReachesBlocks.SHOCK_SHROOM_DOOR);
        this.addDoubleBlock(NetherReachesBlocks.TANGLE_SHROOM_DOOR);
        this.addDoubleBlock(NetherReachesBlocks.TOXIC_SHROOM_DOOR);

        this.addLeaves(NetherReachesBlocks.BLIGHT_SHROOM_CAP,NetherReachesBlocks.BLIGHT_SHROOM_SAPLING, NetherReachesItems.BLIGHT_STICK);
        this.addLeaves(NetherReachesBlocks.CINDER_SHROOM_CAP,NetherReachesBlocks.CINDER_SHROOM_SAPLING, NetherReachesItems.CINDER_STICK);
        this.addLeaves(NetherReachesBlocks.SHADE_SHROOM_CAP,NetherReachesBlocks.SHADE_SHROOM_SAPLING, NetherReachesItems.SHADE_STICK);
        this.addLeaves(NetherReachesBlocks.SHOCK_SHROOM_CAP,NetherReachesBlocks.SHOCK_SHROOM_SAPLING, NetherReachesItems.SHOCK_STICK);
        this.addLeaves(NetherReachesBlocks.TANGLE_SHROOM_CAP,NetherReachesBlocks.TANGLE_SHROOM_SAPLING, NetherReachesItems.TANGLE_STICK);
        this.addLeaves(NetherReachesBlocks.TOXIC_SHROOM_CAP,NetherReachesBlocks.TOXIC_SHROOM_SAPLING, NetherReachesItems.TOXIC_STICK);

        this.addGem(NetherReachesBlocks.BERNEG_ORE, NetherReachesItems.BERNEG);
        this.addGem(NetherReachesBlocks.FARON_ORE, NetherReachesItems.FARON);

        this.addWithCountAndBonus(NetherReachesBlocks.BLACK_REACHCRYSTAL,NetherReachesItems.BLACK_REACHCRYSTAL_SHARD,RandomValueRange.of(1,3));
        this.addWithCountAndBonus(NetherReachesBlocks.BLUE_REACHCRYSTAL,NetherReachesItems.BLUE_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.BROWN_REACHCRYSTAL,NetherReachesItems.BROWN_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.CYAN_REACHCRYSTAL,NetherReachesItems.CYAN_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.GRAY_REACHCRYSTAL,NetherReachesItems.GRAY_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.GREEN_REACHCRYSTAL,NetherReachesItems.GREEN_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.LIGHT_BLUE_REACHCRYSTAL,NetherReachesItems.LIGHT_BLUE_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.LIGHT_GRAY_REACHCRYSTAL,NetherReachesItems.LIGHT_GRAY_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.LIME_REACHCRYSTAL,NetherReachesItems.LIME_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.MAGENTA_REACHCRYSTAL,NetherReachesItems.MAGENTA_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.ORANGE_REACHCRYSTAL,NetherReachesItems.ORANGE_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.PINK_REACHCRYSTAL,NetherReachesItems.PINK_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.PURPLE_REACHCRYSTAL,NetherReachesItems.PURPLE_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.RED_REACHCRYSTAL,NetherReachesItems.RED_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.WHITE_REACHCRYSTAL,NetherReachesItems.WHITE_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));
        this.addWithCountAndBonus(NetherReachesBlocks.YELLOW_REACHCRYSTAL,NetherReachesItems.YELLOW_REACHCRYSTAL_SHARD,RandomValueRange.of(1, 3));

        this.lootTables.forEach(consumer::accept);
    }

    private static <T> T explosionDecay(ILootFunctionConsumer<T> consumer) {
        return consumer.acceptFunction(ExplosionDecay.builder());
    }

    private static <T> T checkExplosion(ILootConditionConsumer<T> consumer) {
        return consumer.acceptCondition(SurvivesExplosion.builder());
    }

    private static LootTable.Builder drop(IItemProvider item) {
        return LootTable.builder()
                .addLootPool(checkExplosion(LootPool.builder()
                        .rolls(ONE)
                        .addEntry(ItemLootEntry.builder(item))
                ));
    }

    private static LootTable.Builder dropIf(IItemProvider item, ILootCondition.IBuilder condition) {
        return LootTable.builder()
                .addLootPool(checkExplosion(LootPool.builder()
                        .rolls(ONE)
                        .addEntry(ItemLootEntry.builder(item))
                        .acceptCondition(condition)
                ));
    }

    private static LootTable.Builder selfOrAlternative(Block block, ILootCondition.IBuilder condition, LootEntry.Builder<?> alternative) {
        return LootTable.builder().addLootPool(LootPool.builder()
                .addEntry(ItemLootEntry.builder(block).acceptCondition(condition).alternatively(alternative))
                .rolls(ONE)
        );
    }

    private static LootTable.Builder silkTouched(Block block, LootEntry.Builder<?> alternative) {
        return selfOrAlternative(block, Conditions.HAS_SILK_TOUCH, alternative);
    }

    private static LootTable.Builder silkOrSheared(Block block, LootEntry.Builder<?> alternative) {
        return selfOrAlternative(block, Conditions.HAS_SHEARS_OR_SILK_TOUCH, alternative);
    }

    private static LootTable.Builder copyName(Block block) {
        return LootTable.builder().addLootPool(checkExplosion(LootPool.builder()
                .rolls(ONE)
                .addEntry(ItemLootEntry.builder(block).acceptFunction(CopyName.builder(CopyName.Source.BLOCK_ENTITY)))
        ));
    }

    private void add(Block block, Function<Block, LootTable.Builder> function) {
        this.add(block, function.apply(block));
    }

    private void add(Block block, LootTable.Builder table) {
        this.lootTables.put(block, table);
    }

    private void add(Block block, IItemProvider item) {
        this.add(block, drop(item));
    }

    private void add(Block block) {
        this.add(block, block);
    }

    private void addSilkTouchedAlternative(Block block, IItemProvider drop) {
        this.add(block, silkTouched(block, ItemLootEntry.builder(drop)));
    }

    private void addSilkTouched(Block block) {
        this.add(block, dropIf(block, Conditions.HAS_SILK_TOUCH));
    }

    private void addSheared(Block block, IItemProvider drop) {
        this.add(block, dropIf(drop, Conditions.HAS_SHEARS));
    }

    private void addSheared(Block block) {
        this.addSheared(block, block);
    }

    private void addSlab(Block block) {
        ILootCondition.IBuilder isDouble = BlockStateProperty.builder(block).with(SlabBlock.TYPE, SlabType.DOUBLE);
        LootFunction.Builder<?> doubleFunction = SetCount.builder(ConstantRange.of(2)).acceptCondition(isDouble);

        LootTable.Builder table = LootTable.builder().addLootPool(LootPool.builder()
                .addEntry(explosionDecay(ItemLootEntry.builder(block).acceptFunction(doubleFunction)))
                .rolls(ONE)
        );

        this.add(block, table);
    }

    private void addGem(Block block, IItemProvider gem) {
        LootTable.Builder table = silkTouched(block, explosionDecay(
                ItemLootEntry.builder(gem).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))
        ));

        this.add(block, table);
    }

    private void addFungiCap(Block block, IItemProvider fungi, IItemProvider powder) {
        LootPool.Builder pool = LootPool.builder()
                .addEntry(AlternativesLootEntry.builder(
                        ItemLootEntry.builder(fungi).acceptCondition(RandomChance.builder(0.5F)),
                        ItemLootEntry.builder(powder)
                ))
                .rolls(ONE);

        this.add(block, LootTable.builder().addLootPool(explosionDecay(pool)));
    }

    private void addLeaves(Block block, IItemProvider sapling, IItemProvider stick) {
        LootTable.Builder table = silkOrSheared(block, checkExplosion(ItemLootEntry.builder(sapling))
                .acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.05F, 0.0625F, 0.08F, 0.1F)))
                .addLootPool(LootPool.builder()
                        .acceptCondition(Conditions.NOT_SHEARS_OR_SILK_TOUCH)
                        .addEntry(explosionDecay(ItemLootEntry.builder(stick)
                                .acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 2.0F))))
                                .acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.02F, 0.02F, 0.025F, 0.03F, 0.1F))
                        )
                        .rolls(ONE)
                );

        this.add(block, table);
    }

    private void addDoubleBlock(Block block) {
        LootTable.Builder table = LootTable.builder()
                .addLootPool(checkExplosion(LootPool.builder()
                        .rolls(ONE)
                        .addEntry(ItemLootEntry.builder(block))
                        .acceptCondition(BlockStateProperty.builder(block).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER))
                ));

        this.add(block, table);
    }

    private void addShearedDoubleBlock(Block block) {
        LootTable.Builder table = LootTable.builder()
                .addLootPool(checkExplosion(LootPool.builder()
                        .rolls(ONE)
                        .addEntry(ItemLootEntry.builder(block))
                        .acceptCondition(BlockStateProperty.builder(block).with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER))
                        .acceptCondition(Conditions.HAS_SHEARS)
                ));

        this.add(block, table);
    }

    private void addWithCountAndBonus(Block block, IItemProvider item, IRandomRange count) {
        LootTable.Builder table = silkTouched(block, explosionDecay(
                ItemLootEntry.builder(item)
                        .acceptFunction(SetCount.builder(count))
                        .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
        ));

        this.add(block, table);
    }
}
