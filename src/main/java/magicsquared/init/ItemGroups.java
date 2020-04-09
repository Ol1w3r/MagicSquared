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
	public static final ItemGroup TOOLS = FabricItemGroupBuilder.create(
			new Identifier(util.MODID, "tools"))
			.icon(() -> new ItemStack(RegisterItems.ITEM_AMETHYST_PICKAXE))
			.appendItems(stacks ->
			{
				stacks.add(new ItemStack(RegisterItems.ITEM_AMETHYST_AXE));
				stacks.add(new ItemStack(RegisterItems.ITEM_AMETHYST_PICKAXE));
				stacks.add(new ItemStack(RegisterItems.ITEM_AMETHYST_SHOVEL));
				stacks.add(new ItemStack(RegisterItems.ITEM_AMETHYST_SWORD));
				
				stacks.add(new ItemStack(RegisterItems.ITEM_AZURITE_AXE));
				stacks.add(new ItemStack(RegisterItems.ITEM_AZURITE_PICKAXE));
				stacks.add(new ItemStack(RegisterItems.ITEM_AZURITE_SHOVEL));
				stacks.add(new ItemStack(RegisterItems.ITEM_AZURITE_SWORD));
				
				stacks.add(ItemStack.EMPTY);

				stacks.add(new ItemStack(RegisterItems.ITEM_PERIDOT_AXE));
				stacks.add(new ItemStack(RegisterItems.ITEM_PERIDOT_PICKAXE));
				stacks.add(new ItemStack(RegisterItems.ITEM_PERIDOT_SHOVEL));
				stacks.add(new ItemStack(RegisterItems.ITEM_PERIDOT_SWORD));
				
				stacks.add(new ItemStack(RegisterItems.ITEM_PHOSPHOPHYLLITE_AXE));
				stacks.add(new ItemStack(RegisterItems.ITEM_PHOSPHOPHYLLITE_PICKAXE));
				stacks.add(new ItemStack(RegisterItems.ITEM_PHOSPHOPHYLLITE_SHOVEL));
				stacks.add(new ItemStack(RegisterItems.ITEM_PHOSPHOPHYLLITE_SWORD));

				stacks.add(ItemStack.EMPTY);

				stacks.add(new ItemStack(RegisterItems.ITEM_RUBY_AXE));
				stacks.add(new ItemStack(RegisterItems.ITEM_RUBY_PICKAXE));
				stacks.add(new ItemStack(RegisterItems.ITEM_RUBY_SHOVEL));
				stacks.add(new ItemStack(RegisterItems.ITEM_RUBY_SWORD));

				stacks.add(new ItemStack(RegisterItems.ITEM_SAPPHIRE_AXE));
				stacks.add(new ItemStack(RegisterItems.ITEM_SAPPHIRE_PICKAXE));
				stacks.add(new ItemStack(RegisterItems.ITEM_SAPPHIRE_SHOVEL));
				stacks.add(new ItemStack(RegisterItems.ITEM_SAPPHIRE_SWORD));
				
			})
			.build();
	
}
