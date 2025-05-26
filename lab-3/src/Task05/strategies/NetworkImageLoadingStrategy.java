package Task05.strategies;

public class NetworkImageLoadingStrategy implements ImageLoadingStrategy {
    @Override
    public String load(String href) {
        return "[Image from network: " + href + "]";
    }
}
