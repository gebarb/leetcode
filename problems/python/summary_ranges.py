"""228. Summary Ranges"""

from typing import List


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        n = len(nums)
        ranges = []

        start = nums[0]
        for i in range(1, n + 1):
            if i == n or nums[i] != nums[i - 1] + 1:
                # If the number is in a self-range
                if start == nums[i - 1]:
                    ranges.append(str(start))
                # This is the end of a range
                else:
                    ranges.append(f"{start}->{nums[i - 1]}")
                # Shift start to the next range
                if i < len(nums):
                    start = nums[i]

        return ranges
