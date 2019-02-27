package misc.threads;

/**
 * Is this class thread safe?
 * Does this class do what it states to do when used by multiple threads?
 * Is it possible for the fields a and b to have a different value?
 *
 * @author Michael Liu
 */
public class NoThreadSafeValuePair
{

  private int a;
  private int b;

  public synchronized void copy(final NoThreadSafeValuePair other) {
    this.a = other.a;
    this.b = other.b;
  }

  public synchronized void setValue(final int value) {
    this.a = value;
    this.b = value;
  }

  @Override
  public synchronized String toString() {
    return String.format("a: %d and b: %d", a, b);
  }

  public static void main(final String[] args) throws InterruptedException {
    final NoThreadSafeValuePair object1 = new NoThreadSafeValuePair();
    object1.setValue(1);

    final NoThreadSafeValuePair object2 = new NoThreadSafeValuePair();
    object2.setValue(5);

    final Thread thread1 = new Thread("Thread 1") {
      @Override
      public void run() {
        object1.copy(object2);
      }
    };

    final Thread thread2 = new Thread("Thread 2") {
      @Override
      public void run() {
        object2.setValue(12);
      }
    };

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

    System.out.println(object1);
  }
}