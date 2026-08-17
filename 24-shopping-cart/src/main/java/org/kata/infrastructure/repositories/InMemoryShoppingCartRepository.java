package org.kata.infrastructure.repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.kata.domain.repositories.ShoppingCartRepository;

public class InMemoryShoppingCartRepository implements ShoppingCartRepository {
    @Override
    public void save(Object cart) {}

    @Override
    public Optional<Object> get(String id) {
        return Optional.of(Map.of("id", id));
    }

    @Override
    public List<Object> getAll() {
        return List.of();
    }
}
