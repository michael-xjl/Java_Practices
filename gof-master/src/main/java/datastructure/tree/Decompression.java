package datastructure.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a String that represents a Binary Tree, write a method - decompressTree that decompresses that tree (reconstructs the tree) and returns the root TreeNode. The compression algorithm included traversing the tree level by level, from the left to the right. The TreeNode's data values were appended to the String, delimited by commas. Also, null TreeNodes were denoted by appending an asterisk - *. The input String denotes the structure of a Full Binary Tree - i.e. a tree that is structurally balanced. However, the reconstructed tree may not be a full tree as the String included * characters, which represent null TreeNodes.
 *
 * @author Michael Liu
 */
public class Decompression
{

  public static  TreeNode decompressTree(String str){

    if(str == null || str.length() == 0 )
      return null;
    //ArrayDeque doesn't allow null/but LinkedList allows
    Queue<TreeNode> q = new LinkedList<>();

    String[] arr = str.split(",");


    int index = 0;
    TreeNode root = buildNode(arr[index]);
    q.add(root);

    while(!q.isEmpty() && index < arr.length - 1)
    {
      TreeNode[] tns =  q.toArray(new TreeNode[0]);
      q.clear();

      for(TreeNode t : tns)
      {
        if(t != null)
        {
          t.left = buildNode(arr[++index]);
          t.right = buildNode(arr[++index]);

          q.add(t.left);
          q.add(t.right);
        }
        else
        {
          index  += 2;
        }
      }
    }


    return root;
  }

  private static TreeNode buildNode(String s)
  {
    if(s.equals("*"))
      return null;
    else
      return new TreeNode(Integer.valueOf(s));
  }

  @Test
  public void decompressTest()
  {
    final TreeNode treeNode = decompressTree("1,2,*,3,*,*,*");
    System.out.println(treeNode);
  }
}
