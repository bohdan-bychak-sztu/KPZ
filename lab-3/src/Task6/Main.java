package Task6;

import Task05.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Style container = new Style();
        container.set("margin-left", "4px");

        Style header = new Style();
        header.set("color", "blue");
        header.set("font-weight", "bold");

        Style intro = new Style();
        intro.set("color", "green");

        Style highlight = new Style();
        highlight.set("color", "red");

        Style list = new Style();
        list.set("color", "yellow");

        Style item = new Style();
        item.set("color", "blue");
        item.set("margin-left", "4px");

        StyleRegistry.registerClass("container", container);
        StyleRegistry.registerClass("header", header);
        StyleRegistry.registerClass("intro", intro);
        StyleRegistry.registerClass("highlight", highlight);
        StyleRegistry.registerClass("list", list);
        StyleRegistry.registerClass("item", item);

        List<String> lines = Files.readAllLines(Path.of("book.txt"));

        System.out.println("=== Без легковаговика ===");
        LightElementNode normalTree = BookHtmlConverter.convertToHtml(lines, false);
        System.gc(); Thread.sleep(100);
        long mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        normalTree.render();
        System.out.println("\nВикористано памʼяті: " + mem1 + " байт");

        System.out.println("\n=== З легковаговиком ===");
        LightElementNode flyweightTree = BookHtmlConverter.convertToHtml(lines, true);
        System.gc(); Thread.sleep(100);
        long mem2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        flyweightTree.render();
        System.out.println("\nВикористано памʼяті: " + mem2 + " байт");
    }

}
