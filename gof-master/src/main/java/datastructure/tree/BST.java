package datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;

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
    System.out.println(isBST(new TreeUtility(new Integer[]{1,2,3}).buildTree()));
    System.out.println(isBST(new TreeUtility(new Integer[]{2,1,9,4,12}).buildTree()));
    System.out.println(isBST(new TreeUtility(new Integer[]{2}).buildTree()));
    System.out.println(isBST(new TreeUtility(new Integer[]{}).buildTree()));

    //should false, as node(30) is on the left of tree, it should be less than root(20) even it it greater than its parent node(15)
    System.out.println(isBST(new TreeUtility(new Integer[]{20,15,40,10,30}).buildTree()));

    System.out.println(validateBST2(new TreeUtility(new Integer[]{20,15,40,10,30}).buildTree()));
  }


  public static boolean isBST(TreeNode tn)
  {

    if(tn == null)
      return true;

    return compareBSTNodes(tn.left, -1, tn.val,  true) && compareBSTNodes(tn.right, tn.val, -1,  false);
  }

  private static boolean compareBSTNodes(TreeNode pNode, int min, int max,  boolean isLeft)
  {

      if(pNode == null)
        return true;

     if((isLeft && pNode.val > max ) || (!isLeft && pNode.val < min))
        return false;

     return compareBSTNodes(pNode.left, pNode.val, -1, true) && compareBSTNodes(pNode.right, -1, pNode.val , false);

  }


  /**simple version, but can't cover every case**/

  public static boolean validateBST(TreeNode root) {

    if(root == null )
      return true;

    if(root.left != null )
      if(root.left.val > root.val )
        return false;

    if(root.right != null )
      if(root.right.val < root.val )
        return false;

    return validateBST(root.left) && validateBST(root.right);

  }


  /*** another way **/
  static ArrayList<Integer> nodesList = new ArrayList<Integer>();

  public static boolean validateBST2(TreeNode root) {
    inorderTraversal(root);
    System.out.println(Arrays.toString(nodesList.toArray()));
    for (int i = 1; i < nodesList.size(); i++) {
      if (nodesList.get(i-1) > nodesList.get(i)) {
        nodesList.clear();
        return false;
      }
    }
    nodesList.clear();
    return true;

  }

  //after inorder travel, all the nodes are sorted
  public static void inorderTraversal(TreeNode node) {
    if (node != null) {
      inorderTraversal(node.left);
      nodesList.add(node.val);
      inorderTraversal(node.right);
    }
  }

}
