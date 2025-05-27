package Task05;

import Task05.Visitor.Visitor;

public abstract class LightNode {
    public abstract String outerHTML();
    public abstract String innerHTML();
    public abstract void render();
    public abstract void accept(Visitor visitor);
}
