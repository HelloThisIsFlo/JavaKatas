package katas.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static katas.bowling.Game.NUM_OF_FRAMES;
import static katas.bowling.Game.ROLLS_PER_FRAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private static final int NUM_OF_ROLLS = NUM_OF_FRAMES * ROLLS_PER_FRAME;
    Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void gutterGame_allZero() {
        rollMany(NUM_OF_ROLLS, 0);
        assertEquals(0, game.score());
    }

    private void rollMany(int times, int pinsDownOnEachRoll) {
        for (int i = 0; i < times; i++) {
            game.roll(pinsDownOnEachRoll);
        }
    }

    @Test
    public void allOne() {
        rollMany(NUM_OF_ROLLS, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void oneSpare() {
        game.roll(5);
        game.roll(5); // Spare!

        game.roll(3);
        rollMany(NUM_OF_ROLLS - 3, 0);

        assertEquals(16, game.score());
    }
    /*

    ({}–>nil) no code at all->code that employs nil
    (nil->constant)
    (constant->constant+) a simple constant to a more complex constant
    (constant->scalar) replacing a constant with a variable or an argument
    (statement->statements) adding more unconditional statements.
    (unconditional->if) splitting the execution path
    (scalar->array)
    (array->container)
    (statement->recursion)
    (if->while)
    (expression->function) replacing an expression with a function or algorithm
    (variable->assignment) replacing the value of a variable.

     */

    @Test
    public void oneSpareTricky() {
        game.roll(5);
        game.roll(5); // Spare!

        game.roll(3);
        game.roll(3);

        game.roll(7);
        game.roll(2);

        rollMany(NUM_OF_ROLLS - 5, 0);
        assertEquals(28, game.score());
    }

}