package com.github.megabyte6.thomas.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer.Builder;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ThomasTheTankEngineEntity extends HostileEntity {
    public ThomasTheTankEngineEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        super.initGoals();

        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(4, new MeleeAttackGoal(this, 1.0, true));
        goalSelector.add(5, new WanderAroundGoal(this, 0.4));
        goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));

        targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static Builder createThomasTheTankEngineAttributes() {
        return createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 500)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.ATTACK_DAMAGE, 5)
                .add(EntityAttributes.ARMOR, 10);
    }
}
