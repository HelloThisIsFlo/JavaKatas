package multithreading.educativeio;

public class ThreadSandbox {


    long counter = 0;

    public void sum(long start, long end) {
        for (long i = start; i < end; i++) {
            counter += i;
        }
    }

    public static void main(String[] args) throws Exception {
        new ThreadSandbox().runSandbox();
    }


    public void runSandbox() throws Exception {
        benchmark("multi", ThreadSandbox::multiThreaded);
        benchmark("multi", ThreadSandbox::multiThreaded);
        benchmark("multi", ThreadSandbox::multiThreaded);
        benchmark("multi", ThreadSandbox::multiThreaded);
        benchmark("single", ThreadSandbox::singleThreaded);
        benchmark("single", ThreadSandbox::singleThreaded);
        benchmark("single", ThreadSandbox::singleThreaded);


    }

    private static void multiThreaded() throws Exception{
        ThreadSandbox sum1stHalf = new ThreadSandbox();
        ThreadSandbox sum2ndHalf = new ThreadSandbox();

        Thread thread1 = new Thread(() -> {
            sum1stHalf.sum(0, Integer.MAX_VALUE / 2);
        });
        Thread thread2 = new Thread(() -> {
            sum2ndHalf.sum(Integer.MAX_VALUE / 2, Integer.MAX_VALUE);
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        double result = sum1stHalf.counter + sum2ndHalf.counter;
    }

    private static void singleThreaded() throws Exception {
        ThreadSandbox sumComplete = new ThreadSandbox();
        Thread thread = new Thread(() -> {

            sumComplete.sum(0, Integer.MAX_VALUE);
        });
        thread.start();
        thread.join();
        double result = sumComplete.counter;
    }

    private void benchmark(String tag, RunnableWithException runnable) throws Exception {
        long start = System.nanoTime() / 1_000_000;
        runnable.run();
        long end = System.nanoTime() / 1_000_000;
        System.out.println(tag);
        System.out.println("Time taken: " + (end - start));
    }
}
