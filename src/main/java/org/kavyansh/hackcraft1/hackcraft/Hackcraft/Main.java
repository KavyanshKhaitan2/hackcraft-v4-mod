package org.kavyansh.hackcraft1.hackcraft.Hackcraft;

import net.fabricmc.api.ModInitializer;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.component.ModComponents;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
    public static final String MOD_ID = "hackcraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("Loading HackCraft...");

        ModItems.registerModItems();
        ModComponents.initialize();

        LOGGER.info("Successfully loaded HackCraft!");
    }
}
