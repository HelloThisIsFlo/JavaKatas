package katas.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public static List<Integer> of(int number) {
        int leftToDivide = number;
        List<Integer> primeFactors = new ArrayList<>();
        int divider = 2;

        while (!finishedComputation(leftToDivide)) {
            if (isDivisibleBy(leftToDivide, divider)) {
                primeFactors.add(divider);
                leftToDivide /= divider;
            } else {
                divider += 1;
            }
        }

        return primeFactors;
    }

    private static boolean finishedComputation(int leftToDivide) {
        return leftToDivide <= 1;
    }

    private static boolean isDivisibleBy(int number, int divider) {
        return number % divider == 0;
    }
}
