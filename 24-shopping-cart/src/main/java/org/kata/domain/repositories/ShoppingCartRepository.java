package org.kata.domain.repositories;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository {
    void save(Object cart);

    Optional<Object> get(String id);

    List<Object> getAll();
}
