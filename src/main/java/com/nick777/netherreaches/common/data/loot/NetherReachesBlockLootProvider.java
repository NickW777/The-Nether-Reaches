package com.nick777.netherreaches.common.data.loot;

import com.nick777.netherreaches.common.registry.NetherReachesBlocks;
import com.nick777.netherreaches.common.registry.NetherReachesItems;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.storage.loot.AlternativesLootEntry;
import net.minecraft.world.storage.loot.ConstantRange;
import net.minecraft.world.storage.loot.ILootConditionConsumer;
import net.minecraft.world.storage.loot.ILootFunctionConsumer;
import net.minecraft.world.storage.loot.IRandomRange;
import net.minecraft.world.storage.loot.ItemLootEntry;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootFunction;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.BlockStateProperty;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraft.world.storage.loot.conditions.SurvivesExplosion;
import net.minecraft.world.storage.loot.conditions.TableBonus;
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
        this.add(NetherReachesBlocks.SHADE_SHROOM_PLANKS);
        this.add(NetherReachesBlocks.SHADE_SHROOM_STEM);
        this.add(NetherReachesBlocks.SHADE_SHROOM_SAPLING);
        this.add(NetherReachesBlocks.ILLIA_ORE);
        this.add(NetherReachesBlocks.REGITE_ORE);
        this.add(NetherReachesBlocks.SHARNIK_ORE);
        this.add(NetherReachesBlocks.BERNEG_BLOCK);
        this.add(NetherReachesBlocks.FARON_BLOCK);
        this.add(NetherReachesBlocks.ILLIA_BLOCK);
        this.add(NetherReachesBlocks.REGITE_BLOCK);
        this.add(NetherReachesBlocks.SHARNIK_BLOCK);
        this.addLeaves(NetherReachesBlocks.SHADE_SHROOM_CAP,NetherReachesBlocks.SHADE_SHROOM_SAPLING);
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

    private void addLeaves(Block block, IItemProvider sapling) {
        LootTable.Builder table = silkOrSheared(block, checkExplosion(ItemLootEntry.builder(sapling))
                .acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.05F, 0.0625F, 0.08F, 0.1F)))
                .addLootPool(LootPool.builder()
                        .acceptCondition(Conditions.NOT_SHEARS_OR_SILK_TOUCH)
                        .addEntry(explosionDecay(ItemLootEntry.builder(Items.STICK)
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