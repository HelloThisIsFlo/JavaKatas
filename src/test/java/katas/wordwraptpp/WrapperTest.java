package katas.wordwraptpp;

import org.junit.Ignore;
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

    private void assertWrappedText(String text, int colSize, String expectedResult) {
        assertEquals(expectedResult, wrap(text, colSize));
    }

    @Test
    public void enoughSpace_doNotWrap() {
        assertWrappedText("frank", 100, "frank");
    }

//    @Test
//    public void singleWord_notEnoughSpace_breakInMiddleOfWord() {
//        assertWrappedText("frank", 4, "fran\nk");
//    }
//
//    @Test
//    public void breakBetween2Words_breakAtSpace_path2() {
//        int colEndsInMiddleOfPatrick = 8;
//        assertWrappedText("frank patrick", colEndsInMiddleOfPatrick, "frank\npatrick");
//    }
//
//    @Test
//    public void multipleWords_oneOnEachLine() {
//        int oneWordOnEachLine = 8;
//        assertWrappedText("frank patrick sarah", oneWordOnEachLine, "frank\npatrick\nsarah");
//    }
//
//    @Test
//    public void wordTooLongToFitOn2Lines_breakMultipleTimesOnSameWord() {
//        assertWrappedText("thisIsASuperLongWord!", 5, "thisI\nsASup\nerLon\ngWord\n!");
//    }
//
//    @Test
//    public void multipleWhitespacesTogetherOnTheSameLine() {
//        int breakInMiddleOfSarah = 22;
//        assertWrappedText("hello frank this is sarah", breakInMiddleOfSarah, "hello frank this is\nsarah");
//    }

    /*
     * [x] Multiple whitespaces together on the same line
     * [x] Word too long to fit on 2 lines -> Multiple breaks in same word
     * [x] Multiple words, one on each line
     * [ ] Multiple whitespaces together on the same line but word being cut too long to be on one line
     */

    @Test
//    @Ignore("Path 1")
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
    public void wordTooLongForOneColumn() {
        assertWrappedText("ThisIsALongWord", 8, "ThisIsAL\nongWord");
    }

    @Test
    public void breakInTheMiddleOfAWord() {
        int columnSizeForcesABreakInSamantha = 9;
        assertWrappedText(
                "frank patrick thisIsALongWord",
                columnSizeForcesABreakInSamantha,
                "frank\npatrick\nthisIsALo\nngWord"
        );
    }

    @Test
    public void breakInTheMiddleOfAWord_alt() {
        int columnSizeForcesABreakInSamantha = 9;
        assertWrappedText(
                "frank thisIsALongWord patrick",
                columnSizeForcesABreakInSamantha,
                "frank\nthisIsALo\nngWord\npatrick"
        );
    }
}