package katas.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class RoverAcceptanceTest {
    Rover rover;

    @BeforeEach
    public void setUp() {
        rover = new Rover();
    }

    @Test
    public void it_can_move_within_the_bounds_of_the_grid() {
        String command = "MMRMMLMLMLM";
        String expectedOutput = "1:2:S";
        assertEquals(expectedOutput, rover.execute(command));
    }

    @Test
    public void it_can_wrap_around_the_grid() {
        String command = "MMMMMMMMMM";
        String expectedOutput = "0:0:N";
        assertEquals(expectedOutput, rover.execute(command));
    }

    @Test
    @Disabled("todo")
    public void obstacles_RENAME() {
        // TODO: to implement
        /* given a grid with an obstacle at (0, 3), input MMMM gives output O:0:2:N */
    }
}