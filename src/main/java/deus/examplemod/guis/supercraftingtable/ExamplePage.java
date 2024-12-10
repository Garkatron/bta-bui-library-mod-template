package deus.examplemod.guis.supercraftingtable;

import deus.examplemod.ExampleMod;
import deus.guilib.guimanagement.routing.Page;
import deus.guilib.guimanagement.routing.Router;

public class ExamplePage extends Page {

	public ExamplePage(Router router, String... text) {
		super(ExampleMod.class, router);

		styleSheetPath = "/assets/"+ ExampleMod.MOD_ID +"/guis/ExampleBlockGui/test.yaml";
		xmlPath = "/assets/"+ ExampleMod.MOD_ID +"/guis/ExampleBlockGui/test.xml";
		// XMLProcessor.printChildNodes(XMLProcessor.parseXML(xmlPath),"-",0);

		// ! DON'T DELETE IT
		reloadXml();
		reloadStyles();

	}
}
