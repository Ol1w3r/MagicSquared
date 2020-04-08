package magicsquared;

import magicsquared.init.blocks.RegisterBlocks;
import magicsquared.init.items.RegisterItems;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		util.LOGGER.debug("MagicSquared Main initiated");
		new RegisterItems();
		new RegisterBlocks();
	}
}
