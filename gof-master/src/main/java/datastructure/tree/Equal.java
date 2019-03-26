package datastructure.tree;

/**
 * @author Michael Liu
 */
public class Equal
{
  public boolean isIdentical(TreeNode root1, TreeNode root2)
  {
    //if both or one of the tree is empty
    if (root1 == null && root2 == null)
      return true;
    if (root1 == null || root2 == null)
      return false;
    //both are not empty
    return (
        root1.val == root2.val &&
            isIdentical(root1.left, root2.left) &&
            isIdentical(root1.right, root2.right));
  }
}
