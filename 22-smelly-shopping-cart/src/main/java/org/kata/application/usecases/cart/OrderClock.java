package org.kata.application.usecases.cart;

import java.time.Instant;

import org.kata.domain.ports.Clock;

public class OrderClock implements Clock {
    // NOTE: TS's OrderClock has a static `now()` and an instance `now()` with
    // the same name -- legal in TS/JS (static and instance members live in
    // different namespaces there) but illegal in Java (same erasure can't be
    // both static and instance in one class). The static side is renamed to
    // `currentTimestamp()` here; see PORTING_NOTES_JAVA.md.
    public static String currentTimestamp() {
        return Instant.now().toString();
    }

    @Override
    public String now() {
        return OrderClock.currentTimestamp();
    }
}
