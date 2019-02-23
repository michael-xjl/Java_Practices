package datastructure.string;

/**
 * @author Michael Liu
 */
public class StrToInt
{
  public int myAtoi(String str) {
    if(str==null || str.length() == 0) return 0;

    int index = 0;
    while(index < str.length() && str.charAt(index) == ' ')
      index++;

    int sign = 1;
    if(index < str.length() && str.charAt(index) == '-') {
      sign = -1;
      index++;
    } else if (index < str.length() && str.charAt(index) == '+') {
      index++;
    }

    int total = 0;
    while(index < str.length()) {
      int digit = str.charAt(index) - '0';
      if(digit < 0 || digit > 9) break;

      if((Integer.MAX_VALUE - digit) / 10 < total) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      total = total * 10 + digit;
      index++;
    }

    return total * sign;
  }
}
