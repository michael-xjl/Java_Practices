package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Michael Liu
 */
public class NumberOfHalfNodes
{
  public int numberOfHalfNodes(TreeNode root) {

    if(root == null)
      return 0;

    int count = 0;
    if((root.left == null && root.right != null) || (root.left != null && root.right == null))
        count ++;

    return count + numberOfHalfNodes(root.left) + numberOfHalfNodes(root.right);
  }

  public int numberOfHalfNodes2(TreeNode root) {
    if(root == null) return 0;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    int count = 0;
    TreeNode curr = null;
    while(!q.isEmpty()) {
      curr = q.remove();
      if(curr.left == null && curr.right != null || curr.left != null && curr.right == null) {
        count++;
      }
      if(curr.left != null)
        q.add(curr.left);
      if(curr.right != null)
        q.add(curr.right);
    }
    return count;
  }
}
