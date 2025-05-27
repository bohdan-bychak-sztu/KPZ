package Task05.state;

import Task05.LightElementNode;

public class HiddenState implements VisibilityState {
    @Override
    public void render(LightElementNode node) {

    }

    @Override
    public String outerHTML(LightElementNode node) {
        return "";
    }
}
