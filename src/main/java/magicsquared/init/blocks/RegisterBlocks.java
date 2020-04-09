package magicsquared.init.blocks;

import magicsquared.util;
import magicsquared.init.ItemGroups;
import magicsquared.interfaces.IGem.GEM_TYPES;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {

	public static final GemBlock BLOCK_AMETHYST 		= new GemBlock(GEM_TYPES.AMETHYST);
	public static final GemBlock BLOCK_AZURITE 			= new GemBlock(GEM_TYPES.AZURITE);
	public static final GemBlock BLOCK_PERIDOT 			= new GemBlock(GEM_TYPES.PERIDOT);
	public static final GemBlock BLOCK_PHOSPHOPHYLLITE	= new GemBlock(GEM_TYPES.PHOSPHOPHYLLITE);
	public static final GemBlock BLOCK_RUBY				= new GemBlock(GEM_TYPES.RUBY);
	public static final GemBlock BLOCK_SAPPHIRE 		= new GemBlock(GEM_TYPES.SAPPHIRE);
	
	public RegisterBlocks() {
		
		String prefix = "block_";
		
		util.LOGGER.debug("START REGISTER ITEMS");
		
		registerBlock(BLOCK_AMETHYST, 			prefix + BLOCK_AMETHYST.getType().getName());
		registerBlock(BLOCK_AZURITE, 			prefix + BLOCK_AZURITE.getType().getName());
		registerBlock(BLOCK_PERIDOT, 			prefix + BLOCK_PERIDOT.getType().getName());
		registerBlock(BLOCK_PHOSPHOPHYLLITE, 	prefix + BLOCK_PHOSPHOPHYLLITE.getType().getName());
		registerBlock(BLOCK_RUBY, 				prefix + BLOCK_RUBY.getType().getName());
		registerBlock(BLOCK_SAPPHIRE, 			prefix + BLOCK_SAPPHIRE.getType().getName());
		
	}
	
	private void registerBlock(Block block, String name) {
		util.LOGGER.debug("Registered: " + name);
		Registry.register(Registry.BLOCK, new Identifier(util.MODID, name), block);
		Registry.register(Registry.ITEM, new Identifier(util.MODID, name), new BlockItem(block, new Item.Settings().group(ItemGroups.GENERAL)));
	}
}
