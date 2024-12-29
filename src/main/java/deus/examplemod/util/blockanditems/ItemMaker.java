package deus.examplemod.util.blockanditems;

import deus.examplemod.ExampleMod;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.CreativeHelper;
import turniplabs.halplibe.helper.ItemBuilder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ItemMaker {
	public static ItemBuilder genericItemBuilder = new ItemBuilder(ExampleMod.MOD_ID);

	public static <T extends Item> T make(ItemBuilder builder, T item) {
		return builder.build(item);
	}

	public static  <T extends Item> T  make(T item) {
		return genericItemBuilder.build(item);
	}

	public static <T extends Item> List<Item> make(T... items) {
		List<Item> iItems = new ArrayList<>();
		for (T item : items) {
			iItems.add(genericItemBuilder.build(item));
		}
		return iItems;
	}

	public static <T extends Item> List<Item> make(ItemBuilder builder, T... items) {
		List<Item> iItems = new ArrayList<>();
		for (Item item : items) {
			iItems.add(builder.build(item));
		}
		return iItems;
	}

	public static void assignPriorities(Class<?> c) {
		int initialPriority = 1001;
		try {
			String[] staticFieldNames = StaticFieldsExtractor.extractor(c);
			for (String fieldName : staticFieldNames) {
				Field field = c.getDeclaredField(fieldName);
				field.setAccessible(true);
				Object value = field.get(null);

				if (value instanceof Item) {
					Item item = (Item) value;
					CreativeHelper.setPriority(item, initialPriority);
					initialPriority++;

				}
			}
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}


