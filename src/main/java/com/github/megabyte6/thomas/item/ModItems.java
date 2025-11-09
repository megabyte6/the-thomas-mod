package com.github.megabyte6.thomas.item;

import com.github.megabyte6.thomas.Thomas;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

import static com.github.megabyte6.thomas.Thomas.idOf;

public class ModItems {
    public static final Item THOMAS_INGOT = register("thomas_ingot", Item::new, new Item.Properties());

    public static void registerItems() {
        Thomas.LOGGER.info("Register mod items for" + Thomas.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.THOMAS).register(itemGroup -> itemGroup.accept(THOMAS_INGOT));
    }

    private static Item register(String path, Function<Item.Properties, Item> factory, Item.Properties settings) {
        return Items.registerItem(ResourceKey.create(Registries.ITEM, idOf(path)), factory, settings);
    }
}
