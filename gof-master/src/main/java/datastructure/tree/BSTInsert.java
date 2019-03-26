package datastructure.tree;

/**
 * @author Michael Liu
 */
public class BSTInsert
{
  public TreeNode insertRec(TreeNode root, int data) {
    if(root == null) {
      root = new TreeNode(data);
    } else
    if(data < root.val) {
      root.left = insertRec(root.left, data);
    } else
    if(data > root.val) {
      root.right = insertRec(root.right, data);
    }
    return root;
  }

  public TreeNode insertItr(TreeNode root, int data) {

    if(root == null)
      return new TreeNode(data);

    TreeNode curr = root;

    while( curr != null)
    {
      if(curr.val > data )
      {
        if(curr.left == null)
          curr.left  = new TreeNode(data);
        else
          curr = curr.left;
      }
      else if(curr.val < data)
      {
        if(curr.right == null)
          curr.right  = new TreeNode(data);
        else
          curr = curr.right;
      }
      else
        break;

    }

    return root;

  }
}
