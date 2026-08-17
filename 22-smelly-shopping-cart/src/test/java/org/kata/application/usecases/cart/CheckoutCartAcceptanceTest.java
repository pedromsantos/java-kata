package org.kata.application.usecases.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.kata.domain.models.Cart;
import org.kata.domain.models.Product;
import org.kata.domain.ports.Clock;
import org.kata.domain.ports.NotificationPort;
import org.kata.domain.repositories.ShoppingCartRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Acceptance tests for the CheckoutCart use case.
 *
 * <p>Boundary: use case -> domain. Mocked (external world only):
 * ShoppingCartRepository, NotificationPort, Clock, randomSource. Real: Cart,
 * Product, LineItem, PromotionEngine (the domain is exercised for real).
 */
class CheckoutCartAcceptanceTest {

    private static class FakeShoppingCartRepository implements ShoppingCartRepository {
        private final Map<String, Cart> carts = new HashMap<>();

        void seed(Cart cart) {
            carts.put(cart.id, cart);
        }

        @Override
        public void save(Cart cart) {
            carts.put(cart.id, cart);
        }

        @Override
        public Optional<Cart> findById(String id) {
            return Optional.ofNullable(carts.get(id));
        }
    }

    private static final Product MUG = new Product("MUG", "Coffee Mug", 7.5);
    private static final Product VOUCHER = new Product("VOUCHER", "Voucher", 5.0);
    private static final String FIXED_CONFIRMED_AT = "2024-01-01T00:00:00.000Z";

    private FakeShoppingCartRepository repository;
    private NotificationPort notifier;
    private CheckoutCart useCase;

    @BeforeEach
    void setUp() {
        repository = new FakeShoppingCartRepository();
        notifier = mock(NotificationPort.class);
        Clock fixedClock = () -> FIXED_CONFIRMED_AT;
        // fixedRandomSource returns 0.5 -> Math.floor(0.5 * 1_000_000) = 500000
        useCase = new CheckoutCart(repository, notifier, fixedClock, () -> 0.5);
    }

    @Test
    void confirmsCheckoutAndReturnsAReceiptWhenTheCartHasNoDiscounts() throws Exception {
        Cart cart = new Cart("cart-1", "Ada Lovelace");
        cart.addProduct(MUG, 1);
        repository.seed(cart);

        Receipt receipt = useCase.execute("cart-1", "ada@example.com");

        assertThat(receipt.cartId()).isEqualTo("cart-1");
        assertThat(receipt.total()).isEqualTo(7.5);
        assertThat(receipt.confirmationCode()).isEqualTo("ORD-500000");
        assertThat(receipt.confirmedAt()).isEqualTo(FIXED_CONFIRMED_AT);
    }

    @Test
    void notifiesTheCustomerOfTheConfirmedTotalWhenCheckoutSucceeds() throws Exception {
        Cart cart = new Cart("cart-2", "Ada Lovelace");
        cart.addProduct(MUG, 1);
        repository.seed(cart);

        Receipt receipt = useCase.execute("cart-2", "ada@example.com");

        verify(notifier, times(1))
                .send("ada@example.com", "Order confirmed: " + receipt.confirmationCode() + ", total 7.50€");
    }

    @Test
    void computesTheConfirmedTotalUsingRealPromotionRulesWhenTheCartQualifiesForATwoForOneDiscount()
            throws Exception {
        Cart cart = new Cart("cart-3", "Grace Hopper");
        cart.addProduct(VOUCHER, 3); // two-for-one: 2 payable units * 5.0€ = 10.0€
        repository.seed(cart);

        Receipt receipt = useCase.execute("cart-3", "grace@example.com");

        assertThat(receipt.total()).isEqualTo(10.0);
        verify(notifier).send("grace@example.com", "Order confirmed: " + receipt.confirmationCode() + ", total 10.00€");
    }

    @Test
    void rejectsCheckoutWhenTheCartDoesNotExist() {
        assertThatThrownBy(() -> useCase.execute("missing-cart", "nobody@example.com"))
                .hasMessage("Cart missing-cart not found");
    }

    @Test
    void doesNotNotifyTheCustomerWhenTheCartDoesNotExist() {
        assertThatThrownBy(() -> useCase.execute("missing-cart", "nobody@example.com"));

        verify(notifier, never()).send(anyString(), anyString());
    }
}
