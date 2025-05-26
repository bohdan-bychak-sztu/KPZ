package task1;

public class WebSite implements SubscriptionCreator {
    @Override
    public Subscription createSubscription(String type) {
        System.out.println("Creating subscription via Web Site...");
        return SubscriptionCreator.super.createSubscription(type);
    }
}
