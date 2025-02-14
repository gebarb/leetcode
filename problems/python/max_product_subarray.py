"""
152. Maximum Product Subarray

Given an integer array nums, find a subarray that has the largest product, and return the product.

Constraints:

1 <= nums.length <= 2 * 10^4
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
"""

from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0
        product = prev_max = prev_min = nums[0]

        for i in range(1, len(nums)):
            curr_min = min(prev_max * nums[i], prev_min * nums[i], nums[i])
            curr_max = max(prev_max * nums[i], prev_min * nums[i], nums[i])

            prev_min, prev_max = curr_min, curr_max

            product = max(curr_max, product)

        return product
