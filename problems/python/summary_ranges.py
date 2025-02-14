"""
228. Summary Ranges

You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
nums is sorted in ascending order.
"""

from typing import List


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        ranges = []
        if not nums:
            return ranges

        n = len(nums)
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
