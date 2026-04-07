package org.kata.hole2;

import org.kata.hole1.Board;

public class Game {
    private char _lastSymbol = ' ';
    private Board board = new Board();

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
        if (board.tileAt(x, y).Symbol != ' ') {
            throw new Exception("Invalid position");
        }
    }
    private void updatePlayer(char symbol) {
        _lastSymbol = symbol;
    }

    private void updateBoard(char symbol, int x, int y) {
        board.addTileAt(symbol, x, y);
    }

    public char winner() {
        //if the positions in first row are taken
        if (board.tileAt(0, 0).Symbol != ' ' &&
                board.tileAt(0, 1).Symbol != ' ' &&
                board.tileAt(0, 2).Symbol != ' ') {
            //if first row is full with same symbol
            if (board.tileAt(0, 0).Symbol ==
                    board.tileAt(0, 1).Symbol &&
                    board.tileAt(0, 2).Symbol == board.tileAt(0, 1).Symbol) {
                return board.tileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (board.tileAt(1, 0).Symbol != ' ' &&
                board.tileAt(1, 1).Symbol != ' ' &&
                board.tileAt(1, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (board.tileAt(1, 0).Symbol ==
                    board.tileAt(1, 1).Symbol &&
                    board.tileAt(1, 2).Symbol ==
                            board.tileAt(1, 1).Symbol) {
                return board.tileAt(1, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (board.tileAt(2, 0).Symbol != ' ' &&
                board.tileAt(2, 1).Symbol != ' ' &&
                board.tileAt(2, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (board.tileAt(2, 0).Symbol ==
                    board.tileAt(2, 1).Symbol &&
                    board.tileAt(2, 2).Symbol ==
                            board.tileAt(2, 1).Symbol) {
                return board.tileAt(2, 0).Symbol;
            }
        }

        return ' ';
    }
}