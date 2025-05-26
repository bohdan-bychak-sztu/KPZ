package Task05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StyleRegistry {
    private static final Map<String, Style> classStyles = new HashMap<>();

    public static void registerClass(String className, Style style) {
        classStyles.put(className, style);
    }

    public static Style getStyleForClasses(List<String> classNames) {
        Style result = new Style();
        for (String className : classNames) {
            Style classStyle = classStyles.get(className);
            if (classStyle != null) {
                result.merge(classStyle);
            }
        }
        return result;
    }
}
