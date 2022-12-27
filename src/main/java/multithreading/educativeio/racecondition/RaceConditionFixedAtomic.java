package multithreading.educativeio.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

class RaceConditionFixedAtomic {

  public static final int MAX = 1000000;
  public AtomicInteger number = new AtomicInteger(0);

  public static void main(String[] args) throws InterruptedException {
    RaceConditionFixedAtomic.runTest();
  }

  public static void runTest() throws InterruptedException {
    final RaceConditionFixedAtomic rc = new RaceConditionFixedAtomic();
    Thread thread1 = new Thread(rc::increment);
    Thread thread2 = new Thread(rc::decrement);

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

    System.out.println("rc.number = " + rc.number);
  }

  void increment() {
    for (int i = 0; i < MAX; i++) {
      number.incrementAndGet();
    }
  }

  void decrement() {
    for (int i = 0; i < MAX; i++) {
      number.decrementAndGet();
    }
  }
}