package datastructure.tree;

/**
 * @author Michael Liu
 */
 public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode(int x) { val = x; }

     @Override
      public String toString()
     {



       return super.toString() + "[" + val + "]";
     }
 }