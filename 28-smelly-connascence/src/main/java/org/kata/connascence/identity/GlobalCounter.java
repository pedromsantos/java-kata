package org.kata.connascence.identity;

// Connascence of Identity: correctness of every consumer depends on
// them all sharing this exact single static instance -- there is no way
// to have two independent counters, and the dependency is invisible
// from any one consumer's own code.
public class GlobalCounter {
    public static final GlobalCounter INSTANCE = new GlobalCounter();

    private int value = 0;

    private GlobalCounter() {}

    public int increment() {
        value += 1;
        return value;
    }

    public int current() {
        return value;
    }
}
