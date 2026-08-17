package org.kata.domain.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.kata.domain.models.LineItem;
import org.kata.domain.models.Product;
import org.kata.domain.ports.NotificationPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CartSummaryNotifierUnitTest {
    private static final long testRunTimestamp = System.currentTimeMillis();

    @Test
    void notifiesTheCustomerOfTheCartTotal() {
        PromotionEngine mockEngine = mock(PromotionEngine.class);
        NotificationPort mockNotifications = mock(NotificationPort.class);
        // Mocking a plain immutable value object -- spy() over a real instance
        // so field reads below still see real values (Product has no getters).
        Product mockProduct = spy(new Product("MUG", "Coffee Mug", 7.5));

        List<LineItem> items = List.of(new LineItem(mockProduct, 1));
        when(mockEngine.apply(items)).thenReturn(42.0);

        CartSummaryNotifier notifier = new CartSummaryNotifier(mockEngine, mockNotifications);
        double total = notifier.notifyTotal("customer@example.com", items);

        assertThat(total).isEqualTo(42.0);
        verify(mockEngine).apply(items);
        assertThat(mockProduct.code).isEqualTo("MUG");
    }

    @Test
    void recordsTheRunTimestampAlongsideTheNotification() {
        List<String> sent = new ArrayList<>();
        NotificationPort notifications = (to, message) -> sent.add(message);
        CartSummaryNotifier notifier = new CartSummaryNotifier(new PromotionEngine(), notifications);

        notifier.notifyTotal(
                "customer@example.com", List.of(new LineItem(new Product("MUG", "Coffee Mug", 7.5), 1)));

        assertThat(sent.get(0)).contains("Cart total");
        assertThat(testRunTimestamp).isLessThanOrEqualTo(System.currentTimeMillis());
    }
}
