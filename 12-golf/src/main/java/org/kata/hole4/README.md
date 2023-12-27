# Actions

Remember to run the tests on each refactor and if green commit the changes

Winner method has Feature Envy on board lets fix this

- On class `Game`
  - Rename instance variable `-lastSymbol` to `lastPlayer`
  - On method `play`
    - rename argument `symbol` to `player`
  - On method `validateFirstMove`
    - rename argument `symbol` to `player`
  - On method `updatePlayer`
    - rename argument `symbol` to `player`
  - On method `updateBoard`
    - rename argument `symbol` to `player`
