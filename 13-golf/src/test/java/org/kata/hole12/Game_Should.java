package org.kata.hole12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.kata.hole12.Column.*;
import static org.kata.hole12.Row.*;

class Game_Should {
    private Game game;

    @BeforeEach
    public void InitializeGame(){
        game = new Game();
    }

    @Test
    void NotAllowPlayerOToPlayFirst() {
        assertThrows(Exception.class, () -> game.play(new Tile(TOP, LEFT, 'O')));
    }

    @Test
    void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () ->{
            game.play(new Tile(TOP, LEFT, 'X'));
            game.play(new Tile(CENTER, LEFT, 'X'));
        });
    }

    @Test
    void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play(new Tile(TOP, LEFT, 'X'));
            game.play(new Tile(TOP, LEFT, 'O'));
        });
    }

    @Test
    void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play(new Tile(TOP, LEFT, 'X'));
            game.play(new Tile(CENTER, LEFT, 'O'));
            game.play(new Tile(TOP, LEFT, 'X'));
        });
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play(new Tile(TOP, LEFT, 'X'));
        game.play(new Tile(CENTER, LEFT, 'O'));
        game.play(new Tile(TOP, Column.MIDDLE, 'X'));
        game.play(new Tile(CENTER, Column.MIDDLE, 'O'));
        game.play(new Tile(TOP, RIGHT, 'X'));

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play(new Tile(BOTTOM, RIGHT, 'X'));
        game.play(new Tile(TOP, LEFT, 'O'));
        game.play(new Tile(CENTER, LEFT, 'X'));
        game.play(new Tile(TOP, Column.MIDDLE, 'O'));
        game.play(new Tile(CENTER, Column.MIDDLE, 'X'));
        game.play(new Tile(TOP, RIGHT, 'O'));

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play(new Tile(CENTER, LEFT, 'X'));
        game.play(new Tile(TOP, LEFT, 'O'));
        game.play(new Tile(CENTER, Column.MIDDLE, 'X'));
        game.play(new Tile(TOP, Column.MIDDLE, 'O'));
        game.play(new Tile(CENTER, RIGHT, 'X'));

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play(new Tile(TOP, LEFT, 'X'));
        game.play(new Tile(CENTER, LEFT, 'O'));
        game.play(new Tile(BOTTOM, LEFT, 'X'));
        game.play(new Tile(CENTER, Column.MIDDLE, 'O'));
        game.play(new Tile(BOTTOM, Column.MIDDLE, 'X'));
        game.play(new Tile(CENTER, RIGHT, 'O'));

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play(new Tile(BOTTOM, LEFT, 'X'));
        game.play(new Tile(TOP, LEFT, 'O'));
        game.play(new Tile(BOTTOM, Column.MIDDLE, 'X'));
        game.play(new Tile(TOP, Column.MIDDLE, 'O'));
        game.play(new Tile(BOTTOM, RIGHT, 'X'));

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play(new Tile(TOP, LEFT, 'X'));
        game.play(new Tile(BOTTOM, LEFT, 'O'));
        game.play(new Tile(CENTER, LEFT, 'X'));
        game.play(new Tile(BOTTOM, Column.MIDDLE, 'O'));
        game.play(new Tile(CENTER, Column.MIDDLE, 'X'));
        game.play(new Tile(BOTTOM, RIGHT, 'O'));

        char winner = game.Winner();

        assertEquals('O', winner);
    }
}
