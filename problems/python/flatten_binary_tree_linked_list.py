"""114. Flatten Binary Tree to Linked List"""

from typing import Optional
from collections import deque

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return root

        visited = deque([root])

        while visited:
            node = visited.pop()
            if node.right:
                visited.append(node.right)
            if node.left:
                visited.append(node.left)
            if visited:
                node.right = visited[-1]
            node.left = None
