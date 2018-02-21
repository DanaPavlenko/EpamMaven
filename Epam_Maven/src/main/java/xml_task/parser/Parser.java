package xml_task.parser;

import xml_task.filechecker.ExtensionChecker;
import xml_task.comparator.GemComparator;
import xml_task.model.Gem;
import xml_task.parser.dom.DOMParserUser;
import xml_task.parser.sax.SAXParserUser;
import xml_task.parser.stax.StAXReader;

import java.io.File;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Parser {

	private Map<String, String> menu;
	private Map<String, Printable> menuItems;

	private static File xml = new File("src\\main\\resources\\xml\\gemXML.xml");
	private static File xsd = new File("src\\main\\resources\\xml\\gemXSD.xsd");

	public Parser() {
		this.menu = new LinkedHashMap<>();
		this.menuItems = new LinkedHashMap<>();

		this.menu.put("1", "1 - SAX");
		this.menu.put("2", "2 - STAX");
		this.menu.put("3", "3 - DOM");
		this.menu.put("Q", "Q - for exit");

		this.menuItems.put("1", this::parseUsingSAX);
		this.menuItems.put("2", this::parseUsingSTAX);
		this.menuItems.put("3", this::parseUsingDOM);

	}

	private void parseUsingSAX() {
		if (checkIfXML(xml) && checkIfXSD(xsd))
			printList(SAXParserUser.parseGems(xml, xsd), "SAX");
	}

	private void parseUsingSTAX() {
		if (checkIfXML(xml) && checkIfXSD(xsd))
			printList(StAXReader.parseGems(xml, xsd), "StAX");
	}

	private void parseUsingDOM() {
		if (checkIfXML(xml) && checkIfXSD(xsd))
			printList(DOMParserUser.getGemList(xml, xsd), "DOM");
	}

	private static boolean checkIfXSD(File xsd) {
		return ExtensionChecker.isXSD(xsd);
	}

	private static boolean checkIfXML(File xml) {
		return ExtensionChecker.isXML(xml);
	}

	private void printList(List<Gem> gems, String parserName) {
		Collections.sort(gems, new GemComparator());
		System.out.println(parserName);
		for (Gem gem : gems) {
			System.out.println(gem);
		}
	}

	private void outputMenu() {
		System.out.println("\nSelect parser you would like to use:");
		for (String key : menu.keySet())
			if (key.length() == 1)
				System.out.println(menu.get(key));
	}

	public void show() {
		Scanner sc = new Scanner(System.in);
		String keyMenu;
		do {
			outputMenu();
			keyMenu = sc.nextLine().toUpperCase();
			try {
				menuItems.get(keyMenu).print();
				// CHANGE!!!
			} catch (NullPointerException e) {
				System.out.println("Invalid input!!! Please, try again");
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		} while (!keyMenu.equals("Q"));
		sc.close();
	}

}
