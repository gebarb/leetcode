"""146. LRU Cache"""


class Node:
    def __init__(self, key: int, val: int):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None


class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)
        # Initialize Doubly Linked List
        self.head.next = self.tail
        self.tail.prev = self.head
        self.cache = {}

    def addNode(self, newNode: Node):
        # Append this node to the front of the doubly linked list
        node = self.head.next
        newNode.next = node
        newNode.prev = self.head
        self.head.next = newNode
        node.prev = newNode

    def deleteNode(self, delNode: Node):
        # Delete this node from the doubly linked list
        prev = delNode.prev
        nxt = delNode.next
        prev.next = nxt
        nxt.prev = prev

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache.pop(key)
            answer = node.val
            self.deleteNode(node)
            self.addNode(node)
            self.cache[key] = self.head.next
            return answer
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            curr = self.cache.pop(key)
            self.deleteNode(curr)
        # Capacity Reached, pop the end of the doubly linked list
        if len(self.cache) == self.capacity:
            del self.cache[self.tail.prev.key]
            self.deleteNode(self.tail.prev)

        node = Node(key, value)
        self.addNode(node)
        self.cache[key] = self.head.next

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
