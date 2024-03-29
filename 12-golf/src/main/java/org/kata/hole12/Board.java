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
        for (Row row: Row.values()) {
            if (isRowFull(row)) {
                return commonPlayerOnAllColumns(row);
            }
        }
        return ' ';
    }

    private boolean isRowFull(Row row) {
        return TileAt(new Tile(row, LEFT)).isNotEmpty() &&
                TileAt(new Tile(row, MIDDLE)).isNotEmpty() &&
                TileAt(new Tile(row, RIGHT)).isNotEmpty();
    }

    private char commonPlayerOnAllColumns(Row row) {
        if (TileAt(new Tile(row, LEFT)).hasSamePlayerAs(TileAt(new Tile(row, MIDDLE))) &&
                TileAt(new Tile(row, MIDDLE)).hasSamePlayerAs(TileAt(new Tile(row, RIGHT)))) {
            return TileAt(new Tile(row, LEFT)).getPlayer();
        }
        return ' ';
    }
}