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

    public Tile TileAt(int x, int y)
    {
        for (Tile t : plays) {
            if (t.X == x && t.Y == y){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char player, int x, int y)
    {
        TileAt(x,y).Symbol = player;
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
        return TileAt(x, 0).Symbol != ' ' &&
                TileAt(x, 1).Symbol != ' ' &&
                TileAt(x, 2).Symbol != ' ';
    }

    private char commonPlayerOnAllColumns(int x) {
        if (TileAt(x, 0).Symbol ==
                TileAt(x, 1).Symbol &&
                TileAt(x, 2).Symbol == TileAt(x, 1).Symbol) {
            return TileAt(x, 0).Symbol;
        }
        return ' ';
    }
}