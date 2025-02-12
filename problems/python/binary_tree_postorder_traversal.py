"""145. Binary Tree Postorder Traversal"""


import collections
from typing import List, Optional


class TreeNode:
    # Definition for a binary tree node.
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        visited_nodes = []
        if not root:
            return visited_nodes
        else:
            nodes = collections.deque([])
            nodes.append(root)
            while nodes:
                curr_node = nodes.pop()
                visited_nodes.append(curr_node.val)
                if curr_node.left:
                    nodes.append(curr_node.left)
                if curr_node.right:
                    nodes.append(curr_node.right)
            return visited_nodes[::-1]
