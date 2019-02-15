package gc.memoryleak;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Michael Liu
 */
public class StringIntern
{
  @Test
  public void givenLengthString_whenIntern_thenOutOfMemory()
      throws IOException, InterruptedException {
    Thread.sleep(15000);

    String str
        = new Scanner(new File("src/test/resources/large.txt"), "UTF-8")
        .useDelimiter("\\A").next();
    str.intern();

    System.gc();
    Thread.sleep(15000);
  }
}
