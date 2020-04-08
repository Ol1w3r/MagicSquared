package magicsquared.init.items;

import magicsquared.init.ItemGroups;
import net.minecraft.item.Item;

public class GemItem extends Item {

	private GEM_TYPES type;
	
	public GemItem(GEM_TYPES type) {
		
		super(new Item.Settings().group(ItemGroups.GENERAL));
		
		this.type = type;
	}
	
	public GEM_TYPES getType() { return this.type; }
	
	public enum GEM_TYPES {
		AMETHYST,
		AZURITE,
		PERIDOT,
		PHOSPHOPHYLLITE,
		RUBY,
		SAPPHIRE,
	}
}
