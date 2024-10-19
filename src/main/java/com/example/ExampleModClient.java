package com.example;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.client.render.entity.ZombieEntityRenderer;


@Environment(EnvType.CLIENT)
public class ExampleModClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_GSKELTON_LAYER = new EntityModelLayer(Identifier.of(ExampleMod.MOD_ID, "gskeleton"), "main");
    @Override
    public void onInitializeClient() {
	/*
	 * Registers our Cube Entity's renderer, which provides a model and texture for the entity.
	 *
	 * Entity Renderers can also manipulate the model before it renders based on entity context (EndermanEntityRenderer#render).
	 */
	// EntityRendererRegistry.INSTANCE.register(ExampleMod.GSKELETON, (context) -> {
	// 	    return new SkeletonEntityRenderer(context);
	// 	});
	// In 1.17, use EntityRendererRegistry.register (seen below) instead of EntityRendererRegistry.INSTANCE.register (seen above)
	EntityRendererRegistry.register(ExampleMod.GSKELETON, (context) -> {
		return new SkeletonEntityRenderer(context);
	    });
	EntityRendererRegistry.register(ExampleMod.GZOMBIE, (context) -> {
		return new ZombieEntityRenderer(context);
	    });
     
	// EntityModelLayerRegistry.registerModelLayer(MODEL_GSKELTON_LAYER, GSkeletonEntityModel::getTexturedModelData);
    }
}
