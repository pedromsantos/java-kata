package org.kata;

public class Turn {
    private final Cell cell;
    private final Player player;

    public Turn(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }

    public boolean equals(Turn other) {
        return this.player == other.player && this.cell.equals(other.cell);
    }
}
