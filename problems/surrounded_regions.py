"""130. Surrounded Regions"""

from typing import List


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])

        def dfs(i: int, j: int):
            # Mark this cell as checked
            board[i][j] = "?"
            directions = [(i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)]
            for x, y in directions:
                # If not a boundary cell
                if 0 <= x < rows and 0 <= y < cols:
                    # And cell value is O
                    if board[x][y] == 'O':
                        # Negate this entire region
                        dfs(x, y)

        # DFS from 0's of the border determines regions that CAN'T be surrounded
        for i in range(rows):
            if board[i][0] == 'O':
                dfs(i, 0)
            if board[i][cols - 1] == 'O':
                dfs(i, cols - 1)
        for j in range(cols):
            if board[0][j] == 'O':
                dfs(0, j)
            if board[rows - 1][j] == 'O':
                dfs(rows - 1, j)
        # Check each cell of the board
        for i in range(rows):
            for j in range(cols):
                # This region can be surrounded
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                # Revert negated cell
                elif board[i][j] == '?':
                    board[i][j] = 'O'
