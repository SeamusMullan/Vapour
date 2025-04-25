package com.seamusmullan.vapour.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
//import net.minecraft.world.InteractionResultHolder; // added import
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Base class for consumable items that apply effects
 */
public class ConsumableItem extends Item {
    private final List<MobEffectInstance> effects;
    private final int useDuration;
    private final boolean isDamageable;

    public ConsumableItem(Item.Properties properties, List<MobEffectInstance> effects, int useDuration, boolean isDamageable) {
        super(properties);
        this.effects = effects;
        this.useDuration = useDuration;
        this.isDamageable = isDamageable;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player != null) {
            player.startUsingItem(context.getHand());
        }
        return InteractionResult.SUCCESS;
    }
//
//    @Override
//    public InteractionResult use(Level level, Player player, InteractionHand hand) {
//        player.startUsingItem(hand);
//        return InteractionResultHolder.consume(player.getItemInHand(hand));
//    }

//    @Override
//    public int getUseDuration(ItemStack stack) {
//        return useDuration;
//    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide && livingEntity instanceof Player) {
            for (MobEffectInstance effect : effects) {
                livingEntity.addEffect(new MobEffectInstance(effect));
            }
            
            if (isDamageable && stack.isDamageableItem()) {
                stack.setDamageValue(stack.getDamageValue() + 1);
                if (stack.getDamageValue() >= stack.getMaxDamage()) {
                    stack.shrink(1);
                }
            } else if (!isDamageable) {
                stack.shrink(1);
            }
        }
        
        return stack;
    }
}