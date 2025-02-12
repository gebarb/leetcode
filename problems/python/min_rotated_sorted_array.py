"""153. Find Minimum in Rotated Sorted Array"""

from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            # Binary Search
            mid = (left + right) // 2

            # Sorted array was rotated, so minimum is in the left half
            if nums[mid] <= nums[right]:
                right = mid
            else:
                left = mid + 1

        return nums[left]
