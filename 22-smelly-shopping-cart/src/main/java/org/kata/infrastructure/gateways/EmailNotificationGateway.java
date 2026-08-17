package org.kata.infrastructure.gateways;

import org.kata.domain.ports.NotificationPort;

public class EmailNotificationGateway implements NotificationPort {
    private final String fromAddress;

    public EmailNotificationGateway() {
        this("orders@shop.example.com");
    }

    public EmailNotificationGateway(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    @Override
    public void send(String to, String message) {
        System.out.println("[EMAIL " + fromAddress + " -> " + to + "] " + message);
    }
}
