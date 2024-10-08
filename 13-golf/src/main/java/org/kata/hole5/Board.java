package org.kata.hole5;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> _plays = new ArrayList<>();

    public Board()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Tile tile = new Tile();
                tile.X = i;
                tile.Y = j;
                tile.Symbol = ' ';
                _plays.add(tile);
            }
        }
    }

    public Tile tileAt(int x, int y)
    {
        for (Tile t : _plays) {
            if (t.X == x && t.Y == y){
                return t;
            }
        }
        return null;
    }

    public void addTileAt(char symbol, int x, int y)
    {
        Tile newTile = new Tile();
        newTile.X = x;
        newTile.Y = y;
        newTile.Symbol = symbol;

        tileAt(x,y).Symbol = symbol;
    }

    public boolean isRowFull(int x) {
        return tileAt(x, 0).Symbol != ' ' &&
                tileAt(x, 1).Symbol != ' ' &&
                tileAt(x, 2).Symbol != ' ';
    }

    public char winnerOnRow(int x) {
        if (tileAt(x, 0).Symbol ==
                tileAt(x, 1).Symbol &&
                tileAt(x, 2).Symbol == tileAt(x, 1).Symbol) {
            return tileAt(x, 0).Symbol;
        }
        return ' ';
    }

    public char rowHasSameSymbolOnAllColumns() {
        for(int row = 0; row < 3; row++) {
            if (isRowFull(row)) {
                char winnerOnRow = winnerOnRow(row);
                if (winnerOnRow != ' ') return winnerOnRow;
            }
        }
        return ' ';
    }
}