package katas.roman;

public class RomanNumerals {
    private StringBuilder roman;
    private int leftToConvert;

    private RomanNumerals(int number) {
        leftToConvert = number;
        roman = new StringBuilder();
    }

    public static String toRoman(int number) {
        if (number >= 4000) throw new InvalidNumber("Number too high");
        if (number <= 0) throw new InvalidNumber("Number too low");
        return new RomanNumerals(number).toRoman();
    }

    private String toRoman() {
        for (Roman roman : Roman.values()) {
            consumeDigitalAndConvertToRoman(roman.decimal, roman.toString());
        }
        return roman.toString();
    }

    private void consumeDigitalAndConvertToRoman(int unitDecimal, String unitRoman) {
        while (leftToConvert >= unitDecimal) {
            roman.append(unitRoman);
            leftToConvert -= unitDecimal;
        }
    }

    enum Roman {
        M(1000),
        CM(900),
        D(500),
        CD(400),
        C(100),
        XC(90),
        L(50),
        XL(40),
        X(10),
        IX(9),
        V(5),
        IV(4),
        I(1);

        int decimal;

        Roman(int decimal) {
            this.decimal = decimal;
        }
    }

    public static class InvalidNumber extends RuntimeException {
        public InvalidNumber(String message) {
            super(message);
        }
    }
}
