package org.kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {
    FizzBuzz fizzBuzz = new FizzBuzz();

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 150})
    void five_and_three_multiples_numbers_should_return_fizzbuzz(int number) {
        // When
        String result = fizzBuzz.evaluate(number);
        // Then
        assertThat(result).isEqualTo("FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 55, 80})
    void five_multiple_numbers_should_return_buzz(int number) {
        // When
        String result = fizzBuzz.evaluate(number);
        // Then
        assertThat(result).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 12, 99})
    void three_multiple_numbers_should_return_fizz(int number) {
        // When
        String result = fizzBuzz.evaluate(number);
        // Then
        assertThat(result).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 11, 56})
    void non_three_and_five_multiple_numbers_should_return_string_formatted_number(int number) {
        // When
        String result = fizzBuzz.evaluate(number);
        // Then
        if (number == 1) {
            assertThat(result).isEqualTo("1");
        }
        if (number == 2) {
            assertThat(result).isEqualTo("2");
        }
        if (number == 11) {
            assertThat(result).isEqualTo("11");
        }
        if (number == 56) {
            assertThat(result).isEqualTo("56");
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -15, -3, -5})
    void should_handle_zero_and_negative_numbers(int number) {
        // When
        String result = fizzBuzz.evaluate(number);
        // Then
        if (number % 3 == 0 && number % 5 == 0) assertThat(result).isEqualTo("FizzBuzz");
        else if (number % 5 == 0) assertThat(result).isEqualTo("Buzz");
        else if (number % 3 == 0) assertThat(result).isEqualTo("Fizz");
        else assertThat(result).isEqualTo(String.valueOf(number));
    }
}
