package katas.marsroverwithtoni;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverWithToniTest {

    RoverWithToni rover;

    @Before
    public void setUp() {
        rover = new RoverWithToni();
    }

    @Test
    @Ignore("Acceptance TODO")
    public void acceptance_noObstacle_noWrap() {
        assertRover("MMRMMLMLMLM", "1:2:S");
    }

    private void assertRover(String commands, String expectedFinalPosition) {
        assertEquals(expectedFinalPosition, rover.execute(commands));
    }

    @Test
    @Ignore("Acceptance TODO")
    public void acceptance_noObstacle_withWrap() {
        assertRover("MMMMMMMMMM", "0:0:N");
    }

    @Test
    public void it_starts_at_origin_facing_north() {
        String doNotMove = "";
        String originFacingNorth = "0:0:N";
        assertRover(doNotMove, originFacingNorth);
    }

    @Test
    public void it_rotates_left() {
        assertRover("L", "0:0:W");
    }

    @Test
    public void it_rotates_left_2_times() {
        assertRover("LL", "0:0:S");
    }

    @Test
    public void it_rotates_left_3_times() {
        assertRover("LLL", "0:0:E");
    }

    @Test
    public void it_rotates_left_4_times() {
        assertRover("LLLL", "0:0:N");
    }

    @Test
    public void it_rotates_right() {
        assertRover("R", "0:0:E");
    }

    @Test
    public void it_rotates_right_multiple_times() {
        assertRover("RRRR", "0:0:N");
    }

    @Test
    public void it_moves_north() {
        // Rover starts pointing north
        assertRover("M", "0:1:N");
    }

    @Test
    public void it_moves_north_multiple_times() {
        // Rover starts pointing north
        assertRover("MMM", "0:3:N");
    }

    @Test
    public void it_moves_east() {
        assertRover("RM", "1:0:E");
    }

    @Test
    public void it_moves_west() {
        String moveEastTo_1_0_andMoveBackWest = "RMLLM";
        assertRover(moveEastTo_1_0_andMoveBackWest, "0:0:W");
    }

    @Test
    public void it_moves_south() {
        String moveNorthTo_0_1_andMoveBackSouth = "MLLM";
        assertRover(moveNorthTo_0_1_andMoveBackSouth, "0:0:S");
    }

    @Test
    public void it_wraps_around_the_top_edge() {
        String moveForwardUntilItGoesAroundTheTopEdge = "MMMMMMMMMM";
        assertRover(moveForwardUntilItGoesAroundTheTopEdge, "0:0:N");
    }

    @Test
    public void it_wraps_around_the_right_edge() {
        String moveForwardUntilItGoesAroundTheRightEdge = "RMMMMMMMMMM";
        assertRover(moveForwardUntilItGoesAroundTheRightEdge, "0:0:E");
    }

    @Test
    public void it_wraps_around_the_left_edge() {
        assertRover("LM", "9:0:W");
    }

    @Test
    public void it_wraps_around_the_bottom_edge() {
        assertRover("LLM", "0:9:S");
    }
}