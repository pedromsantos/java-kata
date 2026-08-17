package org.kata;

public class Die {
    public final int value;

    public Die(int value) {
        this.value = value;
    }

    public boolean equals(Die other) {
        return this.value == other.value;
    }
}
