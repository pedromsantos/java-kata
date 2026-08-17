package org.kata.domain.repositories;

import java.util.Optional;

import org.kata.domain.models.Cart;

public interface ShoppingCartRepository {
    void save(Cart cart);

    Optional<Cart> findById(String id);
}
