package org.kata;

public class RadioTransmitter {
    private final String endpoint;

    public RadioTransmitter(String endpoint) {
        this.endpoint = endpoint;
    }

    public void send(String message) {
        System.out.println("[RADIO -> " + endpoint + "] " + message);
    }
}
