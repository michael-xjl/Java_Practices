package datastructure.string;

/**
 * @author Michael Liu
 */
public class UniqueCharacters
{
  public static void main(String[] args)
  {
    System.out.println(areAllCharactersUnique("No unique"));
  }

  public static boolean areAllCharactersUnique(String str){

    if(str == null || str.length()  < 2) return true;

    int[] letters = new int[256];

    char[] arr = str.toLowerCase().toCharArray();

    for(char c : arr)
    {
      if(letters[(int)c] > 0)
        return false;

      letters[(int)c] = ++ letters[(int)c];
    }


    return true;
  }

}
