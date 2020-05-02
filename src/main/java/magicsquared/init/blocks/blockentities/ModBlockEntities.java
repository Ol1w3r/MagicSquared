package magicsquared.init.blocks.blockentities;

import java.util.HashMap;
import java.util.Map;

import magicsquared.util;
import magicsquared.init.blocks.ModBlocks;
import magicsquared.interfaces.IGem.GemType;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {

	public static Map<String, BlockEntityType<DragonEggBlockEntity>> blockEntityMap = new HashMap<>();
	
	public ModBlockEntities() {
		String name = "";
		for(GemType type: GemType.values()) {
			name = type.getName() + "_egg";
			blockEntityMap.put(name, Registry.register(Registry.BLOCK_ENTITY_TYPE, 
					new Identifier(util.MODID, type.getName() + "_dragon_egg_entity"), 
					BlockEntityType.Builder.<DragonEggBlockEntity>create(() -> {
						return new DragonEggBlockEntity(type);
					}, ModBlocks.blockMap.get(type.getName() + "_egg")).build(null)));
		}
	}
}
