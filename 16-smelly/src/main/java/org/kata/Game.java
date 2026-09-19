package org.kata;

public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();
    private RowWinnerChecker _rowWinnerChecker = new RowWinnerChecker();
    private ColumnWinnerChecker _columnWinnerChecker = new ColumnWinnerChecker();
    private DiagonalWinnerChecker _diagonalWinnerChecker = new DiagonalWinnerChecker();

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
        char rowWinner = _rowWinnerChecker.check(_board);
        if (rowWinner != ' ') {
            return rowWinner;
        }

        char columnWinner = _columnWinnerChecker.check(_board);
        if (columnWinner != ' ') {
            return columnWinner;
        }

        return _diagonalWinnerChecker.check(_board);
    }
}
