package katas.marsrover;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {

    Rover rover;

    @Before
    public void setUp() {
        rover = new Rover();
    }

    @Test
    public void it_starts_at_origin_0_0_N() {
        assertRover("", "0:0:N");
    }

    private void assertRover(String commands, String expectedFinalPosition) {
        assertEquals(expectedFinalPosition, rover.execute(commands));
    }

    @Test
    public void it_rotates_left_from_origin() {
        assertRover("L", "0:0:W");
    }

    @Test
    public void it_rotates_left_multiple_times_from_origin() {
        assertRover("LLLLLLL", "0:0:E");
    }

    @Test
    public void it_rotates_right_from_origin() {
        assertRover("R", "0:0:E");
    }

    @Test
    public void it_rotates_right_multiple_times_from_origin() {
        assertRover("RRRR", "0:0:N");
    }

    @Test
    public void it_moves_north() {
        // Rover starts facing north
        assertRover("MMMM", "0:4:N");
    }

    @Test
    public void it_moves_east() {
        // Rover starts facing north
        String faceEastAndMoveForward = "RM";
        assertRover(faceEastAndMoveForward, "1:0:E");
    }

    @Test
    public void it_moves_west() {
        // Rover starts facing north
        String goTo_2_0_andMoveWest = "RMMLLM";
        assertRover(goTo_2_0_andMoveWest, "1:0:W");
    }

    @Test
    public void it_moves_south() {
        // Rover starts facing north
        String goTo_0_2_andMoveSouth = "MMLLM";
        assertRover(goTo_0_2_andMoveSouth, "0:1:S");
    }

    @Test
    public void it_wraps_when_reaching_the_top() {
        String goToTheTopAndBackToOrigin = "MMMMMMMMMM";
        assertRover(goToTheTopAndBackToOrigin, "0:0:N");
    }

    @Test
    public void it_wraps_when_reaching_the_bottom() {
        String goToTheTopByWrappingFromBottom = "RRM";
        assertRover(goToTheTopByWrappingFromBottom, "0:9:S");
    }

    @Test
    public void it_wraps_when_reaching_the_right_end() {
        String goToTheRightEndAndBackToOrigin = "RMMMMMMMMMM";
        assertRover(goToTheRightEndAndBackToOrigin, "0:0:E");
    }

    @Test
    public void it_wraps_when_reaching_the_left_end() {
        String goToTheRightEndByWrappingFromTheLeft = "LM";
        assertRover(goToTheRightEndByWrappingFromTheLeft, "9:0:W");
    }
}