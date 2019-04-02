package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Michael Liu
 */
public class Mirror
{
  public TreeNode mirrorRecursion(TreeNode root) {
    if (root == null)
      return null;
    TreeNode curr = null;
    if(root != null) {
      mirrorRecursion(root.left);
      mirrorRecursion(root.right);
      //swap node pointers between left and right nodes
      curr = root.left;
      root.left = root.right;
      root.right = curr;
    }
    return root;
  }

  public TreeNode mirrorItr1(TreeNode root) {

    if(root == null) return null;

    TreeNode mirror = new TreeNode(root.val);

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);


    Queue<TreeNode> queue2 = new LinkedList<>();
    queue2.add(mirror);

    while(!queue.isEmpty())
    {
      TreeNode[] nodes = queue.toArray(new TreeNode[0]);
      queue.clear();

      TreeNode[] nodes2 = queue2.toArray(new TreeNode[0]);
      queue2.clear();

      for(int i = 0 ; i < nodes.length; i++)
      {
        TreeNode node = nodes[i];
        TreeNode node2 = nodes2[i];

        if(node.right != null)
        {
          TreeNode child = new TreeNode(node.right.val);
          queue.add(node.right);
          queue2.add(child);
          node2.left = child;
        }
        if(node.left != null)
        {
          TreeNode child = new TreeNode(node.left.val);
          queue.add(node.left);
          queue2.add(child);
          node2.right = child;
        }

      }


    }

    return mirror;





  }

  public TreeNode mirrorItr2(TreeNode root) {
    if(root == null){
      return null;
    }
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    Queue<TreeNode> m = new LinkedList<TreeNode>();
    TreeNode newhead = new TreeNode(root.val);
    q.add(root);
    m.add(newhead);
    while(!q.isEmpty()){
      TreeNode cur = q.poll();
      TreeNode newCur = m.poll();
      if(cur == null || newCur == null){
        continue;
      }
      if(cur.left == null){
        newCur.right = null;
      }
      else{
        newCur.right = new TreeNode(cur.left.val);
      }
      if(cur.right == null){
        newCur.left = null;
      }
      else{
        newCur.left = new TreeNode(cur.right.val);
      }
      q.add(cur.right);
      q.add(cur.left);
      m.add(newCur.left);
      m.add(newCur.right);
    }
    return newhead;
  }
}
