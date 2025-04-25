package com.seamusmullan.vapour.item;

import com.seamusmullan.vapour.effect.VapourEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
//import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemUtils;
//import net.minecraft.world.item.UseAnim; // added import
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

/**
 * Energy Drink item - provides speed and mining boost effects
 */
public class EnergyDrinkItem extends Item {
    
    public EnergyDrinkItem(Item.Properties properties) {
        super(properties);
    }
    
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide && livingEntity instanceof Player player) {
            // Apply all effects
            VapourEffects.getEnergyDrinkEffects().forEach(livingEntity::addEffect);
            
            // Play drink sound
            level.playSound(null, player.getX(), player.getY(), player.getZ(), 
                    SoundEvents.PLAYER_BURP, SoundSource.PLAYERS, 0.5F, 
                    level.random.nextFloat() * 0.1F + 0.9F);
        }
        
        // Return empty can or decrease stack
        if (stack.getCount() > 1) {
            stack.shrink(1);
            return stack;
        } else {
            return ItemStack.EMPTY;
        }
    }
    
//    @Override
    public int getUseDuration(ItemStack stack) {
        return 32; // Drinking animation time
    }
    
//    @Override
//    public ItemUseAnimation getUseAnimation(ItemStack stack) { // changed return type to UseAnim
//        return UseAnim.DRINK; // Correct animation for drinking
//    }
    
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }
    
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player != null) {
            player.startUsingItem(context.getHand());
        }
        return InteractionResult.SUCCESS;
    }
}