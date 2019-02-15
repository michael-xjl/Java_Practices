package gc.memoryleak;

/**
 * https://stackoverflow.com/questions/10864853/when-exactly-is-it-leak-safe-to-use-anonymous-inner-classes
 * @author Michael Liu
 */
public class InnerOuterClass
{   public LeakFactory.Leak[] myHoles;

  public InnerOuterClass()
  {//Gotta have a Factory to make my holes
    LeakFactory _holeDriller = new LeakFactory();
    // Now, let's get the holes and store them.
    myHoles = new LeakFactory.Leak[1000];

    for (int i = 0;  i<1000 ; i++)
    {//Store them in the class member
      myHoles[i] = _holeDriller.createLeak();
    }

    // Yay! We're done!

    // Buh-bye LeakFactory. I don't need you anymore...
  }
}
