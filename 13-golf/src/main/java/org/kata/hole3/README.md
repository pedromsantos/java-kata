# Actions

Remember to run the tests on each refactor and if green commit the changes

- On class `Game`
  - On Method `Winner`
    - Extract method `isRowFull` from first if condition
      - Accept IntelliJ suggestions to remove duplication
    - Extract method `winnerOnRow` from inner if block
      - Accept Intellij suggestions to remove duplication
    - Manually fix any incoherence's
    - Remove comments
    - Replace if statements with for loop. 
      - Use the *Parallel Change* Refactor technique to make this change
    - Replace `null` return on method `winnerOnRow` with char
