package org.kata.hole9;

public class Game {
    private char lastPlayer = ' ';
    private Board board = new Board();

    public char Winner() {
        return board.anyRowHasSamePlayerOnAllColumns();
    }

    public void play(char player, int x, int y) throws Exception {
        Tile tile = new Tile(x, y, player);

        validateFirstMove(tile.getSymbol());
        validatePlayer(tile.getSymbol());
        validatePosition(tile);

        updatePlayer(tile.getSymbol());
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
        if (board.TileAt(tile).isNotEmpty()) {
            throw new Exception("Invalid position");
        }
    }
    private void updatePlayer(char player) {
        lastPlayer = player;
    }

    private void updateBoard(Tile tile) {
        board.AddTileAt(tile);
    }
}