# Actions

Remember to run the tests on each refactor and if green commit the changes

- On class `Game`
  - Introduce parameter `new Tile(x, y, player)` to method `updateBoard`
    - Remove unused parameters
  - Introduce parameter `new Tile(x, y)` to method `validatePosition`
    - Remove unused parameters
  - Introduce variable tile on `play` method
    - Adjust method to use `tile` variable
