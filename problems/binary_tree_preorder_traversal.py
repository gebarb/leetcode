"""144. Binary Tree Preorder Traversal"""


import collections
from typing import List, Optional


class TreeNode:
    # Definition for a binary tree node.
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        visited_nodes = []
        if not root:
            return visited_nodes
        else:
            nodes = collections.deque([])
            nodes.append(root)
            while nodes:
                curr_node = nodes.pop()
                visited_nodes.append(curr_node.val)
                if curr_node.right:
                    nodes.append(curr_node.right)
                if curr_node.left:
                    nodes.append(curr_node.left)
            return visited_nodes
