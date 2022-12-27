package multithreading.educativeio.semaphore;

import java.util.concurrent.Semaphore;

public class IncorrectSemaphoreExample {

  public static void main(String[] args) throws InterruptedException {
    final Semaphore semaphore = new Semaphore(1);

    Thread badThread = new Thread(() -> {
      while (true) {
        try {
          semaphore.acquire();
        } catch (InterruptedException ie) {
          // handle thread interruption
        }

        // Thread was meant to run forever but runs into an
        // exception that causes the thread to crash.
        if (true) {
          throw new RuntimeException("exception happens at runtime.");
        }

        // The following line to signal the semaphore is never reached
         semaphore.release();
      }
    });
    final Thread goodThread = new Thread(() -> {
      System.out.println("Good thread patiently waiting to be signalled.");
      try {
        semaphore.acquire();
      } catch (InterruptedException ie) {
        // handle thread interruption
      }
    });


    badThread.start();
    goodThread.start();
    badThread.join();
    goodThread.join();
    System.out.println("Exiting Program");
  }
}