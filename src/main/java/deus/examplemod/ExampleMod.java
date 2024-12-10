package deus.examplemod;

import deus.examplemod.block.ExamplemodBlocks;
import deus.examplemod.item.ExamplemodItems;
import deus.examplemod.util.configuration.ConfigHandler;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class ExampleMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static final String MOD_ID = "examplemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ConfigHandler MOD_CONFIG = new deus.examplemod.util.configuration.ConfigHandler();

	@Override
    public void onInitialize() {
        LOGGER.info("{} initialized.", ExampleMod.MOD_ID);
		ExamplemodItems.initialize();
		ExamplemodBlocks.initialize();
    }

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}

	@Override
	public void initNamespaces() {

	}
}
