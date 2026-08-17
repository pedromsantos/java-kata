package org.kata.infrastructure.repositories;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.kata.domain.models.Cart;
import org.kata.domain.repositories.ShoppingCartRepository;

public class InMemoryShoppingCartRepository implements ShoppingCartRepository {
    private static final Map<String, Cart> CARTS = new ConcurrentHashMap<>();

    @Override
    public void save(Cart cart) {
        CARTS.put(cart.id, cart);
    }

    @Override
    public Optional<Cart> findById(String id) {
        return Optional.ofNullable(CARTS.get(id));
    }

    public static void clear() {
        CARTS.clear();
    }
}
