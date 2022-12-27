package multithreading.educativeio;

import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.units.qual.A;

public class InterruptShowcase {

  volatile int asdf = 0;
  volatile List<Integer> asdfasdf = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    Thread thread = new Thread(() -> {
      System.out.println("I am a Thread. I am sleeping forever (almost)");
      try {
        Thread.sleep(Integer.MAX_VALUE);
      } catch (InterruptedException e) {
        System.out.println("I was interrupted!");
        System.out.println("Shutting down gracefully \uD83D\uDE0A ");
        waitSmallDelayAndPrintDot();
        waitSmallDelayAndPrintDot();
        waitSmallDelayAndPrintDot();
        System.out.print("Done");
      }
    });

    thread.start();
    System.out.println("Press ENTER to shutdown gracefully");
    //noinspection ResultOfMethodCallIgnored
    System.in.read();
    thread.interrupt();
  }

  public static void waitSmallDelayAndPrintDot() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.print(".");
  }
}
