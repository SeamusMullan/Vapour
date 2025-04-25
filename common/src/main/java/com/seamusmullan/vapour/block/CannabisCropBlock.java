package com.seamusmullan.vapour.block;

import com.seamusmullan.vapour.registry.ModItems;
import net.minecraft.world.level.block.Block;

/**
 * Cannabis plant block for growing cannabis
 */
public class CannabisCropBlock extends CustomCropBlock {
    
    public CannabisCropBlock(Properties properties) {
        super(properties,
                ModItems.CANNABIS_SEEDS::get,
                ModItems.CANNABIS_LEAF::get);
    }
}