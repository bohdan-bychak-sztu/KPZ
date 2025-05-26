package warehouse;

import product.Product;
import reporting.Reportable;

import java.util.*;

public class Warehouse implements Reportable {
    private final Map<Product, Integer> stock = new HashMap<>();
    private final Map<Product, String> lastDeliveryDate = new HashMap<>();

    public void addProduct(Product product, int quantity, String date) {
        stock.put(product, stock.getOrDefault(product, 0) + quantity);
        lastDeliveryDate.put(product, date);
    }

    public boolean removeProduct(Product product, int quantity) {
        if (stock.containsKey(product) && stock.get(product) >= quantity) {
            stock.put(product, stock.get(product) - quantity);
            return true;
        }
        return false;
    }

    @Override
    public void generateReport() {
        for (Product product : stock.keySet()) {
            System.out.printf("%s | Quantity: %d | Last Delivery: %s%n",
                    product.toString(),
                    stock.get(product),
                    lastDeliveryDate.get(product));
        }
    }

    public Map<Product, Integer> getStock() {
        return stock;
    }
}
