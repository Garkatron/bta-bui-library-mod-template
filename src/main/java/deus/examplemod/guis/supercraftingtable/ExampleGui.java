package deus.examplemod.guis.supercraftingtable;

import deus.builib.guimanagement.AdvancedContainer;
import deus.builib.guimanagement.AdvancedGuiContainer;
import deus.builib.guimanagement.routing.Page;
import deus.builib.guimanagement.routing.Router;
import net.minecraft.core.player.inventory.IInventory;

public class ExampleGui extends AdvancedGuiContainer {
	private static final Page page = new ExamplePage(router);

	static {
		router.registerRoute("0ºhome", page);
		router.navigateTo("0ºhome");

	}

	public ExampleGui(IInventory inventory, IInventory playerInventory) {
		super(new ExampleContainer(page, inventory, playerInventory));
	}



}
