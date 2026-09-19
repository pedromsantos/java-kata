package org.kata.connascence.algorithm;

// Connascence of Algorithm: the same checksum computation (sum of char
// codes mod 10) is duplicated in both methods instead of extracted once
// -- if the algorithm ever changes, both call sites must be updated in
// lockstep or they silently disagree.
public class ChecksumCalculator {
    public String addChecksum(String inputData) {
        int sum = 0;
        for (int i = 0; i < inputData.length(); i++) {
            sum += inputData.charAt(i);
        }
        int checksum = sum % 10;
        return inputData + checksum;
    }

    public boolean check(String inputDataWithChecksum) {
        String inputData = inputDataWithChecksum.substring(0, inputDataWithChecksum.length() - 1);
        int expected = Integer.parseInt(inputDataWithChecksum.substring(inputDataWithChecksum.length() - 1));
        int sum = 0;
        for (int i = 0; i < inputData.length(); i++) {
            sum += inputData.charAt(i);
        }
        return sum % 10 == expected;
    }
}
