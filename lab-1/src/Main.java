import money.Money;
import product.Product;
import reporting.Reporting;
import warehouse.Warehouse;

public class Main {
    public static void main(String[] args) {
        Money price1 = new Money(100, 50); // 100.50 грн
        Product apple = new Product("Apple", "kg", price1);

        Warehouse warehouse = new Warehouse();
        Reporting reporting = new Reporting(warehouse);

        reporting.registerArrival(apple, 100);
        reporting.generateReport();

        apple.reducePrice(10, 0);
        System.out.println(apple.toString());

        reporting.registerShipment(apple, 30);
        reporting.generateReport();
    }
}