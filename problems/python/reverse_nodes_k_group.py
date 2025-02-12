"""25. Reverse Nodes in k-Group"""

from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k == 1 or not head:
            return head

        node = ListNode(0, head)
        prev = node
        curr = head

        # Total number of nodes in list
        count = 0
        while curr:
            count += 1
            curr = curr.next

        # Reverse subsets of k nodes at a time
        while count >= k:
            curr = prev.next
            nxt = curr.next

            # Reverse k nodes
            for i in range(1, k):
                curr.next, nxt.next = nxt.next, prev.next
                prev.next = nxt
                nxt = curr.next

            prev = curr
            count -= k

        return node.next
