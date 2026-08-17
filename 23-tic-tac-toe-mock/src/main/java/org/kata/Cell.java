package org.kata;

public class Cell {
    private final Row row;
    private final Column column;

    public Cell(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

    public boolean equals(Cell other) {
        return this.row == other.row && this.column == other.column;
    }
}
