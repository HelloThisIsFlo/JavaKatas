package multithreading.educativeio.missedsignals;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class MissedSignalExample {

  public static void main(String args[]) throws InterruptedException {

    final ReentrantLock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    Thread signaller = new Thread(() -> {
      lock.lock();
      condition.signal();
      System.out.println("Sent signal");
      lock.unlock();
    });

    Thread waiter = new Thread(() -> {
      lock.lock();

      try {
        condition.await();
        System.out.println("Received signal");
      } catch (InterruptedException ie) {
        // handle interruption
      }

      lock.unlock();
    });

    System.out.println(
         """
         In this code, the waiter thread waits indefinitely because it is waiting for a signal
         that is never sent. The signaller thread sends the signal before the waiter thread
         starts waiting, so the waiter thread never receives the signal. As a result, the waiter
         thread remains in the await state indefinitely.
         """
    );

    signaller.start();
    signaller.join();

    waiter.start();
    waiter.join();

    System.out.println("Program Exiting.");
  }
}

