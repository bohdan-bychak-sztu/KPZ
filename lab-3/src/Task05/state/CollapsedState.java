package Task05.state;

import Task05.LightElementNode;

public class CollapsedState implements VisibilityState {
    @Override
    public void render(LightElementNode node) {
        System.out.println("<" + node.getTagName() + " .../>");
    }

    @Override
    public String outerHTML(LightElementNode node) {
        return "<" + node.getTagName() + " />";
    }
}
