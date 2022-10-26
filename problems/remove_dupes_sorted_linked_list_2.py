"""82. Remove Duplicates from Sorted List II"""

from typing import Optional

# Definition for singly-linked list.


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        ret = ListNode(0, head)
        prev = ret
        ptr = head
        while ptr:
            while ptr.next and ptr.val == ptr.next.val:
                ptr = ptr.next
            if prev.next == ptr:
                prev = ptr
            else:
                prev.next = ptr.next
            ptr = ptr.next
        return ret.next
