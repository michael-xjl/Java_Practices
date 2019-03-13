package datastructure.tree;

/**
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * @author Michael Liu
 */
public class Symmetric
{
  public static boolean isSymmetric(TreeNode root) {

    if(root == null)
      return true;

    return isSym(root.left, root.right);

  }

  private static boolean isSym(TreeNode left, TreeNode right)
  {
    if(left == null && right == null)
      return true;

    if((left == null && right != null) || (left != null && right == null))
      return false;

    if(left.val != right.val)
      return false;

    return isSym(left.left, right.right) && isSym(left.right, right.left);
  }
}
