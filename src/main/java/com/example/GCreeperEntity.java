package com.example;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.registry.Registries;

public class GCreeperEntity extends CreeperEntity {

    private int counter= 0;

    public GCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
	this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)
	    .setBaseValue(0.1F);
    }

    @Override
    public void onDamaged(DamageSource damageSource) {
        super.onDamaged(damageSource);
        // ExampleMod.LOGGER.info(damageSource.toString());
        // ExampleMod.LOGGER.info(damageSource.getType().toString());
        // ExampleMod.LOGGER.info(Registries.get DamageTypes.EXPLOSION.getRegistry());
//        if (damageSource.getType());
//            this.ignite();
    }


    @Override
    public void ignite() {
        super.ignite();
    }

//    @Override
//    public void tick() {
//        super.tick();
//        if ( counter == 0) {
//            this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
//
//        }
//        counter += 1;
//        counter %= 20;
//    }

    @Override
    public int getFuseSpeed() {
        return super.getFuseSpeed() * 1;
    }
}
