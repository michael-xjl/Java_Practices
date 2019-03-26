package datastructure.tree;

/**
 * @author Michael Liu
 */
public class MaxBSTNode
{
  public TreeNode findMax(TreeNode root) {

    if(root == null) return null;

    if(root.right == null)
      return root;

    return findMax(root.right);




  }

  public TreeNode findMax2(TreeNode root) {

    if(root == null) return null;

    while(root.right != null)
      return root = root.right;

    return root;
  }
}
