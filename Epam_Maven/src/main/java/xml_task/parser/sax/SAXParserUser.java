package xml_task.parser.sax;

import xml_task.model.Gem;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParserUser {
	private static SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

	public static List<Gem> parseGems(File xml, File xsd) {
		List<Gem> gemList = new ArrayList<>();
		try {
			saxParserFactory.setSchema(SAXValidator.createSchema(xsd));

			SAXParser saxParser = saxParserFactory.newSAXParser();
			SAXHandler saxHandler = new SAXHandler();
			saxParser.parse(xml, saxHandler);

			gemList = saxHandler.getGemList();
		} catch (SAXException | ParserConfigurationException | IOException ex) {
			ex.printStackTrace();
		}

		return gemList;
	}
}
