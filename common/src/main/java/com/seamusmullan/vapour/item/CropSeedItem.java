package com.seamusmullan.vapour.item;

import com.seamusmullan.vapour.registry.ModBlocks;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FarmBlock;

/**
 * Custom crop seed that plants the appropriate crop
 */
public class CropSeedItem extends Item {
    private final Block cropBlock;

    public CropSeedItem(Block cropBlock, Item.Properties properties) {
        super(properties);
        this.cropBlock = cropBlock;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        BlockPos abovePos = pos.above();
        
        // Can only place on farmland
        if (state.getBlock() instanceof FarmBlock) {
            // Only place if the block above is air
            if (level.isEmptyBlock(abovePos)) {
                // Place the crop block
                BlockState cropState = this.cropBlock.defaultBlockState();
                level.setBlock(abovePos, cropState, 3);
                context.getItemInHand().shrink(1);
                return InteractionResult.SUCCESS;
            }
        }
        
        return InteractionResult.PASS;
    }
}