"""
137. Single Number II

Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Constraints:

1 <= nums.length <= 3 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
Each element in nums appears exactly three times except for one element which appears once.

"""

from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # Naive approach - keep count of each appearance
        # counts = {}

        # for n in nums:
        #     counts[n] = counts.get(n, 0) + 1

        # return next(iter([n for n, c in counts.items() if c == 1]))

        # Bit Manipulation - XOR

        # Number of bits that have appeared once, twice
        ones, twos = 0, 0

        for n in nums:
            # ^ XOR current number with previous value to toggle bits that have appeared an odd number of times
            # ~ negates bits, removing those that appeared x times
            # & AND ensures only bits that have appeared x times are retained
            ones ^= (n & ~twos)
            twos ^= (n & ~ones)

        return ones
