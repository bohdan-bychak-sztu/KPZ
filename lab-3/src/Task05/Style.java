package Task05;

import java.util.HashMap;
import java.util.Map;

public class Style {
    private final Map<String, String> styles = new HashMap<>();

    public void set(String key, String value) {
        styles.put(key, value);
    }

    public String get(String key) {
        return styles.getOrDefault(key, "");
    }

    public void merge(Style other) {
        styles.putAll(other.styles);
    }

    public String toAnsiStart() {
        StringBuilder ansi = new StringBuilder();

        switch (get("color")) {
            case "red" -> ansi.append("\u001B[31m");
            case "green" -> ansi.append("\u001B[32m");
            case "yellow" -> ansi.append("\u001B[33m");
            case "blue" -> ansi.append("\u001B[34m");
            case "magenta" -> ansi.append("\u001B[35m");
            case "cyan" -> ansi.append("\u001B[36m");
            case "white" -> ansi.append("\u001B[37m");
        }

        if ("bold".equals(get("font-weight"))) {
            ansi.append("\u001B[1m");
        }

        return ansi.toString();
    }

    public String toAnsiEnd() {
        return "\u001B[0m";
    }

    public int getLeftMargin() {
        String margin = get("margin-left");
        if (margin.endsWith("px")) {
            try {
                return Integer.parseInt(margin.replace("px", "")) / 2;
            } catch (Exception ignored) {}
        }
        return 0;
    }
}