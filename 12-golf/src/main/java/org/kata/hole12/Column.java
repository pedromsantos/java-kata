package org.kata.hole12;

public enum Column {
    LEFT_COLUMN(0), MIDDLE_COLUMN(1), RIGHT_COLUMN(2);
    private final int value;

    Column(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}