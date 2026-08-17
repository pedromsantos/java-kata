# Tic Tac Toe (Mockist) kata

## Rules

- X always plays first
- Players alternate placing X's and O's on the board
- Players cannot play on a played position
- A Player wins when it has three in a row
  - Horizontally
  - Vertically
  - Diagonally
- If all nine squares are filled and neither player has won, the game is a draw

In this version of TicTacToe nothing is returned but a call to an `Output` is
made to print the game events. This is a **mockist / output-based** variant
of `9-tic-tac-toe`: instead of asserting on returned board state, drive the
design outside-in from the `Output` port and verify behavior through the
calls made to it (classicist vs. mockist TDD; London School style).

Use the type definitions in `Player.java`, `Row.java`, `Column.java`,
`Cell.java`, `Turn.java`, `TicTacToe.java`, and `Output.java` to get started.

## Follow TDD rules strictly

1. Write production code only to pass a failing unit test.
2. Write no more of a unit test than sufficient to fail (compilation failures are failures).
3. Write no more production code than necessary to pass the one failing unit test.

## Testing

This module uses JUnit 5, AssertJ, and Mockito -- Mockito is included because
a mockist/London-school approach to this kata typically verifies behavior by
mocking the `Output` port and asserting on the calls made to it, rather than
asserting on returned state.

## Resources

<https://williamdurand.fr/2013/06/03/object-calisthenics/>
