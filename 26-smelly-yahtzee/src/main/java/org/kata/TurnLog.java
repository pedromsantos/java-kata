package org.kata;

import java.util.List;
import java.util.stream.Collectors;

public class TurnLog {
    private final DiceCup diceCup;
    private final TelemetryPort telemetry;

    public TurnLog(DiceCup diceCup, TelemetryPort telemetry) {
        this.diceCup = diceCup;
        this.telemetry = telemetry;
    }

    public List<Die> rerollSelectedDice() {
        List<Die> dice = diceCup.rerollSelected();
        String values = dice.stream().map(die -> String.valueOf(die.value)).collect(Collectors.joining(","));
        telemetry.record("rerolled:" + values);
        return dice;
    }
}
