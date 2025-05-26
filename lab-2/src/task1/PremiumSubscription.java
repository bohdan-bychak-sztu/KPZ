package task1;

import java.util.Arrays;
import java.util.List;

public class PremiumSubscription implements Subscription {
    protected double monthlyFee;
    protected int minPeriodMonths;
    protected List<String> channels;
    protected List<String> features;

    public PremiumSubscription() {
        this.monthlyFee = 20;
        this.minPeriodMonths = 1;
        this.channels = Arrays.asList("All channels");
        this.features = Arrays.asList("4K quality", "Multiple screens", "No ads");    }


    @Override
    public double getMonthlyFee() {
        return monthlyFee;
    }

    @Override
    public int getMinPeriodMonths() {
        return minPeriodMonths;
    }

    @Override
    public List<String> getChannels() {
        return channels;
    }

    @Override
    public List<String> getFeatures() {
        return features;
    }
}
