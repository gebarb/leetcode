"""
199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
"""

from collections import deque
from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        values = []
        visited = deque([root])
        level = 0

        while visited:
            values.append([])

            for _ in range(len(visited)):
                node = visited.popleft()
                values[level].append(node.val)
                if node.left:
                    visited.append(node.left)
                if node.right:
                    visited.append(node.right)
            level += 1

        right = [l[-1] for l in values]
        return right
