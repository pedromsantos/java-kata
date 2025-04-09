package org.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {
    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void number_three_should_return_fizz() {
        // Given
        int number = 3;
        // When
        String result = fizzBuzz.evaluate(number);
        // Then
        assertThat(result).isEqualTo("Fizz");
    }

    @Test
    void number_six_should_return_fizz() {
        // Given
        int number = 6;
        // When
        String result = fizzBuzz.evaluate(number);
        // Then
        assertThat(result).isEqualTo("Fizz");
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 11, 56})
    void non_three_and_five_multiples_should_return_string_format_number(int number) {
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
