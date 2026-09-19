package org.kata.solid.lsp;

// LSP violation: Microwave can't honour Oven's cook() contract, so it
// throws instead -- callers that only know about Oven get a broken promise.
public class Microwave extends Oven {
    @Override
    public void cook(String food) {
        throw new UnsupportedOperationException("Microwave does not support cook(); use cookMicrowaving() instead");
    }

    public void cookMicrowaving(String food) {
        System.out.println("Microwaving " + food);
    }
}
