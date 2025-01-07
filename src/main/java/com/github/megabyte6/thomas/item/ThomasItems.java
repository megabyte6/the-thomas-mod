package com.github.megabyte6.thomas.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
//import net.minecraft.item.ProjectileItem.Settings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
//import net.fabricmc.fabric.api.item.v1.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import com.github.megabyte6.thomas.Thomas;
import net.minecraft.util.Identifier;

public class ThomasItems {
    
    private static final Item THOMAS_INGOT = registerItem("thomas_ingot", new Item(new Item.Settings()));
    
    private static void  addItemsToGroup(FabricItemGroupEntries entries)
    {
        entries.add(THOMAS_INGOT);
    }
    
    private static Item registerItem(String name, Item item)
    {
        // registers items with names and IDs e.g. "minecraft_blaze_rod" 
        return Registry.register(Registries.ITEM, Identifier.of(Thomas.MOD_ID, name), item); 
    }
    
    public static void registerModItems()
    {
        Thomas.LOGGER.info("Regeistering Mod Items for" + Thomas.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ThomasItems::addItemsToGroup);
    }
    
}
