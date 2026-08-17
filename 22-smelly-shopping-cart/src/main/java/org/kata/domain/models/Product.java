package org.kata.domain.models;

public class Product {
    public final String code;
    public final String name;
    public final double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public boolean equals(Product other) {
        return this.code.equals(other.code);
    }
}
