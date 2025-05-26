package task1;

public class MobileApp implements SubscriptionCreator {
    @Override
    public Subscription createSubscription(String type) {
        System.out.println("Creating subscription via Mobile App...");
        return SubscriptionCreator.super.createSubscription(type);
    }
}
