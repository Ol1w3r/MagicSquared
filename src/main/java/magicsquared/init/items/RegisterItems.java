package magicsquared.init.items;

import java.util.HashMap;
import java.util.Map;

import magicsquared.util;
import magicsquared.init.ToolMaterials.MaterialGem;
import magicsquared.init.items.tools.AxeBase;
import magicsquared.init.items.tools.PickaxeBase;
import magicsquared.init.items.tools.ShovelBase;
import magicsquared.init.items.tools.SwordBase;
import magicsquared.interfaces.IGem.GEM_TYPE;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {

	public static final Map<String, Item> gemItemMap = new HashMap<>();
	
	public static final Map<String, Item> gemToolMap = new HashMap<>();
	
	public static final Map<String, Item> basicItemMap = new HashMap<>();
	
	public RegisterItems() { 
		
		util.LOGGER.debug("START REGISTER ITEMS");
		
		registerGems();
		
		registerTools();
		
		registerItemInMap("obsidian_shard", new BasicItem(), basicItemMap);
		registerItemInMap("tool_rod", new BasicItem(), basicItemMap);
		
	}
	
	private void registerItemInMap(String name, Item item, Map<String, Item> map) {
		
		map.put(name, item);
		registerItem(name, item);
	}
	
	private void registerItem(String name, Item item) {

		String prefix = "item_";
		
		util.LOGGER.debug("Registered: " + name);
		
		Registry.register(Registry.ITEM, new Identifier(util.MODID, prefix + name), item);
		
	}

	private void registerGems() {
		
		String name = "";
		for(GEM_TYPE type: GEM_TYPE.values()) {
			name = type.getName();
			registerItemInMap(name, new GemItem(type), gemItemMap);
		}
	}
	
	private void registerTools() {
		String pickaxe = "_pickaxe";
		String axe = "_axe";
		String shovel = "_shovel";
		String sword = "_sword";
		
		String namePick = "";
		String nameAxe = "";
		String nameShovel = "";
		String nameSword = "";		
		
		for(GEM_TYPE type: GEM_TYPE.values()) {
			namePick = type.getName() + pickaxe;
			nameAxe = type.getName() + axe;
			nameShovel = type.getName() + shovel;
			nameSword = type.getName() + sword;
			
			gemToolMap.put(namePick, new PickaxeBase(new MaterialGem(type)));
			registerTool((ToolItem)gemToolMap.get(namePick), pickaxe);
			
			gemToolMap.put(nameAxe, new AxeBase(new MaterialGem(type)));
			registerTool((ToolItem)gemToolMap.get(nameAxe), axe);
			
			gemToolMap.put(nameShovel, new ShovelBase(new MaterialGem(type)));
			registerTool((ToolItem)gemToolMap.get(nameShovel), shovel);
			
			gemToolMap.put(nameSword, new SwordBase(new MaterialGem(type)));
			registerTool((ToolItem)gemToolMap.get(nameSword), sword);
		}
	}
	
	private void registerTool(ToolItem item, String suffix) {
		
		String name = ((MaterialGem)item.getMaterial()).getType().getName() + suffix;
		registerItem(name, item);
	}
}
