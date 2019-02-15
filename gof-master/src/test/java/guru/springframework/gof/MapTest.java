package guru.springframework.gof;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Michael Liu
 */
public class MapTest
{
  public static void main(String[] args)
  {
    Map m = new HashMap();

    Key k1 = new Key(1, "this is one");
    Key k2 = new Key(2, "this is two 1");
    Key k22= new Key(2, "this is two 2");
    Key k3= new Key(3, "this is threee ");

    m.put(k1,"11");
    m.put(k2,"221");
    m.put(k22,"222"); //hash collision happened here, will store the linkedList in the bulkek, after java8, when the count of collisiion values is more than threldhold, then use tree to store

    m.put(k3,"333");


  }

  @Test
  public void testHashCollision()
  {
    Map m = new HashMap();

    Key k1 = new Key(1, "this is one");
    Key k2 = new Key(2, "this is two 1");
    Key k22= new Key(2, "this is two 2");
    Key k3= new Key(3, "this is threee ");

    m.put(k1,"11");
    m.put(k2,"221");
    m.put(k22,"222"); //hash collision happened here, will store the linkedList in the bulkek, after java8, when the count of collisiion values is more than threldhold, then use tree to store

    m.put(k3,"333");

    assertFalse(m.containsKey(new Key(2, "this is two 1000") ));
    assertTrue(m.containsKey(new Key(2, "this is two 2") ));
  }

}

class Key
{
  private Integer id;
  private String name;

  public Key(Integer id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;

    if (o == null || getClass() != o.getClass())
      return false;

    Key key = (Key) o;

    return new org.apache.commons.lang3.builder.EqualsBuilder()
        .append(id, key.id)
        .append(name, key.name)
        .isEquals();
  }

  @Override public int hashCode()
  {
    if ( id == 2)
    {
      return 2;
    }
    else
    {
      return new HashCodeBuilder(17, 37)
          .append(id)
          .append(name)
          .toHashCode();
    }
  }
}
