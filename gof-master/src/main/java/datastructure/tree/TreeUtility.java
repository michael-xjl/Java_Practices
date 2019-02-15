package datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Michael Liu
 *
 * [1,2,3,4,5,null,2,null,3]
 */
public class TreeUtility
{
  private final Integer[] a ;
  public TreeUtility(Integer[] a)
  {
    this.a = a;
  }


  public TreeNode getNode2(int m, int n)
  {
    final int rootIndex = (1 << m) +  n ;
    final int nextRootIndex = (1 << (m+1)) +  2*n ;

    //out of tree,current is the last row
    if(nextRootIndex > a.length && a[rootIndex - 1] != null)
    {
      TreeNode treeNode = new TreeNode(a[rootIndex - 1]);
      int leftIndex = (1<<(m+1))+2*n;
      int rightIndex = leftIndex + 1;
      if(leftIndex <= a.length && a[leftIndex -1] != null )
        treeNode.left = new TreeNode(a[leftIndex -1]);
      if(rightIndex <= a.length && a[rightIndex -1] != null)
        treeNode.right = new TreeNode(a[rightIndex -1]);



      return treeNode;
    }
    else
    {
      if(a[rootIndex - 1] != null)
      {
        TreeNode treeNode = new TreeNode(a[rootIndex - 1]);
        treeNode.left = getNode2(m+1,2*n);
        treeNode.right = getNode2(m+1,2*n+1);
        return treeNode;
      }
      else
        return null;


    }



  }

  //first ele is max power
  //second is the left num
  public static int[] getPower(int length)
  {
    int[] result = {0,0};
    int sum = 0;
    int i=0;
    for(;;)
    {
      if(sum == length)
      {
        result[0] = i;
        result[1] = 0;
        break;
      }
        
      if(sum > length)
      {
        result[0] = i - 1;
        final int i1 = 1 << (i - 1);
        result[1] = length - (sum - i1);
        break;
      }
        
      
      sum += 1<<i;
      
      i++;
    }
    return result;
  }

  public static void main(String[] args)
  {
    Integer[] treeA = {1,2,3,4,5,null,2,null,3};
    final int[] power = getPower(treeA.length);
    System.out.println(Arrays.toString(power));

    Integer[] a = {1}; //one time initialize
    TreeUtility treeUtility = new TreeUtility(a);
    TreeNode node = treeUtility.getNode2(0, 0);
    System.out.println(getLevel(node));

    a = new Integer[]{1,2,3};
    treeUtility = new TreeUtility(a);
    node = treeUtility.getNode2(0, 0);
    System.out.println(getLevel(node));
//
    a = new Integer[]{1,2,3,4,5};
    treeUtility = new TreeUtility(a);
    node = treeUtility.getNode2(0, 0);
    System.out.println(getLevel(node));


    a = new Integer[]{1,2,3,4,5,null,6};
    treeUtility = new TreeUtility(a);
    node = treeUtility.getNode2(0, 0);

    System.out.println(getLevel(node));


    a = new Integer[]{1,2,3,4,5,null,6,7,8,9,10,null,11};
    treeUtility = new TreeUtility(a);
    node = treeUtility.getNode2(0, 0);

    final int level = getLevel(node);
    System.out.println(level);

    List<Integer> sortOrder = new ArrayList<>();
    preOrderTraversal(sortOrder, node);
    System.out.println(sortOrder);

    sortOrder = new ArrayList<>();
    inOrderTraversal(sortOrder, node);
    System.out.println(sortOrder);

    sortOrder = new ArrayList<>();
    postOrderTraversal(sortOrder, node);
    System.out.println(sortOrder);
  }



  public static int getLevel(TreeNode treeNode)
  {

    if(treeNode.right == null && treeNode.left == null)
    {
      return 1;
    }
    else
    {

      int leftL , rightL ;
      leftL = rightL = 0;

      if(treeNode.left != null)
      {
        leftL = getLevel(treeNode.left);
      }

      if(treeNode.right != null)
        rightL = getLevel(treeNode.left);

      return 1 + (leftL > rightL ? leftL : rightL);
    }

  }

  public static void printTree(TreeNode treeNode)
  {

  }


  public static void preOrderTraversal(List<Integer> preOrderList,TreeNode treeNode)
  {
    if(treeNode != null)
      preOrderList.add(treeNode.val);

    if(treeNode.left != null)
      preOrderTraversal(preOrderList, treeNode.left);

    if(treeNode.right != null)
      preOrderTraversal(preOrderList, treeNode.right);
  }

  public static void inOrderTraversal(List<Integer> list,TreeNode treeNode)
  {

    if(treeNode.left != null)
      inOrderTraversal(list, treeNode.left);

    if(treeNode != null)
      list.add(treeNode.val);

    if(treeNode.right != null)
      inOrderTraversal(list, treeNode.right);
  }

  public static void postOrderTraversal(List<Integer> list,TreeNode treeNode)
  {

    if(treeNode.left != null)
      postOrderTraversal(list, treeNode.left);

    if(treeNode.right != null)
      postOrderTraversal(list, treeNode.right);

    if(treeNode != null)
      list.add(treeNode.val);
  }
}
