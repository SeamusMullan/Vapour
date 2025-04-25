package com.seamusmullan.vapour.registry;

import com.seamusmullan.vapour.Vapour;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

/**
 * Helper class for managing mod resources
 */
public class ResourceRegistry {
    private static final Logger LOGGER = Vapour.LOGGER;
    
    /**
     * Register client resources
     */
    public static void registerClientResources() {
        LOGGER.info("Registering Vapour client resources");
        // This method is called during client initialization
        // Most textures are loaded automatically based on models
    }
    
    /**
     * Create a mod-namespaced resource location
     */
    public static ResourceLocation modLoc(String path) {
        // Fix: Use ResourceLocation.fromNamespaceAndPath instead of the constructor
        return ResourceLocation.fromNamespaceAndPath(Vapour.MOD_ID, path);
    }
    
    /**
     * Get a texture path with the correct namespace
     */
    public static String getTexturePath(String type, String name) {
        return Vapour.MOD_ID + ":textures/" + type + "/" + name + ".png";
    }
}
