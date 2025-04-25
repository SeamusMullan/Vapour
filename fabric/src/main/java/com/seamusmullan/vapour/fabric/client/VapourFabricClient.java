package com.seamusmullan.vapour.fabric.client;

import com.seamusmullan.vapour.registry.ResourceRegistry;
import net.fabricmc.api.ClientModInitializer;

public class VapourFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register client resources
        ResourceRegistry.registerClientResources();
    }
}
