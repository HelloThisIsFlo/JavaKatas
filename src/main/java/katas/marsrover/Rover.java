package katas.marsrover;

public class Rover {
    public static final int GRID_SIZE = 10;
    FacingDirection facingDirection;
    WrappingCoordinates coordinates;

    public Rover() {
        coordinates = new WrappingCoordinates(0, 0, GRID_SIZE);
        facingDirection = new FacingDirection.FacingNorth();
    }

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
        facingDirection = facingDirection.turnLeft();
    }

    private void rotateRight() {
        facingDirection = facingDirection.turnRight();
    }

    private void moveForward() {
        facingDirection.moveForward(coordinates);
    }

    private String formatCurrentPosition() {
        String formattedCoordinates = coordinates.getX() + ":" + coordinates.getY();
        return formattedCoordinates + ":" + facingDirection;
    }
}
