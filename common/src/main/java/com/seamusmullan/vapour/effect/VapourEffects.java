package com.seamusmullan.vapour.effect;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.ArrayList;
import java.util.List;

/**
 * Centralizes effect management for Vapour products
 */
public class VapourEffects {
    
    // Tobacco Effects - Slower movement but resistance to damage
    public static List<MobEffectInstance> getCigaretteEffects() {
        List<MobEffectInstance> effects = new ArrayList<>();
        effects.add(new MobEffectInstance(MobEffects.RESISTANCE, 600, 0));
        effects.add(new MobEffectInstance(MobEffects.SLOWNESS, 400, 0));
        return effects;
    }
    
    // Vape Effects - Mild effects with visual particles
    public static List<MobEffectInstance> getVapeEffects() {
        List<MobEffectInstance> effects = new ArrayList<>();
        effects.add(new MobEffectInstance(MobEffects.RESISTANCE, 300, 0));
        return effects;
    }
    
    // Cannabis Effects - "Munchies" and enhanced view
    public static List<MobEffectInstance> getCartEffects() {
        List<MobEffectInstance> effects = new ArrayList<>();
        effects.add(new MobEffectInstance(MobEffects.HUNGER, 800, 0));
        effects.add(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0));
        effects.add(new MobEffectInstance(MobEffects.SLOWNESS, 1000, 0));
        return effects;
    }
    
    // Energy Drink Effects - Speed and mining boost
    public static List<MobEffectInstance> getEnergyDrinkEffects() {
        List<MobEffectInstance> effects = new ArrayList<>();
        effects.add(new MobEffectInstance(MobEffects.SPEED, 600, 1));
        effects.add(new MobEffectInstance(MobEffects.HASTE, 600, 0));
        // Add a mild negative effect after the positive ones wear off
        effects.add(new MobEffectInstance(MobEffects.WEAKNESS, 200, 0, false, false, true));
        return effects;
    }
}