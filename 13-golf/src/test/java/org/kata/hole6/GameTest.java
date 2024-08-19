package org.kata.hole6;

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
        assertThrows(Exception.class, () -> game.play('O', 0, 0));
    }

    @Test
    void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () ->{
            game.play('X', 0, 0);
            game.play('X', 1, 0);
        });
    }

    @Test
    void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play('X', 0, 0);
            game.play('O', 0, 0);
        });
    }

    @Test
    void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play('X', 0, 0);
            game.play('O', 1, 0);
            game.play('X', 0, 0);
        });
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 0, 1);
        game.play('O', 1, 1);
        game.play('X', 0, 2);

        char winner = game.winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play('X', 2, 2);
        game.play('O', 0, 0);
        game.play('X', 1, 0);
        game.play('O', 0, 1);
        game.play('X', 1, 1);
        game.play('O', 0, 2);

        char winner = game.winner();

        assertEquals('O', winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play('X', 1, 0);
        game.play('O', 0, 0);
        game.play('X', 1, 1);
        game.play('O', 0, 1);
        game.play('X', 1, 2);

        char winner = game.winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 2, 0);
        game.play('O', 1, 1);
        game.play('X', 2, 1);
        game.play('O', 1, 2);

        char winner = game.winner();

        assertEquals('O', winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play('X', 2, 0);
        game.play('O', 0, 0);
        game.play('X', 2, 1);
        game.play('O', 0, 1);
        game.play('X', 2, 2);

        char winner = game.winner();

        assertEquals('X', winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play('X', 0, 0);
        game.play('O', 2, 0);
        game.play('X', 1, 0);
        game.play('O', 2, 1);
        game.play('X', 1, 1);
        game.play('O', 2, 2);

        char winner = game.winner();

        assertEquals('O', winner);
    }
}
