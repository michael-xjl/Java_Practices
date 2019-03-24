package datastructure.tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Michael Liu
 */
public class Serialize2
{
  public static void main(String[] args)
  {

    TreeNode treeNode = new TreeNode(3);
    treeNode.left = null;
    treeNode.right = new TreeNode(5);

    treeNode.right.left = new TreeNode(4);;

    treeNode.right.left.right = new TreeNode(9);


    Serialize2 s = new Serialize2();
    final String serializeTree = s.serializeTree(treeNode);
    System.out.println(serializeTree);

    final TreeNode restoreTree = s.restoreTree(serializeTree);

    System.out.println(restoreTree);
  }

  public String serializeTree(TreeNode root){
    StringBuilder sb = new StringBuilder();
    serializeTreeHelper(root,sb);
    if(sb.length() > 0) sb.deleteCharAt(0);
    return sb.toString();
  }

  private StringBuilder serializeTreeHelper(TreeNode t, StringBuilder sb){
    if(t == null) sb.append(",null");
    else {
      sb.append(","+t.val);
      serializeTreeHelper(t.left, sb);
      serializeTreeHelper(t.right, sb);
    }
    return sb;
  }

  public TreeNode restoreTree(String str){
    String[] nodesSplit = str.split(",");
    LinkedList<String> nodesList = new LinkedList<>(Arrays.asList(nodesSplit));
    return restoreTreeHelper(nodesList);
  }

  public TreeNode restoreTreeHelper(LinkedList<String> nodes){
    String nodeDataStr = nodes.remove();
    if(nodeDataStr.equals("null")) return null;
    TreeNode t = new TreeNode(Integer.valueOf(nodeDataStr));
    t.left = restoreTreeHelper(nodes);
    t.right = restoreTreeHelper(nodes);
    return t;
  }
}
