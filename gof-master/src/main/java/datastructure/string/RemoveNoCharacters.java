package datastructure.string;

/**
 * only keep digital nums and letters (aphacinumbers)
 * //    System.out.println("a : f & A".replaceAll("[^a-zA-Z]",""));
 * @author Michael Liu
 */
public class RemoveNoCharacters
{
  public static void main(String[] args)
  {

//    System.out.println("a : f & A".replaceAll("[^a-zA-Z]",""));

    System.out.println(Integer.MAX_VALUE);
    System.out.println((int)'a'); //97
    System.out.println((int)'A'); //65

    System.out.println(removeSpecialChars("A man,%^&*() a plan, a canal: Panama"));
  }

  public static String removeSpecialChars(String s) {

    if(s == null)
      return null;

    int noAphaicNumsCount = 0;

    char[] sa = s.toCharArray();



    for(char sac : sa)
    {
      if(!((sac >= '0' && sac <= '9' )|| (sac >= 'A' && sac <= 'Z' )||(sac >= 'a' && sac <= 'z' )))
      {
        noAphaicNumsCount++;
      }
    }

    char[] nsa = new char[sa.length - noAphaicNumsCount];

    int i = 0;
    for(char sac : sa)
    {
      if((sac >= '0' && sac <= '9' )|| (sac >= 'A' && sac <= 'Z' )||(sac >= 'a' && sac <= 'z' ))
      {
        nsa[i] = sac;
        i++;

      }
    }

    return new String(nsa);

  }



}
