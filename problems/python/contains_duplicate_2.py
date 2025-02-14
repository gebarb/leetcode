"""219. Contains DUplicate II"""

from typing import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        positions = {}

        for i, n in enumerate(nums):
            if n in positions and i - positions[n] <= k:
                return True
            # Since abs(i - j) <= k, can ignore past index values
            positions[n] = i

        return False
