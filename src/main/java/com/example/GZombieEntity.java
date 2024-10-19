package com.example;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.EntityType;

import net.minecraft.util.Identifier;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.attribute.EntityAttributes;


public class GZombieEntity extends ZombieEntity {
    public GZombieEntity (EntityType<? extends ZombieEntity> entityType, World world) {
	super (entityType, world);
	// int r = this.getRandom ().nextBetween (1, 3);
	int r = this.getRandom ().nextInt (3);
	ExampleMod.LOGGER.info (r.toString ());
	this.setMovementSpeed (r == 0 ? 0.05f : (r == 1 ? 0.1f : 0.15f));
    }
}
