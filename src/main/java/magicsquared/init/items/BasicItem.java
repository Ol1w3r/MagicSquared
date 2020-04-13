package magicsquared.init.items;

import magicsquared.init.ItemGroups;
import net.minecraft.item.Item;

public class BasicItem extends Item{

	public BasicItem() {
		super(new Item.Settings().group(ItemGroups.GENERAL));
	}
}
