"""835. Image Overlap"""

import collections
from typing import List


class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:

        n = len(img1)

        def get_ones(img):
            ret = []
            for i in range(n):
                for j in range(n):
                    if img[i][j] == 1:
                        ret.append((i, j))
            return ret

        transforms = collections.defaultdict(int)
        overlaps = 0
        img1_one_cells = get_ones(img1)
        img2_one_cells = get_ones(img2)

        for (p, q) in img1_one_cells:
            for (r, s) in img2_one_cells:
                vectors = (r - p, s - q)
                transforms[vectors] += 1
                overlaps = max(overlaps, transforms[vectors])

        return overlaps
