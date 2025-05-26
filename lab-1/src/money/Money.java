package money;

public class Money {
    private int major; // гривні
    private int minor; // копійки

    public Money(int major, int minor) {
        if (minor >= 100) {
            this.major = major + minor / 100;
            this.minor = minor % 100;
        } else {
            this.major = major;
            this.minor = minor;
        }
    }

    public void setMoney(int major, int minor) {
        this.major = major;
        this.minor = minor;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d ₴", major, minor);
    }

    public void decrease(int amountMajor, int amountMinor) {
        int totalCents = this.major * 100 + this.minor;
        int decreaseCents = amountMajor * 100 + amountMinor;
        totalCents -= decreaseCents;
        if (totalCents < 0) totalCents = 0;
        this.major = totalCents / 100;
        this.minor = totalCents % 100;
    }
}
