package Lib;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final PricingService pricingService;
    private final ProductCatalog catalog;
    private final List<CartItem> items = new ArrayList<>();

    public ShoppingCart(PricingService pricingService, ProductCatalog catalog) {
        this.pricingService = pricingService;
        this.catalog = catalog;
        checkRep();
    }
    public int getItemCount() {
        checkRep();
        return items.size();
    }

    public double getTotalPrice() {
        checkRep();
        double total = 0.0;
        for (CartItem item : items) {
            total += pricingService.calculatePrice(item);
        }
        return total;
    }

    public void addItem(String sku, int quantity) {
        if (quantity <= 0) return;
            Product product = catalog.findByID(sku);
        if (product == null) return;
             for (CartItem item : items) {
                if (item.getProduct().getproductID().equals(sku)) {
                item.increaseQuantity(quantity); 
                return;
        }
    }
    items.add(new CartItem(product, quantity));
    checkRep();
    }

    public void removeItem(String sku) {
         for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getproductID().equals(sku)) {
                items.remove(i);
                checkRep();
                return;
             }
        }checkRep();     
    }

    public void clearCart() {
        items.clear();
        checkRep();
    }

    private void checkRep() {
        for (CartItem item : items) {
            if (item.getQuantity() <= 0) {
                throw new RuntimeException("CartItem quantity must be positive");
            }
            if (item.getProduct() == null) {
                throw new RuntimeException("CartItem product must not be null");
            }
        }
    }
}
