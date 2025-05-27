package Task05.templateMethod;

import Task05.LightElementNode;

public class SimpleRenderer extends RendererTemplate {
    @Override
    protected void renderStartTag(LightElementNode node) {
        System.out.println("<" + node.getNodeInfo().getTagName() + ">");
    }

    @Override
    protected void renderEndTag(LightElementNode node) {
        System.out.println("</" + node.getNodeInfo().getTagName() + ">");
    }
}
