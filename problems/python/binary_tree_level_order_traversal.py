"""102. Binary Tree Level Order Traversal"""

# Definition for a binary tree node.


import collections
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        visited_nodes = []
        if not root:
            return visited_nodes
        else:
            nodes = collections.deque([root])
            while nodes:
                levels = len(nodes)
                curr_level = []
                while levels > 0:
                    curr_node = nodes.popleft()
                    curr_level.append(curr_node.val)
                    if (curr_node.left):
                        nodes.append(curr_node.left)
                    if (curr_node.right):
                        nodes.append(curr_node.right)
                    levels -= 1
                visited_nodes.append(curr_level)
            return visited_nodes
