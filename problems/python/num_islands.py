"""200. Number of Islands"""


from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])

        def dfs(p, q):
            if grid[p][q] == "1":
                grid[p][q] = "0"
                if p >= 1:
                    dfs(p-1, q)
                if p + 1 < m:
                    dfs(p + 1, q)
                if q >= 1:
                    dfs(p, q-1)
                if q + 1 < n:
                    dfs(p, q+1)
                return 1
            else:
                return 0

        return sum(dfs(i, j) for i in range(m) for j in range(n))
