package org.kata.solid.dip;

// DIP violation: MicrowaveOven news up a concrete MicrowaveGenerator
// itself instead of depending on an injected abstraction.
public class MicrowaveOven {
    private final MicrowaveGenerator heater;

    public MicrowaveOven() {
        this.heater = new MicrowaveGenerator();
    }

    public void cook() {
        heater.generate();
    }
}
