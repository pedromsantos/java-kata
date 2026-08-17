package org.kata.domain.services;

import java.util.List;
import java.util.Locale;

import org.kata.domain.models.LineItem;
import org.kata.domain.ports.NotificationPort;

public class CartSummaryNotifier {
    private final PromotionEngine promotionEngine;
    private final NotificationPort notifications;

    public CartSummaryNotifier(PromotionEngine promotionEngine, NotificationPort notifications) {
        this.promotionEngine = promotionEngine;
        this.notifications = notifications;
    }

    public double notifyTotal(String customerEmail, List<LineItem> items) {
        double total = promotionEngine.apply(items);
        notifications.send(customerEmail, String.format(Locale.US, "Cart total: %.2f€", total));
        return total;
    }
}
