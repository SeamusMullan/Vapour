package com.seamusmullan.vapour;

import com.seamusmullan.vapour.registry.ModBlocks;
import com.seamusmullan.vapour.registry.ModCreativeTabs;
import com.seamusmullan.vapour.registry.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Vapour {
    public static final String MOD_ID = "vapour";
    public static final Logger LOGGER = LoggerFactory.getLogger("Vapour");

    public static void init() {
        LOGGER.info("Initializing Vapour Mod - Time to relax!");
        
        // Register blocks
        ModBlocks.register();
        
        // Register items
        ModItems.register();
        
        // Register creative tabs
        ModCreativeTabs.register();
        
        LOGGER.info("Vapour Mod initialization complete!");
    }
}
