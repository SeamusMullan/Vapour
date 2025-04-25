package com.seamusmullan.vapour.item;

import com.seamusmullan.vapour.effect.VapourEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Cart (Cannabis vape) item - provides unique effects with colored vapor
 */
public class CartItem extends ConsumableItem {
    
    public CartItem(Item.Properties properties) {
        super(properties, VapourEffects.getCartEffects(), 45, true);
    }
    
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        // Play vape sound when used
        if (level.isClientSide && entity instanceof Player) {
            level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), 
                    SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 0.3F, 
                    1.2F + 0.3F * RandomSource.create().nextFloat(), false);
            
            // Create a big puff of special vapor
            spawnCartVapor(level, entity, 20);
        }
        
        return super.finishUsingItem(stack, level, entity);
    }
    
    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseDuration) {
        if (level.isClientSide && remainingUseDuration % 5 == 0) {
            // Small vapor puffs while using
            spawnCartVapor(level, entity, 4);
        }
    }
    
    private void spawnCartVapor(Level level, LivingEntity entity, int particleCount) {
        double x = entity.getX();
        double y = entity.getEyeY();
        double z = entity.getZ();
        RandomSource random = RandomSource.create();
        
        // Calculate direction based on entity's rotation
        double lookX = -Math.sin(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot()));
        double lookZ = Math.cos(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot()));
        
        // Spawn particles in front of the entity's face
        for (int i = 0; i < particleCount; i++) {
            double offsetX = lookX * 0.3 + random.nextGaussian() * 0.04;
            double offsetY = random.nextGaussian() * 0.04;
            double offsetZ = lookZ * 0.3 + random.nextGaussian() * 0.04;
            
            // Using spore particles for a more colorful effect
            level.addParticle(ParticleTypes.SPORE_BLOSSOM_AIR, 
                    x + lookX * 0.5, y + 0.1, z + lookZ * 0.5, 
                    offsetX, offsetY + 0.08, offsetZ);
        }
    }
}