package datastructure.string;

/**
 * @author Michael Liu
 */
public class Palindrome
{
  public static void main(String[] args)
  {

//    System.out.println("a : f & A".replaceAll("[^a-zA-Z]",""));

    System.out.println((int)'a'); //97
    System.out.println((int)'A'); //65

    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
  }

  public static boolean isPalindrome(String s) {

    if(s == null)
      return false;

    String ns = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");

    if(ns.length() == 1)
      return true;

    char[] nsa = ns.toCharArray();



    int i = 0 ;
    int j = nsa.length -1;
    int mid =  nsa.length/2;

    for(;i <= mid && j >=mid; i++, j--)
    {
      if(nsa[i] != nsa[j])
        return false;
    }

    return true;
  }

  public static boolean isPalindromeBest(String s) {
    if(s.length() == 0) return true;
    char[] arr = s.toCharArray();
    int i = 0, j = arr.length - 1;
    while(i < j){
      char ic = arr[i];
      if(!((ic >= '0' && ic <= '9') || (ic >= 'a' && ic <= 'z') || ic >= 'A' && ic <= 'Z')){
        i++;
        continue;
      }
      if(ic >= 'A' && ic <= 'Z') ic += 32;
      char jc = arr[j];
      if(!((jc >= '0' && jc <= '9') || (jc >= 'a' && jc <= 'z') || jc >= 'A' && jc <= 'Z')){
        j--;
        continue;
      }
      if(jc >= 'A' && jc <= 'Z') jc += 32;
      if(ic != jc) return false;
      i++;
      j--;
    }
    return true;
  }

  public boolean isPalindrome2(String s) {

    if(s.equals("")) return true;

    char[] charString = s.toCharArray();

    int start = 0, end = charString.length - 1;

    while(start < end){

      while(!Character.isLetterOrDigit(charString[start]) && (start < end)) start++;
      while(!Character.isLetterOrDigit(charString[end]) && (start < end)) end--;

      if(Character.toLowerCase(charString[start]) != Character.toLowerCase(charString[end]))    return false;

      start++;
      end--;
    }
    return true;
  }



}
