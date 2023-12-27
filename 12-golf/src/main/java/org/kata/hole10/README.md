# Actions

Remember to run the tests on each refactor and if green commit the changes

- On class `Game`

  - Introduce parameter `tile` to method `play` from variable `tile`
    - Remove unused parameters

- On class `Tile`

  - Rename instance variable `Symbol` to `player`
  - Rename instance variable `X` to `x`
  - Rename instance variable `Y` to `y`
  - Rename method `setPSymbol` to `setPlayer` also rename argument `symbol` to `player`

- Introduce class `Position` from `Tile` use parallel refactoring
