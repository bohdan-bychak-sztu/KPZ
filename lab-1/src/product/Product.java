package product;

import money.Money;

public class Product {
    private String name;
    private String unit;
    private Money price;

    public Product(String name, String unit, Money price) {
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public void reducePrice(int major, int minor) {
        price.decrease(major, minor);
    }

    @Override
    public String toString() {
        return String.format("Product: %s, Unit: %s, Price: %s", name, unit, price.toString());
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
