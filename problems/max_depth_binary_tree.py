"""104. Maximum Depth of Binary Tree"""


import collections
from typing import Optional


class TreeNode:
    # Definition for a binary tree node.
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        ## Level Order Traversal
        depth = 0
        if not root:
            return 0
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
                depth += 1
            return depth
