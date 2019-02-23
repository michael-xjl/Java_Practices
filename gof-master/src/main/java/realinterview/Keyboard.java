package realinterview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Michael Liu
 */
public class Keyboard
{
  final static public String shiftStr = "1234567890qwertyuiopasdfghjkl;zxcvbnm,./";

  final static public int shiftLength = shiftStr.length();

  final static Map<Character, Character> hMap = new HashMap<>();

  static
  {
    hMap.put('1', '0');
    hMap.put('2', '9');
    hMap.put('3', '8');
    hMap.put('4', '7');
    hMap.put('5', '6');
    hMap.put('0', '1');
    hMap.put('9', '2');
    hMap.put('8', '3');
    hMap.put('7', '4');
    hMap.put('6', '5');

    hMap.put('q', 'p');
    hMap.put('w', 'o');
    hMap.put('e', 'i');
    hMap.put('r', 'u');
    hMap.put('t', 'y');
    hMap.put('p', 'q');
    hMap.put('o', 'w');
    hMap.put('i', 'e');
    hMap.put('u', 'r');
    hMap.put('y', 't');

    hMap.put('a', ';');
    hMap.put('s', 'l');
    hMap.put('d', 'k');
    hMap.put('f', 'j');
    hMap.put('g', 'h');
    hMap.put('h', 'g');
    hMap.put('j', 'f');
    hMap.put('k', 'd');
    hMap.put('l', 's');
    hMap.put(';', 'a');

    hMap.put('z', '/');
    hMap.put('x', '.');
    hMap.put('c', ',');
    hMap.put('v', 'm');
    hMap.put('b', 'n');
    hMap.put('n', 'b');
    hMap.put('m', 'v');
    hMap.put(',', 'c');
    hMap.put('.', 'x');
    hMap.put('/', 'z');

  }

  static final Map<Character, Character> vMap = new HashMap<>();

  static
  {
    vMap.put('1', 'z');
    vMap.put('2', 'x');
    vMap.put('3', 'c');
    vMap.put('4', 'v');
    vMap.put('5', 'b');
    vMap.put('6', 'n');
    vMap.put('7', 'm');
    vMap.put('8', ',');
    vMap.put('9', '.');
    vMap.put('0', '/');

    vMap.put('z', '1');
    vMap.put('x', '2');
    vMap.put('c', '3');
    vMap.put('v', '4');
    vMap.put('b', '5');
    vMap.put('n', '6');
    vMap.put('m', '7');
    vMap.put(',', '8');
    vMap.put('.', '9');
    vMap.put('/', '0');

    vMap.put('q', 'a');
    vMap.put('w', 's');
    vMap.put('e', 'd');
    vMap.put('r', 'f');
    vMap.put('t', 'g');
    vMap.put('y', 'h');
    vMap.put('u', 'j');
    vMap.put('i', 'k');
    vMap.put('o', 'l');
    vMap.put('p', ';');

    vMap.put('a', 'q');
    vMap.put('s', 'w');
    vMap.put('d', 'e');
    vMap.put('f', 'r');
    vMap.put('g', 't');
    vMap.put('h', 'y');
    vMap.put('j', 'u');
    vMap.put('k', 'i');
    vMap.put('l', 'o');
    vMap.put(';', 'p');
  }

  public static void main(String[] args)
  {

    String transformCommand = "H,V,5,V";

    String inputStr = "hello world";

    String outputStr = transform(transformCommand, inputStr);

    transform("V,-85,V,H", ";3jju 4u2je");

  }

  public static String transform(String transformCommand, String inputStr)
  {

    System.out.println("Input: " + inputStr);
    System.out.println("command: " + transformCommand);
    String[] cmds = transformCommand.toUpperCase().split(",");

    StringBuffer sb = new StringBuffer();
    int i = 0;
    while (i < inputStr.length())
    {
      char ic = inputStr.charAt(i);

      if (shiftStr.indexOf(ic) >= 0)
      {
        for (int k = 0; k < cmds.length; k++)
        {
          String cmd = cmds[k];

          if (cmd.equalsIgnoreCase("H"))
          {
            ic = getHFlip(ic);
          }
          else if (cmd.equalsIgnoreCase("V"))
          {
            ic = getVFlip(ic);
          }
          else
          {
            ic = getShift(ic, Integer.valueOf(cmd));
          }
        }

      }

      sb.append(ic);

      i++;
    }

    System.out.println("output: " + sb);

    return sb.toString();

  }

  public static char getHFlip(char c)
  {
    if (hMap.containsKey(c))
      return hMap.get(c);
    else
      return c;
  }

  public static char getVFlip(char c)
  {
    if (vMap.containsKey(c))
      return vMap.get(c);
    else
      return c;
  }

  public static char getShift(char c, int n)
  {
    if (shiftStr.indexOf(c) < 0)
      return c;

    n = n % shiftLength;

    int index = shiftStr.indexOf(c);

    int steps = index + n;
    if (steps < 0)
      steps = (steps + shiftLength) % shiftLength;
    else
      steps = steps % shiftLength;

    return shiftStr.charAt(steps);

  }
}
