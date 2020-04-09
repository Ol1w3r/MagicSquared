package magicsquared.init.items;

import magicsquared.init.ItemGroups;
import magicsquared.interfaces.IGem;
import net.minecraft.item.Item;

public class GemItem extends Item implements IGem {

	private GEM_TYPES type;
	
	public GemItem(GEM_TYPES type) {
		
		super(new Item.Settings().group(ItemGroups.GENERAL));
		
		this.type = type;
	}

	@Override
	public GEM_TYPES getType() {
		return type;
	}
}
