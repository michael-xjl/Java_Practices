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
    final String serializeTree = s.serializeTreePreOrder1(treeNode);
    System.out.println(serializeTree);
    //6,1,null,null,8,null,10,9,null,null,12,null,null

    System.out.println(s.serializeTreeInOrder(treeNode));
    //null,1,null,6,null,8,null,9,null,10,null,12,null

    final TreeNode restoreTree = s.restoreTreePreOrder(serializeTree);

    System.out.println(restoreTree);
  }

  /**
   * VLR - preorder to serialize tree
   *
   */

  public String serializeTreePreOrder1(TreeNode root){
    StringBuilder sb = new StringBuilder();
    serializeTreePreOrder2Helper(root,sb);
    if(sb.length() > 0) sb.deleteCharAt(0);
    return sb.toString();
  }

  private StringBuilder serializeTreePreOrder2Helper(TreeNode t, StringBuilder sb){
    if(t == null) sb.append(",null");
    else {
      sb.append(","+t.val);
      serializeTreePreOrder2Helper(t.left, sb);
      serializeTreePreOrder2Helper(t.right, sb);
    }
    return sb;
  }


  /*************** InOrder LVR *****************/

  public String serializeTreeInOrder(TreeNode root){
    StringBuilder sb = new StringBuilder();
    serializeTreeInOrderHelper(root,sb);
    if(sb.length() > 0) sb.deleteCharAt(0);
    return sb.toString();
  }

  private StringBuilder serializeTreeInOrderHelper(TreeNode t, StringBuilder sb){
    if(t == null) sb.append(",null");
    else {
      serializeTreeInOrderHelper(t.left, sb);
      sb.append(","+t.val);
      serializeTreeInOrderHelper(t.right, sb);
    }
    return sb;
  }

  public TreeNode restoreTreePreOrder(String str){
    String[] nodesSplit = str.split(",");
    LinkedList<String> nodesList = new LinkedList<>(Arrays.asList(nodesSplit));
    return restoreTreePreOrderHelper(nodesList);
  }

  public TreeNode restoreTreePreOrderHelper(LinkedList<String> nodes){
    String nodeDataStr = nodes.remove();
    if(nodeDataStr.equals("null")) return null;
    TreeNode t = new TreeNode(Integer.valueOf(nodeDataStr));
    t.left = restoreTreePreOrderHelper(nodes);
    t.right = restoreTreePreOrderHelper(nodes);
    return t;
  }
}
