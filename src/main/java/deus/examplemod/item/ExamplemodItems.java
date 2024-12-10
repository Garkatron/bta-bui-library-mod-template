package deus.examplemod.item;

import deus.examplemod.ExampleMod;
import deus.examplemod.util.blockanditems.ItemMaker;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;


public class ExamplemodItems {

	public static Item exampleItem;

	public static void initialize() {

		ItemBuilder genericItemBuilder = new ItemBuilder(ExampleMod.MOD_ID);

		exampleItem = genericItemBuilder.build(
			new Item("exampleItem", ExampleMod.MOD_CONFIG.newItemID())
		);

		ItemMaker.assignPriorities(ExamplemodItems.class);
	}
}
