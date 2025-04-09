package org.kata;

public class FizzBuzz {
    public String evaluate(int number) {
        if (number == 3 || number == 6) {
            return "Fizz";
        }
        return number + "";
    }
}