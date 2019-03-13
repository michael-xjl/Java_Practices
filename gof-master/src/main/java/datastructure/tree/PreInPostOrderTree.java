package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://stackoverflow.com/questions/9456937/when-to-use-preorder-postorder-and-inorder-binary-search-tree-traversal-strate
 *
 * Pre-Order / In-order /Post-order Usage : Simple words
 *
 * Pre-order: Used to create a copy of tree Example : If you want to create a replica of a tree and need node values in an array and when you insert those values from index 0 to end in a new tree, you get a replica
 *            simply print out the hierarchical format of the tree in a linear format, I'd probably use preorder traversal
 *
 * In-order: : To get values of node in non-increasing order. **you have a BST of a list of words or names, inorder traversal would print them out in order.
 *
 *
 * Post-order: : When you want to delete a tree from leaf to root.  to evaluate an expression like A + B * C
 *
 * ********************************************************************************
 *
 * Pre- and post-order relate to top-down and bottom-up recursive algorithms,
 * respectively. If you want to write a given recursive algorithm on binary trees in an iterative fashion,
 * this is what you will essentially do.
 *
 * @author Michael Liu
 */
public class PreInPostOrderTree
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

