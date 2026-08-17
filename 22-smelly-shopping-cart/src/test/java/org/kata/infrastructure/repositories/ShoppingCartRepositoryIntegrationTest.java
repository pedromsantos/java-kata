package org.kata.infrastructure.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.kata.domain.models.Cart;
import org.kata.domain.models.Product;
import org.kata.domain.repositories.ShoppingCartRepository;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingCartRepositoryIntegrationTest {
    private ShoppingCartRepository repository;

    private static Cart aCartWithProducts(String id) {
        Cart cart = new Cart(id, "Ada Lovelace");
        cart.addProduct(new Product("MUG", "Coffee Mug", 7.5), 2);
        cart.addProduct(new Product("VOUCHER", "Gift Voucher", 5), 1);
        return cart;
    }

    @BeforeEach
    void setUp() {
        InMemoryShoppingCartRepository.clear();
        repository = new InMemoryShoppingCartRepository();
    }

    @AfterEach
    void tearDown() {
        InMemoryShoppingCartRepository.clear();
    }

    @Test
    void findsCartWhenSavedThroughRepository() {
        Cart cart = aCartWithProducts("repository-integration-cart-1");

        repository.save(cart);
        var found = repository.findById(cart.id);

        assertThat(found).contains(cart);
    }

    @Test
    void returnsEmptyWhenCartIdIsUnknown() {
        assertThat(repository.findById("unknown-cart")).isEmpty();
    }
}
