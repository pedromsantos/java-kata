package org.kata.hole11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Game_Should {
    private Game game;

    @BeforeEach
    public void InitializeGame(){
        game = new Game();
    }

    @Test
    public void NotAllowPlayerOToPlayFirst() {
        assertThrows(Exception.class, () -> game.play(new Tile(0, 0, 'O')));
    }

    @Test
    public void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () ->{
            game.play(new Tile(0, 0, 'X'));
            game.play(new Tile(1, 0, 'X'));
        });
    }

    @Test
    public void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play(new Tile(0, 0, 'X'));
            game.play(new Tile(0, 0, 'O'));
        });
    }

    @Test
    public void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play(new Tile(0, 0, 'X'));
            game.play(new Tile(1, 0, 'O'));
            game.play(new Tile(0, 0, 'X'));
        });
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play(new Tile(0, 0, 'X'));
        game.play(new Tile(1, 0, 'O'));
        game.play(new Tile(0, 1, 'X'));
        game.play(new Tile(1, 1, 'O'));
        game.play(new Tile(0, 2, 'X'));

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play(new Tile(2, 2, 'X'));
        game.play(new Tile(0, 0, 'O'));
        game.play(new Tile(1, 0, 'X'));
        game.play(new Tile(0, 1, 'O'));
        game.play(new Tile(1, 1, 'X'));
        game.play(new Tile(0, 2, 'O'));

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play(new Tile(1, 0, 'X'));
        game.play(new Tile(0, 0, 'O'));
        game.play(new Tile(1, 1, 'X'));
        game.play(new Tile(0, 1, 'O'));
        game.play(new Tile(1, 2, 'X'));

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play(new Tile(0, 0, 'X'));
        game.play(new Tile(1, 0, 'O'));
        game.play(new Tile(2, 0, 'X'));
        game.play(new Tile(1, 1, 'O'));
        game.play(new Tile(2, 1, 'X'));
        game.play(new Tile(1, 2, 'O'));

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play(new Tile(2, 0, 'X'));
        game.play(new Tile(0, 0, 'O'));
        game.play(new Tile(2, 1, 'X'));
        game.play(new Tile(0, 1, 'O'));
        game.play(new Tile(2, 2, 'X'));

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play(new Tile(0, 0, 'X'));
        game.play(new Tile(2, 0, 'O'));
        game.play(new Tile(1, 0, 'X'));
        game.play(new Tile(2, 1, 'O'));
        game.play(new Tile(1, 1, 'X'));
        game.play(new Tile(2, 2, 'O'));

        char winner = game.Winner();

        assertEquals('O', winner);
    }
}
