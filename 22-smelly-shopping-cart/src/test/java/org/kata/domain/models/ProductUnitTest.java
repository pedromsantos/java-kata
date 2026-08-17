package org.kata.domain.models;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class ProductUnitTest {
    static Stream<Arguments> productsWithSameCode() {
        return Stream.of(
                Arguments.of(
                        "different names",
                        new Product("MUG", "Coffee Mug", 7.5),
                        new Product("MUG", "Travel Mug", 12)),
                Arguments.of(
                        "different prices",
                        new Product("VOUCHER", "Gift Voucher", 5),
                        new Product("VOUCHER", "Gift Voucher", 10)));
    }

    @ParameterizedTest(name = "treats products with the same code as equal despite {0}")
    @MethodSource("productsWithSameCode")
    void treatsProductsWithTheSameCodeAsEqualDespiteDifference(
            String difference, Product product, Product otherProduct) {
        assertThat(product.equals(otherProduct)).isTrue();
    }

    @Test
    void treatsProductsWithDistinctCodesAsDifferentWhenTheirDetailsMatch() {
        Product mug = new Product("MUG", "Coffee Mug", 7.5);
        Product otherMug = new Product("MUG-PROMO", "Coffee Mug", 7.5);

        assertThat(mug.equals(otherMug)).isFalse();
    }
}
