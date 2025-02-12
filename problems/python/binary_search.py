"""704. Binary Search"""


from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # Assume nums is sorted
        lower_half = 0
        upper_half = len(nums) - 1
        while lower_half <= upper_half:
            midpoint = (lower_half + upper_half) // 2
            if nums[midpoint] == target:
                return midpoint
            elif nums[midpoint] > target:
                upper_half = midpoint-1
            else:
                lower_half = midpoint+1
        return -1
