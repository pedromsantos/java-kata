package org.kata;

// Cross-file Duplicated Code / Shotgun Surgery kata fixture: this checker
// re-implements the exact same "are these three tiles taken and equal"
// pattern as RowWinnerChecker and ColumnWinnerChecker, independently,
// instead of sharing one extracted line-checking algorithm -- fixing a
// bug in the matching rule (e.g. wildcards, N-in-a-row) means
// remembering to edit all three files.
public class DiagonalWinnerChecker {
    public char check(Board board) {
        if (board.tileAt(0, 0).Symbol != ' ' &&
                board.tileAt(1, 1).Symbol != ' ' &&
                board.tileAt(2, 2).Symbol != ' ') {
            if (board.tileAt(0, 0).Symbol ==
                    board.tileAt(1, 1).Symbol &&
                    board.tileAt(2, 2).Symbol == board.tileAt(1, 1).Symbol) {
                return board.tileAt(0, 0).Symbol;
            }
        }

        if (board.tileAt(0, 2).Symbol != ' ' &&
                board.tileAt(1, 1).Symbol != ' ' &&
                board.tileAt(2, 0).Symbol != ' ') {
            if (board.tileAt(0, 2).Symbol ==
                    board.tileAt(1, 1).Symbol &&
                    board.tileAt(2, 0).Symbol == board.tileAt(1, 1).Symbol) {
                return board.tileAt(0, 2).Symbol;
            }
        }

        return ' ';
    }
}
