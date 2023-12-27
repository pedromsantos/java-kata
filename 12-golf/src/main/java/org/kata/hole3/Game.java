package org.kata.hole3;

import org.kata.hole1.Board;

public class Game {
    private char _lastSymbol = ' ';
    private org.kata.hole1.Board board = new Board();

    public void play(char symbol, int x, int y) throws Exception {
        validateFirstMove(symbol);
        validatePlayer(symbol);
        validatePosition(x, y);

        updatePlayer(symbol);
        updateBoard(symbol, x, y);
    }

    private void updateBoard(char symbol, int x, int y) {
        board.AddTileAt(symbol, x, y);
    }

    private void updatePlayer(char symbol) {
        _lastSymbol = symbol;
    }

    private void validatePosition(int x, int y) throws Exception {
        if (board.TileAt(x, y).Symbol != ' ') {
            throw new Exception("Invalid position");
        }
    }

    private void validatePlayer(char symbol) throws Exception {
        if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
    }

    private void validateFirstMove(char symbol) throws Exception {
        if (_lastSymbol == ' ' && symbol == 'O') {
            throw new Exception("Invalid first player");
        }
    }

    public char Winner() {
        //if the positions in first row are taken
        if (board.TileAt(0, 0).Symbol != ' ' &&
                board.TileAt(0, 1).Symbol != ' ' &&
                board.TileAt(0, 2).Symbol != ' ') {
            //if first row is full with same symbol
            if (board.TileAt(0, 0).Symbol ==
                    board.TileAt(0, 1).Symbol &&
                    board.TileAt(0, 2).Symbol == board.TileAt(0, 1).Symbol) {
                return board.TileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (board.TileAt(1, 0).Symbol != ' ' &&
                board.TileAt(1, 1).Symbol != ' ' &&
                board.TileAt(1, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (board.TileAt(1, 0).Symbol ==
                    board.TileAt(1, 1).Symbol &&
                    board.TileAt(1, 2).Symbol ==
                            board.TileAt(1, 1).Symbol) {
                return board.TileAt(1, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (board.TileAt(2, 0).Symbol != ' ' &&
                board.TileAt(2, 1).Symbol != ' ' &&
                board.TileAt(2, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (board.TileAt(2, 0).Symbol ==
                    board.TileAt(2, 1).Symbol &&
                    board.TileAt(2, 2).Symbol ==
                            board.TileAt(2, 1).Symbol) {
                return board.TileAt(2, 0).Symbol;
            }
        }

        return ' ';
    }
}