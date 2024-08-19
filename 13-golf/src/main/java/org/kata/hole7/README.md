# Actions

Remember to run the tests on each refactor and if green commit the changes

Let's now turn our attention to class `Tile`

- On class `Tile`

    - Generate a contructor
    - Implement method `isNotEmpty`
    - Implement method `hasSameSymbol`
    - Generate getter for `Symbol`;
    - Generate setter for `Symbol`
    - Implement method `hasSamePosition`;
    - Create a constructor with default empty `symbol`

- On class `Board`

    - Modify the constructor of Board to use the Tile contructor
        - Refactor the constructor on bord to rename loop variable `i` and `j` to `row` and `column`
        - Inline variable tile
    - on method `isRowFull` replace Symbol comparisation with method call `isNotEmpty` on `Tile`
    - on method `commonPlayerOnAllColumns` replace Symbol comparisation with method call `hasSameSymbol` on Tile
    - Refactor `TileAt` to use method `hasSamePosition` and default symbol contructor on `Tile`

- On class `Game`
    - Refactor the method `validatePosition` to use method `isNotEmpty` on `Tile`
