# Actions

Remember to run the tests on each refactor and if green commit the changes

Winner method has Feature Envy on board lets fix this

- On class `Game`
  - On Method `Winner`
    - Extract method `rowHasSameSymbolOnAllColumns` from for loop block
      - Simplyfy method return block
        - Simplify if/else
        - Inline variable
    - Move method `isRowFull` to class `Board`
    - Move method `winnerOnRow` to class `Board`
    - Move method `rowHasSameSymbolOnAllColumns` to class `Board`
