package multithreading.educativeio.racecondition;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class RaceConditionWeird {

  //  public static final int MAX = 10_000;
  public static final int MAX = Integer.MAX_VALUE;
  public long number = 0;
  CyclicBarrier barrier = new CyclicBarrier(2);

  public static void main(String[] args) throws InterruptedException {
    System.out.println("""
        WARNING: This doesn't work, so it'll lock forever!
            
        It was supposed to demonstrate how setting a 'long' number is NOT an atomic operation, in theory
        doing so would set the first 32 bits and THEN the second 32 bits.
        So there is a small time where the number isn't at all what we expect
            
            
        """);
    RaceConditionWeird raceConditionWeird = new RaceConditionWeird();
    boolean weirdScenarioHasNOTOcurred = true;
    while (weirdScenarioHasNOTOcurred) {
      raceConditionWeird.runTest();
      weirdScenarioHasNOTOcurred = (raceConditionWeird.number == Long.MIN_VALUE
                                    || raceConditionWeird.number == Long.MAX_VALUE);
    }
    System.out.println(raceConditionWeird.number);
  }

  public void runTest() throws InterruptedException {
    Thread thread1 = new Thread(this::setNumberToMaxValue);
    Thread thread2 = new Thread(this::setNumberToMinValue);

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
  }

  void setNumberToMaxValue() {
    try {
      barrier.await();
    } catch (InterruptedException | BrokenBarrierException e) {
      throw new RuntimeException(e);
    }
    for (int i = 0; i < MAX; i++) {
//      try {
//        Thread.sleep(1);
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
      number = Long.MAX_VALUE;
    }
  }

  void setNumberToMinValue() {
    try {
      barrier.await();
    } catch (InterruptedException | BrokenBarrierException e) {
      throw new RuntimeException(e);
    }
    for (int i = 0; i < MAX; i++) {
//      try {
//        Thread.sleep(1);
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
      number = Long.MIN_VALUE;
    }
  }
}