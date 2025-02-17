"""
11. Container With Most Water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Constraints:

n == height.length
2 <= n <= 10^5
0 <= height[i] <= 10^4

"""

from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height)
        left = 0
        right = n - 1
        maximum = 0

        while left < right:
            h = min(height[left], height[right])
            area = h * (right - left)

            maximum = max(area, maximum)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return maximum
