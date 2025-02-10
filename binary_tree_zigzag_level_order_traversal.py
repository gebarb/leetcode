"""103. Binary Tree Zigzag Level Order Traversal"""

from typing import List, Optional
from collections import deque

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []

        levels = []
        visited = deque([root])
        zig = 0

        while visited:
            count = len(visited)
            level = []
            for _ in range(count):
                node = visited.popleft()
                if zig % 2 == 0:
                    level.append(node.val)
                else:
                    level.insert(0, node.val)

                if node.left:
                    visited.append(node.left)
                if node.right:
                    visited.append(node.right)

            levels.append(level)
            zig = not zig

        return levels
