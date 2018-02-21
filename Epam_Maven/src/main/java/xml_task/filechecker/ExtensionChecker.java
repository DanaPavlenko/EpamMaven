package xml_task.filechecker;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class ExtensionChecker {
    public static boolean isXML(File xml) {
        return xml.isFile() && FilenameUtils.getExtension(xml.getName()).equals("xml");
    }

    public static boolean isXSD(File xsd){
        return xsd.isFile() && FilenameUtils.getExtension(xsd.getName()).equals("xsd");
    }
}
