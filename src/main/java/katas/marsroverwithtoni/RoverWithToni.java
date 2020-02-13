package katas.marsroverwithtoni;

import java.util.Map;

import static katas.marsroverwithtoni.RoverWithToni.Direction.*;

public class RoverWithToni {

    public static final int MAP_SIZE = 10;
    private final static Map<Direction, Direction> rotateLeft = Map.of(
            N, W,
            W, S,
            S, E,
            E, N
    );
    private final static Map<Direction, Direction> rotateRight = Map.of(
            N, E,
            E, S,
            S, W,
            W, N
    );
    Direction direction = N;
    int coordinate_x = 0;
    int coordinate_y = 0;

    public String execute(String commands) {
        for (Character command : commands.toCharArray()) {
            switch (command) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    move();
                    break;
            }
        }

        return formatPosition();
    }

    private void turnLeft() {
        direction = rotateLeft.get(direction);
    }

    private void turnRight() {
        direction = rotateRight.get(direction);
    }

    private void move() {
        switch (direction) {
            case E:
                coordinate_x += 1;
                break;
            case N:
                coordinate_y += 1;
                break;
            case W:
                coordinate_x -= 1;
                break;
            case S:
                coordinate_y -= 1;
                break;
        }

        coordinate_x = checkForWrap(coordinate_x);
        coordinate_y = checkForWrap(coordinate_y);
    }

    private String formatPosition() {
        String coordinates = coordinate_x + ":" + coordinate_y;
        return coordinates + ":" + direction;
    }

    private int checkForWrap(int coordinate) {
        if (coordinate < 0) coordinate = MAP_SIZE - 1;
        return coordinate % MAP_SIZE;
    }

    enum Direction {N, S, E, W}
}
