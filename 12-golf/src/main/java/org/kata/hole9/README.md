# Actions

Remember to run the tests on each refactor and if green commit the changes

Let's now turn our attention to more class `Tile` usages

- On class `Tile`

  - Generate getter for player

- On class `Board`

  - On method `TileAt` introduce parameter `new Tile(x,y)`
    - Remove unused parameters `x` and `y`
  - On method `AddTileAt` introduce parameter `new Tile(x,y)`
    - Remove unused parameters `x` and `y`
  - On method `AddTileAt` use method `getPlayer` from class `Tile`
  - on method `isRowFull` rename argument `x` to `row`
  - on method `commonPlayerOnAllColumns` rename argument `x` to `row`

- On class `Game`
  - Add argument `player` to new Tile
