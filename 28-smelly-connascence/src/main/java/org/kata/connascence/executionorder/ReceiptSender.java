package org.kata.connascence.executionorder;

// Connascence of Execution Order: archive() is only correct if
// sendToCustomer() has already run, but nothing in the type or method
// signatures expresses that -- the caller has to know the right order
// from tribal knowledge, not from the code.
public class ReceiptSender {
    private boolean sent = false;

    public void sendToCustomer(String receiptId) {
        System.out.println("Emailing receipt " + receiptId + " to customer");
        this.sent = true;
    }

    public void archive(String receiptId) {
        if (!sent) {
            System.out.println("Warning: archiving " + receiptId + " before it was sent");
        }
        System.out.println("Archiving receipt " + receiptId);
    }
}
