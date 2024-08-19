# Actions

Remember to run the tests on each refactor and if green commit the changes

We are almost done with class `Game` just a few name improvements and we are done.
Lets fix names on class `Game`. `player` seams a better name than `symbol`

- On class `Game`
    - Rename instance variable `_lastSymbol` to `lastPlayer`
    - On method `play`
        - rename argument `symbol` to `player`
    - On method `validateFirstMove`
        - rename argument `symbol` to `player`
    - On method `validatePlayer`
        - rename argument `symbol` to `player`
    - On method `updatePlayer`
        - rename argument `symbol` to `player`
    - On method `updateBoard`
        - rename argument `symbol` to `player`
