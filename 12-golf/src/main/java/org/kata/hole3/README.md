# Actions

Remember to run the tests on each refactor and if green commit the changes

- On class `Game`
  - On Method `Winner`
    - Extract method `isRowFull` from first if condition
      - Accept IntelliJ suggestions to remove duplication
    - Extract method `winnerOnRow` from inner if block
      - Accept Intellij suggestions to remove duplication
    - Manually fix any incoherences
    - Remove comments
    - Replace if statments with for loop
    - Replace `null` return on method `winnerOnRow` with char
