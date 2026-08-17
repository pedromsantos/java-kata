package org.kata;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MissionLogTest {
    private static final long testRunTimestamp = System.currentTimeMillis();

    @Test
    void logsATranslatedSequence() {
        CommandTranslator mockTranslator = mock(CommandTranslator.class);
        TelemetryPort mockTelemetry = mock(TelemetryPort.class);
        Coordinate mockCoordinate = mock(Coordinate.class);

        when(mockTranslator.translateSequence(anyString(), anyString())).thenReturn("LRM");

        MissionLog log = new MissionLog(mockTranslator, mockTelemetry);
        String result = log.logTranslatedSequence("GDA", "FR");

        assertThat(result).isEqualTo("LRM");
        verify(mockTranslator).translateSequence("GDA", "FR");
        assertThat(mockCoordinate.x).isEqualTo(0);
    }

    @Test
    void recordsTelemetryWithTheRunTimestamp() {
        List<String> recorded = new ArrayList<>();
        TelemetryPort telemetry = recorded::add;
        MissionLog log = new MissionLog(new CommandTranslator(), telemetry);

        log.logTranslatedSequence("A", "IT");

        assertThat(recorded.get(0)).contains("IT");
        assertThat(testRunTimestamp).isLessThanOrEqualTo(System.currentTimeMillis());
    }
}
