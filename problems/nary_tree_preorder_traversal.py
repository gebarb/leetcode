"""589. N-ary Tree visited_nodes Traversal"""


from typing import List


class Node(object):
    # Definition for a Node.
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        visited_nodes = []
        if not root:
            return visited_nodes
        else:
            nodes = []
            nodes.append(root)
            while nodes:
                curr_node = nodes.pop()
                visited_nodes.append(curr_node.val)
                nodes.extend(curr_node.children[::-1])
            return visited_nodes
