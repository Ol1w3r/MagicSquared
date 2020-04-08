package magicsquared.init.blocks;

import magicsquared.util;
import magicsquared.init.items.GemItem.GEM_TYPES;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {

	public static final Block BLOCK_AMETHYST 		= new GemBlock(GEM_TYPES.AMETHYST);
	public static final Block BLOCK_AZURITE 		= new GemBlock(GEM_TYPES.AZURITE);
	public static final Block BLOCK_PERIDOT 		= new GemBlock(GEM_TYPES.PERIDOT);
	public static final Block BLOCK_PHOSPHOPHYLLITE	= new GemBlock(GEM_TYPES.PHOSPHOPHYLLITE);
	public static final Block BLOCK_RUBY			= new GemBlock(GEM_TYPES.RUBY);
	public static final Block BLOCK_SAPPHIRE 		= new GemBlock(GEM_TYPES.SAPPHIRE);
	
	public RegisterBlocks() {

		util.LOGGER.debug("START REGISTER ITEMS");
		registerBlock(BLOCK_AMETHYST, 			"block_amethyst");
		registerBlock(BLOCK_AZURITE, 			"block_azurite");
		registerBlock(BLOCK_PERIDOT, 			"block_peridot");
		registerBlock(BLOCK_PHOSPHOPHYLLITE, 	"block_phosphophyllite");
		registerBlock(BLOCK_RUBY, 				"block_ruby");
		registerBlock(BLOCK_SAPPHIRE, 			"block_sapphire");
		
	}
	
	private void registerBlock(Block block, String name) {
		util.LOGGER.debug("Registered: " + name);
		Registry.register(Registry.BLOCK, new Identifier(util.MODID, name), block);
	}
}
