# Connascence Violations Kata

## Overview

This is a **verification fixture, not a practice exercise**. Each folder
contains a small, self-contained example of exactly one Connascence type,
translated directly from *Agile Technical Practices Distilled*'s
Connascence chapter worked examples. Its purpose is to give a known-answer
set for [jev-review](https://github.com/pedromsantos/jev-review)'s upcoming
Connascence rules to be verified against before those rules are implemented.

`CoV` (Connascence of Value) is intentionally not represented -- already
covered by jev-review's existing checks. `CoMT` (Connascence of Manual
Task) is intentionally not represented either -- it's connascence with an
external, undocumented manual step no code review can see.

This is the Java translation of the reference kata in ts-kata's
`26_SmellyConnascence`; equivalent kata exist for Go, Python, C#, and C.

## What's here

| File | Type | Why |
|---|---|---|
| `org/kata/connascence/position/NotificationSystem.java` | Connascence of Position | three same-typed `String` parameters carry meaning only through argument order |
| `org/kata/connascence/meaning/TransportSelector.java` | Connascence of Meaning | `"1"`/`"2"`/`"3"`/`"4"` mean bike/car/train/bus only by an unstated, shared convention |
| `org/kata/connascence/algorithm/ChecksumCalculator.java` | Connascence of Algorithm | the checksum computation (`sum % 10`) is duplicated across two methods instead of extracted once |
| `org/kata/connascence/executionorder/ReceiptSender.java` | Connascence of Execution Order | `archive()` is only correct after `sendToCustomer()`, but nothing enforces that order |
| `org/kata/connascence/timing/BackgroundJobRunner.java` | Connascence of Timing | waits a fixed, arbitrary delay instead of the job's actual completion |
| `org/kata/connascence/identity/GlobalCounter.java` + `org/kata/connascence/identity/CounterConsumer.java` | Connascence of Identity | every consumer's correctness depends on sharing this exact static singleton instance |
