/*
 * 404. Sum of Left Leaves
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

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int sum = 0;
    Stack<TreeNode> visited = new Stack<TreeNode>();
    visited.push(root);

    while (!visited.empty()) {
      TreeNode node = visited.pop();
      // If Left Child exists
      if (node.left != null) {
        // Check if Left Child is a Leaf
        if ((node.left.left == null) && (node.left.right == null)) {
          sum += node.left.val;
        }
        // If not, move to Left Child and repeat
        else {
          visited.push(node.left);
        }
      }
      // If Right Child exists
      if (node.right != null) {
        // Process any of its children
        if ((node.right.left != null) || (node.right.right) != null) {
          visited.push(node.right);
        }
      }
    }
    return sum;
  }
}
