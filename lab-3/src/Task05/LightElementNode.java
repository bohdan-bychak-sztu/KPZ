package Task05;

import java.util.*;

import Task05.iterator.BreadthFirstIterator;
import Task05.iterator.DepthFirstIterator;
import Task05.iterator.NodeIterator;
import Task6.*;

public class LightElementNode extends LightNode {
    private final NodeInfo nodeInfo;
    private final List<LightNode> children = new ArrayList<>();
    private final Style inlineStyle = new Style();
    private final Map<String, List<EventListener>> eventListeners = new HashMap<>();

    public LightElementNode(String tagName, DisplayType displayType, ClosingType closingType, List<String> classNames) {
        this.nodeInfo = new NodeInfo(tagName, displayType, closingType, classNames);
    }

    public LightElementNode(String tagName, DisplayType displayType, ClosingType closingType) {
        this.nodeInfo = new NodeInfo(tagName, displayType, closingType, List.of());
    }

    public LightElementNode(NodeInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    public void setStyle(String key, String value) {
        inlineStyle.set(key, value);
    }

    public void addChild(LightNode child) {
        children.add(child);
    }

    public int getChildCount() {
        return children.size();
    }

    @Override
    public String outerHTML() {
        StringBuilder html = new StringBuilder();
        html.append("<").append(nodeInfo.getTagName());

        List<String> classes = nodeInfo.getClassNames();
        if (!classes.isEmpty()) {
            html.append(" class=\"");
            StringJoiner joiner = new StringJoiner(" ");
            classes.forEach(joiner::add);
            html.append(joiner).append("\"");
        }

        if (nodeInfo.getClosingType() == ClosingType.SELF_CLOSING) {
            html.append(" />");
        } else {
            html.append(">");
            for (LightNode child : children) {
                html.append(child.outerHTML());
            }
            html.append("</").append(nodeInfo.getTagName()).append(">");
        }

        return html.toString();
    }

    @Override
    public String innerHTML() {
        StringBuilder inner = new StringBuilder();
        for (LightNode child : children) {
            inner.append(child.outerHTML());
        }
        return inner.toString();
    }

    @Override
    public void render() {
        Style style = resolveStyle();
        String leftPad = " ".repeat(style.getLeftMargin());

        System.out.print(leftPad + style.toAnsiStart());
        for (LightNode child : children) {
            child.render();
        }
        System.out.println(style.toAnsiEnd());
    }

    private Style resolveStyle() {
        Style combined = StyleRegistry.getStyleForClasses(nodeInfo.getClassNames());
        combined.merge(inlineStyle);
        return combined;
    }

    public void addClass(String className) {
        nodeInfo.addClass(className);
    }

    public void addEventListener(String eventType, EventListener listener) {
        eventListeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    public void triggerEvent(String eventType) {
        List<EventListener> listeners = eventListeners.getOrDefault(eventType, List.of());
        for (EventListener listener : listeners) {
            listener.handleEvent(eventType, this);
        }
    }
    public List<LightNode> getChildren() {
        return children;
    }

    public NodeIterator getDepthFirstIterator() {
        return new DepthFirstIterator(this);
    }

    public NodeIterator getBreadthFirstIterator() {
        return new BreadthFirstIterator(this);
    }
}
