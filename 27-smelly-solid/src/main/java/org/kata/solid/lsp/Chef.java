package org.kata.solid.lsp;

// The instanceof special-case here is the diagnostic signature of the
// LSP violation in Microwave: a caller that can't just trust Oven.cook().
public class Chef {
    public void cook(Oven oven, String food) {
        if (oven instanceof Microwave microwave) {
            microwave.cookMicrowaving(food);
        } else {
            oven.cook(food);
        }
    }
}
