package magicsquared.init.items;

import magicsquared.util;
import magicsquared.init.ToolMaterials.MaterialGem;
import magicsquared.init.items.tools.AxeBase;
import magicsquared.init.items.tools.PickaxeBase;
import magicsquared.init.items.tools.ShovelBase;
import magicsquared.init.items.tools.SwordBase;
import magicsquared.interfaces.IGem;
import magicsquared.interfaces.IGem.GEM_TYPE;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {

	public static final GemItem ITEM_AMETHYST 			= new GemItem(GEM_TYPE.AMETHYST);
	public static final GemItem ITEM_AZURITE 			= new GemItem(GEM_TYPE.AZURITE);
	public static final GemItem ITEM_PERIDOT 			= new GemItem(GEM_TYPE.PERIDOT);
	public static final GemItem ITEM_PHOSPHOPHYLLITE 	= new GemItem(GEM_TYPE.PHOSPHOPHYLLITE);
	public static final GemItem ITEM_RUBY 				= new GemItem(GEM_TYPE.RUBY);
	public static final GemItem ITEM_SAPPHIRE 			= new GemItem(GEM_TYPE.SAPPHIRE);
	
	public static final ToolItem ITEM_AMETHYST_PICKAXE = new PickaxeBase(new MaterialGem(GEM_TYPE.AMETHYST));
	public static final ToolItem ITEM_AMETHYST_AXE = new AxeBase(new MaterialGem(GEM_TYPE.AMETHYST));
	public static final ToolItem ITEM_AMETHYST_SHOVEL = new ShovelBase(new MaterialGem(GEM_TYPE.AMETHYST));
	public static final ToolItem ITEM_AMETHYST_SWORD = new SwordBase(new MaterialGem(GEM_TYPE.AMETHYST));

	public static final ToolItem ITEM_AZURITE_PICKAXE = new PickaxeBase(new MaterialGem(GEM_TYPE.AZURITE));
	public static final ToolItem ITEM_AZURITE_AXE = new AxeBase(new MaterialGem(GEM_TYPE.AZURITE));
	public static final ToolItem ITEM_AZURITE_SHOVEL = new ShovelBase(new MaterialGem(GEM_TYPE.AZURITE));
	public static final ToolItem ITEM_AZURITE_SWORD = new SwordBase(new MaterialGem(GEM_TYPE.AZURITE));
	
	public static final ToolItem ITEM_PERIDOT_PICKAXE = new PickaxeBase(new MaterialGem(GEM_TYPE.PERIDOT));
	public static final ToolItem ITEM_PERIDOT_AXE = new AxeBase(new MaterialGem(GEM_TYPE.PERIDOT));
	public static final ToolItem ITEM_PERIDOT_SHOVEL = new ShovelBase(new MaterialGem(GEM_TYPE.PERIDOT));
	public static final ToolItem ITEM_PERIDOT_SWORD = new SwordBase(new MaterialGem(GEM_TYPE.PERIDOT));
	
	public static final ToolItem ITEM_PHOSPHOPHYLLITE_PICKAXE = new PickaxeBase(new MaterialGem(GEM_TYPE.PHOSPHOPHYLLITE));
	public static final ToolItem ITEM_PHOSPHOPHYLLITE_AXE = new AxeBase(new MaterialGem(GEM_TYPE.PHOSPHOPHYLLITE));
	public static final ToolItem ITEM_PHOSPHOPHYLLITE_SHOVEL = new ShovelBase(new MaterialGem(GEM_TYPE.PHOSPHOPHYLLITE));
	public static final ToolItem ITEM_PHOSPHOPHYLLITE_SWORD = new SwordBase(new MaterialGem(GEM_TYPE.PHOSPHOPHYLLITE));

	public static final ToolItem ITEM_RUBY_PICKAXE = new PickaxeBase(new MaterialGem(GEM_TYPE.RUBY));
	public static final ToolItem ITEM_RUBY_AXE = new AxeBase(new MaterialGem(GEM_TYPE.RUBY));
	public static final ToolItem ITEM_RUBY_SHOVEL = new ShovelBase(new MaterialGem(GEM_TYPE.RUBY));
	public static final ToolItem ITEM_RUBY_SWORD = new SwordBase(new MaterialGem(GEM_TYPE.RUBY));

	public static final ToolItem ITEM_SAPPHIRE_PICKAXE = new PickaxeBase(new MaterialGem(GEM_TYPE.SAPPHIRE));
	public static final ToolItem ITEM_SAPPHIRE_AXE = new AxeBase(new MaterialGem(GEM_TYPE.SAPPHIRE));
	public static final ToolItem ITEM_SAPPHIRE_SHOVEL = new ShovelBase(new MaterialGem(GEM_TYPE.SAPPHIRE));
	public static final ToolItem ITEM_SAPPHIRE_SWORD = new SwordBase(new MaterialGem(GEM_TYPE.SAPPHIRE));
	
	private GemItem[] gemItems = new GemItem[] {
			
			ITEM_AMETHYST, 
			ITEM_AZURITE, 
			ITEM_PERIDOT, 
			ITEM_PHOSPHOPHYLLITE, 
			ITEM_RUBY, 
			ITEM_SAPPHIRE
	};
	private ToolItem[] pickaxes = new ToolItem[] {
			ITEM_AMETHYST_PICKAXE,
			ITEM_AZURITE_PICKAXE,
			ITEM_PERIDOT_PICKAXE,
			ITEM_PHOSPHOPHYLLITE_PICKAXE,
			ITEM_RUBY_PICKAXE,
			ITEM_SAPPHIRE_PICKAXE
	};
	private ToolItem[] axes = new ToolItem[] {
			ITEM_AMETHYST_AXE,
			ITEM_AZURITE_AXE,
			ITEM_PERIDOT_AXE,
			ITEM_PHOSPHOPHYLLITE_AXE,
			ITEM_RUBY_AXE,
			ITEM_SAPPHIRE_AXE
	};
	private ToolItem[] shovels = new ToolItem[] {
			ITEM_AMETHYST_SHOVEL,
			ITEM_AZURITE_SHOVEL,
			ITEM_PERIDOT_SHOVEL,
			ITEM_PHOSPHOPHYLLITE_SHOVEL,
			ITEM_RUBY_SHOVEL,
			ITEM_SAPPHIRE_SHOVEL
	};
	private ToolItem[] swords = new ToolItem[] {
			ITEM_AMETHYST_SWORD,
			ITEM_AZURITE_SWORD,
			ITEM_PERIDOT_SWORD,
			ITEM_PHOSPHOPHYLLITE_SWORD,
			ITEM_RUBY_SWORD,
			ITEM_SAPPHIRE_SWORD
	};
	
	public RegisterItems() { 
		
		util.LOGGER.debug("START REGISTER ITEMS");
		
		for(GemItem item: gemItems) {
			registerGem(item, "");
		}
		for(ToolItem item: pickaxes) {
			registerTool(item, "_pickaxe");
		}
		for(ToolItem item: axes) {
			registerTool(item, "_axe");
		}
		for(ToolItem item: shovels) {
			registerTool(item, "_shovel");
		}
		for(ToolItem item: swords) {
			registerTool(item, "_sword");
		}
	}
	
	private void registerItem(Item item, String name) {
		util.LOGGER.debug("Registered: " + name);
		Registry.register(Registry.ITEM, new Identifier(util.MODID, name), item);
	}

	private void registerGem(IGem item, String suffix) {
		String prefix = "item_";
		registerItem((Item)item, prefix + item.getType().getName());
	}
	
	private void registerTool(ToolItem item, String suffix) {
		String prefix = "item_";
		String name = prefix + ((MaterialGem)item.getMaterial()).getType().getName() + suffix;
		registerItem(item, name);
	}
}
