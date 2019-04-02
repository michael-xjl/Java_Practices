package datastructure.tree;

import java.util.ArrayList;
import java.util.Stack;

import static datastructure.tree.BFSSerialize.restoreTree;

/**
 * @author Michael Liu
 */
public class KthSmall
{
  public static void main(String[] args)
  {
    TreeNode root  = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(6);
    final TreeNode kthSmallest = findKthSmallest(root, 2);
    System.out.println(kthSmallest.val);

    System.out.println(findKthSmallest2(root, 2));
    System.out.println(findKthSmallest3(root, 2));
    System.out.println(findKthSmallest4(root, 2));
  }
  public static TreeNode findKthSmallest(TreeNode root, int k) {


    int[] karr = new int[]{k};
    TreeNode[] kNode = new TreeNode[1];

    findK(root, kNode, karr);

    return kNode[0];

  }

  private static void findK(TreeNode root, TreeNode[] kNode, int[] k)
  {
    if(root == null)
      return;

    if(root.left != null)
      findK(root.left, kNode, k);

    k[0] = k[0] - 1;

    if(k[0] == 0)
    {

      kNode[0] = root;
      return;
    }

    if(root.right != null)
      findK(root.right, kNode, k);

    return;
  }

  //O(logn)
  public static TreeNode findKthSmallest2(TreeNode root, int k) {

    if(root == null) return null;

    int leftSize = 0;
    if(root.left != null)
       leftSize = size(root.left);

    if(leftSize + 1 == k)
        return root;

    if( k <= leftSize)
      return findKthSmallest2(root.left, k);
    else
      return findKthSmallest2(root.right , k - leftSize -1 );
  }

  private static int size(TreeNode root)
  {
    if(root == null) return 0;

    return size(root.left) + 1 + size(root.right);
  }



  public static TreeNode findKthSmallest3(TreeNode root, int k) {

    ArrayList<TreeNode> list = new ArrayList<>();
    inOrderTraversal(root, list);

    return k < list.size() ? list.get(k -1) : null;
  }

  private static void inOrderTraversal(TreeNode root, ArrayList<TreeNode> list)
  {
    if(root == null)
      return;

    if(root.left != null)
      inOrderTraversal(root.left, list);

    list.add(root);

    if(root.right != null)
      inOrderTraversal(root.right, list);


  }


  public static TreeNode findKthSmallest4(TreeNode root, int k) {

    if(root == null) return  null;

    Stack<TreeNode> stack = new Stack<>();

    TreeNode curr = root;

    while( !stack.isEmpty() || curr != null)
    {
      if(curr == null)
      {
        curr = stack.pop();
        if( --k == 0)
          return curr;
        curr = curr.right;
      }
      else
      {
        stack.push(curr);
        curr = curr.left;
      }
    }

    return null;
  }


}
