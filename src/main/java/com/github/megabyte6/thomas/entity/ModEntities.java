package com.github.megabyte6.thomas.entity;

import com.github.megabyte6.thomas.Thomas;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import static com.github.megabyte6.thomas.Thomas.idOf;

public class ModEntities {
    public static final EntityType<ThomasTheTankEngineEntity> THOMAS_THE_TANK_ENGINE = register(
            "thomas_the_tank_engine",
            EntityType.Builder.create(ThomasTheTankEngineEntity::new, SpawnGroup.MONSTER).dimensions(1, 0.75f));

    public static void initialize() {
        Thomas.LOGGER.debug("Registering custom entities");

        FabricDefaultAttributeRegistry.register(THOMAS_THE_TANK_ENGINE,
                ThomasTheTankEngineEntity.createThomasTheTankEngineAttributes());
    }

    private static <T extends Entity> EntityType<T> register(String path, EntityType.Builder<T> entityTypeBuilder) {
        Thomas.LOGGER.debug("Registering custom entity '{}'", path);

        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, idOf(path));
        return Registry.register(Registries.ENTITY_TYPE, key, entityTypeBuilder.build(key));
    }
}
