package org.kata.solid.dip;

// DIP violation: Kitchen (high-level policy) directly constructs a
// concrete MicrowaveOven (low-level detail) -- it can't work with any
// other kind of oven.
public class Kitchen {
    private final MicrowaveOven oven;

    public Kitchen() {
        this.oven = new MicrowaveOven();
    }

    public void cookDinner() {
        oven.cook();
    }
}
