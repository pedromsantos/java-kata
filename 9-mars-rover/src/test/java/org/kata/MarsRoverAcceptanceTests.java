package org.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverAcceptanceTests {
	@Test
	void turn_360_degrees_clockwise_while_moving_around_the_plateau() {
		String commands = "5 5\n1 2 N\nLMLMLMLMM";
		MarsRover rover = new MarsRover();

		String finalPosition = rover.execute(commands);

		assertThat(finalPosition).isEqualTo(commands); // 1 3 N
	}

	@Test
	void turn_360_degrees_counter_clockwise_while_moving_around_the_plateau() {
		String commands = "5 5\n1 2 N\nMMRMMRMRRM";
		MarsRover rover = new MarsRover();

		String finalPosition = rover.execute(commands);

		assertThat(finalPosition).isEqualTo(commands); // 5 1 E
	}
}