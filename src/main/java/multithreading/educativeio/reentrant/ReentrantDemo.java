package multithreading.educativeio.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo {

  public static void main(String[] args) {
    ReentrantLock lock = new ReentrantLock();

    lock.lock();
    System.out.println("Trying to acquire the lock a first time");
    System.out.println("Acquired lock a first time");

    System.out.println("Trying to acquire the lock a second time");
    lock.lock();
    System.out.println("Acquired lock a second time");
  }
}
