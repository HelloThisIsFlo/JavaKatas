package katas.roman;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import katas.stringcalculator.StringCalculator;
import katas.stringcalculator.StringCalculator.NumberStringError;
import org.junit.jupiter.api.Test;


public class RomanNumeralsTest {

    @Test
    public void multiple_I() {
        assertRoman(1, "I");
        assertRoman(2, "II");
        assertRoman(3, "III");
    }

    private void assertRoman(int number, String roman) {
        assertEquals(roman, RomanNumerals.toRoman(number));
    }

    @Test
    public void after_V() {
        assertRoman(5, "V");
        assertRoman(6, "VI");
        assertRoman(7, "VII");
    }

    @Test
    public void after_X() {
        assertRoman(10, "X");
        assertRoman(11, "XI");
        assertRoman(12, "XII");
    }

    @Test
    public void after_XV() {
        assertRoman(15, "XV");
        assertRoman(16, "XVI");
    }

    @Test
    public void multiple_X() {
        assertRoman(20, "XX");
        assertRoman(30, "XXX");
    }

    @Test
    public void after_L() {
        assertRoman(50, "L");
        assertRoman(51, "LI");
        assertRoman(60, "LX");
        assertRoman(67, "LXVII");
    }

    @Test
    public void after_C() {
        assertRoman(100, "C");
        assertRoman(110, "CX");
        assertRoman(157, "CLVII");
    }

    @Test
    public void multiple_C() {
        assertRoman(200, "CC");
        assertRoman(300, "CCC");
    }

    @Test
    public void after_D() {
        assertRoman(500, "D");
        assertRoman(538, "DXXXVIII");
    }

    @Test
    public void after_M() {
        assertRoman(1000, "M");
        assertRoman(1300, "MCCC");
        assertRoman(1625, "MDCXXV");
    }

    @Test
    public void multiple_M() {
        assertRoman(2000, "MM");
        assertRoman(3000, "MMM");
    }

    @Test
    public void number_too_high() {
        assertThrows(
            RomanNumerals.InvalidNumber.class,
            () -> RomanNumerals.toRoman(4000)
        );
    }

    @Test
    public void number_zero_or_below() {
        assertThrows(
            RomanNumerals.InvalidNumber.class,
            () -> {
                RomanNumerals.toRoman(0);
                RomanNumerals.toRoman(-1);
            }
        );
    }

    @Test
    public void special_before_V_L_D() {
        assertRoman(4, "IV");
        assertRoman(40, "XL");
        assertRoman(400, "CD");

        assertRoman(41, "XLI");

        assertRoman(224, "CCXXIV");
        assertRoman(242, "CCXLII");
        assertRoman(444, "CDXLIV");
    }

    @Test
    public void special_before_X_C_M() {
        assertRoman(9, "IX");
        assertRoman(90, "XC");
        assertRoman(900, "CM");

        assertRoman(229, "CCXXIX");
        assertRoman(292, "CCXCII");
        assertRoman(999, "CMXCIX");
    }
}