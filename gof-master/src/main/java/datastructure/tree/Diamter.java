package datastructure.tree;

import org.junit.Test;

/**
 * @author Michael Liu
 */
public class Diamter
{



  /**
   *
   O(n^2)
   */
  public static int getDiameter2(TreeNode root) {
    if (root == null)
      return 0;

    int rootDiameter = getHeight(root.left) + getHeight(root.right) + 1;
    int leftDiameter = getDiameter2(root.left);
    int rightDiameter = getDiameter2(root.right);

    return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
  }

  public static int getHeight(TreeNode root) {
    if (root == null)
      return 0;

    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
  /**
   *  O(n) solution
   */
  public static int[] getDiameter(TreeNode root) {
    int[] result = new int[]{0,0};    //1st element: diameter, 2nd: height
    if (root == null)  return result;
    int[] leftResult = getDiameter(root.left);
    int[] rightResult = getDiameter(root.right);
    int height = Math.max(leftResult[1], rightResult[1]) + 1;
    int rootDiameter = leftResult[1] + rightResult[1] + 1;
    int leftDiameter = leftResult[0];
    int rightDiameter = rightResult[0];
    result[0] = Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    result[1] = height;

    return result;
  }

  @Test
  public void rootHeight()
  {

  }
}
