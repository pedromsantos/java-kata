package org.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
//non_three_and_five_should_return_stringified_number
class FizzBuzzTest {


    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void one_number_should_return_one_string() {
        // Given
        int number = 1;
        // When
        String result = fizzBuzz.evaluate(number);
        // Then
        assertThat(result).isEqualTo("1");
    }

    @Test
    void two_number_should_return_two_string() {
        //Given
        int number = 2;
        // When
        String result = fizzBuzz.evaluate(number);
        // Then
        assertThat(result).isEqualTo("2");
    }

    @Test
    void eleven_number_should_return_eleven_string() {
        // Given
        int number = 11;
        // When
        String result = fizzBuzz.evaluate(number);
        // Then
        assertThat(result).isEqualTo("11");
    }
}
