package datastructure.tree;

import java.util.ArrayList;

/**
 * @author Michael Liu
 */
public class findMaxSumPath
{

  public static void main(String[] args)
  {

    DFSSerialize s = new DFSSerialize();
    TreeNode restoreTree = s.restoreTreePreOrder("8,9,4,1,null,null,2,null,null,6,null,7,null,null,5,null,null");
    final int sum = maxSumPath(restoreTree);


    ArrayList<Integer> list = new ArrayList<>();
    maxSumPath(restoreTree, list);
    System.out.println(list);

  }

  public static int maxSumPath(TreeNode root)
  {
    int[] maxRecursiveHolder = new int[1];
    maxSumPathMain(root, maxRecursiveHolder);
    return maxRecursiveHolder[0];
  }

  public static int maxSumPathMain(TreeNode root, int[] maxRecursiveHolder)
  {
    if (root == null)
      return 0;
    int leftSum = maxSumPathMain(root.left, maxRecursiveHolder);
    int rightSum = maxSumPathMain(root.right, maxRecursiveHolder);
    // Get the max path sum up to this node, including this node's value
    int nodeCumVal = Math.max(root.val + leftSum, root.val + rightSum);
    // Check and update the max holder
    maxRecursiveHolder[0] = Math.max(maxRecursiveHolder[0], leftSum + root.val + rightSum);
    return nodeCumVal;
  }

  public static void maxSumPath(TreeNode root, ArrayList<Integer> list)
  {
    int[] maxRecursiveHolder = new int[1];
    maxSumPathMain(root, maxRecursiveHolder, list);
  }

  public static int maxSumPathMain(TreeNode root, int[] maxRecursiveHolder, ArrayList<Integer> list)
  {
    if (root == null)
      return 0;

    int leftSum = maxSumPathMain(root.left, maxRecursiveHolder,list);
    int rightSum = maxSumPathMain(root.right, maxRecursiveHolder,list);

    // Get the max path sum up to this node, including this node's value
    int nodeCumVal = Math.max(root.val + leftSum, root.val + rightSum);

    if((root.val + leftSum) > (root.val + rightSum))
    {
      if(root.left != null)
        list.add(root.left.val);

      list.add(root.val);
    }
    else
    {
      if(root.right != null)
        list.add(root.right.val);

      list.add(root.val);
    }

    // Check and update the max holder
    maxRecursiveHolder[0] = Math.max(maxRecursiveHolder[0], leftSum + root.val + rightSum);

    return nodeCumVal;
  }
}
