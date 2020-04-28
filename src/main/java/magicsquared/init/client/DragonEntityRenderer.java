package magicsquared.init.client;

import magicsquared.init.client.rendering.entity.model.DragonEntityModel;
import magicsquared.init.entities.DragonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class DragonEntityRenderer extends MobEntityRenderer<DragonEntity, DragonEntityModel<DragonEntity>> {

	public DragonEntityRenderer(EntityRenderDispatcher renderManager) {
		super(renderManager, new DragonEntityModel<DragonEntity>(), 0.3F);
	}

	@Override
	public Identifier getTexture(DragonEntity entity) {
		return new Identifier("magicsquared:textures/entity/dragon/dragon_" + entity.getGemType().getName() + ".png");
	}

	protected float getAnimationProgress(DragonEntity entity, float f) {
		float g = MathHelper.lerp(f, entity.field_6736, entity.field_6741);
		float h = MathHelper.lerp(f, entity.field_6738, entity.field_6743);
		return (MathHelper.sin(g) + 1.0F) * h;
	}
}
