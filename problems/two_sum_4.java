/*
 * 653. Two Sum IV - Input is a BST
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

  public boolean findTarget(TreeNode root, int k) {
    return dfs(root, root, k);
  }

  public boolean dfs(TreeNode root, TreeNode curr_node, int k) {
    if (curr_node == null) {
      return false;
    }
    return (
      search(root, curr_node, k - curr_node.val) ||
      dfs(root, curr_node.left, k) ||
      dfs(root, curr_node.right, k)
    );
  }

  public boolean search(TreeNode root, TreeNode curr_node, int val) {
    if (root == null) {
      return false;
    }
    return (
      (root.val == val) &&
      (root != curr_node) ||
      (root.val < val) &&
      search(root.right, curr_node, val) ||
      (root.val > val) &&
      search(root.left, curr_node, val)
    );
  }
}
