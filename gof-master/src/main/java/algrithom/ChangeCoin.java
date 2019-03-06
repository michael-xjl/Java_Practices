package algrithom;

/**
 * @author Michael Liu
 */
public class ChangeCoin
{
  volatile  int[] coins = {1,2,5,10,20,50};

  public static void main(String[] args)
  {

    int[] coins = {1,2,5,10,20,50};

    System.out.println(changeCoin(78, coins));

  }

  public static int changeCoin(int x, int[] coins)
  {
    if(x == 0)
      return 0;


    for(int coin: coins)
    {
      if(coin <= x)
      {
        x = x - coin;
      }
    }


    return 0;
  }
}
