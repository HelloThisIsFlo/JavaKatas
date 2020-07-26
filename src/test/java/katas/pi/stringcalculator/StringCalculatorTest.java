package katas.pi.stringcalculator;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.StringContains;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    public void emptyStringReturns0() {
        String emptyString = "";
        assertEquals(calculator.add(emptyString), 0);
    }

    @Test
    public void notANumber_throwsError() {
        try {
            String notANumber = "asd";
            calculator.add(notANumber);
            fail("Did not throw");
        } catch (Exception e) {
            assertThat(e.getMessage(), containsString("not a number"));
        }
    }

    @Test
    public void inputIsSingleNumber_returnNumber() {
        assertEquals(calculator.add("1234"), 1234);
    }

    @Test
    public void inputIsTwoNumber_returnSum() {
        assertEquals(
                calculator.add("1234,4567"),
                1234 + 4567
        );
    }
}
