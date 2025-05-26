package Task6;

import Task05.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BookHtmlConverter {
    public static LightElementNode convertToHtml(List<String> lines, boolean useFlyweight) {
        LightElementNode root = new LightElementNode(NodeInfoFactory.get("div", DisplayType.BLOCK, ClosingType.STANDARD, List.of("container")));

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).stripTrailing();

            NodeInfo tagDef;
            if (i == 0) {
                tagDef = getTagDef("h1", List.of("header"), useFlyweight);
            } else if (line.length() < 20) {
                tagDef = getTagDef("h2", List.of("intro"), useFlyweight);
            } else if (Character.isWhitespace(line.charAt(0))) {
                tagDef = getTagDef("blockquote", List.of("highlight"), useFlyweight);
            } else {
                tagDef = getTagDef("p", List.of("item"), useFlyweight);
            }

            LightElementNode element = new LightElementNode(tagDef);
            element.addChild(new LightTextNode(line));
            root.addChild(element);
        }

        return root;
    }

    private static  NodeInfo getTagDef(String tag, List<String> classes, boolean useFlyweight) {
        if (useFlyweight) {
            return  NodeInfoFactory.get(tag, DisplayType.BLOCK, ClosingType.STANDARD, classes);
        } else {
            return new  NodeInfo(tag, DisplayType.BLOCK, ClosingType.STANDARD, classes);
        }
    }
}
