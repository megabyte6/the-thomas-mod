package com.github.megabyte6.thomas.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer.Builder;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class ThomasTheTankEngineEntity extends HostileEntity {
    public ThomasTheTankEngineEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static Builder createThomasTheTankEngineAttributes() {
        return createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 500)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.ATTACK_DAMAGE, 5)
                .add(EntityAttributes.ARMOR, 10);
    }
}
