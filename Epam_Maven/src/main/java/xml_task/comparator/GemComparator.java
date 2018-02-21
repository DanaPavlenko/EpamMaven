package xml_task.comparator;

import xml_task.model.Gem;

import java.util.Comparator;

public class GemComparator implements Comparator<Gem> {
    @Override
    public int compare(Gem o1, Gem o2) {
        return Integer.compare(o1.getParameters().getTransparency(), o2.getParameters().getTransparency());
    }
}
