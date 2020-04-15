package katas.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static int add(String numbers) {
        validateNumbers(numbers);

        if (numbers.length() == 0) {
            return 0;
        }

        boolean hasCustomDelimiter = numbers.startsWith("//");
        if (hasCustomDelimiter) {

            String regex = "^//(.)\\n(.*)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(numbers);
            matcher.find();

            String delimiter = matcher.group(1);
            String numbersRENAME = matcher.group(2);

            String[] numbersArray = numbersRENAME.split("[" + delimiter + "\n]");
            int sum = 0;
            for (String number : numbersArray) {
                if (!number.isEmpty()) {
                    sum += parseInt(number);
                }
            }


            return sum;
        }

        String[] numbersArray = numbers.split("[,\n]");

        int sum = 0;
        for (String number : numbersArray) {
            if (!number.isEmpty()) {
                sum += parseInt(number);
            }
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
