package Task6;

import Task05.*;

import java.util.HashMap;
import java.util.Map;

public class ElementFactory {
    private final Map<String, LightElementNode> flyweightCache = new HashMap<>();
    private final boolean useFlyweight;

    public ElementFactory(boolean useFlyweight) {
        this.useFlyweight = useFlyweight;
    }

    public LightElementNode createElement(String tag) {
        String className = switch (tag) {
            case "h1" -> "header";
            case "h2" -> "intro";
            case "blockquote" -> "highlight";
            case "p" -> "list";
            default -> "container";
        };

        if (!useFlyweight) {
            LightElementNode node = new LightElementNode(tag, DisplayType.BLOCK, ClosingType.STANDARD);
            node.addClass(className);
            return node;
        }

        if (flyweightCache.containsKey(tag)) {
            return flyweightCache.get(tag);
        }

        LightElementNode node = new LightElementNode(tag, DisplayType.BLOCK, ClosingType.STANDARD);
        node.addClass(className);
        flyweightCache.put(tag, node);
        return node;
    }

    public LightElementNode createContainer() {
        LightElementNode div = new LightElementNode("div", DisplayType.BLOCK, ClosingType.STANDARD);
        div.addClass("container");
        return div;
    }
}
