package multithreading.educativeio.interviewpractice;

public class BlockingQueue<T> {
  record Hello(int a){};

  T[] items;
  int capacity;
  int head = 0;
  int tail = 0;

  public BlockingQueue(int capacity) {
    this.items = (T[]) new Object[capacity];
    this.capacity = capacity;
  }

  public synchronized void enqueue(T item) throws InterruptedException {
    /*
    - Blocking queue blocks caller of enqueue method when no more capacity
    - Notifies blocked enqueuing thread when space available
     */

    while (full()) { // Not using 'if' to prevent against Spurious Wakeup
      wait();
    }
    items[++tail % capacity] = item;
    notify();
  }

  public boolean full() {
    return size() == capacity;
  }

  public int size() {
    return tail - head;
  }

  public synchronized T dequeue() throws InterruptedException {
    /*
    - Blocking queue blocks caller of dequeue method when no items in queue
    - Notifies blocked dequeuing thread when item available in queue
     */
    while (empty()) {
      wait();
    }
    T res = items[head++ % capacity];
    notify();
    return res;
  }

  public boolean empty() {
    return size() == 0;
  }


}

