package org.kata.hole12;

public enum Row {
    TOP_ROW(0), MIDDLE_ROW(1), BOTTOM_ROW(2);
    private final int value;

    Row(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}