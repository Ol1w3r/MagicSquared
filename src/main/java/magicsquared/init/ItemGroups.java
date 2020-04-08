package magicsquared.init;

import magicsquared.util;
import magicsquared.init.items.RegisterItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroups {

	public static final ItemGroup GENERAL = FabricItemGroupBuilder.build(
			new Identifier(util.MODID, "general"),
			() -> new ItemStack(RegisterItems.ITEM_AMETHYST));
	
	
}
