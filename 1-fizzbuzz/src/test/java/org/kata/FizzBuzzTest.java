package org.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {
    FizzBuzz fizzBuzz = new FizzBuzz();

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 12})
    void three_multiples_numbers_should_return_fizz(int number) {
        // When
        String result = fizzBuzz.evaluate(number);
        // Then
        assertThat(result).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 11, 56})
    void non_three_and_five_multiples_numbers_should_return_string_format_number(int number) {
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
}
