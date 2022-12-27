package multithreading.educativeio.reentrant;

public class NonReentrantLock {

  boolean isLocked;

  public NonReentrantLock() {
    isLocked = false;
  }

  public synchronized void lock() throws InterruptedException {

    while (isLocked) {
      wait();
    }
    isLocked = true;
  }

}