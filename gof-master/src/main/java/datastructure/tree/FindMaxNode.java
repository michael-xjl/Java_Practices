package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Michael Liu
 */
public class FindMaxNode
{
  public static void main(String[] args)
  {
    final TreeNode treeNode = new TreeUtility(new Integer[] { 2, 1, 19, 4, 12 }).buildTree();
    System.out.println(findMaxItr(treeNode));
    System.out.println(findMaxItr2(treeNode));
    System.out.println(findMaxItrRecursion(treeNode));
  }

  public static int findMaxItrRecursion(TreeNode treeNode)
  {
      if(treeNode == null)
        return 0;

      return Math.max(Math.max(treeNode.val, findMaxItrRecursion(treeNode.left)), findMaxItrRecursion(treeNode.right));
  }

  public static int findMaxItr(TreeNode root)
  {

    if (root == null)
      return 0;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int max = root.val;

    while (!q.isEmpty())
    {
      TreeNode[] arr = q.toArray(new TreeNode[0]);
      q.clear();

      for (TreeNode t : arr)
      {
        max = Math.max(max, t.val);

        if (t.left != null)
          q.add(t.left);
        if (t.right != null)
          q.add(t.right);
      }

    }

    return max;
  }

  public static int findMaxItr2(TreeNode root)
  {

    if (root == null)
      return 0;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int max = root.val;

    while (!q.isEmpty())
    {
      TreeNode curr = q.remove();

      max = Math.max(max, curr.val);

      if (curr.left != null)
        q.add(curr.left);
      if (curr.right != null)
        q.add(curr.right);

    }

    return max;
  }
}
