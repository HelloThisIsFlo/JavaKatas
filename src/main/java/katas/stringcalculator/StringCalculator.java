package katas.stringcalculator;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static int add(String numbers) {
        validateNumbers(numbers);

        if (numbers.length() == 0) {
            return 0;
        }

        String[] numbersArray = numbers.split(",");

        int sum = 0;
        for (String number: numbersArray) {
           sum += parseInt(number);
        }

        return sum;
    }

    private static void validateNumbers(String numbers) {
        if (numbers == null) {
            throw new NumberStringError("String of numbers can not be null");
        }
    }

    public static class NumberStringError extends RuntimeException {
        public NumberStringError(String message) {
            super(message);
        }
    }
}
