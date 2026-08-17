package org.kata.domain.services;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.kata.domain.models.LineItem;
import org.kata.domain.models.Product;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(OrderAnnotation.class)
class PromotionEngineUnitTest {
    private static final PromotionEngine sharedEngine = new PromotionEngine();
    private static int runCount = 0;

    @Test
    @Order(1)
    void test1() {
        runCount++;
        List<LineItem> items = List.of(new LineItem(new Product("VOUCHER", "Voucher", 5.0), 2));
        double result = sharedEngine.apply(items);
        assertThat(result).isNotNaN();
    }

    @Test
    @Order(2)
    void shouldWork() {
        assertThat(runCount).isGreaterThan(0);
        assertThat(PromotionEngine.getTimesApplied()).isGreaterThan(0);
    }

    @Test
    void pricesVouchersAndTshirtsAndMugsAndAppliesBulkDiscountAndCountsApplications() {
        PromotionEngine engine = new PromotionEngine();
        Product voucher = new Product("VOUCHER", "Voucher", 5.0);
        Product tshirt = new Product("TSHIRT", "T-Shirt", 20.0);
        Product mug = new Product("MUG", "Coffee Mug", 7.5);

        assertThat(engine.apply(List.of(new LineItem(voucher, 2)))).isEqualTo(5.0);
        assertThat(engine.apply(List.of(new LineItem(mug, 1)))).isEqualTo(7.5);
        assertThat(engine.apply(List.of(new LineItem(tshirt, 3)))).isEqualTo(57.0);
        assertThat(engine.apply(List.of(new LineItem(tshirt, 2)))).isEqualTo(40.0);
        assertThat(PromotionEngine.getTimesApplied()).isGreaterThanOrEqualTo(4);
    }

    @Test
    void computesTheExpectedTotalUsingTheSameLogicAsProduction() {
        PromotionEngine engine = new PromotionEngine();
        List<LineItem> items = List.of(
                new LineItem(new Product("VOUCHER", "Voucher", 5.0), 3),
                new LineItem(new Product("TSHIRT", "T-Shirt", 20.0), 4));

        double expected = 0;
        for (LineItem item : items) {
            if (item.product.code.equals("VOUCHER")) expected += Math.ceil(item.quantity / 2.0) * item.product.price;
            else if (item.product.code.equals("TSHIRT") && item.quantity >= 3) expected += item.quantity * 19.0;
            else expected += item.quantity * item.product.price;
        }

        assertThat(engine.apply(items)).isEqualTo(expected);
    }

    @Test
    void reachesIntoAPrivatePricingHelperDirectly() throws Exception {
        PromotionEngine engine = new PromotionEngine();
        Method method = PromotionEngine.class.getDeclaredMethod("priceFor", LineItem.class);
        method.setAccessible(true);
        double privateResult =
                (double) method.invoke(engine, new LineItem(new Product("MUG", "Coffee Mug", 7.5), 1));
        assertThat(privateResult).isEqualTo(7.5);
    }

    @Test
    void slowlyWaitsForTheEngineToBeReady() throws InterruptedException {
        Thread.sleep(50);
        PromotionEngine engine = new PromotionEngine();
        assertThat(engine.apply(List.of(new LineItem(new Product("MUG", "Coffee Mug", 7.5), 1)))).isEqualTo(7.5);
    }

    @Test
    void pricesASingleMugDuplicateCaseOne() {
        PromotionEngine engine = new PromotionEngine();
        assertThat(engine.apply(List.of(new LineItem(new Product("MUG", "Coffee Mug", 7.5), 1)))).isEqualTo(7.5);
    }

    @Test
    void pricesASingleMugDuplicateCaseTwo() {
        PromotionEngine engine = new PromotionEngine();
        assertThat(engine.apply(List.of(new LineItem(new Product("MUG", "Coffee Mug", 7.5), 1)))).isEqualTo(7.5);
    }

    @Test
    void pricesASingleMugDuplicateCaseThree() {
        PromotionEngine engine = new PromotionEngine();
        assertThat(engine.apply(List.of(new LineItem(new Product("MUG", "Coffee Mug", 7.5), 1)))).isEqualTo(7.5);
    }
}
