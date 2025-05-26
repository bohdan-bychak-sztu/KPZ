package task1;

public class ManagerCall implements SubscriptionCreator {
    @Override
    public Subscription createSubscription(String type) {
        System.out.println("Creating subscription via Manager Call...");
        return SubscriptionCreator.super.createSubscription(type);
    }
}
