package xml_task.parser.dom;

import xml_task.model.Gem;
import org.w3c.dom.Document;

import java.io.File;
import java.util.List;

public class DOMParserUser {
    public static List<Gem> getGemList(File xml, File xsd){
        DOMDocCreator creator = new DOMDocCreator(xml);
        Document doc = creator.getDocument();

        DOMDocReader reader = new DOMDocReader();

        return reader.readDoc(doc);
    }
}
