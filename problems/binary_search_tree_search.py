"""700. Search in a Binary Search Tree"""

from typing import Optional


class TreeNode:
    # Definition for a binary tree node.
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if root == None or root.val == val:
            return root
        else:
            if root.val < val:
                return self.searchBST(root.right, val)
            else:
                return self.searchBST(root.left, val)
