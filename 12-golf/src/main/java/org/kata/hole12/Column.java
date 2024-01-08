package org.kata.hole12;

public enum Column {
    LEFT(0), MIDDLE(1), RIGHT(2);
    private final int value;

    Column(int value) {
        this.value = value;
    }
}