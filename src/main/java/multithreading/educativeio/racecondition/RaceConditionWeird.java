package multithreading.educativeio.racecondition;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@SuppressWarnings("ALL")
class RaceConditionWeird {

  //  public static final int MAX = 10_000;
//  public static final int MAX = Integer.MAX_VALUE;
  public long number = Long.MIN_VALUE;
  CyclicBarrier barrier = new CyclicBarrier(3);

  public static void main(String[] args) throws InterruptedException {
    System.out.println("""
        WARNING: This doesn't work, so it'll lock forever!
            
        It was supposed to demonstrate how setting a 'long' number is NOT an atomic operation, in theory
        doing so would set the first 32 bits and THEN the second 32 bits.
        So there is a small time where the number isn't at all what we expect
            
            
        """);
    RaceConditionWeird raceConditionWeird = new RaceConditionWeird();

    raceConditionWeird.runDemo();
//    boolean weirdScenarioHasNOTOcurred = true;
//    while (weirdScenarioHasNOTOcurred) {
//      raceConditionWeird.runTest();
//      weirdScenarioHasNOTOcurred = (raceConditionWeird.number == Long.MIN_VALUE
//                                    || raceConditionWeird.number == Long.MAX_VALUE);
//    }
//    System.out.println(raceConditionWeird.number);
  }

  public void runDemo() throws InterruptedException {
    Thread thread1 = new Thread(this::setNumberToMaxValue);
    Thread thread2 = new Thread(this::setNumberToMinValue);
    Thread thread3 = new Thread(this::keepReadingUntilValueIsntWhatWeExpect);

    thread1.setDaemon(true);
    thread2.setDaemon(true);
    thread1.start();
    thread2.start();
    thread3.start();

    thread3.join();
  }

  void setNumberToMaxValue() {
    waitForBarrier();
    while (true) {
      Thread.yield();
      number = Long.MAX_VALUE;
    }
  }

  void setNumberToMinValue() {
    waitForBarrier();
    while (true) {
      Thread.yield();
      number = Long.MIN_VALUE;
    }
  }

  private void keepReadingUntilValueIsntWhatWeExpect() {
    waitForBarrier();
    long yo;
//    while (yo := number == Long.MIN_VALUE || number == Long.MAX_VALUE) {
    while ((yo = number) == Long.MIN_VALUE || yo == Long.MAX_VALUE) {
      //noinspection BusyWait
      Thread.yield();
    }
    System.out.println("WOOOOOOOHOOOOOOOOO We found the BUG !!!");
    System.out.println("Long.MIN_VALUE = " + Long.MIN_VALUE);
    System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
    System.out.println("number = " + yo);

  }

  private void waitForBarrier() {
    try {
      barrier.await();
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }
    System.out.println("Barrier unlocked! Starting now!");
  }
}