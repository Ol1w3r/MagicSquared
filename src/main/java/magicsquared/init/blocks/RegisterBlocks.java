package magicsquared.init.blocks;

import java.util.HashMap;
import java.util.Map;

import magicsquared.util;
import magicsquared.init.ItemGroups;
import magicsquared.interfaces.IGem.GEM_TYPE;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {

	String prefix = "block_";
	
	public static final Map<String, Block> blockMap = new HashMap<>();
	
	public RegisterBlocks() {
		
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
		for(GEM_TYPE type: GEM_TYPE.values()) {
			blockMap.put(type.getName(), new GemBlock(type));
		}
	}
	
	private void registerBlock(Block block, String name) {
		name = prefix + name;
		util.LOGGER.debug("Registered: " + name);
		Registry.register(Registry.BLOCK, new Identifier(util.MODID, name), block);
		Registry.register(Registry.ITEM, new Identifier(util.MODID, name), new BlockItem(block, new Item.Settings().group(ItemGroups.GENERAL)));
	}
}
