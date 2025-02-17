"""

15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Constraints:

3 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5

"""

from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        triplets = []

        # Sort nums to make pointer direction simpler
        nums.sort()

        # For each number in nums
        for i in range(n):
            # Avoid duplicates by skipping nums that are the same
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            # 2 Pointers at begin/end for subarray of remaining nums
            j = i + 1
            k = n - 1

            # Iterate subarray
            while j < k:
                # Calculate 3Sum
                total = nums[i] + nums[j] + nums[k]

                # If positive, then shorten end of subarray
                if total > 0:
                    k -= 1
                # If negative, shorten begin of subarraay
                elif total < 0:
                    j += 1
                # Valid triplet, short begin of subarray, skipping duplicates
                else:
                    triplets.append([nums[i], nums[j], nums[k]])
                    j += 1

                    while nums[j] == nums[j - 1] and j < k:
                        j += 1

        return triplets
