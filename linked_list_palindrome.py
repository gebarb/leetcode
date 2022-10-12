"""LeetCode 234. Linked List Palindrome"""

from typing import Optional

# Definition for singly-linked list.


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        ptr = snail = head
        buffer = []

        while ptr and ptr.next:
            buffer.append(ptr.val)
            snail = snail.next
            ptr = ptr.next.next
        if ptr:
            snail = snail.next
        while snail:
            val = buffer.pop()
            if val != snail.val:
                return False
            snail = snail.next
        return True
