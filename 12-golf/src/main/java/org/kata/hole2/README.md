# Actions

Remember to run the tests on each refactor and if green commit the changes

- On class Game
  - On Method play
    1. Remove else keyword
       1. Unwrap else branch
       2. Remove redundant else
    2. Merge nested if statments
    3. Extract method "validateFirstMove" from first if statment
       - Remove comments related to if statment
    4. Extract method "validatePlayer" from second if statment
       - Remove comments related to if statment
    5. Extract method "validatePosition" from third if statment
       - Remove comments related to if statment
    6. Extract method `updatePlayer` from `_lastSymbol = symbol;`
       - Remove comments related to statment
    7. Extract method `updateBoard` from `_board.AddTileAt(symbol, x, y);`
    8. Rename method `Play` to `play` following Java conventions for method names
    9. Rename instance variable `_board` to `board` following Java conventions for instance variable names
