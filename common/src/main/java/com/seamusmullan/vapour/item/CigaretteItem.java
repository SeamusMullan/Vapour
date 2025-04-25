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
 * Cigarette item - provides relaxation effects
 */
public class CigaretteItem extends ConsumableItem {
    
    public CigaretteItem(Item.Properties properties) {
        super(properties, VapourEffects.getCigaretteEffects(), 40, false);
    }
    
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        // Play smoke sound when used
        if (level.isClientSide && entity instanceof Player) {
            level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), 
                    SoundEvents.CAMPFIRE_CRACKLE, SoundSource.PLAYERS, 0.5F, 
                    1.0F + 0.4F * RandomSource.create().nextFloat(), false);
            
            // Spawn smoke particles
            spawnSmokeParticles(level, entity);
        }
        
        return super.finishUsingItem(stack, level, entity);
    }
    
    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseDuration) {
        if (level.isClientSide && remainingUseDuration % 5 == 0) {
            // Spawn smoke particles periodically while using
            spawnSmokeParticles(level, entity);
        }
    }
    
    private void spawnSmokeParticles(Level level, LivingEntity entity) {
        double x = entity.getX();
        double y = entity.getEyeY();
        double z = entity.getZ();
        RandomSource random = RandomSource.create();
        
        // Calculate direction based on entity's rotation
        double lookX = -Math.sin(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot()));
        double lookZ = Math.cos(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot()));
        
        // Spawn particles in front of the entity's face
        for (int i = 0; i < 8; i++) {
            double offsetX = lookX * 0.2 + random.nextGaussian() * 0.02;
            double offsetY = random.nextGaussian() * 0.02;
            double offsetZ = lookZ * 0.2 + random.nextGaussian() * 0.02;
            
            level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, 
                    x + lookX * 0.5, y + 0.1, z + lookZ * 0.5, 
                    offsetX, offsetY + 0.05, offsetZ);
        }
    }
}