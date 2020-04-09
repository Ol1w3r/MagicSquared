package magicsquared.init.blocks;

import magicsquared.interfaces.IGem;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class GemBlock extends Block implements IGem {
	
	private GEM_TYPES type;
	
	public GemBlock(GEM_TYPES type) {
		super(getSettingsFromType(type));
		this.type = type;
	}

	@Override
	public GEM_TYPES getType() {
		return type;
	}
	public static Settings getSettingsFromType(GEM_TYPES type) {
		
		FabricBlockSettings settings = FabricBlockSettings.copy(Blocks.DIAMOND_BLOCK);
		
		switch(type) {
		
		case AZURITE:
		case AMETHYST:
		case PERIDOT:
		case PHOSPHOPHYLLITE:
		case RUBY:
		case SAPPHIRE:
		default:
			settings.strength(5, 6).breakByTool(FabricToolTags.PICKAXES, 3);
		}
		
		return settings.build();
	}


}
