package katas.primefactors;

import com.google.common.base.MoreObjects;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;

/*
RunWith(Parameterized.class)
 public class FibonacciTest {
     @Parameters(name= "{index}: fib[{0}]={1}")
     public static Iterable<Object[]> data() {
         return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 },
                 { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
     }

     private int fInput;

     private int fExpected;

     public FibonacciTest(int input, int expected) {
         fInput= input;
         fExpected= expected;
     }

     @Test
     public void test() {
         assertEquals(fExpected, Fibonacci.compute(fInput));
     }
 }
 */
//@RunWith(Parameterized.class)
public class PrimeFactorsTest {
    // TODO: Convert to jUnit 5
//    private static final List<PrimeFactorsTestParams> TEST_PARAMS = List.of(
//            testThat(1, NONE),
//            testThat(2, 2),
//            testThat(3, 3),
//            testThat(4, 2, 2),
//            testThat(5, 5),
//            testThat(6, 2, 3),
//            testThat(449, 449),
//            testThat(430, 2, 5, 43)
//    );
//    PrimeFactorsTestParams testParams;
//    public PrimeFactorsTest(PrimeFactorsTestParams testParams) {
//        this.testParams = testParams;
//    }
//
//    private static PrimeFactorsTestParams testThat(int number, Integer... hasForPrimeFactors) {
//        return new PrimeFactorsTestParams(number, List.of(hasForPrimeFactors));
//    }
//
//    private static PrimeFactorsTestParams testThat(int number, NoPrimeFactor hasForPrimeFactors) {
//        return new PrimeFactorsTestParams(number, List.of());
//    }
//
//    @Parameterized.Parameters(name = "{0}")
//    public static Iterable<PrimeFactorsTestParams> data() {
//        return TEST_PARAMS;
//    }
//
//    @Test
//    public void testPrimeFactors() {
//        assertEquals(testParams.expectedPrimeFactors, PrimeFactors.of(testParams.number));
//    }
//
//    enum NoPrimeFactor {
//        NONE
//    }
//
//    public static class PrimeFactorsTestParams {
//        int number;
//        List<Integer> expectedPrimeFactors;
//
//        public PrimeFactorsTestParams(int number, List<Integer> expectedPrimeFactors) {
//            this.number = number;
//            this.expectedPrimeFactors = expectedPrimeFactors;
//        }
//
//        @Override
//        public String toString() {
//            return MoreObjects.toStringHelper(this)
//                    .add("number", number)
//                    .add("expectedPrimeFactors", expectedPrimeFactors)
//                    .toString();
//        }
//    }
}