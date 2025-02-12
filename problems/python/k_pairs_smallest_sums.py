"""373. Find K Pairs with Smallest Sums"""

from heapq import heappop, heappush
from typing import List


class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        n, m = len(nums1), len(nums2)
        sums = []
        pairs = []

        # Initialize pairs priority queue
        for i in range(min(k, n)):
            heappush(sums, [nums1[i] + nums2[0], 0])

        # Pop smallest pairs from the priority queue
        while k > 0 and sums:
            pair = heappop(sums)
            # Get the smallest sum and index of nums2 element
            smallest, position = pair[0], pair[1]

            # Add pair to the result
            s = smallest - nums2[position]
            pairs.append([s, nums2[position]])

            # If nums2 has more elements, push them into the priority queue of smallest sums
            if position + 1 < m:
                heappush(sums, [s + nums2[position + 1], position + 1])

            k -= 1

        return pairs
