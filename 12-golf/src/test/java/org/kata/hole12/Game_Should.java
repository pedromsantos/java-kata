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
        assertThrows(Exception.class, () -> game.play(new Tile(TOP_ROW, LEFT_COLUMN, 'O')));
    }

    @Test
    public void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () ->{
            game.play(new Tile(TOP_ROW, LEFT_COLUMN, 'X'));
            game.play(new Tile(MIDDLE_ROW, LEFT_COLUMN, 'X'));
        });
    }

    @Test
    public void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play(new Tile(TOP_ROW, LEFT_COLUMN, 'X'));
            game.play(new Tile(TOP_ROW, LEFT_COLUMN, 'O'));
        });
    }

    @Test
    public void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play(new Tile(TOP_ROW, LEFT_COLUMN, 'X'));
            game.play(new Tile(MIDDLE_ROW, LEFT_COLUMN, 'O'));
            game.play(new Tile(TOP_ROW, LEFT_COLUMN, 'X'));
        });
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play(new Tile(TOP_ROW, LEFT_COLUMN, 'X'));
        game.play(new Tile(MIDDLE_ROW, LEFT_COLUMN, 'O'));
        game.play(new Tile(TOP_ROW, MIDDLE_COLUMN, 'X'));
        game.play(new Tile(MIDDLE_ROW, MIDDLE_COLUMN, 'O'));
        game.play(new Tile(TOP_ROW, RIGHT_COLUMN, 'X'));

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play(new Tile(BOTTOM_ROW, RIGHT_COLUMN, 'X'));
        game.play(new Tile(TOP_ROW, LEFT_COLUMN, 'O'));
        game.play(new Tile(MIDDLE_ROW, LEFT_COLUMN, 'X'));
        game.play(new Tile(TOP_ROW, MIDDLE_COLUMN, 'O'));
        game.play(new Tile(MIDDLE_ROW, MIDDLE_COLUMN, 'X'));
        game.play(new Tile(TOP_ROW, RIGHT_COLUMN, 'O'));

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play(new Tile(MIDDLE_ROW, LEFT_COLUMN, 'X'));
        game.play(new Tile(TOP_ROW, LEFT_COLUMN, 'O'));
        game.play(new Tile(MIDDLE_ROW, MIDDLE_COLUMN, 'X'));
        game.play(new Tile(TOP_ROW, MIDDLE_COLUMN, 'O'));
        game.play(new Tile(MIDDLE_ROW, RIGHT_COLUMN, 'X'));

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play(new Tile(TOP_ROW, LEFT_COLUMN, 'X'));
        game.play(new Tile(MIDDLE_ROW, LEFT_COLUMN, 'O'));
        game.play(new Tile(BOTTOM_ROW, LEFT_COLUMN, 'X'));
        game.play(new Tile(MIDDLE_ROW, MIDDLE_COLUMN, 'O'));
        game.play(new Tile(BOTTOM_ROW, MIDDLE_COLUMN, 'X'));
        game.play(new Tile(MIDDLE_ROW, RIGHT_COLUMN, 'O'));

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play(new Tile(BOTTOM_ROW, LEFT_COLUMN, 'X'));
        game.play(new Tile(TOP_ROW, LEFT_COLUMN, 'O'));
        game.play(new Tile(BOTTOM_ROW, MIDDLE_COLUMN, 'X'));
        game.play(new Tile(TOP_ROW, MIDDLE_COLUMN, 'O'));
        game.play(new Tile(BOTTOM_ROW, RIGHT_COLUMN, 'X'));

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play(new Tile(TOP_ROW, LEFT_COLUMN, 'X'));
        game.play(new Tile(BOTTOM_ROW, LEFT_COLUMN, 'O'));
        game.play(new Tile(MIDDLE_ROW, LEFT_COLUMN, 'X'));
        game.play(new Tile(BOTTOM_ROW, MIDDLE_COLUMN, 'O'));
        game.play(new Tile(MIDDLE_ROW, MIDDLE_COLUMN, 'X'));
        game.play(new Tile(BOTTOM_ROW, RIGHT_COLUMN, 'O'));

        char winner = game.Winner();

        assertEquals('O', winner);
    }
}
