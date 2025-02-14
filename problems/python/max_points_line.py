"""
149. Max Points on a Line

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

Constraints:

1 <= points.length <= 300
points[i].length == 2
-10^4 <= xi, yi <= 10^4
All the points are unique.
"""

from typing import List

class Solution:
    def slope(self, a: List[int], b: List[int]) -> int:
        if a[0] == b[0]:
            return float('inf')

        return (b[1] - a[1]) / (b[0] - a[0])

    def maxPoints(self, points: List[List[int]]) -> int:
        l = len(points)

        if l <= 2:
            return l

        maximum = 0
        for i in range(l):
            slopes = {float('-inf'): 0}
            for j in range(i + 1, l):
                if i != j:
                    m = self.slope(points[i], points[j])
                    slopes[m] = slopes.get(m, 1) + 1

            maximum = max(maximum, max(slopes.values()))

        return maximum
