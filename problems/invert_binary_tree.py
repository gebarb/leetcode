"""226. Invert Binary Tree"""


import collections
from typing import Optional


class TreeNode:
    # Definition for a binary tree node.
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        nodes = collections.deque([root])
        while nodes:
            curr_node = nodes.pop()
            if curr_node:
                nodes.append(curr_node.left)
                nodes.append(curr_node.right)
                curr_node.left, curr_node.right = curr_node.right, curr_node.left
        return root
