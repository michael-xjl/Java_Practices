package datastructure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author Michael Liu
 *
 * [1,2,3,4,5,null,2,null,3]
 */
public class TreeUtility
{
  private final Integer[] a;

  public TreeUtility(Integer[] a)
  {
    this.a = a;
  }

  /**
   * get the default tree , from the root
   * @return
   */
  public TreeNode buildTree()
  {
    return getNode2(0, 0);
  }

  /**
   *
   * [ 1,  2,3,  4,5,null,6,  7,8,9,10,null,11]
   *  |-| |---| |----------| |----------------|
   *   1    2         4             8
   *   2^0  2^1       2^2           2^3
   *
   *
   *   how to find the parent node then location its child nodes?
   *   fomular to locate the index in array:
   *      *    root node position index (m = 0, n = 0)
   *    *      int leftChildNodeIndex = (1 << (m + 1)) + 2 * n; ==> 2^(m+1) + 2*n
   *    *      int rightChildNodeIndex = leftIndex + 1; ==> 2^(m+1) + 2*n + 1
   *
   *
   *                           1
   *                          / \
   *                         2   3
   *                        / \ / \
   *                       4  5 n  6
   *                      /\  /\   /\
   *                     7 8 9 10 n  11
   *
   *     variable : m ,n (m: row index, start from 0; n: col index, start from 0)
   *     so :
   *     root node (1) : m = 0, n= 0
   *           node(2) : m = 1, n= 0
   *           node(6) : m = 2, n= 3
   *     by this way, can extract any part tree from the whole tree.
   *
   *
   *
   *    root node position index (m = 0, n = 0)
   *      int leftChildNodeIndex = (1 << (m + 1)) + 2 * n; ==> 2^(m+1) + 2*n
   *      int rightChildNodeIndex = leftIndex + 1;
   *
   *   array.length == 2^(n-1)+2^(n-2)+...+2^0 ==> n is height of tree
   *
   *
   *
   *
   *
   *
   * @param m row index , base on 0
   * @param n col index, base on 0
   * @return
   */
  public TreeNode getNode2(int m, int n)
  {
    if (a == null || a.length == 0)
      return null;

    /**
     * 2^3=2⋅2⋅2⋅1=8
     * 2^2=2⋅2⋅1=4
     * 2^1=2⋅1=2
     * 2^0=1=1
     *
     *
     * 1 << 0 = `0000 0001`
     * 1 << 1 = `0000 0010`
     * 1 << 2 = `0000 0100`
     */
    final int rootIndex = (1 << m) + n;
    final int nextRootIndex = (1 << (m + 1)) + 2 * n;

    // out of tree,current is the last row
    if (nextRootIndex > a.length && a[rootIndex - 1] != null)
    {
      TreeNode treeNode = new TreeNode(a[rootIndex - 1]);
      int leftIndex = (1 << (m + 1)) + 2 * n;
      int rightIndex = leftIndex + 1;
      if (leftIndex <= a.length && a[leftIndex - 1] != null)
        treeNode.left = new TreeNode(a[leftIndex - 1]);
      if (rightIndex <= a.length && a[rightIndex - 1] != null)
        treeNode.right = new TreeNode(a[rightIndex - 1]);

      return treeNode;
    }
    else
    {
      if (a[rootIndex - 1] != null)
      {
        TreeNode treeNode = new TreeNode(a[rootIndex - 1]);
        treeNode.left = getNode2(m + 1, 2 * n);
        treeNode.right = getNode2(m + 1, 2 * n + 1);
        return treeNode;
      }
      else
        return null;
    }
  }

  // first ele is max power
  // second is the left num
  public static int[] getPower(int length)
  {
    int[] result = { 0, 0 };
    int sum = 0;
    int i = 0;
    for (;;)
    {
      if (sum == length)
      {
        result[0] = i;
        result[1] = 0;
        break;
      }

      if (sum > length)
      {
        result[0] = i - 1;
        final int i1 = 1 << (i - 1);
        result[1] = length - (sum - i1);
        break;
      }

      sum += 1 << i;

      i++;
    }
    return result;
  }

  /**
   * get the height of the tree
   * @param treeNode
   * @return
   */
  public static int getLevel(TreeNode treeNode)
  {

    if (treeNode.right == null && treeNode.left == null)
    {
      return 1;
    }
    else
    {

      int leftL =0, rightL = 0;

      if (treeNode.left != null)
      {
        leftL = getLevel(treeNode.left);
      }

      if (treeNode.right != null)
        rightL = getLevel(treeNode.left);

      return 1 + (leftL > rightL ? leftL : rightL);
    }

  }

  public static int getLevel2(TreeNode treeNode)
  {

    if(treeNode == null )
    {
      return 0;
    }
    else
    {
      int left = getLevel2(treeNode.left);
      int right = getLevel2(treeNode.right);

      return 1 + (left > right ? left : right);
    }

  }

  public static void printTree(TreeNode treeNode)
  {
    final int height = getLevel2(treeNode);

    

  }

  public static void preOrderTraversal(List<Integer> preOrderList, TreeNode treeNode)
  {
    if (treeNode != null)
    {
      preOrderList.add(treeNode.val);
      System.out.print(treeNode.val + "-->");

      if (treeNode.left != null)
        preOrderTraversal(preOrderList, treeNode.left);

      if (treeNode.right != null)
        preOrderTraversal(preOrderList, treeNode.right);
    }
  }

  public static void inOrderTraversal(List<Integer> list, TreeNode treeNode)
  {
    if (treeNode != null)
    {
      if (treeNode.left != null)
        inOrderTraversal(list, treeNode.left);

      list.add(treeNode.val);
      System.out.print(treeNode.val + "-->");

      if (treeNode.right != null)
        inOrderTraversal(list, treeNode.right);
    }
  }

  public static void postOrderTraversal(List<Integer> list, TreeNode treeNode)
  {
    if (treeNode != null)
    {
      if (treeNode.left != null)
        postOrderTraversal(list, treeNode.left);

      if (treeNode.right != null)
        postOrderTraversal(list, treeNode.right);

      list.add(treeNode.val);
      System.out.print(treeNode.val + "-->");
    }
  }

  /**
   * From Bottom to Top traversal is a little more complicate , comparing to Top to Bottom,
   * as have to reach buttom level first, and store the stack
   *
   * use Queue to store the stacks , then get layer from tail of the Queue
   *
   * from bottom to top
   * @param list
   * @param treeNode
   */
  public static void downUpTraversal(List<Integer> list, TreeNode treeNode)
  {
    Queue<List<TreeNode>> fullTreeNodeQueue = new ArrayDeque<>();
    
    if(treeNode != null)
    {
      //store each level data
      List<TreeNode> levelTreeNodeList = new ArrayList<>();

      //add root node
      levelTreeNodeList.add(treeNode);

      /**
       * get current layer nodes as Array, then clear list,
       * loop the array, put all the left/right child nodes to list
       * until each node reach the end (no more node add to list)
       */
      while(levelTreeNodeList.size() > 0 )
      {
        TreeNode[] nodeInQ = levelTreeNodeList.toArray(new TreeNode[0]);
        levelTreeNodeList.clear();

        fullTreeNodeQueue.add(Arrays.asList(nodeInQ));

        for(TreeNode pNode : nodeInQ)
        {
          if(pNode.left != null)
            levelTreeNodeList.add(pNode.left);
          if(pNode.right != null)
            levelTreeNodeList.add(pNode.right);
        }
      }
    }

    /**
     * get the nodes out.
     * each list in the queue is one level
     */
    while(!fullTreeNodeQueue.isEmpty())
    {
      final List<TreeNode> treeNodes = ((ArrayDeque<List<TreeNode>>) fullTreeNodeQueue).removeLast();
      for(TreeNode node : treeNodes)
      {
        list.add(node == null ? null : node.val);
        System.out.print((node == null ? null : node.val) + "-->");
      }
    }
  }

  /**
   * traverse from top to bottom
   * @param list
   * @param treeNode
   */
  public static void upDownTraversal(List<Integer> list, TreeNode treeNode)
  {

    Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
    if(treeNode != null)
    {
      treeNodeQueue.add(treeNode);

      while(treeNodeQueue.size() > 0 )
      {
        TreeNode[] nodeInQ = treeNodeQueue.toArray(new TreeNode[0]);
        treeNodeQueue.clear();

        for(TreeNode pNode : nodeInQ)
        {
          list.add(pNode.val);
          System.out.print(pNode.val + "-->");
          if(pNode.left != null)
            treeNodeQueue.add(pNode.left);
          if(pNode.right != null)
            treeNodeQueue.add(pNode.right);
        }
      }
    }
  }

  public static void sumEachLevelVal(List<Integer> list, TreeNode treeNode)
  {

    Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
    if(treeNode != null)
    {
      treeNodeQueue.add(treeNode);

      while(treeNodeQueue.size() > 0 )
      {
        TreeNode[] nodeInQ = treeNodeQueue.toArray(new TreeNode[0]);
        treeNodeQueue.clear();

        int sum = 0;
        for(TreeNode pNode : nodeInQ)
        {
          sum += pNode.val;
          System.out.print(pNode.val + "-->");
          if(pNode.left != null)
            treeNodeQueue.add(pNode.left);
          if(pNode.right != null)
            treeNodeQueue.add(pNode.right);
        }
        System.out.println();
        list.add(sum);

      }
    }
  }
}
