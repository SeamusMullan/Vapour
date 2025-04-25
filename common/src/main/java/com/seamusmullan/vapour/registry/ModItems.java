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
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ModItems {
    // Create a deferred register for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Vapour.MOD_ID, Registries.ITEM);

    // Tobacco Products
    public static final RegistrySupplier<Item> CIGARETTE = registerItem("cigarette", 
            () -> new CigaretteItem(new Item.Properties().stacksTo(16)));
    public static final RegistrySupplier<Item> TOBACCO_SEEDS = registerItem("tobacco_seeds",
            () -> new CropSeedItem(ModBlocks.TOBACCO_CROP.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> TOBACCO_LEAF = registerItem("tobacco_leaf",
            () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> LIGHTER = registerItem("lighter",
            () -> new LighterItem(new Item.Properties().durability(64)));

    // Vaping Devices
    public static final RegistrySupplier<Item> VAPE_PEN = registerItem("vape_pen",
            () -> new VapePenItem(new Item.Properties().durability(100)));
    public static final RegistrySupplier<Item> E_LIQUID = registerItem("e_liquid",
            () -> new Item(new Item.Properties().stacksTo(16)));

    // Cannabis Products
    public static final RegistrySupplier<Item> CANNABIS_SEEDS = registerItem("cannabis_seeds",
            () -> new CropSeedItem(ModBlocks.CANNABIS_CROP.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> CANNABIS_LEAF = registerItem("cannabis_leaf",
            () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> CART = registerItem("cart",
            () -> new CartItem(new Item.Properties().durability(50)));

    // Energy Drinks
    public static final RegistrySupplier<Item> ENERGY_DRINK = registerItem("energy_drink",
            () -> new EnergyDrinkItem(new Item.Properties().stacksTo(16)));

    // Helper method to register items
    private static <T extends Item> RegistrySupplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return ITEMS.register(name, itemSupplier);
    }

    public static void register() {
        ITEMS.register();
    }
}