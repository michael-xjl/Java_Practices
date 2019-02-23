package datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Michael Liu
 */
public class TreeUtilityTest
{

  public static void main(String[] args)
  {
    Integer[] treeA = { 1, 2, 3, 4, 5, null, 2, null, 3 };
    final int[] power = TreeUtility.getPower(treeA.length);
    System.out.println(Arrays.toString(power));

    Integer[] a = { 1 }; // one time initialize
    TreeUtility treeUtility = new TreeUtility(a);
    TreeNode node = treeUtility.getNode2(0, 0);
    System.out.println(TreeUtility.getLevel(node));

    a = new Integer[] { 1, 2, 3 };
    treeUtility = new TreeUtility(a);
    node = treeUtility.getNode2(0, 0);
    System.out.println(TreeUtility.getLevel(node));
    //
    a = new Integer[] { 1, 2, 3, 4, 5 };
    treeUtility = new TreeUtility(a);
    node = treeUtility.getNode2(0, 0);
    System.out.println(TreeUtility.getLevel(node));

    a = new Integer[] { 1, 2, 3, 4, 5, null, 6 };
    treeUtility = new TreeUtility(a);
    node = treeUtility.getNode2(0, 0);

    System.out.println(TreeUtility.getLevel(node));

    a = new Integer[] { 1, 2, 3, 4, 5, null, 6, 7, 8, 9, 10, null, 11 };
    treeUtility = new TreeUtility(a);
    node = treeUtility.getNode2(0, 0);

    final int level = TreeUtility.getLevel(node);
    System.out.println("Tree Height:  " + level);

    List<Integer> sortOrder = new ArrayList<>();
    TreeUtility.preOrderTraversal(sortOrder, node);
    System.out.println("Pre Order: " + sortOrder);

    sortOrder = new ArrayList<>();
    TreeUtility.inOrderTraversal(sortOrder, node);
    System.out.println("In Order: " + sortOrder);

    sortOrder = new ArrayList<>();
    TreeUtility.postOrderTraversal(sortOrder, node);
    System.out.println("Post Order: " + sortOrder);

    sortOrder = new ArrayList<>();
    TreeUtility.upDownTraversal(sortOrder, node);
    System.out.println("UpDown Order: " + sortOrder);

    sortOrder = new ArrayList<>();
    TreeUtility.downUpTraversal(sortOrder, node);
    System.out.println("DownUp Order: " + sortOrder);
  }

  public void testTopDownTraversal()
  {

  }

}
