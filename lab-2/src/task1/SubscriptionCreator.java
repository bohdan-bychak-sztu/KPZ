package task1;

public interface SubscriptionCreator {
    default Subscription createSubscription(String type){
        return switch (type.toLowerCase()) {
            case "domestic" -> new DomesticSubscription();
            case "educational" -> new EducationalSubscription();
            case "premium" -> new PremiumSubscription();
            default -> throw new IllegalArgumentException("Unknown subscription type");
        };
    }
}
