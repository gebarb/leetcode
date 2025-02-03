"""117. Populating Next Right Pointers in Each Node II"""

# Definition for a Node.


class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root

        node = Node(-1)
        """Level Order Traversal"""
        # visited = deque([root])
        # while visited:
        #     prev = node
        #     for i in range(len(visited)):
        #         current = visited.popleft()
        #         if current.left:
        #             visited.append(current.left)
        #             prev.next = current.left
        #             prev = prev.next
        #         if current.right:
        #             visited.append(current.right)
        #             prev.next = current.right
        #             prev = prev.next

        """Optimized with constant space"""
        curr = root
        head = root

        while head:
            curr = head
            prev = node
            while curr:
                if curr.left:
                    prev.next = curr.left
                    prev = prev.next
                if curr.right:
                    prev.next = curr.right
                    prev = prev.next
                curr = curr.next
            head = node.next
            node.next = None

        return root
