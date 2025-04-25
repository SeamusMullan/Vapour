package com.seamusmullan.vapour.registry;

import com.seamusmullan.vapour.Vapour;
import com.seamusmullan.vapour.block.CannabisCropBlock;
import com.seamusmullan.vapour.block.TobaccoCropBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class ModBlocks {
    // Create a deferred register for blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Vapour.MOD_ID, Registries.BLOCK);

    // Crop Blocks
    public static final RegistrySupplier<Block> TOBACCO_CROP = registerBlock("tobacco_crop",
            () -> new TobaccoCropBlock(BlockBehaviour.Properties.of()
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistrySupplier<Block> CANNABIS_CROP = registerBlock("cannabis_crop",
            () -> new CannabisCropBlock(BlockBehaviour.Properties.of()
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)));

    // Helper method to register blocks
    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }

    public static void register() {
        BLOCKS.register();
    }
}