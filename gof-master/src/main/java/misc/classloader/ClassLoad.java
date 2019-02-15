package misc.classloader;

import java.net.URLClassLoader;
import java.util.Arrays;

/**
 * @author Michael Liu
 */
public class ClassLoad
{

  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException
  {
    System.out.println(new ClassLoad().getClass().getClassLoader());
    System.out.println(new ClassLoad().getClass().getClassLoader().getParent());
    System.out.println(new ClassLoad().getClass().getClassLoader().getParent().getParent());
    final LoadA loadA = new LoadA();
    loadA.test();
    System.out.println(System.identityHashCode(loadA));

    final Class<?> loadAClass = new ClassLoad().getClass().getClassLoader().loadClass("misc.classloader.LoadA");

    LoadA loadAInst = (LoadA)loadAClass.newInstance();
    loadAInst.test();
    System.out.println(System.identityHashCode(loadAInst));

    System.out.println(Arrays.toString(((URLClassLoader)ClassLoad.class.getClassLoader()).getURLs()));

  }


}

class LoadA
{

  int val = 1;

  public void test()
  {
    System.out.println("Test.....");
  }

  @Override public int hashCode()
  {
    return val;
  }

  @Override public String toString()
  {
    return super.toString();
  }
}
