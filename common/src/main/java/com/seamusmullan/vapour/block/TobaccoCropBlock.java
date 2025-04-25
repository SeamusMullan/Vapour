package com.seamusmullan.vapour.block;

import com.seamusmullan.vapour.registry.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

/**
 * Tobacco plant block for growing tobacco
 */
public class TobaccoCropBlock extends CustomCropBlock {
    
    public TobaccoCropBlock(Properties properties) {
        super(properties,
                ModItems.TOBACCO_SEEDS::get,
                ModItems.TOBACCO_LEAF::get);
    }
}