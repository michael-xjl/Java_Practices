package algrithom;

/**
 * https://www.daveperrett.com/articles/2010/12/07/comp-sci-101-big-o-notation/
 *
 * http://bigocheatsheet.com/
 *
 * Big-O measures how well an operation will “scale” when you increase the amount of “things” it operates on.
 *
| * Big-O      | Operations for 10 “things” | Operations for 100 “things” |
| * O(1)       | 1                          | 1                           |
| * O(log n)   | 3                          | 7                           |
| * O(n)       | 10                         | 100                         |
| * O(n log n) | 30                         | 700                         |
| * O(n^2)     | 100                        | 10000                       |
| * O(2^n)     | 1024                       | 2^100                       |
| * O(n!)      | 3628800                    | 100!                        |
|              |                                                                                  |                                                                                                      |
| * Big-O      | Time             | Example                                                                                                                         |
| * O(1)       | constant time    | no matter how large the input is, the time taken doesn’t change , hashtable                                                     |
| * O(log n)   | logarithmic time | half each time, finding an item in a sorted list with a balanced search tree or a binary search                                 |
| * O(n)       | linear time      | finding an item in an unsorted list                                                                                             |
| * O(n log n) | loglinear time   | quicksort (in the average and best case), heapsort and merge sort                                                               |
| * O(n^2)     | quadratic time   | every element, you do something with every other element, such as comparing them. quicksort (in the worst case) and bubble sort, insertion sort |
| * O(2^n)     | exponential time | the travelling salesman problem (using dynamic programming).    recursion fabonacci                                                                 |
| * O(n!)      | factorial time   | the travelling salesman problem using brute force, where every combination of paths will be examined                            |
|              |                  |                                                                                                                                 |*


 amortized time:
 average time taken per operation, if you do many operations


 Array Sorting Algorithms
 |Algorithm |	Time Complexity	|Space Complexity
 ||Best|	Average|	Worst|	Worst|
 |Quicksort|	Ω(n log(n))	Θ(n log(n))	O(n^2)	O(log(n))
 |Mergesort|	Ω(n log(n))	Θ(n log(n))	O(n log(n))	O(n)
 |Timsort|	Ω(n)	Θ(n log(n))	O(n log(n))	O(n)
 |Heapsort|	Ω(n log(n))	Θ(n log(n))	O(n log(n))	O(1)
 |Bubble Sort	Ω(n)	Θ(n^2)	O(n^2)	O(1)
 |Insertion| Sort	Ω(n)	Θ(n^2)	O(n^2)	O(1)
 |Selection| Sort	Ω(n^2)	Θ(n^2)	O(n^2)	O(1)
 |Tree Sort|	Ω(n log(n))	Θ(n log(n))	O(n^2)	O(n)






 * @author Michael Liu
 */
public class BigO
{
}
