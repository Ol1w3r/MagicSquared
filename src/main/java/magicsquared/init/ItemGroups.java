package magicsquared.init;

import java.util.Map;

import magicsquared.util;
import magicsquared.init.items.ModItems;
import magicsquared.interfaces.IGem.GemType;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroups {
	
	private static final Map<String, Item> map = ModItems.gemToolMap;
	
	public static final ItemGroup GENERAL = FabricItemGroupBuilder.build(
			new Identifier(util.MODID, "general"),
			() -> new ItemStack(ModItems.gemItemMap.get(GemType.AMETHYST.getName())));
	public static final ItemGroup TOOLS = FabricItemGroupBuilder.create(
			new Identifier(util.MODID, "tools"))
			.icon(() -> new ItemStack(map.get(GemType.AMETHYST.getName() + "_pickaxe")))
			.appendItems(stacks ->
			{
				int i = 0;
				String name = "";
				for(GemType type: GemType.values()) {
					name = type.getName();
					stacks.add(new ItemStack(map.get(name + "_pickaxe")));
					stacks.add(new ItemStack(map.get(name + "_axe")));
					stacks.add(new ItemStack(map.get(name + "_shovel")));
					stacks.add(new ItemStack(map.get(name + "_sword")));
					i++;
					if(i % 2 == 0)
						stacks.add(ItemStack.EMPTY);
				}
			})
			.build();
	
}
