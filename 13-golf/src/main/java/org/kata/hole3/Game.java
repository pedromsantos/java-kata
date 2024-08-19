package org.kata.hole3;

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
        for(int row = 0; row < 3; row++) {
            if (isRowFull(row)) {
                char winnerOnRow = winnerOnRow(row);
                if (winnerOnRow != ' ') return winnerOnRow;
            }
        }

        return ' ';
    }

    private char winnerOnRow(int x) {
        if (board.tileAt(x, 0).Symbol ==
                board.tileAt(x, 1).Symbol &&
                board.tileAt(x, 2).Symbol == board.tileAt(x, 1).Symbol) {
            return board.tileAt(x, 0).Symbol;
        }
        return ' ';
    }

    private boolean isRowFull(int x) {
        return board.tileAt(x, 0).Symbol != ' ' &&
                board.tileAt(x, 1).Symbol != ' ' &&
                board.tileAt(x, 2).Symbol != ' ';
    }
}