package datastructure.tree;

/**
 * @author Michael Liu
 */
public class findMaxSumPath
{
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
}
