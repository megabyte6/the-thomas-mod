package com.github.megabyte6.thomas;

import com.github.megabyte6.thomas.entity.ModEntityType;
import com.github.megabyte6.thomas.item.ModItemGroups;
import com.github.megabyte6.thomas.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thomas implements ModInitializer {
    public static final String MOD_ID = "thomas";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier idOf(String path) {
        return Identifier.of(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        ModItemGroups.registerItemGroups();
        ModItems.registerItems();
        ModEntityType.registerEntityAttributes();
    }
}
