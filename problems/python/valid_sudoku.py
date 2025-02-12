"""36. Valid Sudoku"""

from typing import List


class Solution(object):
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            row = {}
            for j in range(9):
                if board[i][j] == '.':
                    pass
                elif board[i][j] in row:
                    return False
                else:
                    row[board[i][j]] = True
        for j in range(9):
            col = {}
            for i in range(9):
                if board[i][j] == '.':
                    pass
                elif board[i][j] in col:
                    return False
                else:
                    col[board[i][j]] = True
        for k in range(0, 9, 3):
            for l in range(0, 9, 3):
                block = {}
                for i in range(l, l + 3):
                    for j in range(k, k + 3):
                        if board[i][j] == '.':
                            pass
                        elif board[i][j] in block:
                            return False
                        else:
                            block[board[i][j]] = True
        return True
