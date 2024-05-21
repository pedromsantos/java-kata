# Actions

Remember to run the tests on each refactor and if green commit the changes

Let's now turn our attention to class `Board`

- On class `Board`
  - Change access modifier on method `isRowFull` from `public`to `private`
  - Change access modifier on method `winnerOnRow` from `public`to `private`
  - Rename method `winnerOnRow` to `hasSamePlayerOnAllColumns`. The board should not know about winning conditions.
  - Rename method `rowHasSameSymbolOnAllColumns` to `anyRowHasSamePlayerOnAllColumns`.
  - Rename method `hasSamePlayerOnAllColumns` to `commonPlayerOnAllColumns`.
  - Rename instance variable `_plays` to `plays` to follow Java naming conventions.
  - Delete Dead Code on method `AddTileAt`
  - Rename argument 'symmbol' to `player`on method `AddTileAt`
  - Simplify method `rowHasSamePlayerOnAllColumns`
