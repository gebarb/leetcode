/*
 * 143. Reorder List
 */

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */

/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function (head) {
  if (!head || !head.next) {
    return;
  }

  let slow = head;
  let fast = head;
  // Iterate through list, at regular and double rate to determine midpoint
  while (fast.next && fast.next.next) {
    slow = slow.next;
    fast = fast.next.next;
  }

  let prev = null;
  let curr = slow.next;
  // Reverse the 2nd half
  while (curr) {
    let nextNode = curr.next;
    curr.next = prev;
    prev = curr;
    curr = nextNode;
  }

  slow.next = null;
  let reOrder1 = head;
  let reOrder2 = prev;
  // Merge the 1st half of original list with the reverse half of the 2nd list, alternating nodes
  while (reOrder1 && reOrder2) {n
    let reOrderNext1 = reOrder1.next;
    let reOrderNext2 = reOrder2.next;
    reOrder1.next = reOrder2;
    reOrder2.next = reOrderNext1;
    reOrder1 = reOrderNext1;
    reOrder2 = reOrderNext2;
  }
};
