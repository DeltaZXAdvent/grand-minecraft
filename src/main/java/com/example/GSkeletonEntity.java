package com.example;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.entity.SpawnGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class GSkeletonEntity extends SkeletonEntity {
    public GSkeletonEntity (EntityType<? extends SkeletonEntity> entityType, World world) {
	super (entityType, world);
	this.setMovementSpeed (this.getMovementSpeed () * 2);
    }
    @Override
    protected int getRegularAttackInterval () {
	return super.getRegularAttackInterval () / 2;
    }
}
