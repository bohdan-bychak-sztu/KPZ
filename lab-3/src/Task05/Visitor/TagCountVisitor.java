package Task05.Visitor;

import Task05.LightElementNode;
import Task05.LightImageNode;
import Task05.LightTextNode;

public class TagCountVisitor implements Visitor {
    private final String tagNameToCount;
    private int count = 0;

    public TagCountVisitor(String tagNameToCount) {
        this.tagNameToCount = tagNameToCount.toLowerCase();
    }

    public int getCount() {
        return count;
    }

    @Override
    public void visit(LightElementNode element) {
        if (element.outerHTML().startsWith("<" + tagNameToCount) ||
                element.outerHTML().startsWith("<" + tagNameToCount + " ")) {
            count++;
        }
    }

    @Override
    public void visit(LightTextNode text) {
    }

    @Override
    public void visit(LightImageNode image) {
        if (tagNameToCount.equalsIgnoreCase("img")) {
            count++;
        }
    }
}
