package org.kata.infrastructure.repositories;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.kata.domain.models.Cart;
import org.kata.domain.models.Product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;

@TestMethodOrder(OrderAnnotation.class)
class InMemoryShoppingCartRepositorySmellyIntegrationTest {

    @Test
    @Order(1)
    void test2() {
        InMemoryShoppingCartRepository repository = new InMemoryShoppingCartRepository();
        Cart cart = new Cart("cart-1", "Ada Lovelace");
        cart.addProduct(new Product("MUG", "Coffee Mug", 7.5), 1);

        repository.save(cart);

        assertThat(cart).isNotNull();
    }

    @Test
    @Order(2)
    void findsTheCartSavedEarlier() {
        InMemoryShoppingCartRepository repository = new InMemoryShoppingCartRepository();
        Optional<Cart> found = repository.findById("cart-1");

        assertThat(found).isPresent();
    }

    @Test
    void savesAndRefindsAndMutatesAndResavesAndCountsItemsAndChecksTheCustomerName() {
        InMemoryShoppingCartRepository repository = new InMemoryShoppingCartRepository();
        Cart cart = new Cart("cart-2", "Grace Hopper");
        cart.addProduct(new Product("VOUCHER", "Voucher", 5.0), 1);
        repository.save(cart);

        Cart firstFind = repository.findById("cart-2").orElseThrow();
        firstFind.addProduct(new Product("TSHIRT", "T-Shirt", 20.0), 1);
        repository.save(firstFind);

        Cart secondFind = repository.findById("cart-2").orElseThrow();
        assertThat(secondFind.id).isEqualTo("cart-2");
        assertThat(secondFind.customerName).isEqualTo("Grace Hopper");
        assertThat(secondFind.getLineItems()).hasSize(2);
        assertThat(repository.findById("does-not-exist")).isEmpty();
    }

    @Test
    void slowlyWaitsForTheInMemoryStoreToBeReady() throws InterruptedException {
        Thread.sleep(50);
        InMemoryShoppingCartRepository repository = new InMemoryShoppingCartRepository();
        Cart cart = new Cart("cart-3", "Margaret Hamilton");
        repository.save(cart);
        assertThat(repository.findById("cart-3")).isPresent();
    }

    @Test
    void savesACartDoubleInsteadOfARealCart() {
        Cart mockCart = spy(new Cart("cart-4", "Katherine Johnson"));
        InMemoryShoppingCartRepository repository = new InMemoryShoppingCartRepository();

        repository.save(mockCart);
        Optional<Cart> found = repository.findById("cart-4");

        assertThat(found).isPresent();
        assertThat(found.get()).isSameAs(mockCart);
    }
}
