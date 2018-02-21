package xml_task.parser.stax;

import xml_task.model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

@SuppressWarnings("restriction")
public class StAXReader {

	public static List<Gem> parseGems(File xml, File xsd){
        List<Gem> gemList = new ArrayList<>();
        Gem gem = null;
        VisualParameters parameters = null;
        

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xml));
            while(xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    String name = startElement.getName().getLocalPart();
                    switch (name) {
                        case "gem":
                            gem = new Gem();

                            Attribute idAttr = startElement.getAttributeByName(new QName("gemNo"));
                            if (idAttr != null) {
                                gem.setGemNo(Integer.parseInt(idAttr.getValue()));
                            }
                            break;
                        case "name":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert gem != null;
                            gem.setName(xmlEvent.asCharacters().getData());
                            break;
                        case "preciousness":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert gem != null;
                            gem.setPresiousness(Preciousness.valueOf(xmlEvent.asCharacters().getData().toUpperCase()));
                            break;
                        case "origin":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert gem != null;
                            gem.setOrigin(xmlEvent.asCharacters().getData());
                            break;
                        case "visual_parameters":
                            xmlEvent = xmlEventReader.nextEvent();
                            parameters = new VisualParameters();
                            break;
                        case "color":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert parameters != null;
                            parameters.setColor(Color.valueOf(xmlEvent.asCharacters().getData().toUpperCase()));
                            break;
                        case "transparency":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert parameters != null;
                            parameters.setTransparency(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "edge_number":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert parameters != null;
                            parameters.setNumberOfEdges(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            assert gem != null;
                            gem.setParameters(parameters);
                            break;
                        case "value":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert gem != null;
                            gem.setValue(Integer.parseInt(xmlEvent.asCharacters().getData()));
                           
                            break;
                    }
                }

                if(xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals("gem")){
                        gemList.add(gem);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return gemList;
    }
}
