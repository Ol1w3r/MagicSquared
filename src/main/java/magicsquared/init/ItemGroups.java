package magicsquared.init;

import java.util.Map;

import magicsquared.util;
import magicsquared.init.items.RegisterItems;
import magicsquared.interfaces.IGem.GEM_TYPE;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroups {
	
	private static final Map<String, Item> map = RegisterItems.gemToolMap;
	
	public static final ItemGroup GENERAL = FabricItemGroupBuilder.build(
			new Identifier(util.MODID, "general"),
			() -> new ItemStack(RegisterItems.gemItemMap.get(GEM_TYPE.AMETHYST.getName())));
	public static final ItemGroup TOOLS = FabricItemGroupBuilder.create(
			new Identifier(util.MODID, "tools"))
			.icon(() -> new ItemStack(map.get(GEM_TYPE.AMETHYST.getName() + "_pickaxe")))
			.appendItems(stacks ->
			{
				int i = 0;
				for(GEM_TYPE type: GEM_TYPE.values()) {
					map.forEach((name, item) -> {
						if(name.contains(type.getName()))
							stacks.add(new ItemStack(item));
					});
					i++;
					if(i % 2 == 0)
						stacks.add(ItemStack.EMPTY);
				}
			})
			.build();
	
}
