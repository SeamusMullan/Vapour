package com.seamusmullan.vapour.neoforge.client;

import com.seamusmullan.vapour.Vapour;
import com.seamusmullan.vapour.registry.ModBlocks;
import com.seamusmullan.vapour.registry.ResourceRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

@EventBusSubscriber(modid = Vapour.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VapourNeoForgeClient {
    
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Register client resources
        ResourceRegistry.registerClientResources();
        
        // Set render types for blocks
        event.enqueueWork(() -> {
            // Register cutout render type for crops
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TOBACCO_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CANNABIS_CROP.get(), RenderType.cutout());
        });
    }
}
