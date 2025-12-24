package com.github.megabyte6.thomas.item;

import com.github.megabyte6.thomas.Thomas;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.github.megabyte6.thomas.Thomas.idOf;

public class ModItemGroups {
    public static final ResourceKey<@NotNull CreativeModeTab> THOMAS = createKey("thomas_group");

    public static void registerItemGroups() {
        Thomas.LOGGER.info("Registering custom item groups");

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, THOMAS, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.THOMAS_INGOT))
                .title(Component.translatable("itemgroup.thomas"))
                .build());
    }

    private static ResourceKey<@NotNull CreativeModeTab> createKey(String path) {
        return ResourceKey.create(Registries.CREATIVE_MODE_TAB, idOf(path));
    }
}
