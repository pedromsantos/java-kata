package org.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
//non_three_and_five_should_return_stringified_number
class FizzBuzzTest {


    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void one_nimber_should_return_one_string() {
        // Given
        int number = 1;

        // When
        String result = fizzBuzz.evaluate(number);

        // Then
        assertThat(result).isEqualTo("1");

    }
}
