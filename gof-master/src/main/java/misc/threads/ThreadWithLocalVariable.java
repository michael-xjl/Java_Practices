package misc.threads;

/**
 *
 * User{username='u1'} in Thread: Thread[read_thread,5,main]
 * User{username='u1'} in Thread: Thread[update_thread,5,main]
 * User{username='u1'} in Thread: Thread[read_thread,5,main]
 * User{username='new u1'} in Thread: Thread[update_thread,5,main]
 * User{username='new u1'} in Thread: Thread[read_thread,5,main]
 * User{username='new u1'} in Thread: Thread[update_thread,5,main]
 * User{username='new u1'} in Thread: Thread[read_thread,5,main]
 * User{username='new u1'} in Thread: Thread[update_thread,5,main]
 * User{username='new u1'} in Thread: Thread[read_thread,5,main]
 * User{username='new u1'} in Thread: Thread[update_thread,5,main]
 *
 * @author Michael Liu
 */
public class ThreadWithLocalVariable
{
  public static void main(String[] args)
  {
    RunnableWithLocalVariable tr =  new RunnableWithLocalVariable("u1");
    new Thread(tr, "read_thread").start();
    new Thread(tr,"update_thread").start();
  }
}
class User
{
  String username;

  public User(String username)
  {
    this.username = username;
  }

  @Override public String toString()
  {
    return "User{" +
        "username='" + username + '\'' +
        '}';
  }
}
class RunnableWithLocalVariable implements Runnable
{

  private  User user;

  @Override public void run()
  {
    while(true)
    {
      try
      {
        System.out.println(user + " in Thread: " + Thread.currentThread());

        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      if(Thread.currentThread().getName().equalsIgnoreCase("update_thread"))
      {
        user = new User("new u1");
      }
    }
  }

  public RunnableWithLocalVariable(String userName)
  {

    this.user = new User(userName);
  }
}
