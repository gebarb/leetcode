"""55. Jump Game """

from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        end = n - 1

        # Reverse-Engineer jump seqeunce by going from end to begin
        for i in range(n - 2, -1, -1):
            # If the current end was validly able to be reached from nums[i]
            if i + nums[i] >= end:
                # Move the end to the the current index
                end = i
        # If a full path from end to begin was able to be built
        if end == 0:
            return True

        return False
