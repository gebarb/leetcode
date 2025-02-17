"""
128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

"""

from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        distinct = set(nums)
        longest = 0

        for n in distinct:
            if n - 1 not in distinct:
                length = 1

                while n + length in distinct:
                    length += 1

                longest = max(longest, length)

        return longest
