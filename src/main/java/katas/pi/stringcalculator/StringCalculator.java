package katas.pi.stringcalculator;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class StringCalculator {
    public int add(String inputString) {
        if (inputString.isEmpty()) return 0;

        if (inputString.contains(",")) {
            String[] numbersAsString = inputString.split(",");
            return tryToConvertToNumber(numbersAsString[0])
                    + tryToConvertToNumber(numbersAsString[1]);
        }

        return tryToConvertToNumber(inputString);
    }

    private int tryToConvertToNumber(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new InvalidInput("Input is not a number", e);
        }
    }

    public static class InvalidInput extends RuntimeException {
        public InvalidInput(String message) {
            super(message);
        }

        public InvalidInput(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
