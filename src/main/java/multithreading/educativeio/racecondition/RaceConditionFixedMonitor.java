package multithreading.educativeio.racecondition;

class RaceConditionFixedMonitor {

  public static final int MAX = 1000000;
  public int number = 0;

  public static void main(String[] args) throws InterruptedException {
    RaceConditionFixedMonitor.runTest();
  }

  public static void runTest() throws InterruptedException {
    final RaceConditionFixedMonitor rc = new RaceConditionFixedMonitor();
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
      synchronized (this) {
        number++;
      }
    }
  }

  void decrement() {
    for (int i = 0; i < MAX; i++) {
      synchronized (this) {
        number--;
      }
    }
  }
}