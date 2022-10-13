"""LeetCode 976. Largest Permiter Triangle"""

from typing import List


class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        lrg = 0
        nums.sort(reverse=True)
        for i in range(0, len(nums)-2):
            if nums[i] < (nums[i+1] + nums[i+2]):
                lrg = max(lrg, nums[i] + nums[i+1] + nums[i+2])
                break
        if lrg == 0:
            return 0
        else:
            return lrg
