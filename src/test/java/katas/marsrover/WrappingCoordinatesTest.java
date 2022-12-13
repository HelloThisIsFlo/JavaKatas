package katas.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class WrappingCoordinatesTest {
    private static final int GRID_SIZE = 10;
    WrappingCoordinates wrappingCoordinates;

    @BeforeEach
    public void setUp() {
        wrappingCoordinates = new WrappingCoordinates(0, 0, GRID_SIZE);
    }

    @Test
    public void it_can_set_x() {
        wrappingCoordinates.setX(4);
        assertEquals(4, wrappingCoordinates.getX());
    }

    @Test
    public void it_can_set_y() {
        wrappingCoordinates.setY(2);
        assertEquals(2, wrappingCoordinates.getY());
    }

    @Test
    public void it_wraps_when_X_overflows() {
        wrappingCoordinates.setX(GRID_SIZE + 3);
        assertEquals(3, wrappingCoordinates.getX());
    }

    @Test
    public void it_wraps_when_X_below_zero() {
        wrappingCoordinates.setX(-3);
        assertEquals(GRID_SIZE - 3, wrappingCoordinates.getX());
    }

    @Test
    public void it_wraps_when_Y_overflows() {
        wrappingCoordinates.setY(GRID_SIZE + 3);
        assertEquals(3, wrappingCoordinates.getY());
    }

    @Test
    public void it_wraps_when_Y_below_zero() {
        wrappingCoordinates.setY(-3);
        assertEquals(GRID_SIZE - 3, wrappingCoordinates.getY());
    }
}