package datastructure.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Michael Liu
 */
public class Brackets
{

  public static void main(String[] args)
  {
    System.out.println(isBalanced("{[()()]}"));
  }
  // Complete the isBalanced function below.
  static String isBalanced(String s) {
    String openBrackets  = "{[(";
    String closeBrackets = "}])";
    Stack<Character> bq = new Stack<>();

    char[] brackets = s.toCharArray();
    for(char b : brackets)
    {
      if(openBrackets.indexOf(String.valueOf(b)) > -1)
        bq.add(b);
      else
      {
        int index = closeBrackets.indexOf(String.valueOf(b));
        if(index < 0 )
        {
          return "NO";

        }
        Character lastB = bq.pop();
        if(lastB == null || openBrackets.charAt(index) != lastB )
        {
          return "NO";
        }
      }
    }


    return bq.isEmpty()? "YES":"NO";


  }
}
