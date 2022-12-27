package multithreading.educativeio;

public class InterruptShowcase {

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
