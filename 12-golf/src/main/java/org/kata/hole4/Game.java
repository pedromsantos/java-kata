package org.kata.hole4;

import org.kata.hole1.Board;

public class Game {
    private char _lastSymbol = ' ';
    private org.kata.hole1.Board board = new Board();

    public char Winner() {
        return board.rowHasSameSymbolOnAllColumns();
    }

    public void play(char symbol, int x, int y) throws Exception {
        validateFirstMove(symbol);
        validatePlayer(symbol);
        validatePosition(x, y);

        updatePlayer(symbol);
        updateBoard(symbol, x, y);
    }

    private void validateFirstMove(char symbol) throws Exception {
        if (_lastSymbol == ' ' && symbol == 'O') {
            throw new Exception("Invalid first player");
        }
    }

    private void validatePlayer(char symbol) throws Exception {
        if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
    }

    private void validatePosition(int x, int y) throws Exception {
        if (board.TileAt(x, y).Symbol != ' ') {
            throw new Exception("Invalid position");
        }
    }
    private void updatePlayer(char symbol) {
        _lastSymbol = symbol;
    }

    private void updateBoard(char symbol, int x, int y) {
        board.AddTileAt(symbol, x, y);
    }
}