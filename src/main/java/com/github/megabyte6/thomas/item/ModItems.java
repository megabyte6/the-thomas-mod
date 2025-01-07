package com.github.megabyte6.thomas.item;

import com.github.megabyte6.thomas.Thomas;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

import static com.github.megabyte6.thomas.Thomas.idOf;

public class ModItems {
    public static final Item THOMAS_INGOT = register("thomas_ingot", Item::new, new Item.Settings());

    public static void registerItems() {
        Thomas.LOGGER.info("Register mod items for" + Thomas.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.THOMAS).register(itemGroup -> {
            itemGroup.add(THOMAS_INGOT);
        });
    }

    private static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return Items.register(RegistryKey.of(RegistryKeys.ITEM, idOf(path)), factory, settings);
    }
}
