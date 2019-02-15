package gc.memoryleak;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author Michael Liu
 */
public class HashSetNoEquals
{
  class Key {
    public String key;

    public Key(String key) {
      this.key = key;
    }
  }

  public static void main(String[] args) throws IOException, URISyntaxException
  {
    new HashSetNoEquals().givenMap_whenNoEqualsNoHashCodeMethods_thenOutOfMemory();
  }

  public void givenMap_whenNoEqualsNoHashCodeMethods_thenOutOfMemory()
      throws IOException, URISyntaxException
  {
    Map<Object, Object> map = System.getProperties();
    while (true) {
      map.put(new Key("key"), "value");
    }
  }
}
