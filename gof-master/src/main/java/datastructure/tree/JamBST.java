package datastructure.tree;

import org.junit.Test;

/**
 * @author Michael Liu
 */
public class JamBST
{

  @Test
  public void testInsert()
  {
     TreeNode treeNode = Decompression.decompressTree("4,2,8,*,*,5,10");
    final TreeNode newTreeNode = insert(treeNode, 6);


    treeNode = Decompression.decompressTree("4,2,8,*,*,5,10");
    final TreeNode newTreeNode2 = insertRecursion(treeNode, 6);
  }

  public TreeNode insert(TreeNode root, int data) {

    if(root == null) return root;

    TreeNode curr = root;


    while(curr != null)
    {
      if(data > curr.val)
      {
        if(curr.right == null)
        {
          curr.right = new TreeNode(data);
          return root;
        }

        else
          curr = curr.right;
      }
      else if(data < curr.val)
      {
        if(curr.left == null)
        {
          curr.left = new TreeNode(data);
          return root;
        }
        else
          curr = curr.left;
      }

      else
      {
        return root;
      }
    }

    return root;

  }

  public TreeNode insertRecursion(TreeNode root, int data)
  {
    if(root == null)
      root = new TreeNode(data);
    else if(data < root.val)
      root.left = insertRecursion(root.left,data);
    else if(data > root.val)
      root.right = insertRecursion(root.right,data);

    return root;
  }
}
