package datastructure.tree;

/**
 * @author Michael Liu
 */
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }

     @Override
      public String toString()
     {



       return super.toString() + "[" + val + "]";
     }
 }