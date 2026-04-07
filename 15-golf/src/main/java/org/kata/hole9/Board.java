package org.kata.hole9;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> plays = new ArrayList<>();

    public Board()
    {
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 3; column++)
            {
                plays.add(new Tile(row,column));
            }
        }
    }

    public Tile tileAt(Tile other)
    {
        for (Tile t : plays) {
            if (t.hasSamePositionAs(other)){
                return t;
            }
        }
        return null;
    }

    public void addTileAt(Tile tile)
    {
        tileAt(tile).setSymbol(tile.getSymbol());
    }

    public char anyRowHasSamePlayerOnAllColumns() {
        for(int row = 0; row < 3; row++) {
            if (isRowFull(row)) {
                return commonPlayerOnAllColumns(row);
            }
        }
        return ' ';
    }

    private boolean isRowFull(int row) {
        return tileAt(new Tile(row, 0)).isNotEmpty() &&
                tileAt(new Tile(row, 1)).isNotEmpty() &&
                tileAt(new Tile(row, 2)).isNotEmpty();
    }

    private char commonPlayerOnAllColumns(int row) {
        if (tileAt(new Tile(row, 0)).hasSameSymbolAs(tileAt(new Tile(row, 1))) &&
                tileAt(new Tile(row, 2)).hasSameSymbolAs(tileAt(new Tile(row, 1)))) {
            return tileAt(new Tile(row, 0)).getSymbol();
        }
        return ' ';
    }
}