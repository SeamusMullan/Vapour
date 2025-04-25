package com.seamusmullan.vapour.registry;

import com.seamusmullan.vapour.Vapour;
import com.seamusmullan.vapour.item.CartItem;
import com.seamusmullan.vapour.item.CigaretteItem;
import com.seamusmullan.vapour.item.CropSeedItem;
import com.seamusmullan.vapour.item.EnergyDrinkItem;
import com.seamusmullan.vapour.item.LighterItem;
import com.seamusmullan.vapour.item.VapePenItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ModItems {
    // Create a deferred register for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Vapour.MOD_ID, Registries.ITEM);

    // Cigarette
    public static final RegistrySupplier<Item> CIGARETTE = registerItem("cigarette", () -> {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, "cigarette")
        );
        Item.Properties props = new Item.Properties()
                .stacksTo(16)
                .setId(key);
        return new CigaretteItem(props);
    });

    // Tobacco Seeds
    public static final RegistrySupplier<Item> TOBACCO_SEEDS = registerItem("tobacco_seeds", () -> {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, "tobacco_seeds")
        );
        Item.Properties props = new Item.Properties()
                .setId(key);
        return new CropSeedItem(ModBlocks.TOBACCO_CROP.get(), props);
    });

    // Tobacco Leaf
    public static final RegistrySupplier<Item> TOBACCO_LEAF = registerItem("tobacco_leaf", () -> {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, "tobacco_leaf")
        );
        Item.Properties props = new Item.Properties()
                .setId(key);
        return new Item(props);
    });

    // Lighter
    public static final RegistrySupplier<Item> LIGHTER = registerItem("lighter", () -> {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, "lighter")
        );
        Item.Properties props = new Item.Properties()
                .durability(64)
                .setId(key);
        return new LighterItem(props);
    });

    // Vape Pen
    public static final RegistrySupplier<Item> VAPE_PEN = registerItem("vape_pen", () -> {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, "vape_pen")
        );
        Item.Properties props = new Item.Properties()
                .durability(100)
                .setId(key);
        return new VapePenItem(props);
    });

    // E-Liquid
    public static final RegistrySupplier<Item> E_LIQUID = registerItem("e_liquid", () -> {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, "e_liquid")
        );
        Item.Properties props = new Item.Properties()
                .stacksTo(16)
                .setId(key);
        return new Item(props);
    });

    // Cannabis Seeds
    public static final RegistrySupplier<Item> CANNABIS_SEEDS = registerItem("cannabis_seeds", () -> {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, "cannabis_seeds")
        );
        Item.Properties props = new Item.Properties()
                .setId(key);
        return new CropSeedItem(ModBlocks.CANNABIS_CROP.get(), props);
    });

    // Cannabis Leaf
    public static final RegistrySupplier<Item> CANNABIS_LEAF = registerItem("cannabis_leaf", () -> {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, "cannabis_leaf")
        );
        Item.Properties props = new Item.Properties()
                .setId(key);
        return new Item(props);
    });

    // Cart
    public static final RegistrySupplier<Item> CART = registerItem("cart", () -> {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, "cart")
        );
        Item.Properties props = new Item.Properties()
                .durability(50)
                .setId(key);
        return new CartItem(props);
    });

    // Energy Drink
    public static final RegistrySupplier<Item> ENERGY_DRINK = registerItem("energy_drink", () -> {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, "energy_drink")
        );
        Item.Properties props = new Item.Properties()
                .stacksTo(16)
                .setId(key);
        return new EnergyDrinkItem(props);
    });

    // Helper method to register items
    private static <T extends Item> RegistrySupplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return ITEMS.register(name, itemSupplier);
    }

    public static void register() {
        ITEMS.register();
    }
}
