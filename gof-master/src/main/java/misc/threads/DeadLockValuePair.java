package misc.threads;

/**
 * Is this class thread safe?
 * Does this class do what it states to do when used by multiple threads?
 * Is it possible for the fields a and b to have a different value?
 *
 * @author Michael Liu
 */
public class DeadLockValuePair
{

  private int a;
  private int b;

  /** caused dead lock ***/
  public synchronized void copy(final DeadLockValuePair other) {
    synchronized (other) {
      this.a = other.a;
      this.b = other.b;
    }
  }

  /**** solution avoid dead lock*************/
  public void copy2(final DeadLockValuePair other) {
    final int a, b;
    synchronized (other) {
      a = other.a;
      b = other.b;
    }

    synchronized (this) {
      this.a = a;
      this.b = b;
    }
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
    final DeadLockValuePair object1 = new DeadLockValuePair();
    object1.setValue(1);

    final DeadLockValuePair object2 = new DeadLockValuePair();
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
        object2.copy(object1);
      }
    };

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

    System.out.println(object1);
  }
}