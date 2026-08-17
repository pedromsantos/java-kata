package org.kata.infrastructure.gateways;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmailNotificationGatewayIntegrationTest {
    private static final String DEFAULT_CUSTOMER_EMAIL = "customer@example.com";

    @Test
    void sendsAnOrderConfirmationEmail() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captured));

        try {
            EmailNotificationGateway gateway = new EmailNotificationGateway();
            gateway.send(DEFAULT_CUSTOMER_EMAIL, "Order confirmed: ORD-1");
        } finally {
            System.setOut(originalOut);
        }

        assertThat(captured.toString()).contains(DEFAULT_CUSTOMER_EMAIL);
    }
}
