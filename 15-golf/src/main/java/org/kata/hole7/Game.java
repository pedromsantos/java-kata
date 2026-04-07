package org.kata.hole7;

public class Game {
    private char lastPlayer = ' ';
    private Board board = new Board();

    public char winner() {
        return board.anyRowHasSamePlayerOnAllColumns();
    }

    public void play(char player, int x, int y) throws Exception {
        validateFirstMove(player);
        validatePlayer(player);
        validatePosition(x, y);

        updatePlayer(player);
        updateBoard(player, x, y);
    }

    private void validateFirstMove(char player) throws Exception {
        if (lastPlayer == ' ' && player == 'O') {
            throw new Exception("Invalid first player");
        }
    }

    private void validatePlayer(char player) throws Exception {
        if (player == lastPlayer) {
            throw new Exception("Invalid next player");
        }
    }

    private void validatePosition(int x, int y) throws Exception {
        if (board.tileAt(x, y).isNotEmpty()) {
            throw new Exception("Invalid position");
        }
    }
    private void updatePlayer(char player) {
        lastPlayer = player;
    }

    private void updateBoard(char player, int x, int y) {
        board.addTileAt(player, x, y);
    }
}