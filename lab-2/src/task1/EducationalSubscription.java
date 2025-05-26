package task1;

import java.util.Arrays;
import java.util.List;

public class EducationalSubscription implements Subscription {
    protected double monthlyFee;
    protected int minPeriodMonths;
    protected List<String> channels;
    protected List<String> features;

    public EducationalSubscription() {
        this.monthlyFee = 6;
        this.minPeriodMonths = 3;
        this.channels = Arrays.asList("Science", "Documentary", "History");
        this.features = Arrays.asList("No ads", "Offline access");
    }

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
