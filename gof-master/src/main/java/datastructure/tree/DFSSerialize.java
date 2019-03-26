package datastructure.tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Michael Liu
 */
public class DFSSerialize
{
  public static void main(String[] args)
  {

    TreeNode treeNode = new TreeNode(6);
    treeNode.left = new TreeNode(1);;
    treeNode.right = new TreeNode(8);

    treeNode.right.right = new TreeNode(10);;

    treeNode.right.right.left = new TreeNode(9);
    treeNode.right.right.right = new TreeNode(12);


    DFSSerialize s = new DFSSerialize();
    final String serializeTree = s.serializeTreeInOrder(treeNode);
    System.out.println(serializeTree);
    //1,2,null,null,3,null,4,5,null,null,6,null,null

    System.out.println(s.serializeTreePreOrder(treeNode));

    final TreeNode restoreTree = s.restoreTreeInOrder(serializeTree);

    System.out.println(restoreTree);
  }

  /**
   * VLR - inorder to serialize tree
   *
   */

  public String serializeTreeInOrder(TreeNode root){
    StringBuilder sb = new StringBuilder();
    serializeTreeInOrderHelper(root,sb);
    if(sb.length() > 0) sb.deleteCharAt(0);
    return sb.toString();
  }

  private StringBuilder serializeTreeInOrderHelper(TreeNode t, StringBuilder sb){
    if(t == null) sb.append(",null");
    else {
      sb.append(","+t.val);
      serializeTreeInOrderHelper(t.left, sb);
      serializeTreeInOrderHelper(t.right, sb);
    }
    return sb;
  }


  /*************** PreOrder *****************/

  public String serializeTreePreOrder(TreeNode root){
    StringBuilder sb = new StringBuilder();
    serializeTreePreOrderHelper(root,sb);
    if(sb.length() > 0) sb.deleteCharAt(0);
    return sb.toString();
  }

  private StringBuilder serializeTreePreOrderHelper(TreeNode t, StringBuilder sb){
    if(t == null) sb.append(",null");
    else {
      serializeTreePreOrderHelper(t.left, sb);
      sb.append(","+t.val);
      serializeTreePreOrderHelper(t.right, sb);
    }
    return sb;
  }

  public TreeNode restoreTreeInOrder(String str){
    String[] nodesSplit = str.split(",");
    LinkedList<String> nodesList = new LinkedList<>(Arrays.asList(nodesSplit));
    return restoreTreeInOrderHelper(nodesList);
  }

  public TreeNode restoreTreeInOrderHelper(LinkedList<String> nodes){
    String nodeDataStr = nodes.remove();
    if(nodeDataStr.equals("null")) return null;
    TreeNode t = new TreeNode(Integer.valueOf(nodeDataStr));
    t.left = restoreTreeInOrderHelper(nodes);
    t.right = restoreTreeInOrderHelper(nodes);
    return t;
  }
}
