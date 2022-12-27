package multithreading.educativeio.spuriouswakeup;

class SpuriousWakeupExample {

  public static void main(String[] args) throws InterruptedException {
    System.out.println("""
        In this example, the t1 thread waits on the lock object until the condition is set to
        true. The t2 thread sets the condition and notifies the t1 thread to continue execution.
        However, if a spurious wakeup occurs, the t1 thread will check the condition before
        continuing execution and will not proceed until the condition is actually met. This
        ensures that the t1 thread only continues execution when the condition has been properly
        set.
        """);
    final Object lock = new Object();
    final boolean[] condition = new boolean[1];

    Thread t1 = new Thread(() -> {
      synchronized (lock) {
        while (!condition[0]) {
          try {
            lock.wait();
          } catch (InterruptedException ie) {
            // handle interruption
          }
        }

        // perform some action
      }
    });

    Thread t2 = new Thread(() -> {
      synchronized (lock) {
        // set the condition
        condition[0] = true;
        lock.notifyAll();
      }
    });

    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }
}
