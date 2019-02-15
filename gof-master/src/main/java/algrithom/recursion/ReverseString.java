package algrithom.recursion;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Michael Liu
 */

public class ReverseString
{

  @Test
  public void reverse()
  {
    assertEquals(reverseStringRecursion("abcd"),"dcba");
    assertEquals(reverseStringRecursion(""),"");

    System.out.println("");
    char[] s = {'a','b','c','d','e'};
    reverseCharArraysIterator(s);
    assertArrayEquals(s,new char[]{'e','d','c','b','a'});
  }

  public String reverseStringRecursion(String s)
  {
    if(s.length() == 0)
      return "";

    String revStr = s.substring(0,1);

    if(s.length() > 1)
      revStr = reverseStringRecursion(s.substring(1)) + revStr ;

    System.out.print(revStr);


    return revStr;
  }

  public void noReverseString(String s)
  {
    System.out.print(s.substring(0,1));
    if(s.length() > 1)
    {
      reverseStringRecursion(s.substring(1));
    }



  }
  public void reverseCharArraysIterator(char[] s)
  {
    for(int j = s.length; j >1; j--)
    {
      swap(j,s);
    }
  }

  public void  swap(int end, char[] s)
  {
    if(end < 2)
      return;

    char tmp = s[0];
    for(int i = 0;i < end-1; i ++)
    {
      s[i] = s[i+1];
    }
    s[end-1] = tmp;
  }
}
