package org.kata.hole7;

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

    public Tile TileAt(int x, int y)
    {
        for (Tile t : plays) {
            if (t.hasSamePositionAs(new Tile(x,y))){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char player, int x, int y)
    {
        TileAt(x, y).setSymbol(player);
    }

    public char anyRowHasSamePlayerOnAllColumns() {
        for(int row = 0; row < 3; row++) {
            if (isRowFull(row)) {
                return commonPlayerOnAllColumns(row);
            }
        }
        return ' ';
    }

    private boolean isRowFull(int x) {
        return TileAt(x, 0).isNotEmpty() &&
                TileAt(x, 1).isNotEmpty() &&
                TileAt(x, 2).isNotEmpty();
    }

    private char commonPlayerOnAllColumns(int x) {
        if (TileAt(x, 0).hasSameSymbolAs(TileAt(x, 1)) &&
                TileAt(x, 2).hasSameSymbolAs(TileAt(x, 1))) {
            return TileAt(x, 0).getSymbol();
        }
        return ' ';
    }
}