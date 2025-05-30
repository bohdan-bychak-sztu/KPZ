package Task05;

import java.util.*;

import Task05.iterator.BreadthFirstIterator;
import Task05.iterator.DepthFirstIterator;
import Task05.iterator.NodeIterator;
import Task05.templateMethod.RendererTemplate;
import Task05.Visitor.Visitor;
import Task05.state.VisibilityState;
import Task05.state.VisibleState;
import Task6.*;

public class LightElementNode extends LightNode {
    private final NodeInfo nodeInfo;
    private final List<LightNode> children = new ArrayList<>();
    private final Style inlineStyle = new Style();
    private final Map<String, List<EventListener>> eventListeners = new HashMap<>();
    private RendererTemplate renderer;

    private VisibilityState visibilityState = new VisibleState();

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

    public NodeInfo getNodeInfo() {
        return nodeInfo;
    }

    public List<LightNode> getChildren() {
        return children;
    }
    public void addChild(LightNode child) {
        children.add(child);
    }

    public int getChildCount() {
        return children.size();
    }

    public String getTagName() {
        return nodeInfo.getTagName();
    }

    @Override
    public String outerHTML() {
        return visibilityState.outerHTML(this);
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
        visibilityState.render(this);
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

    public void renderInternal() {
      if (renderer != null) {
            renderer.render(this);
      }
      else{
        Style style = resolveStyle();
        String leftPad = " ".repeat(style.getLeftMargin());
            System.out.print(leftPad + style.toAnsiStart());
            for (LightNode child : children) {
                child.render();
            }
            System.out.println(style.toAnsiEnd());
        }
    }

    private Style resolveStyle() {
        Style combined = StyleRegistry.getStyleForClasses(nodeInfo.getClassNames());
        combined.merge(inlineStyle);
        return combined;
    }

    public String outerHTMLInternal() {
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
    public void setVisibilityState(VisibilityState state) {
        this.visibilityState = state;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (LightNode child : children) {
            child.accept(visitor);
        }
    }

    public void removeChild(LightNode child) {
        children.remove(child);
    }

    public Style getInlineStyle() {
        return inlineStyle;
    }

    public void setRenderer(RendererTemplate renderer) {
        this.renderer = renderer;
    }

    public NodeIterator getDepthFirstIterator() {
        return new DepthFirstIterator(this);
    }

    public NodeIterator getBreadthFirstIterator() {
        return new BreadthFirstIterator(this);
    }
}
