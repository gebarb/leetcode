"""
100. Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
"""

from typing import Optional

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        # Base NULL Case
        if not p and not q:
            return True

        # If this node has the same value in each tree
        if p and q and p.val == q.val:
            # Recursively Check left and right
            return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)

        return False
