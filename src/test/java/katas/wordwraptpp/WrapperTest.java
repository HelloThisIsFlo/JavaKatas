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
        assertWrappedText("", 100, "");
    }

    private void assertWrappedText(String text, int colNum, String expectedResult) {
        assertEquals(expectedResult, wrap(text, colNum));
    }

    @Test
    public void enoughSpace_doNotWrap() {
        assertWrappedText("frank", 100, "frank");
    }

    @Test
    public void breakBetween2Words_breakAtSpace() {
        int colEndsInMiddleOfPatrick = 8;
        assertWrappedText("frank patrick", colEndsInMiddleOfPatrick, "frank\npatrick");
    }

    @Test
    public void multipleWords_onlyBreakWhenGoingOverTheColLimit() {
        int colEndsInMiddleOfSamantha = 17;
        assertWrappedText("frank patrick samantha", colEndsInMiddleOfSamantha, "frank patrick\nsamantha");
    }

    @Test
    public void breakInTheMiddleOfAWord() {
        int columnSizeForcesABreakInSamantha = 7;
        assertWrappedText(
                "frank patrick samantha",
                columnSizeForcesABreakInSamantha,
                "frank\npatrick\nsamanth\na"
        );
    }

    //    @Test7
//    public void singleWord_notEnoughSpace_breakInMiddleOfWord() {
//        assertWrappedText("frank", 4, "fran\nk");
//    }
}