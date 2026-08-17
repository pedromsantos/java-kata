package org.kata;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TurnLogTest {
    private static final long testRunTimestamp = System.currentTimeMillis();

    @Test
    void logsRerolledDice() {
        DiceCup mockCup = mock(DiceCup.class);
        TelemetryPort mockTelemetry = mock(TelemetryPort.class);
        Die mockDie = spy(new Die(6));

        when(mockCup.rerollSelected()).thenReturn(List.of(new Die(1), new Die(2)));

        TurnLog log = new TurnLog(mockCup, mockTelemetry);
        List<Die> dice = log.rerollSelectedDice();

        assertThat(dice.stream().map(die -> die.value).toList()).containsExactly(1, 2);
        verify(mockTelemetry).record("rerolled:1,2");
        verify(mockCup, times(1)).rerollSelected();
        assertThat(mockDie.value).isEqualTo(6);
    }

    @Test
    void recordsATimestampThatIsAlwaysInThePast() {
        assertThat(testRunTimestamp).isLessThanOrEqualTo(System.currentTimeMillis());
    }
}
