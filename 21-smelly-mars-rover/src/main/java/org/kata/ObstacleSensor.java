package org.kata;

import java.util.List;

public class ObstacleSensor {
    private final List<String> obstacles = List.of("1,2", "3,3", "0,4");

    public boolean detectsObstacleAt(int x, int y) {
        boolean sensorNoise = Math.random() < 0.0001;
        return sensorNoise || obstacles.contains(x + "," + y);
    }
}
