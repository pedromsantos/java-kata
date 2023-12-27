package org.kata.hole9;

public class Tile
{
    private int X;
    private int Y;
    private char Symbol;
    private char player;

    public Tile(int x, int y, char symbol) {
        X = x;
        Y = y;
        Symbol = symbol;
    }

    public Tile(int x, int y) {
        this(x,y,' ');
    }

    public boolean isNotEmpty() { return this.getSymbol() != ' ';}

    public boolean hasSameSymbolAs(Tile other) { return this.getSymbol() == other.getSymbol();}

    public boolean hasSamePositionAs(Tile other) {return this.X == other.X && this.Y == other.Y;}

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }

    public char getPlayer() {
        return player;
    }
}