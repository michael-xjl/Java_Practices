package datastructure.tree;

/**
 * @author Michael Liu
 */
public class Search
{
  public static void main(String[] args)
  {
    Integer[] a = new Integer[] { 2, 1, 3 };
    TreeUtility treeUtility = new TreeUtility(a);
    TreeNode root = treeUtility.getNode2(0, 0);

    System.out.println(BST.isBST(root));

    System.out.println(search(root, 3));
    System.out.println(search(root, 1));
    System.out.println(search(root, 5));
  }

  public static TreeNode search(TreeNode root, int k)
  {
    if(root == null || root.val == k )
      return root;

    if( k > root.val)
    {
        return search(root.right,k);
    }
    else
    {
        return search(root.left, k);
    }
  }
}
