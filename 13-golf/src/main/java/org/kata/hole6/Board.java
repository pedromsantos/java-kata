package org.kata.hole6;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> plays = new ArrayList<>();

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
                plays.add(tile);
            }
        }
    }

    public Tile tileAt(int x, int y)
    {
        for (Tile t : plays) {
            if (t.X == x && t.Y == y){
                return t;
            }
        }
        return null;
    }

    public void addTileAt(char player, int x, int y)
    {
        tileAt(x,y).Symbol = player;
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
        return tileAt(x, 0).Symbol != ' ' &&
                tileAt(x, 1).Symbol != ' ' &&
                tileAt(x, 2).Symbol != ' ';
    }

    private char commonPlayerOnAllColumns(int x) {
        if (tileAt(x, 0).Symbol ==
                tileAt(x, 1).Symbol &&
                tileAt(x, 2).Symbol == tileAt(x, 1).Symbol) {
            return tileAt(x, 0).Symbol;
        }
        return ' ';
    }
}