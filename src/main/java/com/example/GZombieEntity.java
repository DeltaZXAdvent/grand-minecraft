package com.example;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.EntityType;

import net.minecraft.util.Identifier;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.attribute.EntityAttributes;


public class GZombieEntity extends ZombieEntity {
    public GZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
	EntityAttributeInstance gms =
	    this.getAttributeInstance (EntityAttributes.GENERIC_MOVEMENT_SPEED);
	gms.setBaseValue (0.1F);
	if (this.random.nextDouble () * 2 > 1.0) {
	    gms.setBaseValue (2 * gms.getBaseValue ());
	    if (this.random.nextDouble () * 1.5 > 1.0) {
		gms.setBaseValue (1.5 * gms.getBaseValue ());
	    }
	}
    }
}
