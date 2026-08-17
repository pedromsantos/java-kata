package org.kata.domain.services;

import java.util.List;

import org.kata.domain.models.LineItem;

public class PromotionEngine {
    private static int timesApplied = 0;

    private final List<String> twoForOneCodes = List.of("VOUCHER");
    private final String bulkDiscountCode = "TSHIRT";
    private final int bulkDiscountThreshold = 3;
    private final double bulkDiscountPrice = 19.0;

    public double apply(List<LineItem> items) {
        PromotionEngine.timesApplied++;

        double total = 0;
        for (LineItem item : items) {
            total += priceFor(item);
        }
        return total;
    }

    public static int getTimesApplied() {
        return PromotionEngine.timesApplied;
    }

    private double priceFor(LineItem item) {
        if (twoForOneCodes.contains(item.product.code)) {
            int payableUnits = (int) Math.ceil(item.quantity / 2.0);
            return payableUnits * item.product.price;
        }

        if (item.product.code.equals(bulkDiscountCode) && item.quantity >= bulkDiscountThreshold) {
            return item.quantity * bulkDiscountPrice;
        }

        return item.quantity * item.product.price;
    }
}
