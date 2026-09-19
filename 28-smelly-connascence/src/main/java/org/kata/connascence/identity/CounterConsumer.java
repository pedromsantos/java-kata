package org.kata.connascence.identity;

public class CounterConsumer {
    public int recordVisit() {
        return GlobalCounter.INSTANCE.increment();
    }

    public int totalVisits() {
        return GlobalCounter.INSTANCE.current();
    }
}
