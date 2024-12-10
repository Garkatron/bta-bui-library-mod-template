package deus.examplemod.item;

import deus.examplemod.util.blockanditems.ItemMaker;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;

import static deus.examplemod.ExampleMod.MOD_CONFIG;
import static deus.examplemod.ExampleMod.MOD_ID;

public class ExamplemodItems {

	public static Item exampleItem;

	public static void initialize() {

		ItemBuilder genericItemBuilder = new ItemBuilder(MOD_ID);

		exampleItem = genericItemBuilder.build(
			new Item("exampleItem", MOD_CONFIG.newItemID())
		);

		ItemMaker.assignPriorities(ExamplemodItems.class);
	}
}
