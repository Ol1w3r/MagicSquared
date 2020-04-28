package magicsquared.init.entities;

import java.util.HashMap;
import java.util.Map;

import magicsquared.util;
import magicsquared.interfaces.IGem.GemType;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
	
	public static final Map<String, EntityType<AnimalEntity>> entityMap = new HashMap<>();

	public ModEntities() {
		String name = "";
		for(GemType type: GemType.values()) {
			name = "dragon_" + type.getName();
			entityMap.put(name,
					Registry.register(Registry.ENTITY_TYPE,
				            new Identifier(util.MODID, name),
				            FabricEntityTypeBuilder.<AnimalEntity>create(EntityCategory.AMBIENT,
				                    (entityType, world) -> new DragonEntity(entityType, world, type)).size(EntityDimensions.fixed(0.5F, 0.5F)).build()));
		}
	}
	
}
