package xml_task.parser.dom;

import xml_task.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMDocReader {
	public List<Gem> readDoc(Document doc) {
		doc.getDocumentElement().normalize();
		List<Gem> gems = new ArrayList<>();

		NodeList nodeList = doc.getElementsByTagName("gem");

		for (int i = 0; i < nodeList.getLength(); i++) {
			Gem gem = new Gem();
			VisualParameters parameters;

			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				gem.setGemNo(Integer.parseInt(element.getAttribute("gemNo")));
				gem.setName(element.getElementsByTagName("name").item(0).getTextContent());
				gem.setPresiousness(Preciousness
						.valueOf(element.getElementsByTagName("preciousness").item(0).getTextContent().toUpperCase()));
				gem.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());

				parameters = getParameters(element.getElementsByTagName("visual_parameters"));
				gem.setParameters(parameters);
				gem.setValue(Integer.parseInt(element.getElementsByTagName("value").item(0).getTextContent()));
				gems.add(gem);
			}
		}
		return gems;
	}

	private VisualParameters getParameters(NodeList nodes) {
		VisualParameters parameters = new VisualParameters();
		if (nodes.item(0).getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) nodes.item(0);
			parameters.setColor(
					Color.valueOf(element.getElementsByTagName("color").item(0).getTextContent().toUpperCase()));
			parameters.setTransparency(
					Integer.parseInt(element.getElementsByTagName("transparency").item(0).getTextContent()));
			parameters.setNumberOfEdges(
					Integer.parseInt(element.getElementsByTagName("edge_number").item(0).getTextContent()));
		}
		return parameters;
	}
}
