package org.kata;

import java.time.Instant;

public class MissionClock {
    public static String now() {
        return Instant.now().toString();
    }
}
