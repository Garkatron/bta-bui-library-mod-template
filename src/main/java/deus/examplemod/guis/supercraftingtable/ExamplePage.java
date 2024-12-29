package deus.examplemod.guis.supercraftingtable;

import deus.examplemod.ExampleMod;
import deus.builib.guimanagement.routing.Page;
import deus.builib.guimanagement.routing.Router;

public class ExamplePage extends Page {

	public ExamplePage(Router router, String... text) {
		super(ExampleMod.class, router);

		// Your xml path here
		xmlPath = "/assets/"+ ExampleMod.MOD_ID +"/guis/ExampleBlockGui/test.xml";

		setup(()->{
			// Your page logic here
		});



	}
}
