# Legacy Code & Test Smells Kata - Yahtzee

## Overview

This kata is a **fixture, not a from-scratch TDD exercise**. It has the same
objective as `21-smelly-mars-rover` and `22-smelly-shopping-cart`, but with a
much smaller surface: a Yahtzee dice cup (inspired by `10-yahtzee`), built
deliberately as legacy code. It exists to practice (or to exercise tooling
for):

- making dice rolling deterministic and testable via an injectable random
  source
- characterization testing of rolling, selecting dice for reroll, and
  rerolling selected dice
- detecting and refactoring test smells in an existing, badly-tested suite
- improving a test suite so it protects observable game behavior instead of
  just passing

Unlike `16-smelly` (which bakes in **production code smells** to refactor),
this kata bakes in **test smells** almost exclusively -- `DiceCup`'s only
testability concession is already made (the random source is injectable), so
the exercise is entirely about the tests, not about finding seams first.

None of the production or test classes contain any explanatory comments.
Finding and naming each smell is part of the exercise -- this README
intentionally does not say where they are.

## Current State

| Area                     | Coverage | What's wrong                                          |
| ------------------------ | -------- | ------------------------------------------------------ |
| `Die`, `DiceCup`         | tested   | tests exist, but nearly all of them are smelly         |
| `TurnLog`                | tested   | one smelly unit test, one unrelated timestamp assertion |

## Problem Description

A `DiceCup` holds five `Die`. `roll()` rolls all five using an injectable
random source (defaulting to `Math.random`, but replaceable with a fake for
tests). `selectForReroll(indexes)` records which dice the player wants to
keep for a reroll; `rerollSelected()` re-rolls just those dice and clears the
selection. `currentDice()` exposes whatever the cup last rolled.

`TurnLog` wraps a `DiceCup` and a `TelemetryPort`: `rerollSelectedDice()`
delegates to the cup's `rerollSelected()` and records a `rerolled:v1,v2,...`
entry on the telemetry port with the resulting values.

## What to Look For

The test suite currently passes in full, but it is deliberately smelly. Look
for (at least) these smells from the catalogue below, spread across
`DiceCupTest` and `TurnLogTest`:

Logic in Test, Test Interdependence, Eager Test, Assertion Roulette, Obscure
Test, Test Code Duplication, Conditional Test Logic, Hard-Coded Test Data,
Testing Private Methods, Slow Unit Test, Mocking Final/Concrete Classes,
Mocking Value Objects, Implementation Coupling, Shared Mutable State, Testing
Theater.

Some smells overlap in the same test. None of them are labeled in the code.

## Tasks

1. **Fix the existing tests** -- everything currently passes, but almost none
   of it protects real behavior. Detect each smell, then refactor it without
   ever weakening or deleting a test to make it pass.
2. **Characterize the rerolling behavior properly** -- once the smells are
   gone, make sure `roll`, `selectForReroll`, and `rerollSelected` are each
   protected by a test that would actually fail if their behavior changed.

## Tips

- The smelly tests currently pass. That is the point: passing is not the same
  as protecting anything.
- Watch for tests that duplicate `DiceCup`'s own rolling formula instead of
  asserting on its output -- a duplicated formula can be wrong in the same
  way the production code is, or wrong in a different way that the chosen
  test values never expose.
- Run mutation testing after any test fix -- high coverage on this code with
  weak assertions is exactly what several of the smells above look like from
  the outside.

## Testing

This module uses JUnit 5 and AssertJ, with Mockito available for test
doubles (matching the style of the pre-written smelly tests, which use
Mockito the way the original TypeScript kata uses Jest mocks).

## Resources

<https://www.youtube.com/watch?v=MM6_tyvBRXE>
<https://refactoring.guru/refactoring/smells>
<https://luzkan.github.io/smells/>
