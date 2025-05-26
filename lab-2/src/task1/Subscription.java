package task1;

import java.util.List;

public interface Subscription {
    double getMonthlyFee();
    int getMinPeriodMonths();
    List<String> getChannels();
    List<String> getFeatures();

    default void showInfo() {
        System.out.println(getClass().getSimpleName() + ":");
        System.out.println("Price: $" + getMonthlyFee());
        System.out.println("Minimum period: " + getMinPeriodMonths() + " months");
        System.out.println("Channels: " + getChannels());
        System.out.println("Features: " + getFeatures());
    }
}
