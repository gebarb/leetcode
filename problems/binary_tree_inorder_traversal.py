"""94. Binary Tree Inorder Traversal"""


from typing import List, Optional


class TreeNode:
    # Definition for a binary tree node.
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        visited_nodes = []
        if not root:
            return visited_nodes
        else:
            nodes = []
            curr_node = root
            while curr_node or nodes:
                while curr_node:
                    nodes.append(curr_node)
                    curr_node = curr_node.left
                curr_node = nodes.pop()
                visited_nodes.append(curr_node.val)
                curr_node = curr_node.right
            return visited_nodes
