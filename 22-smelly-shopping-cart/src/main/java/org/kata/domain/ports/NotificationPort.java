package org.kata.domain.ports;

public interface NotificationPort {
    void send(String to, String message);
}
