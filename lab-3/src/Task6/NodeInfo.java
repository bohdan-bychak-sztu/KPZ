package Task6;

import Task05.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeInfo {
    private final String tagName;
    private final DisplayType displayType;
    private final ClosingType closingType;
    private final List<String> classNames;

    public NodeInfo(String tagName, DisplayType displayType, ClosingType closingType, List<String> classNames) {
        this.tagName = tagName;
        this.displayType = displayType;
        this.closingType = closingType;
        this.classNames = new ArrayList<>(classNames);
    }

    public String getTagName() {
        return tagName;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public ClosingType getClosingType() {
        return closingType;
    }

    public List<String> getClassNames() {
        return Collections.unmodifiableList(classNames);
    }
    public void addClass(String className) {
        classNames.add(className);
    }
}
