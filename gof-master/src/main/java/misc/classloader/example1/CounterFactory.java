package misc.classloader.example1;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Michael Liu
 */
public class CounterFactory {
  public static ICounter newInstance()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException
  {

    final URL resource = CounterFactory.class.getResource("../../../");
//    try (URLClassLoader tmp = new URLClassLoader(new URL[] { resource },null)
    try (URLClassLoader tmp = new URLClassLoader(new URL[] { resource })
    {
      public Class loadClass(String name) throws ClassNotFoundException
      {
        if ("misc.classloader.example1.Counter".equals(name))
          return findClass(name);
        return super.loadClass(name);
      }
    })
    {

      return (ICounter) tmp.loadClass("misc.classloader.example1.Counter").newInstance();
    }
  }
}