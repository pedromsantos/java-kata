package org.kata.hole1;

public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void play(char symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.tileAt(x, y).Symbol != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.addTileAt(symbol, x, y);
    }

    public char winner() {
        //if the positions in first row are taken
        if (_board.tileAt(0, 0).Symbol != ' ' &&
                _board.tileAt(0, 1).Symbol != ' ' &&
                _board.tileAt(0, 2).Symbol != ' ') {
            //if first row is full with same symbol
            if (_board.tileAt(0, 0).Symbol ==
                    _board.tileAt(0, 1).Symbol &&
                    _board.tileAt(0, 2).Symbol == _board.tileAt(0, 1).Symbol) {
                return _board.tileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.tileAt(1, 0).Symbol != ' ' &&
                _board.tileAt(1, 1).Symbol != ' ' &&
                _board.tileAt(1, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (_board.tileAt(1, 0).Symbol ==
                    _board.tileAt(1, 1).Symbol &&
                    _board.tileAt(1, 2).Symbol ==
                            _board.tileAt(1, 1).Symbol) {
                return _board.tileAt(1, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.tileAt(2, 0).Symbol != ' ' &&
                _board.tileAt(2, 1).Symbol != ' ' &&
                _board.tileAt(2, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (_board.tileAt(2, 0).Symbol ==
                    _board.tileAt(2, 1).Symbol &&
                    _board.tileAt(2, 2).Symbol ==
                            _board.tileAt(2, 1).Symbol) {
                return _board.tileAt(2, 0).Symbol;
            }
        }

        return ' ';
    }
}
