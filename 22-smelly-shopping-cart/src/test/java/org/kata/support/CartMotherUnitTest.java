package org.kata.support;

import org.junit.jupiter.api.Test;

import org.kata.domain.models.Cart;
import org.kata.domain.models.Product;

import static org.assertj.core.api.Assertions.assertThat;

class CartMotherUnitTest {
    @Test
    void createsAValidCartWithStableDefaults() {
        Cart cart = CartMother.create();

        assertThat(cart).isInstanceOf(Cart.class);
        assertThat(cart.id).isEqualTo("cart-1");
        assertThat(cart.customerName).isEqualTo("Ada Lovelace");
        assertThat(cart.getLineItems()).isEmpty();
    }

    @Test
    void usesNamedScenariosToCreateValidCartsWithControlledQuantities() {
        Cart emptyCart = CartMother.emptyCart();
        Cart voucherCart = CartMother.voucherCart(3);
        Cart tShirtCart = CartMother.tShirtCart(4);

        assertThat(emptyCart.getLineItems()).isEmpty();
        assertThat(voucherCart.getLineItems()).hasSize(1);
        assertThat(voucherCart.getLineItems().get(0).product).isInstanceOf(Product.class);
        assertThat(voucherCart.getLineItems().get(0).product.code).isEqualTo("VOUCHER");
        assertThat(voucherCart.getLineItems().get(0).quantity).isEqualTo(3);
        assertThat(tShirtCart.getLineItems()).hasSize(1);
        assertThat(tShirtCart.getLineItems().get(0).product).isInstanceOf(Product.class);
        assertThat(tShirtCart.getLineItems().get(0).product.code).isEqualTo("TSHIRT");
        assertThat(tShirtCart.getLineItems().get(0).quantity).isEqualTo(4);
    }
}
