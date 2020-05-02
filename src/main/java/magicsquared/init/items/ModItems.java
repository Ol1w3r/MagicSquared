package magicsquared.init.items;

import java.util.HashMap;
import java.util.Map;

import magicsquared.util;
import magicsquared.init.ItemGroups;
import magicsquared.init.entities.ModEntities;
import magicsquared.init.items.tools.AxeBase;
import magicsquared.init.items.tools.PickaxeBase;
import magicsquared.init.items.tools.ShovelBase;
import magicsquared.init.items.tools.SwordBase;
import magicsquared.init.toolmaterials.MaterialGem;
import magicsquared.interfaces.IGem.GemType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

	public static final Map<String, Item> gemItemMap = new HashMap<>();
	
	public static final Map<String, Item> gemToolMap = new HashMap<>();
	
	public static final Map<String, Item> basicItemMap = new HashMap<>();
	
	public static final Map<String, Item> spawnEggMap = new HashMap<>();
	
	public ModItems() { 
		
		util.LOGGER.debug("START REGISTER ITEMS");
		
		registerGemItems();
		registerSpawnEggs();
		
		
		registerItemInMap("obsidian_shard", new BasicItem(), basicItemMap);
		registerItemInMap("tool_rod", new BasicItem(), basicItemMap);
		
	}
	
	private void registerItemInMap(String name, Item item, Map<String, Item> map) {
		
		map.put(name, item);
		registerItem(name, item);
	}
	
	private void registerItem(String name, Item item) {

		util.LOGGER.debug("Registered: " + name);
		
		Registry.register(Registry.ITEM, new Identifier(util.MODID, name), item);
		
	}

	private void registerGemItems() {
		
		String name = "";
		for(GemType type: GemType.values()) {
			name = type.getName();
			registerItemInMap(name, new GemItem(type), gemItemMap);
			registerItemInMap(name + "_scale", new GemItem(type), gemItemMap);
		}
		registerTools();
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
		
		for(GemType type: GemType.values()) {
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
		
		String name = ((MaterialGem)item.getMaterial()).getGemType().getName() + suffix;
		registerItem(name, item);
	}
	
	private void registerSpawnEggs() {
		for(GemType type: GemType.values()) {
			spawnEggMap.put("dragon_" + type.getName() + "_spawn_egg", 
					new SpawnEggItem(ModEntities.entityMap.get("dragon_" + type.getName()), 
							type.colour1(), type.colour2(), new Item.Settings().group(ItemGroups.GENERAL)));
		}
		spawnEggMap.forEach((name, item) -> {
			registerItem(name, item);
		});
	}
}
