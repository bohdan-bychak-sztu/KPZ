package Task05;

import Task05.strategies.FileImageLoadingStrategy;
import Task05.strategies.ImageLoadingStrategy;
import Task05.strategies.NetworkImageLoadingStrategy;

public class LightImageNode extends LightNode {
    private final String href;
    private final ImageLoadingStrategy strategy;

    public LightImageNode(String href) {
        this.href = href;
        this.strategy = selectStrategy(href);
    }

    private ImageLoadingStrategy selectStrategy(String href) {
        if (href.startsWith("http://") || href.startsWith("https://")) {
            return new NetworkImageLoadingStrategy();
        } else {
            return new FileImageLoadingStrategy();
        }
    }

    @Override
    public String outerHTML() {
        return "<img src=\"" + href + "\" />";
    }

    @Override
    public String innerHTML() {
        return "";
    }

    @Override
    public void render() {
        String loadedImage = strategy.load(href);
        System.out.println(loadedImage);
    }
}
