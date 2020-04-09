package magicsquared.init.items.tools;

import magicsquared.init.ItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class ShovelBase extends ShovelItem {

	public ToolMaterial material;
	public ShovelBase(ToolMaterial material, float attackDamage, float attackSpeed) {
		super(material, attackDamage, attackSpeed, new Item.Settings().group(ItemGroups.TOOLS));
		this.material = material;
	}
	public ShovelBase(ToolMaterial material) {
		this(material, 1.5F, -3.0F);
	}
}