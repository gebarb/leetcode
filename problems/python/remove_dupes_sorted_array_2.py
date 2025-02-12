"""80. Remove Duplicates from Sorted Array II"""

from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        l = len(nums)
        ptr = min(2, l)
        for i in range(2, l):
            if nums[i] != nums[ptr - 2]:
                nums[ptr] = nums[i]
                ptr += 1

        return ptr
