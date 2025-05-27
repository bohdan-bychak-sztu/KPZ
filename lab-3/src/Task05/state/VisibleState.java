package Task05.state;


import Task05.LightElementNode;

public class VisibleState implements VisibilityState {
    @Override
    public void render(LightElementNode node) {
        node.renderInternal();
    }

    @Override
    public String outerHTML(LightElementNode node) {
        return node.outerHTMLInternal();
    }
}
