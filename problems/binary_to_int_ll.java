/*
 * 1290. Convert Binary Number in a Linked List to Integer
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

  public int getDecimalValue(ListNode head) {
    int value = head.val;
    while (head.next != null) {
      // Shift to next bit and add the value to the total (Bitwise OR)
      value = (value << 1) | head.next.val;
      head = head.next;
    }
    return value;
  }
}
