package Task05.strategies;

public class FileImageLoadingStrategy implements ImageLoadingStrategy {
    @Override
    public String load(String href) {
        return "[Image from file: " + href + "]";
    }
}
