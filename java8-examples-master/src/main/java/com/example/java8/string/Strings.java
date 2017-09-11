package com.example.java8.string;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {
	


	public static void main(String[] args)
	{
		
		System.out.println(Strings.countHi2("hihihix"));
		Strings.printOneToTen(10);
		Strings.parenBit(parenBit(""));
//		System.out.println(Strings.countYZ("hello hoz gooy"));
//		System.out.println(Strings.countYZ("!!day--yaz!!"));
//		System.out.println(Strings.doubleChar("The"));
//		System.out.println(Strings.doubleChar2("The"));
//		System.out.println(Strings.doubleChar2("Theabc"));
//		System.out.println(Strings.isPalindrome("A dog, a plan, a canal: pagoda."));
		
		int[] numbers = { 2, 4, 3, 5, 7, 8, 9 }; 
		int[] numbersWithDuplicates = { 2, 4, 3, 5, 6, -2, 4, 7, 8, 9 };
		

	}
	
	/**
	 * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)

countYZ("fez day") → 2
countYZ("day fez") → 2
countYZ("day fyyyz") → 2

Expected	Run		
countYZ("fez day") → 2	2	OK	
countYZ("day fez") → 2	2	OK	
countYZ("day fyyyz") → 2	2	OK	
countYZ("day yak") → 1	1	OK	
countYZ("day:yak") → 1	1	OK	
countYZ("!!day--yaz!!") → 2	2	OK	
countYZ("yak zak") → 0	0	OK	
countYZ("DAY abc XYZ") → 2	2	OK	
countYZ("aaz yyz my") → 3	3	OK	
countYZ("y2bz") → 2	2	OK	
countYZ("zxyx") → 0	0	OK	
other tests
OK	


	 * @param str
	 * @return
	 */
	public static int countYZ(String str) {
		 
		int total = 0;
		char[] ca = str.toCharArray();
		
		for(int i = 0; i< str.length();i++)
		{
			char c = str.charAt(i);
			if(c == 'y' || c == 'z' || c == 'Y' || c == 'Z')
			{
				if(i == str.length() -1 || !Character.isLetter(str.charAt(i+1)))
					total++;
			}
		}
		  
		  return total;
	}

	/**

Given a string, return a string where for every char in the original, there are two chars.

doubleChar("The") → "TThhee"
doubleChar("AAbb") → "AAAAbbbb"
doubleChar("Hi-There") → "HHii--TThheerree"
	 * @param str
	 * @return
	 */
	public static String doubleChar(String str) {
		  Optional<String> option =  str.chars().mapToObj(c -> String.valueOf((char)c)).map(s -> s + s).reduce(String::concat);
		  return option.isPresent()? option.get(): str;
	}
	
	
	//complexity linear o(n)
	public static String doubleChar2(String str) {
		
		for(int i = 0 ; i < str.length() ; i=i+2)
		{
			str = str.substring(0,i) + str.substring(i, i+1) + str.substring(i);  
		}
		return str;
		
	}
	
	
	
	/**
	 * A dog, a plan, a canal: pagoda.
	 * @param str
	 * @return
	 */
	public static boolean isPalindrome(String str)
	{
		str = str.replaceAll("\\W", "");
		StringBuffer sb = new StringBuffer(str);
		return sb.reverse().toString().equalsIgnoreCase(str);
	}
	
	
	/**
	 * if there are two elements in the array equal to the number
	 */
	
	public static boolean isTwoEqualsOne(int[] sourceA,  int target)
	{
		
		if(sourceA.length < 2) return false;
		
		for(int i = 0 ; i < sourceA.length -1 ; i++)
		{
			for(int j = i + 1; j < sourceA.length ; j ++ )
			{
				if(sourceA[i] + sourceA[j] == target)
					return true;
			}
		}
		

		return false;
	}
	
	public static void printIfTwoEqualsOne(int[] sourceA,  int target)
	{
//		List<Integer> list = Arrays.asList(sourceA);
		
	}	
	
	/**
	 * Return the number of times that the string "hi" appears anywhere in the given string.

countHi("abc hi ho") → 1
countHi("ABChi hi") → 2
countHi("hihi") → 2
	 * @param str
	 * @return
	 */
	public int countHi(String str) {
		  
		  int count = 0;

		  while(str.indexOf("hi") > -1)
		  {
		    str = str.substring(str.indexOf("hi") + 2);
		    count++;
		  }
		  
		  return count;
		  
//		  int count = 0;
//		  // Loop to length-1 so we can access index i and i+1 in the loop.
//		  for (int i = 0; i < (str.length() - 1); i++) {
//		    if (str.substring(i, i+2).equals("hi")) count++;
//		  }
//		  return count;
		}

	
	public int countHiByCursion(String str) {
		  
		  int count = 0;
		  String word = "hi";
		  int wlen = word.length();
		  
		  if(str.contains(word))
			  count ++;
		  else
			  return 0;
		  
		  return count + countHiByCursion(str.substring(str.indexOf(word)+wlen));
		  
		}
	
	/**
	 * 
Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative.

strCopies("catcowcat", "cat", 2) → true
strCopies("catcowcat", "cow", 2) → false
strCopies("catcowcat", "cow", 1) → true
	 * @param str
	 * @param sub
	 * @param n
	 * @return
	 */
	public boolean strCopies(String str, String sub, int n) {
		  if (n == 0) return true;
		  int len = sub.length();
		  if (str.length() < len) return false;
		  
		  if (str.substring(0, len).equals(sub)) {
		    // Found it, so subtract 1 from n in the recursion
		    return strCopies(str.substring(1), sub, n-1);
		  } else {
		    return strCopies(str.substring(1), sub, n);
		  }
		}
	
	/**
	 * 
Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".

stringClean("yyzzza") → "yza"
stringClean("abbbcdd") → "abcd"
stringClean("Hello") → "Helo"
	 * @param str
	 * @return
	 */
	public String stringClean(String str) {
		  
		  
		  return "";
		  
	}
	
	/**
	 * 
Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count "hi" that have an 'x' immedately before them.

countHi2("ahixhi") → 1
countHi2("ahibhi") → 2
countHi2("xhixhi") → 0

Expected	Run		
countHi2("ahixhi") → 1	1	OK	
countHi2("ahibhi") → 2	2	OK	
countHi2("xhixhi") → 0	0	OK	
countHi2("hixhi") → 1	1	OK	
countHi2("hixhhi") → 2	2	OK	
countHi2("hihihi") → 3	3	OK	
countHi2("hihihix") → 3	3	OK	
countHi2("xhihihix") → 2	2	OK	
countHi2("xxhi") → 0	0	OK	
countHi2("hixxhi") → 1	1	OK	
countHi2("hi") → 1	1	OK	
countHi2("xxxx") → 0	0	OK	
countHi2("h") → 0	0	OK	
countHi2("x") → 0	0	OK	
countHi2("") → 0	0	OK	
countHi2("Hellohi") → 1	1	OK	
other tests
OK	
	 * @param str
	 * @return
	 */
	
	public static int countHi2(String str) {
	     int total = 0;
	     if(str == null || str.length() < 2 || str.indexOf("hi") < 0)
	        return 0;
	        
	     int fi =  str.indexOf("hi");
	     int si =  str.indexOf("xhi");

	     if( fi  >=0 )
	     {
	       if(!(si >= 0 && si == fi -1 ))
	       {
	    	   
	          total = 1;
	          System.out.println("total++ : " + total);
	       }
	     }
	     
	     return total + countHi2(str.substring(fi+2));
	     
	}
	
	
	public static void printOneToTen(int i)
	{

		if(i <0 ) return ;
		System.out.println(i);
		printOneToTen(i - 1);
		
		
	}
	
	/**

Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)".

parenBit("xyz(abc)123") → "(abc)"
parenBit("x(hello)") → "(hello)"
parenBit("(xy)1") → "(xy)"


	 * @param str
	 * @return
	 */
	public static String parenBit(String str) {
		
		if(str == null) return null;
		String excluse = "";
		Pattern p = Pattern.compile("\\(\\w+\\)");
		Matcher m = p.matcher("xyz(abc)123");
		String g = "";
		if(m.find())
		{
			int sIndex = m.start();
			int eIndex = m.end();
		 
			g = m.group();
		}
		System.out.println(g);
		return g;
		
		
	}


}
