package org.kata;

public class Rover {
    private int x;
    private int y;
    private String direction;
    private final int gridSize;
    private final ObstacleSensor sensor = new ObstacleSensor();
    private final RadioTransmitter radio = new RadioTransmitter("mission-control.nasa.gov");

    public Rover(int x, int y, String direction, int gridSize) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.gridSize = gridSize;
    }

    public String execute(String commands) {
        for (char command : commands.toCharArray()) {
            Position previous = new Position(x, y);

            if (command == 'L') turnLeft();
            else if (command == 'R') turnRight();
            else if (command == 'M') moveForward();

            if (sensor.detectsObstacleAt(x, y)) {
                x = previous.x;
                y = previous.y;
                reportObstacle();
                return "O " + x + " " + y + " " + direction;
            }
        }

        return x + " " + y + " " + direction;
    }

    private void reportObstacle() {
        radio.send("OBSTACLE " + x + " " + y + " " + direction + " at " + MissionClock.now());
    }

    private void turnLeft() {
        String[] order = {"N", "W", "S", "E"};
        direction = order[(indexOf(order, direction) + 1) % 4];
    }

    private void turnRight() {
        String[] order = {"N", "E", "S", "W"};
        direction = order[(indexOf(order, direction) + 1) % 4];
    }

    private void moveForward() {
        if (direction.equals("N")) y = (y + 1) % gridSize;
        else if (direction.equals("S")) y = (y - 1 + gridSize) % gridSize;
        else if (direction.equals("E")) x = (x + 1) % gridSize;
        else if (direction.equals("W")) x = (x - 1 + gridSize) % gridSize;
    }

    private static int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) return i;
        }
        return -1;
    }
}
