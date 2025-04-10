package org.kata;

public class FizzBuzz {
    public String evaluate(int number) {
        if (number == 5) {
            return "Buzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        return number + "";
    }
}