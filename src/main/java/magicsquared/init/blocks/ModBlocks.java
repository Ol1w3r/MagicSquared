package magicsquared.init.blocks;

import java.util.HashMap;
import java.util.Map;

import magicsquared.util;
import magicsquared.init.ItemGroups;
import magicsquared.interfaces.IGem.GemType;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	
	public static final Map<String, Block> blockMap = new HashMap<>();
	
	public ModBlocks() {
		
		util.LOGGER.debug("START REGISTER BLOCKS");
		
		registerGemBlocks();
		for(int i = 1; i < 4; i++) {
			blockMap.put("obsidian_layers_" + i, new ObsidianLayers(i));
		}
		
		blockMap.forEach((name, block) ->
		{
			registerBlock(block, name);
		});
		
		
	}
	
	private void registerGemBlocks() {
		String name;
		for(GemType type: GemType.values()) {
			name = type.getName();
			blockMap.put(name + "_block", new GemBlock(type));
			blockMap.put(name + "_ore", new GemBlock(type, true));
			blockMap.put(name + "_egg", new DragonEgg(type));
		}
	}
	
	private void registerBlock(Block block, String name) {
		util.LOGGER.debug("Registered: " + name);
		Registry.register(Registry.BLOCK, new Identifier(util.MODID, name), block);
		Registry.register(Registry.ITEM, new Identifier(util.MODID, name), new BlockItem(block, new Item.Settings().group(ItemGroups.GENERAL)));
	}
}
