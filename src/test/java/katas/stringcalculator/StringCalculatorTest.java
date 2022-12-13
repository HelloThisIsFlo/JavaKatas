package katas.stringcalculator;

import katas.stringcalculator.StringCalculator.NumberStringError;
import katas.wordwrap.Wrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static katas.wordwrap.Wrapper.wrapPremise;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StringCalculatorTest {
    /*
    Feature 1: Can add 0, 1 or 2 numbers from String and return result as int
    Feature 2: Can add any number of numbers
     */

    @Test
    public void testAddGivenEmptyStringReturn0() {
        int result = StringCalculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void nullString_throwsInvalidNumberStringError() {
        assertThrows(
            NumberStringError.class,
            () -> StringCalculator.add(null)
        );
    }

    @Test
    public void givenASingleNumberAsString_returnNumberAsInt() {
        int result1 = StringCalculator.add("1");
        int result2 = StringCalculator.add("2");
        int result3 = StringCalculator.add("3");

        assertEquals(1, result1);
        assertEquals(2, result2);
        assertEquals(3, result3);
    }

    @Test
    public void given2Numbers_returnSum() {
        int result = StringCalculator.add("2,4");
        assertEquals(2 + 4, result);
    }

    /*
        Feature 2: Can add any amount of numbers
     */

    @Test
    public void given3Numbers_returnSum() {
        int result = StringCalculator.add("1,2,3");
        assertEquals(1 + 2 + 3, result);
    }

    /*
     Feature 3:
     Allow the Add method to handle new lines between numbers (instead of commas).

     the following input is ok: "1\n2,3" (will equal 6)
     the following input is NOT ok: "1,\n" (not need to prove it - just clarifying)
     */

    @Test
    public void givenNewlineAsSeparatorInStringNumber_isValid() {
        int result = StringCalculator.add("1\n2,3");
        assertEquals(1 + 2 + 3, result);
    }

    @Test
    @Disabled
    public void canUseNewlineAsSeparator() {
        // Just a different formulation of the previous test
    }
    /*
    Feature 4:
    Support different delimiters

    to change a delimiter, the beginning of the string will contain a separate line
    that looks like this: "//[delimiter]\n[numbers...]"
    For example "//;\n1;2" should return three where the default delimiter is ‘;’.
    the first line is optional. all existing scenarios should still be supported
     */

    @Test
    public void canSupportDifferentDelimiters() {
        int result = StringCalculator.add("//;\n1;2");
        assertEquals(1 + 2, result);
    }

    // TODO: Add a test to clarify if the delimiter finishes with '\n' or is always 1 char
    // 1) Let's assume delimiter can NOT be a newline
    // 2) Let's add a test to ensure that newline CAN be a delimiter.
    // 1bis) Let's assume that there can only be ONE delimiter at a time.
    // 2bis) Prove there can only be ONE delimiter at the time.

    @Test
    public void learningTest_captureGroups() {
        String line = "#first#second,third";
        String regex = "^#(.*)#(.*),(.*)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        assertTrue(matcher.find());
        assertEquals("first", matcher.group(1));
        assertEquals("second", matcher.group(2));
        assertEquals("third", matcher.group(3));
    }
}