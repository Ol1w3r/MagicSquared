package magicsquared.init.blocks;

import magicsquared.interfaces.IGem;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class GemBlock extends Block implements IGem {
	
	private GEM_TYPE type;
	
	public GemBlock(GEM_TYPE type) {
		super(getSettingsFromType(type));
		this.type = type;
	}

	@Override
	public GEM_TYPE getType() {
		return type;
	}
	
	public static Settings getSettingsFromType(GEM_TYPE type) {
		
		FabricBlockSettings settings = FabricBlockSettings.of(Material.METAL);
		
		float h = type.getHardness();
		
		int level = h >= 8 ? 3 : 
			(h > 6 ? 2 : 
			(h > 4 ? 1 : 
					 0));
		if(h > 2)
			settings.strength(h * 0.5F, h * 0.6F).breakByTool(FabricToolTags.PICKAXES, level);
		else
			settings.strength(h * 0.5F, h * 0.6F).breakByHand(true);
		
		return settings.build();
	}


}
