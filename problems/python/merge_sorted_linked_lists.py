"""21. Merge Two Sorted Lists"""

from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if (list1 == None):
            return list2
        elif (list2 == None):
            return list1
        elif (list1.val < list2.val):
            list1.next = Solution.mergeTwoLists(self, list1.next, list2)
            return list1
        else:
            list2.next = Solution.mergeTwoLists(self, list1, list2.next)
            return list2
