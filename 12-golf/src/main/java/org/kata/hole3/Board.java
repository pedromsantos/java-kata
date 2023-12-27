package org.kata.hole3;

import org.kata.hole1.Tile;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<org.kata.hole1.Tile> _plays = new ArrayList<>();

    public Board()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                org.kata.hole1.Tile tile = new org.kata.hole1.Tile();
                tile.X = i;
                tile.Y = j;
                tile.Symbol = ' ';
                _plays.add(tile);
            }
        }
    }

    public org.kata.hole1.Tile TileAt(int x, int y)
    {
        for (org.kata.hole1.Tile t : _plays) {
            if (t.X == x && t.Y == y){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, int x, int y)
    {
        org.kata.hole1.Tile newTile = new Tile();
        newTile.X = x;
        newTile.Y = y;
        newTile.Symbol = symbol;

        TileAt(x,y).Symbol = symbol;
    }
}