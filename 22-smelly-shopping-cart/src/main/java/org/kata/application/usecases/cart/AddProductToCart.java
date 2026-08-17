package org.kata.application.usecases.cart;

import java.util.Map;

import org.kata.domain.models.Cart;
import org.kata.domain.models.Product;
import org.kata.domain.repositories.ShoppingCartRepository;

class ProductCatalog {
    private static final Map<String, Product> CATALOG = Map.of(
            "VOUCHER", new Product("VOUCHER", "Voucher", 5.0),
            "TSHIRT", new Product("TSHIRT", "T-Shirt", 20.0),
            "MUG", new Product("MUG", "Coffee Mug", 7.5));

    static Product find(String code) throws Exception {
        Product product = CATALOG.get(code);
        if (product == null) throw new Exception("Unknown product code " + code);
        return product;
    }
}

public class AddProductToCart {
    private final ShoppingCartRepository repository;

    public AddProductToCart(ShoppingCartRepository repository) {
        this.repository = repository;
    }

    public void execute(String cartId, String productCode, int quantity) throws Exception {
        Cart cart = repository.findById(cartId)
                .orElseThrow(() -> new Exception("Cart " + cartId + " not found"));

        cart.addProduct(ProductCatalog.find(productCode), quantity);
        repository.save(cart);
    }

    public void execute(String cartId, String productCode) throws Exception {
        execute(cartId, productCode, 1);
    }
}
