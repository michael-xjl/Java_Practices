package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Liu
 */
public class PreOrderTree
{

  public static void main(String[] args)
  {
    Integer[] a = {1,2,null,4,5};

//    TreeNode root = TreeUtility.buildTree(a);
  }

  class RecursiveSolution {

    public List<Integer> preorderTraversal(TreeNode root) {

      List<Integer> poList = new ArrayList<>();
      traversal(poList,  root);

      return poList;
    }

    private void traversal(List<Integer> pl, TreeNode root)
    {
      if(root != null)
        pl.add(root.val);

      if(root.left != null)
        traversal(pl, root.left);
      if(root.right != null)
        traversal(pl, root.right);
    }
  }
}

