package com.seamusmullan.vapour.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * Base class for custom crops in the Vapour mod
 */
public class CustomCropBlock extends CropBlock {
    public static final int MAX_AGE = 7;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
    
    private static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };
    
    private final Supplier<ItemLike> seedItem;
    private final Supplier<ItemLike> harvestItem;

    public CustomCropBlock(Block.Properties properties, Supplier<ItemLike> seedItem, Supplier<ItemLike> harvestItem) {
        super(properties);
        this.seedItem = seedItem;
        this.harvestItem = harvestItem;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return seedItem.get();
    }
    
    public ItemLike getHarvestItem() {
        return harvestItem.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(getAgeProperty())];
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getRawBrightness(pos.above(), 0) >= 9 && random.nextInt(4) == 0) {
            int age = this.getAge(state);
            if (age < this.getMaxAge()) {
                level.setBlock(pos, this.getStateForAge(age + 1), 2);
            }
        }
    }
    
    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();
        int age = getAge(state);
        
        // Always drop at least one seed
        drops.add(new ItemStack(seedItem.get()));
        
        // If the crop is fully grown, drop harvest and extra seeds
        if (age >= getMaxAge()) {
            // Add the harvest item
            drops.add(new ItemStack(harvestItem.get()));
            
            // Add 0-3 extra seeds based on random
            // Fix: Use a new RandomSource instead of trying to get it from the builder
            RandomSource random = RandomSource.create();
            int extraSeeds = random.nextInt(3) + 1; // 1 to 3 extra seeds
            if (extraSeeds > 0) {
                drops.add(new ItemStack(seedItem.get(), extraSeeds));
            }
        }
        
        return drops;
    }
}