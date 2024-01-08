package org.kata.hole12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.kata.hole12.Column.*;
import static org.kata.hole12.Row.*;

public class Game_Should {
    private Game game;

    @BeforeEach
    public void InitializeGame(){
        game = new Game();
    }

    @Test
    public void NotAllowPlayerOToPlayFirst() {
        assertThrows(Exception.class, () -> game.play(new Tile(TOP, LEFT, 'O')));
    }

    @Test
    public void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () ->{
            game.play(new Tile(TOP, LEFT, 'X'));
            game.play(new Tile(CENTER, LEFT, 'X'));
        });
    }

    @Test
    public void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play(new Tile(TOP, LEFT, 'X'));
            game.play(new Tile(TOP, LEFT, 'O'));
        });
    }

    @Test
    public void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play(new Tile(TOP, LEFT, 'X'));
            game.play(new Tile(CENTER, LEFT, 'O'));
            game.play(new Tile(TOP, LEFT, 'X'));
        });
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
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
    public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
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
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
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
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
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
    public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
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
    public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
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
