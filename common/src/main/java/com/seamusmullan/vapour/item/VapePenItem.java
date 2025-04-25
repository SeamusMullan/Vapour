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
 * Vape Pen item - rechargeable with customizable flavors
 */
public class VapePenItem extends ConsumableItem {
    
    public VapePenItem(Item.Properties properties) {
        super(properties, VapourEffects.getVapeEffects(), 30, true);
    }
    
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        // Play vape sound when used
        if (level.isClientSide && entity instanceof Player) {
            level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), 
                    SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 0.3F, 
                    1.5F + 0.5F * RandomSource.create().nextFloat(), false);
            
            // Create a big puff of vapor
            spawnVaporCloud(level, entity, 15);
        }
        
        return super.finishUsingItem(stack, level, entity);
    }
    
    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseDuration) {
        if (level.isClientSide && remainingUseDuration % 4 == 0) {
            // Small vapor puffs while using
            spawnVaporCloud(level, entity, 3);
        }
    }
    
    private void spawnVaporCloud(Level level, LivingEntity entity, int particleCount) {
        double x = entity.getX();
        double y = entity.getEyeY();
        double z = entity.getZ();
        RandomSource random = RandomSource.create();
        
        // Calculate direction based on entity's rotation
        double lookX = -Math.sin(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot()));
        double lookZ = Math.cos(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot()));
        
        // Spawn particles in front of the entity's face
        for (int i = 0; i < particleCount; i++) {
            double offsetX = lookX * 0.3 + random.nextGaussian() * 0.05;
            double offsetY = random.nextGaussian() * 0.05;
            double offsetZ = lookZ * 0.3 + random.nextGaussian() * 0.05;
            
            // Use cloud particles for a vapor effect
            level.addParticle(ParticleTypes.CLOUD, 
                    x + lookX * 0.5, y + 0.1, z + lookZ * 0.5, 
                    offsetX, offsetY + 0.1, offsetZ);
        }
    }
}