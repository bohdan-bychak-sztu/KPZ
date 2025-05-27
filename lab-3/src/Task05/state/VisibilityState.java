package Task05.state;

import Task05.LightElementNode;

public interface VisibilityState {
    void render(LightElementNode node);
    String outerHTML(LightElementNode node);
}
