package org.kata.hole12;

import java.util.ArrayList;
import java.util.List;

import static org.kata.hole12.Column.*;

public class Board {

    private final List<Tile> plays = new ArrayList<>();

    public Board() {
        for (Row row : Row.values()) {
            for (Column column : Column.values()) {
                plays.add(new Tile(row, column));
            }
        }
    }

    public Tile tileAt(Tile other) {
        for (Tile t : plays) {
            if (t.hasSamePositionAs(other)) {
                return t;
            }
        }
        return null;
    }

    public void addTileAt(Tile tile) {
        tileAt(tile).setPlayer(tile.getPlayer());
    }

    public char anyRowHasSamePlayerOnAllColumns() {
        for (Row row: Row.values()) {
            if (isRowFull(row)) {
                return commonPlayerOnAllColumns(row);
            }
        }
        return ' ';
    }

    private boolean isRowFull(Row row) {
        return tileAt(new Tile(row, LEFT)).isNotEmpty() &&
                tileAt(new Tile(row, MIDDLE)).isNotEmpty() &&
                tileAt(new Tile(row, RIGHT)).isNotEmpty();
    }

    private char commonPlayerOnAllColumns(Row row) {
        if (tileAt(new Tile(row, LEFT)).hasSamePlayerAs(tileAt(new Tile(row, MIDDLE))) &&
                tileAt(new Tile(row, MIDDLE)).hasSamePlayerAs(tileAt(new Tile(row, RIGHT)))) {
            return tileAt(new Tile(row, LEFT)).getPlayer();
        }
        return ' ';
    }
}