package magicsquared;

import magicsquared.init.BiomeHandler;
import magicsquared.init.blocks.ModBlocks;
import magicsquared.init.blocks.blockentities.ModBlockEntities;
import magicsquared.init.entities.ModEntities;
import magicsquared.init.items.ModItems;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		util.LOGGER.debug("MagicSquared Main initiated");
		new ModEntities();
		new ModItems();
		new ModBlocks();
		new BiomeHandler();
		new ModBlockEntities();
	}
}
