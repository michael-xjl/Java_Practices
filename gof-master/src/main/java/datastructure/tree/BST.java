package datastructure.tree;

/**
 * BST : Binary Search Tree
 *
 * null is a valid binary tree.
 *
 * a binary tree with only a single root node and no children is also valid (but not empty).
 *
 * In computer science, a binary search tree (BST), sometimes also called an ordered or sorted binary tree, is a node-based binary tree data structure which has the following properties:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * The left and right subtree must each also be a binary search tree.
 * There must be no duplicate nodes
 *
 * debate:
 * 1) left <= root < right
 *
 * 2) left < root <= right
 *
 * 3) left < root < right, such that no duplicate keys exist.
 *
 * All three definitions are acceptable and correct. They define different variations of a BST.
 *
 *      3
 *     /   \
 *   2       4
 *     \
 *      3
 *
 *  can also be use a counter that counts the number of occurrences of the key:
 *
 *        3(2)
 *     /     \
 *   2(1)     4(1)
 *
 * @author Michael Liu
 */
public class BST
{
  public static void main(String[] args)
  {
    Integer[] a = new Integer[]{2,1,3};
    TreeUtility treeUtility = new TreeUtility(a);
    TreeNode node = treeUtility.getNode2(0, 0);
    System.out.println(TreeUtility.getLevel(node));
    System.out.println(isBST(node));
    System.out.println(isBST(new TreeUtility(new Integer[]{1,2,3}).getTreeNode()));
    System.out.println(isBST(new TreeUtility(new Integer[]{2,1,9,4,12}).getTreeNode()));
    System.out.println(isBST(new TreeUtility(new Integer[]{2}).getTreeNode()));
    System.out.println(isBST(new TreeUtility(new Integer[]{}).getTreeNode()));
  }


  public static boolean isBST(TreeNode tn)
  {

    if(tn == null)
      return true;

    boolean left, right;
    left = right = true;

    if(tn.left != null)
      left = compareBSTNodes(tn, tn.left, true);


    if(tn.right != null)
      right = compareBSTNodes(tn, tn.right, false);


    if(!left || !right)
      return false;

    return true;
  }

  private static boolean compareBSTNodes(TreeNode pNode, TreeNode cNode, boolean isLeft)
  {

      if(cNode == null)
        return true;

      return isLeft? pNode.val > cNode.val:  pNode.val < cNode.val;

  }


}
