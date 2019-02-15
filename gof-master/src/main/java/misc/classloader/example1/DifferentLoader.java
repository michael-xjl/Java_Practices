package misc.classloader.example1;

import java.io.IOException;

/**
 * out:
 * [Loaded java.net.Proxy from C:\dev\software\zulu8.21.0.1-jdk8.0.131-win_x64\jre\lib\rt.jar]
 * [Loaded java.net.Proxy$Type from C:\dev\software\zulu8.21.0.1-jdk8.0.131-win_x64\jre\lib\rt.jar]
 * [Loaded java.util.WeakHashMap$HashIterator from C:\dev\software\zulu8.21.0.1-jdk8.0.131-win_x64\jre\lib\rt.jar]
 * [Loaded java.util.WeakHashMap$KeyIterator from C:\dev\software\zulu8.21.0.1-jdk8.0.131-win_x64\jre\lib\rt.jar]
 * [Loaded sun.net.NetHooks from C:\dev\software\zulu8.21.0.1-jdk8.0.131-win_x64\jre\lib\rt.jar]
 * [Loaded java.net.Inet6Address$Inet6AddressHolder from C:\dev\software\zulu8.21.0.1-jdk8.0.131-win_x64\jre\lib\rt.jar]
 * [Loaded misc.classloader.Counter from file:/C:/dev/work/trunk2/Scratches/Java_Practices/gof-master/target/classes/]
 * [Loaded java.net.Socket$2 from C:\dev\software\zulu8.21.0.1-jdk8.0.131-win_x64\jre\lib\rt.jar]
 * [Loaded java.net.SocketInputStream from C:\dev\software\zulu8.21.0.1-jdk8.0.131-win_x64\jre\lib\rt.jar]
 * 1) Version 1 = 0
 * 2) Version 1 = 0
 *
 * [Loaded sun.nio.cs.US_ASCII$Decoder from C:\dev\software\zulu8.21.0.1-jdk8.0.131-win_x64\jre\lib\rt.jar]
 * [Loaded misc.classloader.Counter from file:/C:/dev/work/trunk2/Scratches/Java_Practices/gof-master/target/classes/]
 * 1) Version 1 = 1
 * 2) Version 1 = 0
 *
 * [Loaded misc.classloader.Counter from file:/C:/dev/work/trunk2/Scratches/Java_Practices/gof-master/target/classes/]
 * 1) Version 1 = 2
 * 2) Version 1 = 0
 *
 * [Loaded misc.classloader.Counter from file:/C:/dev/work/trunk2/Scratches/Java_Practices/gof-master/target/classes/]
 * 1) Version 1 = 3
 * 2) Version 1 = 0
 *
 * [Loaded misc.classloader.Counter from file:/C:/dev/work/trunk2/Scratches/Java_Practices/gof-master/target/classes/]
 * 1) Version 1 = 4
 * 2) Version 1 = 0
 *
 * [Loaded misc.classloader.Counter from file:/C:/dev/work/trunk2/Scratches/Java_Practices/gof-master/target/classes/]
 * 1) Version 1 = 5
 * 2) Version 1 = 0
 *
 * [Loaded misc.classloader.Counter from file:/C:/dev/work/trunk2/Scratches/Java_Practices/gof-master/target/classes/]
 * 1) Version 1 = 6
 * 2) Version 1 = 0
 *
 * [Loaded misc.classloader.Counter from file:/C:/dev/work/trunk2/Scratches/Java_Practices/gof-master/target/classes/]
 * 1) Version 1 = 7
 * 2) Version 1 = 0
 * @author Michael Liu
 */
public class DifferentLoader
{
  private static ICounter counter1;
  private static ICounter counter2;

  public static void main(String[] args)
      throws IllegalAccessException, InstantiationException, ClassNotFoundException, InterruptedException, IOException
  {
    counter1 = CounterFactory.newInstance();

    counter2 = CounterFactory.newInstance();

    //will throw ClasCastException , as counter1&2 are from different classloader
    //try (URLClassLoader tmp = new URLClassLoader(new URL[] { resource },null)
    //try (URLClassLoader tmp = new URLClassLoader(new URL[] { resource }), will be ok, it share same classloader
   // ((ICounter)counter2).message();


    while (true)
    {

      System.out.println("1) " +
          counter1.message() + " = " + counter1.plusPlus());
      System.out.println("2) " +
          counter2.message() + " = " + (counter2.plusPlus()  + counter2.plusPlus()));
      System.out.println();

      Thread.currentThread().sleep(3000);
    }
  }
}
