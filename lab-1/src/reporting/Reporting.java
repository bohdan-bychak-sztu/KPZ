package reporting;

import product.Product;
import warehouse.Warehouse;
import utils.DateUtil;

public class Reporting implements Reportable {
    private final Warehouse warehouse;

    public Reporting(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void registerArrival(Product product, int quantity) {
        String today = DateUtil.getTodayDate();
        warehouse.addProduct(product, quantity, today);
        System.out.printf("Arrival Registered: %s x %d%n", product.getName(), quantity);
    }

    public void registerShipment(Product product, int quantity) {
        if (warehouse.removeProduct(product, quantity)) {
            System.out.printf("Shipment Registered: %s x %d%n", product.getName(), quantity);
        } else {
            System.out.printf("Not enough stock for %s%n", product.getName());
        }
    }

    @Override
    public void generateReport() {
        System.out.println("=== Inventory Report ===");
        warehouse.generateReport();
    }

}
