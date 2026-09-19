package org.kata.connascence.position;

// Connascence of Position: three same-typed String parameters carry
// meaning only through argument order -- swap recipient and sender and
// the call still compiles, but breaks silently.
public class NotificationSystem {
    public void sendEmail(String recipient, String sender, String message) {
        System.out.println("From: " + sender);
        System.out.println("To: " + recipient);
        System.out.println("Message: " + message);
    }
}
