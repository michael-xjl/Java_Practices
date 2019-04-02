package datastructure.tree;

import java.util.ArrayList;

/**
 * @author Michael Liu
 */
public class FindAncestors
{
  public ArrayList<Integer> ancestorsList = new ArrayList<Integer>();
  public boolean printAncestors(TreeNode root, int nodeData) {
    if(root==null)
      return false;
    if(nodeData == root.val)
      return true;
    if(printAncestors(root.left, nodeData) || printAncestors(root.right, nodeData))
    {
      ancestorsList.add(root.val);
      return true;
    }
    return false;
  }
}
