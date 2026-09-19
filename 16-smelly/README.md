# Code Smells kata

## The problem

We created a very smelly implementation of TicTacToe.

The winner-checking logic is split across `RowWinnerChecker`, `ColumnWinnerChecker`
and `DiagonalWinnerChecker`, each independently re-implementing the same
"are these three tiles taken and equal" pattern instead of sharing one
extracted line-checking algorithm. `Game.winner()` now checks rows, columns
and diagonals (it used to check rows only), delegating to all three
checkers in turn.

There are a number of code smells in the implementation namely:

- Primitive obsession
- Feature envy
- Data class
- Message chain
- Long method
- Comments
- Long parameter list
- Shotgun surgery
- Duplicated code
- Large class
- Divergent change
- Data clump
- Lazy class
- Dead code

## Your task

Identify the code smells, add comments where you find code smells.
Refactor the code remembering the small steps we took on the refactoring golf exercise.

## Resources

<https://www.youtube.com/watch?v=MM6_tyvBRXE>
<https://refactoring.guru/refactoring/smells>
<https://luzkan.github.io/smells/>
