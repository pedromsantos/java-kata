package org.kata.hole12;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int TOP_ROW = 0;
    private static final int MIDDLE_ROW = 1;
    private static final int BOTTOM_ROW = 2;
    private static final int LEFT_COLUMN = 0;
    private static final int MIDDLE_COLUMN = 1;
    private static final int RIGHT_COLUMN = 2;

    private static int[] rows = {TOP_ROW, MIDDLE_ROW, BOTTOM_ROW};
    private static int[] columns = {LEFT_COLUMN, MIDDLE_COLUMN, RIGHT_COLUMN};

    private final List<Tile> plays = new ArrayList<>();

    public Board() {
        for (int row : rows) {
            for (int column : columns) {
                plays.add(new Tile(row, column));
            }
        }
    }

    public Tile TileAt(Tile other) {
        for (Tile t : plays) {
            if (t.hasSamePositionAs(other)) {
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(Tile tile) {
        TileAt(tile).setPlayer(tile.getPlayer());
    }

    public char anyRowHasSamePlayerOnAllColumns() {
        for (int row: rows) {
            if (isRowFull(row)) {
                return commonPlayerOnAllColumns(row);
            }
        }
        return ' ';
    }

    private boolean isRowFull(int row) {
        return TileAt(new Tile(row, LEFT_COLUMN)).isNotEmpty() &&
                TileAt(new Tile(row, MIDDLE_COLUMN)).isNotEmpty() &&
                TileAt(new Tile(row, RIGHT_COLUMN)).isNotEmpty();
    }

    private char commonPlayerOnAllColumns(int row) {
        if (TileAt(new Tile(row, LEFT_COLUMN)).hasSamePlayerAs(TileAt(new Tile(row, MIDDLE_COLUMN))) &&
                TileAt(new Tile(row, MIDDLE_COLUMN)).hasSamePlayerAs(TileAt(new Tile(row, RIGHT_COLUMN)))) {
            return TileAt(new Tile(row, LEFT_COLUMN)).getPlayer();
        }
        return ' ';
    }
}