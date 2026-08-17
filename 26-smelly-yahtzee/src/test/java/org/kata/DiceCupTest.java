package org.kata;

import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(OrderAnnotation.class)
class DiceCupTest {
    private static final DiceCup sharedCup = new DiceCup(() -> 0);
    private static int rollCount = 0;

    @Test
    @Order(1)
    void test1() {
        rollCount++;
        List<Die> dice = sharedCup.roll();
        assertThat(dice).isNotNull();
    }

    @Test
    @Order(2)
    void shouldWork() {
        assertThat(rollCount).isGreaterThan(0);
        assertThat(sharedCup.currentDice()).hasSize(5);
    }

    @Test
    void rollsDiceAndSelectsDiceAndRerollsDiceAndClearsSelection() {
        DiceCup cup = new DiceCup(() -> 0.5);
        List<Die> rolled = cup.roll();
        cup.selectForReroll(List.of(0, 2));
        List<Die> rerolled = cup.rerollSelected();

        assertThat(rolled).hasSize(5);
        assertThat(rolled.get(0).value).isEqualTo(4);
        assertThat(rolled.get(1).value).isEqualTo(4);
        assertThat(rerolled.get(2).value).isEqualTo(4);
        assertThat(cup.currentDice()).hasSize(5);
        assertThat(rerolled).isSameAs(cup.currentDice());
    }

    @Test
    void doesThings() {
        List<Die> dice = new DiceCup(() -> 0).roll();

        assertThat(dice).hasSize(5);
        assertThat(dice.get(0).value).isEqualTo(1);
        assertThat(dice.get(1).value).isEqualTo(1);
        assertThat(dice.get(2).value).isEqualTo(1);
        assertThat(dice.get(3).value).isEqualTo(1);
    }

    @Test
    void computesExpectedDiceWithTheSameBranchingAsTheCup() {
        List<Double> values = List.of(0.01, 0.2, 0.4, 0.7, 0.99);
        Deque<Double> queue = new ArrayDeque<>(values);
        DiceCup cup = new DiceCup(() -> queue.poll());

        List<Integer> expected = new ArrayList<>();
        for (double value : values) {
            if (value < 1.0 / 6) expected.add(1);
            else if (value < 2.0 / 6) expected.add(2);
            else if (value < 3.0 / 6) expected.add(3);
            else if (value < 5.0 / 6) expected.add(5);
            else expected.add(6);
        }

        List<Integer> actual = cup.roll().stream().map(die -> die.value).collect(Collectors.toList());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void reachesIntoThePrivateDieRollerDirectly() throws Exception {
        DiceCup cup = new DiceCup(() -> 0);
        Method method = DiceCup.class.getDeclaredMethod("rollDie");
        method.setAccessible(true);
        Die die = (Die) method.invoke(cup);
        assertThat(die.value).isEqualTo(1);
    }

    @Test
    void slowlyWaitsBeforeRolling() throws InterruptedException {
        Thread.sleep(20);
        assertThat(new DiceCup(() -> 0).roll().get(0).value).isEqualTo(1);
    }

    @Test
    void rerollsTheFirstDieDuplicateCaseOne() {
        DiceCup cup = new DiceCup(() -> 0);
        cup.roll();
        cup.selectForReroll(List.of(0));
        assertThat(cup.rerollSelected().get(0).value).isEqualTo(1);
    }

    @Test
    void rerollsTheFirstDieDuplicateCaseTwo() {
        DiceCup cup = new DiceCup(() -> 0);
        cup.roll();
        cup.selectForReroll(List.of(0));
        assertThat(cup.rerollSelected().get(0).value).isEqualTo(1);
    }

    @Test
    void rerollsTheFirstDieDuplicateCaseThree() {
        DiceCup cup = new DiceCup(() -> 0);
        cup.roll();
        cup.selectForReroll(List.of(0));
        assertThat(cup.rerollSelected().get(0).value).isEqualTo(1);
    }
}
