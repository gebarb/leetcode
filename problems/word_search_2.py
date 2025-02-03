"""212. Word Search II"""

from typing import List


class TrieNode:
    # Data Structure to build a tree of characters that map to each word
    def __init__(self):
        self.children = {}
        self.isWord = False
        self.references = 0

    def addWord(self, word: str):
        current = self
        current.references += 1
        for c in word:
            if c not in current.children:
                current.children[c] = TrieNode()
            current = current.children[c]
            current.references += 1
        current.isWord = True

    def removeWord(self, word: str):
        current = self
        current.references -= 1
        for c in word:
            if c in current.children:
                current = current.children[c]
                current.references -= 1


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = TrieNode()

        # Build word map
        for w in words:
            root.addWord(w)

        search, visited = set(), set()

        def dfs(r: int, c: int, node: TrieNode, word: str):
            # Check boundaries
            if r not in range(rows) or c not in range(cols):
                return
            # Check character existence
            elif board[r][c] not in node.children:
                return
            # Check node and references
            elif node.children[board[r][c]].references < 1:
                return
            elif (r, c) in visited:
                return

            visited.add((r, c))
            node = node.children[board[r][c]]
            word += board[r][c]
            if node.isWord:
                search.add(word)
                # Remove this word since it has already been found
                node.isWord = False
                root.removeWord(word)
            # Check each direction for next character(s)
            dfs(r + 1, c, node, word)
            dfs(r - 1, c, node, word)
            dfs(r, c + 1, node, word)
            dfs(r, c - 1, node, word)
            visited.remove((r, c))

        rows, cols = len(board), len(board[0])
        for row in range(len(board)):
            for col in range(len(board[0])):
                # Start with no word at the first character
                dfs(row, col, root, "")

        return list(search)
