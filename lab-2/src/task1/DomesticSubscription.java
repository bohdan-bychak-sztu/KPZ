package task1;

import java.util.Arrays;
import java.util.List;

public class DomesticSubscription implements Subscription {
    protected double monthlyFee;
    protected int minPeriodMonths;
    protected List<String> channels;
    protected List<String> features;

    public DomesticSubscription() {
        this.monthlyFee = 10;
        this.minPeriodMonths = 1;
        this.channels = Arrays.asList("News", "Entertainment", "Kids");
        this.features = Arrays.asList("HD quality");
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
