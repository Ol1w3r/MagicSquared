package magicsquared.init.items;

import magicsquared.util;
import magicsquared.init.items.GemItem.GEM_TYPES;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {

	public static final Item ITEM_AMETHYST 			= new GemItem(GEM_TYPES.AMETHYST);
	public static final Item ITEM_AZURITE 			= new GemItem(GEM_TYPES.AZURITE);
	public static final Item ITEM_PERIDOT 			= new GemItem(GEM_TYPES.PERIDOT);
	public static final Item ITEM_PHOSPHOPHYLLITE 	= new GemItem(GEM_TYPES.PHOSPHOPHYLLITE);
	public static final Item ITEM_RUBY 				= new GemItem(GEM_TYPES.RUBY);
	public static final Item ITEM_SAPPHIRE 			= new GemItem(GEM_TYPES.SAPPHIRE);
	
	public RegisterItems() {
		
		util.LOGGER.debug("START REGISTER ITEMS");
		registerItem(ITEM_AMETHYST, 		"item_amethyst");
		registerItem(ITEM_AZURITE, 			"item_azurite");
		registerItem(ITEM_PERIDOT, 			"item_peridot");
		registerItem(ITEM_PHOSPHOPHYLLITE, 	"item_phosphophyllite");
		registerItem(ITEM_RUBY, 			"item_ruby");
		registerItem(ITEM_SAPPHIRE, 		"item_sapphire");
	}
	
	private void registerItem(Item item, String name) {
		util.LOGGER.debug("Registered: " + name);
		Registry.register(Registry.ITEM, new Identifier(util.MODID, name), item);
	}
}
