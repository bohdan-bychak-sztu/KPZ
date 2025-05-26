package Task6;

import Task05.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodeInfoFactory {
    private static final Map<String, NodeInfo> cache = new HashMap<>();

    public static NodeInfo get(String tagName, DisplayType displayType, ClosingType closingType, List<String> classList) {
        String key = tagName + "|" + displayType + "|" + closingType + "|" + String.join(",", classList);
        return cache.computeIfAbsent(key, k -> new NodeInfo(tagName, displayType, closingType, classList));
    }
}
