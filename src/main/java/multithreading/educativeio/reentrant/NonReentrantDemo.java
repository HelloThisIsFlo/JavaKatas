package multithreading.educativeio.reentrant;

public class NonReentrantDemo {

  public static void main(String[] args) throws Exception {
    NonReentrantLock lock = new NonReentrantLock();

    lock.lock();
    System.out.println("Trying to acquire the lock a first time");
    System.out.println("Acquired lock a first time");

    System.out.println("Trying to acquire the lock a second time");
    lock.lock();
    System.out.println("Acquired lock a second time"); // <- Will never happen! Deadlock
  }
}
