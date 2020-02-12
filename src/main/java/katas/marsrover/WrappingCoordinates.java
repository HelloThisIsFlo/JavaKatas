package katas.marsrover;

public class WrappingCoordinates {
    private int x;
    private int y;
    private int gridSize;

    public WrappingCoordinates(int x, int y, int gridSize) {
        this.x = x;
        this.y = y;
        this.gridSize = gridSize;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x < 0 ?
                gridSize - (-x) :
                x % gridSize;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y < 0 ?
                gridSize - (-y) :
                y % gridSize;
    }
}
