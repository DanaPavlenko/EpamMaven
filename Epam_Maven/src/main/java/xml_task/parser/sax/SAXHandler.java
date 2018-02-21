package xml_task.parser.sax;

import xml_task.model.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
	private List<Gem> gemList = new ArrayList<>();
	private Gem gem = null;
	private VisualParameters parameters = null;

	private boolean gName = false;
	private boolean gPreciousness = false;
	private boolean gOrigin = false;
	private boolean gParameters = false;
	private boolean gColor = false;
	private boolean gTransparency = false;
	private boolean gNumberOfEdges = false;
	private boolean gValue = false;

	public List<Gem> getGemList() {
		return this.gemList;
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("gem")) {
			String gemN = attributes.getValue("gemNo");
			gem = new Gem();
			gem.setGemNo(Integer.parseInt(gemN));
		} else if (qName.equalsIgnoreCase("name")) {
			gName = true;
		} else if (qName.equalsIgnoreCase("preciousness")) {
			gPreciousness = true;
		} else if (qName.equalsIgnoreCase("origin")) {
			gOrigin = true;
		} else if (qName.equalsIgnoreCase("visual_parameters")) {
			gParameters = true;
		} else if (qName.equalsIgnoreCase("color")) {
			gColor = true;
		} else if (qName.equalsIgnoreCase("transparency")) {
			gTransparency = true;
		} else if (qName.equalsIgnoreCase("edge_number")) {
			gNumberOfEdges = true;
		} else if (qName.equalsIgnoreCase("value")) {
			gValue = true;
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("gem")) {
			gemList.add(gem);
		}
	}

	public void characters(char ch[], int start, int length) throws SAXException {
		if (gName) {
			gem.setName(new String(ch, start, length));
			gName = false;
		} else if (gPreciousness) {
			gem.setPresiousness(Preciousness.valueOf(new String(ch, start, length).toUpperCase()));
			gPreciousness = false;
		} else if (gOrigin) {
			gem.setOrigin(new String(ch, start, length));
			gOrigin = false;
		}

		else if (gParameters) {
			parameters = new VisualParameters();
			gParameters = false;
		} else if (gColor) {
			Color color = Color.valueOf(new String(ch, start, length).toUpperCase());
			parameters.setColor(color);
			gColor = false;
		} else if (gTransparency) {
			int trans = Integer.parseInt(new String(ch, start, length));
			parameters.setTransparency(trans);
			gTransparency = false;
		} else if (gNumberOfEdges) {
			int edges = Integer.parseInt(new String(ch, start, length));
			parameters.setNumberOfEdges(edges);
			gem.setParameters(parameters);
			gNumberOfEdges = false;
		} else if (gValue) {
			int value = Integer.parseInt(new String(ch, start, length));
			gem.setValue(value);
			gValue = false;
		}

	}
}
