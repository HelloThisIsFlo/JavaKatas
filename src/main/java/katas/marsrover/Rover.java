package katas.marsrover;

public class Rover {

    public static final int GRID_SIZE = 10;
    String direction = "N";
    int coordinate_x = 0;
    int coordinate_y = 0;

    public String execute(String commands) {
        for (String command : commands.split("")) {
            if (command.equals("L")) {
                rotateLeft();
            }
            if (command.equals("R")) {
                rotateRight();
            }
            if (command.equals("M")) {
                moveForward();
            }
        }
        return formatCurrentPosition();
    }

    private void rotateLeft() {
        switch (direction) {
            case "N":
                direction = "W";
                break;

            case "W":
                direction = "S";
                break;

            case "S":
                direction = "E";
                break;

            case "E":
                direction = "N";
                break;
        }
    }

    private void rotateRight() {
        switch (direction) {
            case "N":
                direction = "E";
                break;

            case "E":
                direction = "S";
                break;

            case "S":
                direction = "W";
                break;

            case "W":
                direction = "N";
                break;
        }
    }

    private void moveForward() {
        switch (direction) {
            case "N":
                coordinate_y += 1;
                break;

            case "E":
                coordinate_x += 1;
                break;

            case "W":
                coordinate_x -= 1;
                break;

            case "S":
                coordinate_y -= 1;
                break;
        }

        coordinate_y = checkForWrap(coordinate_y);
        coordinate_x = checkForWrap(coordinate_x);
    }

    private String formatCurrentPosition() {
        String coordinates = coordinate_x + ":" + coordinate_y;
        return coordinates + ":" + direction;
    }

    private int checkForWrap(int coordinate) {
        if (coordinate < 0)
            return GRID_SIZE - 1;
        if (coordinate >= GRID_SIZE)
            return 0;
        return coordinate;
    }
}
