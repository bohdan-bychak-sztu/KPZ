package Task05.templateMethod;


import Task05.LightElementNode;

public class FancyRenderer extends RendererTemplate {
    @Override
    protected void beforeRender(LightElementNode node) {
        System.out.println("╔═ Start of <" + node.getNodeInfo().getTagName() + "> ═╗");
    }

    @Override
    protected void renderChildren(LightElementNode node) {
        System.out.println("║ Rendering children...");
        super.renderChildren(node);
    }

    @Override
    protected void afterRender(LightElementNode node) {
        System.out.println("╚═ End of <" + node.getNodeInfo().getTagName() + "> ═╝");
    }
}
