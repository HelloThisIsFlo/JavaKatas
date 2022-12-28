package multithreading.leetcode.diningphilosophers;

import java.util.Arrays;

class DiningPhilosophers {

  public static final int NUM_OF_PHILOSOPHERS = 5;
  boolean[] forkIsAvailable;

  public DiningPhilosophers() {
    forkIsAvailable = new boolean[NUM_OF_PHILOSOPHERS];
    Arrays.fill(forkIsAvailable, true);
  }

  private void setLeft(int philosopher, boolean available) {
    forkIsAvailable[philosopher] = available;
    notifyAll();
  }

  private void setRight(int philosopher, boolean available) {
    forkIsAvailable[(philosopher + 1) % NUM_OF_PHILOSOPHERS] = available;
    notifyAll();
  }

  // call the run() method of any runnable to execute its code
  public synchronized void wantsToEat(
      int philosopher,
      Runnable pickLeftFork,
      Runnable pickRightFork,
      Runnable eat,
      Runnable putLeftFork,
      Runnable putRightFork) throws InterruptedException {
    if (philosopher != 0) {
      acquireLeftFork(philosopher, pickLeftFork);
      acquireRightFork(philosopher, pickRightFork);
    } else {
      acquireRightFork(philosopher, pickRightFork);
      acquireLeftFork(philosopher, pickLeftFork);
    }

    eat.run();

    putLeftFork.run();
    setLeft(philosopher, true);

    putRightFork.run();
    setRight(philosopher, true);
  }

  private void acquireLeftFork(int philosopher, Runnable pickLeftFork) throws InterruptedException {
    while (!leftIsAvailable(philosopher)) {
      wait();
    }
    pickLeftFork.run();
    setLeft(philosopher, false);
  }

  private void acquireRightFork(int philosopher, Runnable pickRightFork)
      throws InterruptedException {
    while (!rightIsAvailable(philosopher)) {
      wait();
    }
    pickRightFork.run();
    setRight(philosopher, false);
  }

  private boolean leftIsAvailable(int philosopher) {
    return forkIsAvailable[philosopher];
  }

  private boolean rightIsAvailable(int philosopher) {
    return forkIsAvailable[(philosopher + 1) % NUM_OF_PHILOSOPHERS];
  }

}