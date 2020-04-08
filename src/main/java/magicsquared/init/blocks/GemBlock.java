package magicsquared.init.blocks;

import magicsquared.init.items.GemItem.GEM_TYPES;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class GemBlock extends Block {
	
	public GemBlock(GEM_TYPES type) {
		super(getSettingsFromType(type));
	}
	
	public static Settings getSettingsFromType(GEM_TYPES type) {
		
		FabricBlockSettings settings = FabricBlockSettings.of(Material.METAL).breakByHand(false);
		
		switch(type) {
		
		case AZURITE:
		case AMETHYST:
		case PERIDOT:
		case PHOSPHOPHYLLITE:
		case RUBY:
		case SAPPHIRE:
		default:
			settings.strength(1, 1).breakByTool(FabricToolTags.PICKAXES);
		}
		
		return settings.build();
	}

}
