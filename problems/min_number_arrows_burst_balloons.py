"""452. Minimum Number of Arrows to Burst Balloons"""

import math
from typing import List


class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        # Ignoring Y, need to get the minimum number of ranges
        arrows = 0

        # Maintain where the last arrow was shot
        arrow = -math.inf
        for point in sorted(points, key=lambda p: p[1]):
            if point[0] > arrow:
                arrows += 1
                arrow = point[1]

        return arrows
