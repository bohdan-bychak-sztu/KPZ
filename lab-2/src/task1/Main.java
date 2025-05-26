package task1;

public class Main {
    public static void main(String[] args) {
        SubscriptionCreator website = new WebSite();
        SubscriptionCreator app = new MobileApp();
        SubscriptionCreator call = new ManagerCall();

        Subscription s1 = website.createSubscription("domestic");
        s1.showInfo();

        System.out.println();

        Subscription s2 = app.createSubscription("educational");
        s2.showInfo();

        System.out.println();

        Subscription s3 = call.createSubscription("premium");
        s3.showInfo();
    }
}
