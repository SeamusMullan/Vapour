package com.seamusmullan.vapour.registry;

import com.seamusmullan.vapour.Vapour;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {
    // Register the Vapour creative tab as a CreativeModeTab
    public static final CreativeModeTab VAPOUR_TAB = CreativeTabRegistry.create(
            Component.translatable("itemGroup." + Vapour.MOD_ID + ".vapour_tab"),
            () -> new ItemStack(ModItems.VAPE_PEN.get())
    );

    public static void register() {
        CreativeTabRegistry.append(() -> VAPOUR_TAB, ModItems.CIGARETTE::get);
        CreativeTabRegistry.append(() -> VAPOUR_TAB, ModItems.TOBACCO_SEEDS::get);
        CreativeTabRegistry.append(() -> VAPOUR_TAB, ModItems.TOBACCO_LEAF::get);
        CreativeTabRegistry.append(() -> VAPOUR_TAB, ModItems.LIGHTER::get);
        CreativeTabRegistry.append(() -> VAPOUR_TAB, ModItems.VAPE_PEN::get);
        CreativeTabRegistry.append(() -> VAPOUR_TAB, ModItems.E_LIQUID::get);
        CreativeTabRegistry.append(() -> VAPOUR_TAB, ModItems.CANNABIS_SEEDS::get);
        CreativeTabRegistry.append(() -> VAPOUR_TAB, ModItems.CANNABIS_LEAF::get);
        CreativeTabRegistry.append(() -> VAPOUR_TAB, ModItems.CART::get);
        CreativeTabRegistry.append(() -> VAPOUR_TAB, ModItems.ENERGY_DRINK::get);
    }
}