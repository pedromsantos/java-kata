package org.kata;

public class FizzBuzz {
    public String evaluate(int number) {
        if (number % 3 == 0 && number % 5 == 0 ) {
            return "FizzBuzz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(number);
    }
}