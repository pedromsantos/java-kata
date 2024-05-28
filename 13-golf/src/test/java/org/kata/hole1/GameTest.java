package org.kata.hole1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {
    private Game game;

    @BeforeEach
    public void InitializeGame(){
        game = new Game();
    }

    @Test
    void NotAllowPlayerOToPlayFirst() {
        assertThrows(Exception.class, () -> game.Play('O', 0, 0));
    }

    @Test
    void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () ->{
            game.Play('X', 0, 0);
            game.Play('X', 1, 0);
        });
    }

    @Test
    void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.Play('X', 0, 0);
            game.Play('O', 0, 0);
        });
    }

    @Test
    void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.Play('X', 0, 0);
            game.Play('O', 1, 0);
            game.Play('X', 0, 0);
        });
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play('X', 0, 0);
        game.Play('O', 1, 0);
        game.Play('X', 0, 1);
        game.Play('O', 1, 1);
        game.Play('X', 0, 2);

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play('X', 2, 2);
        game.Play('O', 0, 0);
        game.Play('X', 1, 0);
        game.Play('O', 0, 1);
        game.Play('X', 1, 1);
        game.Play('O', 0, 2);

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play('X', 1, 0);
        game.Play('O', 0, 0);
        game.Play('X', 1, 1);
        game.Play('O', 0, 1);
        game.Play('X', 1, 2);

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play('X', 0, 0);
        game.Play('O', 1, 0);
        game.Play('X', 2, 0);
        game.Play('O', 1, 1);
        game.Play('X', 2, 1);
        game.Play('O', 1, 2);

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play('X', 2, 0);
        game.Play('O', 0, 0);
        game.Play('X', 2, 1);
        game.Play('O', 0, 1);
        game.Play('X', 2, 2);

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play('X', 0, 0);
        game.Play('O', 2, 0);
        game.Play('X', 1, 0);
        game.Play('O', 2, 1);
        game.Play('X', 1, 1);
        game.Play('O', 2, 2);

        char winner = game.Winner();

        assertEquals('O', winner);
    }
}
