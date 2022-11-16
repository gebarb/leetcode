/*
 * 116. Populating Next Right Pointers in Each Node
 */

// Definition for a Node.
class Node {

  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}

class Solution {

  public Node connect(Node root) {
    if (root == null) {
      return root;
    }
    Queue<Node> to_connect = new LinkedList<>();
    to_connect.offer(root);
    while (!to_connect.isEmpty()) {
      Node right_node = null;
      for (int i = to_connect.size(); i > 0; i--) {
        Node curr_node = to_connect.poll();
        curr_node.next = right_node;
        right_node = curr_node;
        // Unless this is the last level of Perfect Binary Tree
        if (curr_node.right != null) {
          to_connect.offer(curr_node.right);
          to_connect.offer(curr_node.left);
        }
      }
    }
    return root;
  }
}
