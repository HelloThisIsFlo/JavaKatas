package katas.wordwraptpp;

import org.junit.Test;

import static katas.wordwraptpp.Wrapper.wrap;
import static org.junit.Assert.assertEquals;

public class WrapperTest {
    /*
    Yeah, it's a simple problem to understand, but it's oddly difficult to solve.
    The basic premise is really simple.

    You write a class called Wrapper, that has a single static function named wrap
    that takes two arguments, a string, and a column number.

    The function returns the string, but with line breaks inserted at just the right
    places to make sure that no line is longer than the column number.

    You try to break lines at word boundaries."
    */

    @Test
    public void emptyString_returnsEmptyString() {
        String emptyString = "";
        assertEquals(emptyString, wrap(emptyString, 1));
    }

    @Test
    public void enoughSpace_doNotWrap() {
        String someText = "frank";
        assertEquals(someText, wrap(someText, 100));
    }

    @Test
    public void name() {
    }
}