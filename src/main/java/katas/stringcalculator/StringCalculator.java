package katas.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static int add(String numbersInput) {
        validateNumbers(numbersInput);

        if (numbersInput.length() == 0) {
            return 0;
        }

        boolean hasCustomDelimiter = numbersInput.startsWith("//");

        String delimiter;
        String numbers;
        if (hasCustomDelimiter) {
            String regex = "^//(.)\\n(.*)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(numbersInput);
            matcher.find();

            delimiter = matcher.group(1);
            numbers = matcher.group(2);
        } else {
            delimiter = ",";
            numbers = numbersInput;
        }

        String[] numbersArray = numbers.split("[" + delimiter + "\n]");


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
