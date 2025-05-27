package Task05;

import Task05.Visitor.TagCountVisitor;
import Task05.command.AddChildCommand;
import Task05.command.ChangeStyleCommand;
import Task05.command.Command;
import Task05.command.CommandManager;
import Task05.state.CollapsedState;
import Task05.state.HiddenState;
import Task05.state.VisibleState;
import Task05.strategies.FileImageLoadingStrategy;
import Task05.strategies.NetworkImageLoadingStrategy;
import Task05.templateMethod.FancyRenderer;
import Task05.templateMethod.SimpleRenderer;
import Task6.NodeInfo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
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


        LightElementNode div = new LightElementNode("div", DisplayType.BLOCK, ClosingType.STANDARD, List.of("container"));

        LightElementNode h1 = new LightElementNode("h1", DisplayType.BLOCK, ClosingType.STANDARD, List.of("header"));
        h1.addChild(new LightTextNode("Заголовок"));

        LightElementNode p = new LightElementNode("p", DisplayType.BLOCK, ClosingType.STANDARD, List.of("intro"));
        p.addChild(new LightTextNode("Це "));

        LightElementNode span = new LightElementNode("span", DisplayType.INLINE, ClosingType.STANDARD, List.of("highlight"));
        span.addChild(new LightTextNode("тестовий"));
        p.addChild(span);

        p.addChild(new LightTextNode(" абзац."));

        LightElementNode ul = new LightElementNode("ul", DisplayType.BLOCK, ClosingType.STANDARD, List.of("list"));

        LightElementNode li1 = new LightElementNode("li", DisplayType.BLOCK, ClosingType.STANDARD, List.of("item"));
        li1.addChild(new LightTextNode("Перший елемент"));

        LightElementNode li2 = new LightElementNode("li", DisplayType.BLOCK, ClosingType.STANDARD, List.of("item"));
        li2.setStyle("color", "red");
        li2.addChild(new LightTextNode("Другий елемент"));

        LightElementNode li3 = new LightElementNode("li", DisplayType.BLOCK, ClosingType.STANDARD, List.of("item"));
        li3.addChild(new LightTextNode("Третій елемент"));

        ul.addChild(li1);
        ul.addChild(li2);
        ul.addChild(li3);

        div.addChild(h1);
        div.addChild(p);
        div.addChild(ul);

        div.render();

        System.out.println("OuterHTML:");
        System.out.println(div.outerHTML());
        System.out.println("InnerHTML:");
        System.out.println(div.innerHTML());


        System.out.println("\n=== Strategy ===");
        LightNode fileImg = new LightImageNode("local/path/image.png");
        LightNode netImg = new LightImageNode("http://example.com/image.jpg");

        System.out.println("--- Rendering File Image ---");
        fileImg.render();

        System.out.println("--- Rendering Network Image ---");
        netImg.render();

        LightElementNode div1 = new LightElementNode("div1", DisplayType.BLOCK, ClosingType.STANDARD);
        div1.addChild(fileImg);
        div1.addChild(netImg);
        System.out.println("--- Rendering div with images ---");
        div1.render();

      
        System.out.println("\n=== Observer ===");
        Style btn = new Style();
        header.set("color", "blue");
        header.set("font-weight", "bold");
        StyleRegistry.registerClass("btn", header);

        LightElementNode button = new LightElementNode("button", DisplayType.INLINE, ClosingType.STANDARD, List.of("btn"));
        LightTextNode label = new LightTextNode("Click me!");
        button.addChild(label);


        button.addEventListener("click", (eventType, source) -> System.out.println("Button was clicked!"));
        button.addEventListener("mouseover", (eventType, source) -> System.out.println("Mouse is over the button."));

        System.out.println("HTML:");
        System.out.println(button.outerHTML());
        button.render();

        System.out.println("Triggering events:");
        button.triggerEvent("mouseover");
        button.triggerEvent("click");
        button.triggerEvent("click");


        System.out.println("\n=== Template method ===");
        div.setRenderer(new FancyRenderer());
        div.render();

        div.setRenderer(new SimpleRenderer());
        div.render();

        System.out.println("\n=== Visitor ===");
        TagCountVisitor visitor = new TagCountVisitor("li");
        div.accept(visitor);
        System.out.println("Кількість <li>: " + visitor.getCount());

        TagCountVisitor spanVisitor = new TagCountVisitor("span");
        div.accept(spanVisitor);
        System.out.println("Кількість <span>: " + spanVisitor.getCount());
        System.out.println("\n=== Command ===");
        CommandManager manager = new CommandManager();

        LightElementNode testDiv = new LightElementNode("div", DisplayType.BLOCK, ClosingType.STANDARD);
        LightElementNode testP = new LightElementNode("p", DisplayType.BLOCK, ClosingType.STANDARD);
        testP.addChild(new LightTextNode("Hello world!"));

        Command addCommand = new AddChildCommand(testDiv, testP);
        Command styleCommand = new ChangeStyleCommand(testP, "color", "magenta");

        manager.executeCommand(addCommand);
        manager.executeCommand(styleCommand);

        System.out.println("--- After Commands ---");
        testDiv.render();

        manager.undoLast();
        manager.undoLast();

        System.out.println("--- After Undo ---");
        testDiv.render();

        System.out.println("\n=== State ===");
        LightElementNode section = new LightElementNode("section", DisplayType.BLOCK, ClosingType.STANDARD);
        section.addChild(new LightTextNode("Цей елемент може змінювати стан видимості"));

        System.out.println("--- Видимий стан ---");
        section.setVisibilityState(new VisibleState());
        section.render();
        System.out.println(section.outerHTML());

        System.out.println("--- Прихований стан ---");
        section.setVisibilityState(new HiddenState());
        section.render();
        System.out.println(section.outerHTML());

        System.out.println("--- Згорнутий стан ---");
        section.setVisibilityState(new CollapsedState());
        section.render();
        System.out.println(section.outerHTML());
    }
}
