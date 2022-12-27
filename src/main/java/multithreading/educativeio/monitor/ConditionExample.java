package multithreading.educativeio.monitor;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import multithreading.educativeio.RunnableWithException;

@SuppressWarnings("ALL")
public class ConditionExample {

  int threadIdx = 1;

  public static void main(String[] args) throws Exception {
    startThreadToShowTheTimePassing();

//    new ConditionExample().usingConditionFromLock();

    new ConditionExample().usingConditionFromMonitor();
  }

  private static void startThreadToShowTheTimePassing() {
    Thread showTimePassing = new Thread(() -> {
      while (true) {
        try {
          //noinspection BusyWait
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println(".");
      }
    });
    showTimePassing.setDaemon(true);
    showTimePassing.start();
  }

  public void usingConditionFromMonitor() throws Exception {
    System.out.println("----------- START - Monitor -----------");

    Thread waitUntilReady1 = startThread(() -> waitUntilReady(this));
    Thread waitUntilReady2 = startThread(() -> waitUntilReady(this));
    Thread waitUntilReady3 = startThread(() -> waitUntilReady(this));
    Thread waitUntilReady4 = startThread(() -> waitUntilReady(this));
    Thread waitUntilReady5 = startThread(() -> waitUntilReady(this));
    Thread waitUntilReady6 = startThread(() -> waitUntilReady(this));

    Thread signalAfterWait = startThread(() -> {
      sleep(2);
      log("I will now notify()");
      synchronized (this) {
        notify();
      }

      sleep(2);
      log("I will now notify()");
      synchronized (this) {
        notify();
      }

      sleep(2);
      log("I will now notifyAll()");
      synchronized (this) {
        notifyAll();
      }
    });

    waitUntilReady1.join();
    waitUntilReady2.join();
    waitUntilReady3.join();
    waitUntilReady4.join();
    waitUntilReady5.join();
    waitUntilReady6.join();
    signalAfterWait.join();
    System.out.println("----------- END -------------");
  }

  private Thread startThread(RunnableWithException runnable) throws Exception {
    Thread thread = new Thread(() -> {
      try {
        runnable.run();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    });
    thread.setName("Thread " + threadIdx++);
    thread.start();
    Thread.sleep(100); // Sleep a bit so Threads start in order
    return thread;
  }

  private void waitUntilReady(Object monitor) throws InterruptedException {
    log("I'm waiting until ready");
    //noinspection SynchronizationOnLocalVariableOrMethodParameter
    synchronized (monitor) {
      monitor.wait();
    }
    log("I am now READY \uD83D\uDE03");
  }

  private void log(String toLog) {
    System.out.println(Thread.currentThread().getName() + " | " + toLog);
  }

  private void sleep(int seconds) {
    log("I'm going to sleep for " + seconds + " sec");
    try {
      Thread.sleep(seconds * 1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    log("Finished sleeping");
  }

  public void usingConditionFromLock() throws Exception {
    System.out.println("----------- START - Lock -----------");

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    Thread waitUntilReady = startThread(() -> {
      log("I'm waiting until ready");
      lock.lock();
      condition.await();
      lock.unlock();
      log("I am now READY \uD83D\uDE03");
    });

    Thread signalAfterWait = startThread(() -> {
      log("I'm going to sleep for 4 sec");
      sleep(4000);
      log("Finished sleeping, I will notify now");
      lock.lock();
      condition.signal();
      lock.unlock();
    });

    waitUntilReady.join();
    signalAfterWait.join();
    System.out.println("----------- END -------------");
  }

}
