/*
 * 19. Remove Nth Node From End of List
 */

// Definition for singly-linked list.
public class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    // Two pointers - ptr and snail
    ListNode snail = head;
    ListNode ptr = head;
    // Move ptr pointer n steps ahead
    for (int i = 0; i < n; i++) {
      if (ptr.next == null) {
        // If n is equal to the number of nodes, delete the head node
        if (i == n - 1) {
          head = head.next;
        }
        return head;
      }
      ptr = ptr.next;
    }
    // Loop until we reach to the end.
    // Move both pointers
    while (ptr.next != null) {
      snail = snail.next;
      ptr = ptr.next;
    }
    // Remove nth node from end
    if (snail.next != null) {
      snail.next = snail.next.next;
    }
    return head;
  }
}
