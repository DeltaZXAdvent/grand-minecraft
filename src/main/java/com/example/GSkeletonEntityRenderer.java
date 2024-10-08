import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.client.render.entity.SkeletonEntityModel;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class SkeletonEntityRenderer extends MobEntityRenderer<SkeletonEntity, SkeletonEntityModel> {
     
    public SkeletonEntityRenderer(EntityRendererFactory.Context context) {
	super(context, new SkeletonEntityModel(context.getPart(EntityTestingClient.MODEL_CUBE_LAYER)), 0.5f);
    }
     
    @Override
    public Identifier getTexture(SkeletonEntity entity) {
	return new Identifier("entitytesting", "textures/entity/cube/cube.png");
    }
}
