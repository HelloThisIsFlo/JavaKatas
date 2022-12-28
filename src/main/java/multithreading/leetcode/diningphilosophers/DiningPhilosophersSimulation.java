package multithreading.leetcode.diningphilosophers;

public class DiningPhilosophersSimulation {
    public static void main(String[] args) {
        DiningPhilosophers philosophers = new DiningPhilosophers();
        int numPhilosophers = 5;

        for (int i = 0; i < numPhilosophers; i++) {
            final int philosopherId = i;
            new Thread(() -> {
                try {
                    philosophers.wantsToEat(philosopherId,
                        () -> System.out.println("Philosopher " + philosopherId + " picked up left fork"),
                        () -> System.out.println("Philosopher " + philosopherId + " picked up right fork"),
                        () -> System.out.println("Philosopher " + philosopherId + " is eating"),
                        () -> System.out.println("Philosopher " + philosopherId + " put down left fork"),
                        () -> System.out.println("Philosopher " + philosopherId + " put down right fork")
                    );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("Stop just the thread");
        System.out.println("Stop everything");
    }
}
