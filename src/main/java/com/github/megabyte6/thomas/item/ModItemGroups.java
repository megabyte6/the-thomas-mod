package com.github.megabyte6.thomas.item;

import com.github.megabyte6.thomas.Thomas;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

import static com.github.megabyte6.thomas.Thomas.idOf;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> THOMAS = createKey("thomas_group");

    public static void registerItemGroups() {
        Thomas.LOGGER.info("Registering custom item groups");

        Registry.register(Registries.ITEM_GROUP, THOMAS, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.THOMAS_INGOT))
                .displayName(Text.translatable("itemgroup.thomas"))
                .build());
    }

    private static RegistryKey<ItemGroup> createKey(String path) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, idOf(path));
    }
}
