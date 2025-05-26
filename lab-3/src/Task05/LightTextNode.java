package Task05;

import java.util.ArrayList;
import java.util.List;

public class LightTextNode extends LightNode {
    private final String text;
    private final Style inlineStyle = new Style();
    private final List<String> cssClasses = new ArrayList<>();

    public LightTextNode(String text) {
        this.text = text;
    }

    public void setStyle(String key, String value) {
        inlineStyle.set(key, value);
    }

    public void addClass(String className) {
        cssClasses.add(className);
    }

    private Style resolveStyle() {
        Style combined = StyleRegistry.getStyleForClasses(cssClasses);
        combined.merge(inlineStyle);
        return combined;
    }

    @Override
    public void render() {
        Style style = resolveStyle();
        String leftPad = " ".repeat(style.getLeftMargin());
        System.out.print(leftPad + style.toAnsiStart() + text + style.toAnsiEnd());
    }

    @Override
    public String outerHTML() {
        return text;
    }

    @Override
    public String innerHTML() {
        return text;
    }
}
