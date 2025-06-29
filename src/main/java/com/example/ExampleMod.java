package com.example;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.mob.CreeperEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.entity.Entity;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.entity.SpawnGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import net.minecraft.client.render.entity.EntityRendererFactory;

import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.SpawnReason;
import net.minecraft.client.render.entity.model.EntityModelPartNames;

import net.minecraft.util.Identifier;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.render.entity.MobEntityRenderer;

public class ExampleMod implements ModInitializer {
    public static final String MOD_ID = "modid";
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final EntityType<GSkeletonEntity> GSKELETON =
            Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(MOD_ID, "gskeleton"),
                    EntityType.Builder.create(GSkeletonEntity::new, SpawnGroup.MONSTER).build("gskeleton"));
    public static final EntityType<GZombieEntity> GZOMBIE =
            Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(MOD_ID, "gzombie"),
                    EntityType.Builder.create(GZombieEntity::new, SpawnGroup.MONSTER).build("gzombie"));
    public static final EntityType<GCreeperEntity> GCREEPER =
            Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(MOD_ID, "gcreeper"),
                    EntityType.Builder.create(GCreeperEntity::new, SpawnGroup.MONSTER).build("gcreeper"));

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        LOGGER.info("Hello Fabric world!");
        FabricDefaultAttributeRegistry.register(GSKELETON, GSkeletonEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(GZOMBIE, GZombieEntity.createZombieAttributes());
        FabricDefaultAttributeRegistry.register(GCREEPER, GCreeperEntity.createCreeperAttributes());
        // DONE find a proper way to remove, register and spawn entities
        ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            MobEntity newEntity = null;
            // switch (entity.getClass ()) {
            // case SkeletonEntity.class:
            //     newEntity = GSKELETON.create (world);
            // case ZombieEntity.class:
            //     newEntity = GZOMBIE.create (world);
            // }
            if (entity instanceof SkeletonEntity && !(entity instanceof GSkeletonEntity))
                newEntity = GSKELETON.create(world);
            else if (entity instanceof ZombieEntity && !(entity instanceof GZombieEntity))
                newEntity = GZOMBIE.create(world);
            else if (entity instanceof CreeperEntity && !(entity instanceof GCreeperEntity))
                newEntity = GCREEPER.create(world);
            if (newEntity == null) {
                // LOGGER.error ("");
                return;
            }
            BlockPos pos = entity.getBlockPos();
            newEntity.initialize(world, world.getLocalDifficulty(pos), SpawnReason.NATURAL, null);
            newEntity.refreshPositionAndAngles(pos, 0.0F, 0.0F);
            world.spawnEntityAndPassengers(newEntity);
            // gskeletonEntity.initialize (world, world.get)
            // gs.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ(), entity.getYaw (), entity.getPitch ());
            // world.spawnEntity(gs);
            entity.discard();
        });
    }

    // public class GSkeletonEntityRenderer extends MobEntityRenderer<GSkeletonEntity, GSkeletonEntityModel> {
    // 	public GSkeletonEntityRenderer(EntityRendererFactory.Context context) {
    // 	    super(context, new GSkeletonEntityModel(context.getPart(ExampleModClient.MODEL_GSKELTON_LAYER)), 0.5f);
    // 	}
    // 	@Override
    // 	public Identifier getTexture(GSkeletonEntity entity) {
    // 	    return Identifier.of(MOD_ID, "textures/entity/cube/cube.png");
    // 	}
    // }

    // public class GSkeletonEntityModel extends EntityModel<GSkeletonEntity> {
    //     private final ModelPart base;
    //     public GSkeletonEntityModel(ModelPart modelPart) {
    //         this.base = modelPart.getChild(EntityModelPartNames.CUBE);
    //     }
    // 	// You can use BlockBench, make your model and export it to get this method for your entity model.
    // 	public static TexturedModelData getTexturedModelData() {
    // 	    ModelData modelData = new ModelData();
    // 	    ModelPartData modelPartData = modelData.getRoot();
    // 	    modelPartData.addChild(EntityModelPartNames.GSKELETON, ModelPartBuilder.create().uv(0, 0).cuboid(-6F, 12F, -6F, 12F, 12F, 12F), ModelTransform.pivot(0F, 0F, 0F));
    // 	    return TexturedModelData.of(modelData, 64, 64);
    // 	}
    // 	@Override
    // 	public void setAngles(GSkeletonEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    // 	}
    // 	@Override
    // 	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
    // 	    ImmutableList.of(this.base).forEach((modelRenderer) -> {
    // 		    modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    // 		});
    // 	}
    // }
}
