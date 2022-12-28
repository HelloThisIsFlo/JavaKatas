package multithreading.leetcode.fizzbuzz;

public class RunMultithreadedFizzBuzz {

  public static void main(String[] args) throws Exception{
    FizzBuzz fizzBuzz = new FizzBuzz(15);
    Thread threadA = new Thread(() -> {
      try {
        fizzBuzz.fizz(() -> System.out.println("fizz"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    threadA.setName("Thread A");

    Thread threadB = new Thread(() -> {
      try {
        fizzBuzz.buzz(() -> System.out.println("buzz"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    threadB.setName("Thread B");

    Thread threadC = new Thread(() -> {
      try {
        fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    threadC.setName("Thread C");

    Thread threadD = new Thread(() -> {
      try {
        fizzBuzz.number(i -> System.out.println(i));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    threadD.setName("Thread D");

    threadA.start();
    threadB.start();
    threadC.start();
    threadD.start();

    threadA.join();
    threadB.join();
    threadC.join();
    threadD.join();

    System.out.println("end");
  }
}
