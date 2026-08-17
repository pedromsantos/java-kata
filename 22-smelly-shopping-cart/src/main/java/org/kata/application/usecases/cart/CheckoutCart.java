package org.kata.application.usecases.cart;

import java.util.Locale;
import java.util.function.DoubleSupplier;

import org.kata.domain.models.Cart;
import org.kata.domain.ports.Clock;
import org.kata.domain.ports.NotificationPort;
import org.kata.domain.repositories.ShoppingCartRepository;
import org.kata.infrastructure.gateways.EmailNotificationGateway;

public class CheckoutCart {
    private final ShoppingCartRepository repository;
    private final NotificationPort notifier;
    private final Clock clock;
    private final DoubleSupplier randomSource;

    public CheckoutCart(ShoppingCartRepository repository) {
        this(repository, new EmailNotificationGateway(), new OrderClock(), Math::random);
    }

    public CheckoutCart(
            ShoppingCartRepository repository,
            NotificationPort notifier,
            Clock clock,
            DoubleSupplier randomSource) {
        this.repository = repository;
        this.notifier = notifier;
        this.clock = clock;
        this.randomSource = randomSource;
    }

    public Receipt execute(String cartId, String customerEmail) throws Exception {
        Cart cart = repository.findById(cartId)
                .orElseThrow(() -> new Exception("Cart " + cartId + " not found"));

        double total = cart.calculateSubtotal();
        String confirmationCode = "ORD-" + (int) Math.floor(randomSource.getAsDouble() * 1_000_000);
        String confirmedAt = clock.now();

        notifier.send(customerEmail,
                String.format(Locale.US, "Order confirmed: %s, total %.2f€", confirmationCode, total));

        return new Receipt(cartId, total, confirmationCode, confirmedAt);
    }
}
