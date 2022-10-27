"""733. Flood Fill"""


from typing import List


class Solution:

    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m, n = len(image), len(image[0])
        curr_color = image[sr][sc]
        if curr_color == color:
            return image
        else:
            def dfs(p, q):
                if image[p][q] == curr_color:
                    image[p][q] = color
                    if p >= 1:
                        dfs(p-1, q)
                    if p + 1 < m:
                        dfs(p + 1, q)
                    if q >= 1:
                        dfs(p, q-1)
                    if q + 1 < n:
                        dfs(p, q+1)
            dfs(sr, sc)
            return image
