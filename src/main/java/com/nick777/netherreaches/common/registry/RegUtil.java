package com.nick777.netherreaches.common.registry;

import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nonnull;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.nick777.netherreaches.NetherReaches.MODID;

public class RegUtil {
    @Nonnull
    @SuppressWarnings("ConstantConditions")
    public static <T> T injected() {
        return null;
    }

    public static <T extends IForgeRegistryEntry<T>> Generic<T> generic(IForgeRegistry<T> registry) {
        return new Generic<>(registry);
    }

    public static Blocks blocks(IForgeRegistry<Block> registry) {
        return new Blocks(registry);
    }

    public static Entity entities(IForgeRegistry<EntityType<?>> registry) {
        return new Entity(registry);
    }

    public static Items items(IForgeRegistry<Item> registry) {
        return new Items(registry);
    }

    public static class Items {
        private final IForgeRegistry<Item> registry;
        private Supplier<Item.Properties> propertiesSupplier = Item.Properties::new;

        private Items(IForgeRegistry<Item> registry) {
            this.registry = registry;
        }

        public Items withProperties(Supplier<Item.Properties> propertiesSupplier) {
            this.propertiesSupplier = propertiesSupplier;
            return this;
        }

        public Items add(String name, Item item) {
            ResourceLocation registryName = GameData.checkPrefix(name, false);
            item.setRegistryName(registryName);

            this.registry.register(item);

            return this;
        }

        public Items add(String name, Function<Item.Properties, Item> function) {
            Item item = function.apply(this.propertiesSupplier.get());
            return this.add(name, item);
        }

        public Items add(Block block, BiFunction<Block, Item.Properties, Item> function) {
            Item item = function.apply(block, this.propertiesSupplier.get());
            item.setRegistryName(block.getRegistryName());

            this.registry.register(item);

            return this;
        }

        public Items addAll(BiFunction<Block, Item.Properties, Item> function, Block... blocks) {
            for (Block block : blocks) {
                add(block, function);
            }
            return this;
        }

        public Items add(String customName, Block block, BiFunction<Block, Item.Properties, Item> function) {
            this.registry.register(function.apply(block, this.propertiesSupplier.get()).setRegistryName(MODID, customName));
            return this;
        }
    }

    public static class Blocks {
        private final IForgeRegistry<Block> registry;
        private Supplier<Block.Properties> propertiesSupplier;

        private Blocks(IForgeRegistry<Block> registry) {
            this.registry = registry;
        }

        public Blocks withProperties(Supplier<Block.Properties> propertiesSupplier) {
            this.propertiesSupplier = propertiesSupplier;
            return this;
        }

        public Blocks add(String name, Block block) {
            ResourceLocation registryName = GameData.checkPrefix(name, false);
            block.setRegistryName(registryName);

            this.registry.register(block);

            return this;
        }

        public Blocks add(String name, Function<Block.Properties, Block> function) {
            Preconditions.checkNotNull(this.propertiesSupplier, "properties supplier not set");
            Block block = function.apply(this.propertiesSupplier.get());
            return this.add(name, block);
        }
    }

    public static class Entity {
        private final IForgeRegistry<EntityType<?>> registry;

        private Entity(IForgeRegistry<EntityType<?>> registry) {
            this.registry = registry;
        }

        public Entity add(String name, EntityType<?> entity) {
            ResourceLocation registryName = GameData.checkPrefix(name, false);
            entity.setRegistryName(registryName);

            this.registry.register(entity);

            return this;
        }
    }

    public static class Generic<T extends IForgeRegistryEntry<T>> {
        private final IForgeRegistry<T> registry;

        private Generic(IForgeRegistry<T> registry) {
            this.registry = registry;
        }

        public Generic<T> add(String name, T entry) {
            ResourceLocation registryName = GameData.checkPrefix(name, false);
            entry.setRegistryName(registryName);

            this.registry.register(entry);

            return this;
        }
    }
}
