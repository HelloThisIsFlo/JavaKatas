package katas.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    private String numbersInput;
    private boolean hasCustomDelimiter;
    private Matcher matcherForNumbersInput;

    private StringCalculator(String numbersInput) {
        this.numbersInput = numbersInput;
        validateNumbersInput();
        this.matcherForNumbersInput = getMatcherForNumbersInput();
        this.hasCustomDelimiter = numbersInput.startsWith("//");
    }

    private void validateNumbersInput() {
        if (numbersInput == null) {
            throw new NumberStringError("String of numbers can not be null");
        }
    }

    private Matcher getMatcherForNumbersInput() {
        String regex = "^//(.)\\n(.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numbersInput);
        matcher.find();
        return matcher;
    }

    public static int add(String numbersInput) {
        return new StringCalculator(numbersInput).add();
    }

    public int add() {
        if (isEmptyInput()) return 0;

        String delimiter = getDelimiter();
        String numbers = getNumbers();

        String[] numbersArray = numbers.split("[" + delimiter + "\n]");

        int sum = 0;
        for (String number : numbersArray) {
            if (!number.isEmpty()) {
                sum += parseInt(number);
            }
        }

        return sum;
    }

    private boolean isEmptyInput() {
        return numbersInput.length() == 0;
    }

    private String getDelimiter() {
        if (hasCustomDelimiter) {
            return matcherForNumbersInput.group(1);
        } else {
            return ",";
        }
    }

    private String getNumbers() {
        if (hasCustomDelimiter) {
            return matcherForNumbersInput.group(2);
        } else {
            return numbersInput;
        }
    }

    public static class NumberStringError extends RuntimeException {
        public NumberStringError(String message) {
            super(message);
        }
    }
}
