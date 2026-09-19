package org.kata;

public class RowWinnerChecker {
    public char check(Board board) {
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
