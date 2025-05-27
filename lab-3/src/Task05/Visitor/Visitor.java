package Task05.Visitor;

import Task05.LightElementNode;
import Task05.LightImageNode;
import Task05.LightTextNode;

public interface Visitor {
    void visit(LightElementNode element);
    void visit(LightTextNode text);
    void visit(LightImageNode image);
}
