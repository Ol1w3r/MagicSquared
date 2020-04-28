package magicsquared;

import magicsquared.init.client.ModEntityRenderer;
import net.fabricmc.api.ClientModInitializer;

public class ClientEntry implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		new ModEntityRenderer();
	}

}
