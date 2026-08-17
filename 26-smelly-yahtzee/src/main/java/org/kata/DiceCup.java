package org.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleSupplier;

public class DiceCup {
    private final DoubleSupplier randomSource;
    private List<Die> dice = new ArrayList<>();
    private List<Integer> selectedIndexes = new ArrayList<>();

    public DiceCup() {
        this(Math::random);
    }

    public DiceCup(DoubleSupplier randomSource) {
        this.randomSource = randomSource;
    }

    public List<Die> roll() {
        List<Die> rolled = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            rolled.add(rollDie());
        }
        dice = rolled;
        selectedIndexes = new ArrayList<>();
        return dice;
    }

    public void selectForReroll(List<Integer> indexes) {
        this.selectedIndexes = new ArrayList<>(indexes);
    }

    public List<Die> rerollSelected() {
        for (int index : selectedIndexes) {
            dice.set(index, rollDie());
        }
        selectedIndexes = new ArrayList<>();
        return dice;
    }

    public List<Die> currentDice() {
        return dice;
    }

    private Die rollDie() {
        return new Die((int) Math.floor(randomSource.getAsDouble() * 6) + 1);
    }
}
