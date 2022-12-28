package multithreading.leetcode.fizzbuzz;

import java.util.function.IntConsumer;

public class FizzBuzz {

  volatile boolean nextIsFizz = false;
  volatile boolean nextIsBuzz = false;
  volatile boolean nextIsFizzBuzz = false;
  volatile boolean nextIsNumber = true;

  volatile private int n;
  volatile private int i;

  public FizzBuzz(int n) {
    this.n = n;
    this.i = 1;
  }

  // printFizz.run() outputs "fizz".
  public synchronized void fizz(Runnable printFizz) throws InterruptedException {
    while (i <= n) {
      while (!nextIsFizz) {
        wait();
        if (i > n) return;
      }
      printFizz.run();
      increment();
    }
  }

  private void increment() {
    // don't need to be synchronized, although wouldn't hurt
    // ... would it?
    i++;
    nextIsFizzBuzz = i % 15 == 0;
    nextIsFizz = !nextIsFizzBuzz && i % 3 == 0;
    nextIsBuzz = !nextIsFizzBuzz && i % 5 == 0;
    nextIsNumber = !nextIsFizzBuzz && !nextIsFizz && !nextIsBuzz;
    notifyAll();
  }

  private void log(String method) {
    System.out.println(Thread.currentThread().getName() + " | " + method);
  }

  // printBuzz.run() outputs "buzz".
  public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
    while (i <= n) {
      while (!nextIsBuzz) {
        wait();
        if (i > n) return;
      }
      printBuzz.run();
      increment();
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    while (i <= n) {
      while (!nextIsFizzBuzz) {
        wait();
        if (i > n) return;
      }
      printFizzBuzz.run();
      increment();
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public synchronized void number(IntConsumer printNumber) throws InterruptedException {
    while (i <= n) {
      while (!nextIsNumber) {
        wait();
        if (i > n) return;
      }
      printNumber.accept(i);
      increment();
    }
  }
}