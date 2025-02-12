"""300. Longest Increasing Subsequence"""

from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        l = len(nums)

        sequences = [1] * l
        for i in range(1, l):
            for j in range(i):
                if nums[i] > nums[j]:
                    sequences[i] = max(sequences[i], sequences[j] + 1)

        return max(sequences)
