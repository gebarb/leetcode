"""169. Majority Element"""

from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        return nums[len(nums) // 2]

        # Keep Count
        # l = len(nums)
        # counts = {}

        # for n in nums:
        #     count = counts.get(n, 0)
        #     if count + 1 > l // 2:
        #         return n
        #     counts.update({
        #         n: count + 1
        #     })
