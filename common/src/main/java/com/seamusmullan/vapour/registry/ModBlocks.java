package com.seamusmullan.vapour.registry;

import com.seamusmullan.vapour.Vapour;
import com.seamusmullan.vapour.block.CannabisCropBlock;
import com.seamusmullan.vapour.block.TobaccoCropBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class ModBlocks {
    // Create a deferred register for blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Vapour.MOD_ID, Registries.BLOCK);

    // Tobacco Crop Block
    public static final RegistrySupplier<Block> TOBACCO_CROP = registerBlock("tobacco_crop",
            () -> {
                // 1) Create a ResourceKey for this block
                ResourceKey<Block> key = ResourceKey.create(
                        Registries.BLOCK,
                        // Use static factory: constructor is now private
                        ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, "tobacco_crop")
                );

                // 2) Build Properties with the embedded ID
                BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                        .noCollission()
                        .randomTicks()
                        .instabreak()
                        .sound(SoundType.CROP)
                        .pushReaction(PushReaction.DESTROY)
                        .setId(key);

                // 3) Construct the block with those properties
                return new TobaccoCropBlock(props);
            });

    // Cannabis Crop Block
    public static final RegistrySupplier<Block> CANNABIS_CROP = registerBlock("cannabis_crop",
            () -> {
                ResourceKey<Block> key = ResourceKey.create(
                        Registries.BLOCK,
                        ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, "cannabis_crop")
                );
                BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                        .noCollission()
                        .randomTicks()
                        .instabreak()
                        .sound(SoundType.CROP)
                        .pushReaction(PushReaction.DESTROY)
                        .setId(key);
                return new CannabisCropBlock(props);
            });

    // Helper method to register blocks
    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }

    public static void register() {
        BLOCKS.register();
    }
}
