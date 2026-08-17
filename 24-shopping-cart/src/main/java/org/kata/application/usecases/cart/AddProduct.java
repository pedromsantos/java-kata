package org.kata.application.usecases.cart;

public interface AddProduct {
    void execute(String cartId, String productId);
}
