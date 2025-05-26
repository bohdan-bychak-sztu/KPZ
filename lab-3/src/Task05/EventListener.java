package Task05;

@FunctionalInterface
public interface EventListener {
    void handleEvent(String eventType, LightElementNode source);
}
