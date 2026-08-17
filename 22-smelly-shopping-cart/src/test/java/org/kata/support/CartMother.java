package org.kata.support;

import org.kata.domain.models.Cart;
import org.kata.domain.models.Product;

public final class CartMother {
    private static final String DEFAULT_CART_ID = "cart-1";
    private static final String DEFAULT_CUSTOMER_NAME = "Ada Lovelace";

    private CartMother() {}

    public static Cart create() {
        return new Cart(DEFAULT_CART_ID, DEFAULT_CUSTOMER_NAME);
    }

    public static Cart emptyCart() {
        return create();
    }

    public static Cart voucherCart(int quantity) {
        Cart cart = create();
        cart.addProduct(new Product("VOUCHER", "Voucher", 5), quantity);
        return cart;
    }

    public static Cart tShirtCart(int quantity) {
        Cart cart = create();
        cart.addProduct(new Product("TSHIRT", "T-Shirt", 20), quantity);
        return cart;
    }
}
