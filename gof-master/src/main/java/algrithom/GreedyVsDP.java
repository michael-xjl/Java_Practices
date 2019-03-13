package algrithom;

/**
 * greedy approach uses the current optimal solution to find the global optimal solution
 * DP algorithm reuse the overlapping sub-results.
 * @author Michael Liu
 */
public class GreedyVsDP
{
  /**
   Greed algorithm : Greedy algorithm is one which finds the feasible solution at every stage with the hope of finding global optimum solution.

   Dynamic Programming : Dynamic programming is one which breaks up the problem into series of overlapping sub-problems.

   Difference between greedy method and dynamic programming are given below :

   Greedy algorithm is one which finds feasible solution at every stage with the hope of finding optimal solution whereas Dynamic programming is one which break the problems into series of overlapping sub-problems.
   Greedy algorithm never reconsiders its choices whereas Dynamic programming may consider the previous state.
   Greedy algorithm is less efficient whereas Dynamic programming is more efficient.
   Greedy algorithm have a local choice of the sub-problems whereas Dynamic programming would solve the all sub-problems and then select one that would lead to an optimal solution.
   Greedy algorithm take decision in one time whereas Dynamic programming take decision at every stage.
   Greedy algorithm work based on choice property whereas Dynamic programming work based on principle of optimality.
   Greedy algorithm follows the top-down strategy whereas Dynamic programming follows the bottom-up strategy.


   Greedy Applications:

   Sorting: Selection sort, Topological sort
   Priority Queues: Heap sort
   Huffman coding compression algorithm
   Prim's and Kruskal's algorithms
   Sorted Path in Weighted Graph (Dijikstra's)
   Coin change problem
   Job scheduling algorithms



   Consider this example.
   You are standing at a place p. You are to goto q. There are intermediate places C1,C2 ...

   You want to minimize distance travelled.

   Greedy Method of Solving
   You don't want to try all intermediate places. You goto the nearest intermediate place. Why? You feel by going to the nearest intermediate place, you will minimize the distance to q.

   Dynamic Programming
   You try all the places, but you store the previous result. Eg: To reach C3 in minimum distance, you reached by C1. So you store C1. So if you want to go to C5, by C3, you will goto C1 then C3 and then check if going from C3 to C5 is nearest.


   ************
   With the reference of Biswajit Roy: Dynamic Programming firstly plans then Go. and Greedy algorithm uses greedy choice, it firstly Go then continuously Plans.
   */


  public static void loadBalancing()
  {
    /**
     * Take for instance m=2 machines and n=5 jobs with processing times 4,3,3,2,2.
     *
     * The optimal schedule puts 4+3 on one machine and 3+2+2 on the orther machine.
     *
     * Sorted-greedy assigns 4 to the first machine, 3 to the second machine, 3 to the second machine, 2 to the first machine, 2 to the first machine. Hence the loads are 4+2+2 and 3+3.
     */
  }
}
