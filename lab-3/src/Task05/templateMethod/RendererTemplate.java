package Task05.templateMethod;

import Task05.LightElementNode;

public abstract class RendererTemplate {
    public final void render(LightElementNode node) {
        beforeRender(node);
        renderStartTag(node);
        renderChildren(node);
        renderEndTag(node);
        afterRender(node);
    }

    protected void beforeRender(LightElementNode node) {}
    protected void renderStartTag(LightElementNode node) {}
    protected void renderChildren(LightElementNode node) {
        for (var child : node.getChildren()) {
            child.render();
        }
    }
    protected void renderEndTag(LightElementNode node) {}
    protected void afterRender(LightElementNode node) {}
}
