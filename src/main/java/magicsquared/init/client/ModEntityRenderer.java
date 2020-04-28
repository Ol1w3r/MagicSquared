package magicsquared.init.client;

import magicsquared.init.entities.ModEntities;
import magicsquared.interfaces.IGem.GemType;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class ModEntityRenderer {

	public ModEntityRenderer() {
		
		for(GemType type: GemType.values()) {
			EntityRendererRegistry.INSTANCE.register(ModEntities.entityMap.get("dragon_" + type.getName()), (entityRenderDispatcher, context) -> new DragonEntityRenderer(entityRenderDispatcher));
		}
	}
}
