package multithreading.educativeio.semaphore;

import java.util.concurrent.Semaphore;

class CorrectSemaphoreExample {

  public static void main(String args[]) throws InterruptedException {

    final Semaphore semaphore = new Semaphore(1);

    Thread badThread = new Thread(() -> {
      while (true) {

        try {
          semaphore.acquire();
          try {
            throw new RuntimeException("");
          } catch (Exception e) {
            // handle any program logic exception and exit the function
            return;
          } finally {
            System.out.println("Bad thread releasing semaphore.");
            semaphore.release();
          }

        } catch (InterruptedException ie) {
          // handle thread interruption
        }
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
