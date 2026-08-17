package org.kata.domain.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.kata.domain.services.PromotionEngine;

public class Cart {
    private final List<LineItem> items = new ArrayList<>();
    private final PromotionEngine promotionEngine = new PromotionEngine();

    public final String id;
    public final String customerName;

    public Cart(String id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public void addProduct(Product product, int quantity) {
        Optional<LineItem> existing = items.stream()
                .filter(item -> item.product.equals(product))
                .findFirst();

        if (existing.isPresent()) existing.get().quantity += quantity;
        else items.add(new LineItem(product, quantity));
    }

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public List<LineItem> getLineItems() {
        return items;
    }

    public double calculateSubtotal() {
        return promotionEngine.apply(items);
    }
}
