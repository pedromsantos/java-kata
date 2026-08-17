package org.kata.domain.models;

public class LineItem {
    public final Product product;
    public int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
