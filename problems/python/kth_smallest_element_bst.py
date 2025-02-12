"""230. Kth Smallest Element in a BST"""

from collections import deque
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        values = []
        node = root
        visited = deque()

        # In-Order Traversal of Binary Search Tree gives values in sorted order
        while node or visited:
            if node:
                visited.append(node)
                node = node.left
            else:
                node = visited.pop()
                values.append(node.val)
                node = node.right

        return values[k - 1]
