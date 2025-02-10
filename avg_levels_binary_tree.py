"""637. Average of Levles in Binary Tree"""

from typing import List, Optional
from collections import deque

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        if root is None:
            return root

        levels = []
        visited = deque([root])

        while visited:
            total, count = 0, len(visited)
            for _ in range(count):
                node = visited.popleft()
                total += node.val
                if node.left:
                    visited.append(node.left)
                if node.right:
                    visited.append(node.right)
            levels.append(total / count)

        return levels
