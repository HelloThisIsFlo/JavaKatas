package katas.stringcalculator;

import katas.stringcalculator.StringCalculator.NumberStringError;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test(expected = NumberStringError.class)
    public void nullString_throwsInvalidNumberStringError() {
        StringCalculator.add(null);
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
}