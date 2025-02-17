
"""
909. Snakes and Ladders

You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 are not the starting points of any snake or ladder.

Note that you only take a snake or ladder at most once per dice roll. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of dice rolls required to reach the square n2. If it is not possible to reach the square, return -1.

Constraints:

n == board.length == board[i].length
2 <= n <= 20
board[i][j] is either -1 or in the range [1, n^].
The squares labeled 1 and n^2 are not the starting points of any snake or ladder.

"""


from collections import deque
from typing import List


class Solution:

    def roll(self, n: int, k: int):
        i = k - 1
        r = n - i // n - 1
        if (i // n) % 2 == 1:
            c = n - i % n - 1
        else:
            c = i % n

        return r, c

    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)
        sq = n ** 2

        if n < 3:
            return 1

        moves = set()
        visited = deque([(1, 0)])

        while visited:
            label, step = visited.popleft()
            r, c = self.roll(n, label)
            if board[r][c] != -1:
                label = board[r][c]
            if label == sq:
                return step

            for i in range(1, 7):
                nxt = label + i
                if nxt <= sq and nxt not in moves:
                    moves.add(nxt)
                    visited.append((nxt, step + 1))

        return -1
