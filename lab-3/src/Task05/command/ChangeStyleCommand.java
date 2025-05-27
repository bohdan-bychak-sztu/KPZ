package Task05.command;

import Task05.LightElementNode;

public class ChangeStyleCommand implements Command {
    private final LightElementNode element;
    private final String key, newValue;
    private String oldValue;

    public ChangeStyleCommand(LightElementNode element, String key, String value) {
        this.element = element;
        this.key = key;
        this.newValue = value;
    }

    @Override
    public void execute() {
        oldValue = element.getInlineStyle().get(key);
        element.setStyle(key, newValue);
    }

    @Override
    public void undo() {
        element.setStyle(key, oldValue);
    }
}
