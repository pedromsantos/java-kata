package org.kata.hole11;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int TOP_ROW = 0;
    private static final int BOTTOM_ROW = 2;
    private static final int LEFT_COLUMN = 0;
    private static final int MIDDLE_COLUMN = 1;
    private static final int RIGHT_COLUMN = 2;
    private final List<Tile> plays = new ArrayList<>();

    public Board() {
        for (int row = TOP_ROW; row <= BOTTOM_ROW; row++) {
            for (int column = LEFT_COLUMN; column <= RIGHT_COLUMN; column++) {
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
        for (int row = TOP_ROW; row <= BOTTOM_ROW; row++) {
            if (isRowFull(row)) {
                return commonPlayerOnAllColumns(row);
            }
        }
        return ' ';
    }

    private boolean isRowFull(int row) {
        return tileAt(new Tile(row, LEFT_COLUMN)).isNotEmpty() &&
                tileAt(new Tile(row, MIDDLE_COLUMN)).isNotEmpty() &&
                tileAt(new Tile(row, RIGHT_COLUMN)).isNotEmpty();
    }

    private char commonPlayerOnAllColumns(int row) {
        if (tileAt(new Tile(row, LEFT_COLUMN)).hasSamePlayerAs(tileAt(new Tile(row, MIDDLE_COLUMN))) &&
                tileAt(new Tile(row, MIDDLE_COLUMN)).hasSamePlayerAs(tileAt(new Tile(row, RIGHT_COLUMN)))) {
            return tileAt(new Tile(row, LEFT_COLUMN)).getPlayer();
        }
        return ' ';
    }
}