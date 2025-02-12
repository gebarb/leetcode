/*
 * 222. Count Complete Tree Nodes
 */
// Definition for a binary tree node.
public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    // All Subtrees of a Complete Tree are also Complete
    TreeNode left = root.left;
    TreeNode right = root.right;
    int l_count = 1;
    int r_count = 1;

    while (left != null) {
      left = left.left;
      l_count++;
    }

    while (right != null) {
      right = right.right;
      r_count++;
    }

    if (l_count == r_count) {
      return (int) Math.pow(2, l_count) - 1;
    } else {
      return 1 + countNodes(root.left) + countNodes(root.right);
    }
  }
}
