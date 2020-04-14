package katas.stringcalculator;

public class StringCalculator {

    public static int add(String numbers) {
        validateNumbers(numbers);

        if (numbers.length() == 0) {
            return 0;
        }

        int sum = 0;
        for (String number: extractNumbers(numbers)) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private static String[] extractNumbers(String numbers) {
        return numbers.split(",");
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
