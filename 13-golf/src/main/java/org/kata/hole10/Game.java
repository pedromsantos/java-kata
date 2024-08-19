package org.kata.hole10;

public class Game {
    private char lastPlayer = ' ';
    private Board board = new Board();

    public char winner() {
        return board.anyRowHasSamePlayerOnAllColumns();
    }

    public void play(Tile tile) throws Exception {

        validateFirstMove(tile.getPlayer());
        validatePlayer(tile.getPlayer());
        validatePosition(tile);

        updatePlayer(tile.getPlayer());
        updateBoard(tile);
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

    private void validatePosition(Tile tile) throws Exception {
        if (board.tileAt(tile).isNotEmpty()) {
            throw new Exception("Invalid position");
        }
    }
    private void updatePlayer(char player) {
        lastPlayer = player;
    }

    private void updateBoard(Tile tile) {
        board.addTileAt(tile);
    }
}