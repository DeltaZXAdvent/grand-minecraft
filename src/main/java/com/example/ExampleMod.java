package com.example;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

<<<<<<< HEAD
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.entity.SpawnGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class ExampleMod implements ModInitializer {
    public static final String MOD_ID = "modid";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final EntityType<GSkeletonEntity> GSKELETON =
	Registry.register(Registries.ENTITY_TYPE,
			  Identifier.of ("examplemod", "gskeleton");
			  EntityType.Builder.create (SkeletonEntity::new, SpawnGroup.MONSTER).build ("gskeleton"));

    @Override
    public void onInitialize() {
	// This code runs as soon as Minecraft is in a mod-load-ready state.
	// However, some things (like resources) may still be uninitialized.
	// Proceed with mild caution.

	LOGGER.info("Hello Fabric world!");
	

	// ServerEntityEvents.ENTITY_LOAD.register ((entity, world) -> {
	// 	if (entity instanceof SkeletonEntity) {
	// 	    GSkeletonEntity gs = new GSkeletonEntity(EntityType.SKELETON, world);
	// 	    gs.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ(), entity.getYaw (), entity.getPitch ());
	// 	    world.spawnEntity(gs);
	// 	    entity.discard();
	// 	}
	//     });
	FabricDefaultAttributeRegistry.register(GSKELETON, GSkeletonEntity.createMobAttributes());
    }

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
}
=======
public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "modid";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}
>>>>>>> d2da576 (rebase using github main branch?)
