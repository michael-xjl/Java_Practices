package datastructure.tree;

import java.util.LinkedList;

/**
 * @author Michael Liu
 */
public class Serialize
{
  public static void main(String[] args)
  {


    final TreeNode treeNode = new TreeUtility(new Integer[] { 2, 1, 9, 4, 12 }).buildTree();
    final String serializeTree = serializeTree(treeNode);
    System.out.println(serializeTree);

    TreeNode restoreTree = restoreTree(serializeTree);
    System.out.println(serializeTree(restoreTree));

    restoreTree = restoreTree("1,,3,,,,4");
    System.out.println(serializeTree(restoreTree));
    restoreTree = restoreTree2("1,,3,,,,4");
    System.out.println(serializeTree(restoreTree));
  }



  public static String serializeTree(TreeNode root)
  {

    LinkedList<Integer> lt = new LinkedList<>();

    LinkedList<TreeNode> q = new LinkedList<>();
    q.add(root);

    lt.add(root == null ? null : root.val);

    while (!q.isEmpty())
    {
      TreeNode[] arr = q.toArray(new TreeNode[0]);
      q.clear();

      boolean end = true;
      for (TreeNode t : arr)
      {
        if (t == null)
        {
          q.add(null);
          q.add(null);
        }
        else
        {
          q.add(t.left == null ? null : t.left);
          q.add(t.right == null ? null : t.right);

          if (t.left != null || t.right != null)
            end = false;
        }
      }

      if (!end)
      {
        for (TreeNode tn : q)
          lt.add(tn == null ? null : tn.val);
      }
      else
        break;

    }

    StringBuffer sb = new StringBuffer();
    for (Integer str : lt)
      sb.append(str == null ? "" : str).append(",");

    sb.setLength(sb.length() - 1);

    return sb.toString();

  }



  public static TreeNode restoreTree(String str){

    String[] nodes = str.split(",", -1);

    if(nodes == null || nodes.length == 0)
      return null;

    TreeNode head = createNode(nodes[0]);

    LinkedList<TreeNode> ll = new LinkedList<>();

    ll.add(head);

    int index = 1;

    while(!ll.isEmpty() && index < nodes.length)
    {
      TreeNode[] arr = ll.toArray(new TreeNode[0]);
      ll.clear();

      for(TreeNode t : arr)
      {

        TreeNode left = createNode(nodes[index++]);
        TreeNode right = createNode(nodes[index++]);

        if(t != null)
        {
          t.left = left;
          t.right = right;
        }

        ll.add(left);
        ll.add(right);

      }
    }


    return head;

  }
  public static TreeNode restoreTree2(String str){

    String[] nodes = str.split(",", -1);

    if(nodes == null || nodes.length == 0)
      return null;

    TreeNode head = createNode(nodes[0]);

    LinkedList<TreeNode> ll = new LinkedList<>();

    ll.add(head);

    int index = 1;

    while(!ll.isEmpty() && index < nodes.length)
    {
      TreeNode[] arr = ll.toArray(new TreeNode[0]);
      ll.clear();

      for(TreeNode t : arr)
      {



        if(t != null)
        {

          TreeNode left = createNode(nodes[index++]);
          TreeNode right = createNode(nodes[index++]);

          t.left = left;
          t.right = right;

          ll.add(left);
          ll.add(right);
        }
        else
        {
          index += 2;
        }



      }
    }


    return head;

  }

  private static TreeNode createNode(String str)
  {
    if(str == null || str.equalsIgnoreCase(""))
      return null;
    else
      return new TreeNode(Integer.valueOf(str));
  }
}
