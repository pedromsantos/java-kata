package org.kata.hole12;

public class Tile {
    private final Position position;
    private char player;

    public Tile(Row x, Column y, char player) {
        this.position = new Position(x, y);
        this.player = player;
    }

    public Tile(Row x, Column y) {
        this(x, y, ' ');
    }

    public boolean isNotEmpty() {
        return this.getPlayer() != ' ';
    }

    public boolean hasSamePlayerAs(Tile other) {
        return this.getPlayer() == other.getPlayer();
    }

    public boolean hasSamePositionAs(Tile other) {
        return this.position.equals(other.position);
    }

    public char getPlayer() {
        return player;
    }

    public void setPlayer(char player) {
        this.player = player;
    }
}