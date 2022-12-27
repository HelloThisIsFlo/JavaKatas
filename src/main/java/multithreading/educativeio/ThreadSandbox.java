package multithreading.educativeio;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadSandbox {


  long counter = 0;
  ExecutorService executorService;

  public static void main(String[] args) throws Exception {
    new ThreadSandbox().runSandbox();
  }

  public void runSandbox() throws Exception {
    executorService = Executors.newFixedThreadPool(20);

    benchmark("multi", this::multiThreaded);
    benchmark("multi", this::multiThreaded);
    benchmark("multi", this::multiThreaded);
    benchmark("multi", this::multiThreaded);
    benchmark("single", this::singleThreaded);
    benchmark("single", this::singleThreaded);
    benchmark("single", this::singleThreaded);


    executorService.shutdown();
  }

  private void benchmark(String tag, RunnableWithException runnable) throws Exception {
    long start = System.nanoTime() / 1_000_000;
    runnable.run();
    long end = System.nanoTime() / 1_000_000;
    System.out.println(tag);
    System.out.println("Time taken: " + (end - start));
  }

  private void multiThreaded() throws Exception {
    ThreadSandbox sum1stHalf = new ThreadSandbox();
    ThreadSandbox sum2ndHalf = new ThreadSandbox();

    Future<String> firstHalfDone =
        executorService.submit(() -> sum1stHalf.sum(0, Integer.MAX_VALUE / 2), "Done");
    Future<String> secondHalfDone = executorService.submit(
        () -> sum2ndHalf.sum(Integer.MAX_VALUE / 2, Integer.MAX_VALUE),
        "Done"
    );
    firstHalfDone.get();
    secondHalfDone.get();
  }

  private void singleThreaded() throws Exception {
    ThreadSandbox sumComplete = new ThreadSandbox();
    Future<String> done =
        executorService.submit(() -> sumComplete.sum(0, Integer.MAX_VALUE), "done");
    done.get();
  }

  public void sum(long start, long end) {
    for (long i = start; i < end; i++) {
      counter += i;
    }
  }
}
