"""189. Rotate Array"""

from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        # Rotating k^n times is the same as rotating k times
        k %= length

        # Iterative
        # rotated = [0] * length
        # for i in range(length):
        #     rotated[(i + k) % length] = nums[i]
        # for i in range(length):
        #     nums[i] = rotated[i]

        # Rotating to the right is the same as
        # reversing both the elements before k and the elements after k
        # in distinct groups
        # if k != 0:
        #     # Reverse each group of elements
        #     nums[:k], nums[k:] = nums[-k:], nums[:-k]

        def reverse(i: int, x: int):
            while i < x:
                nums[i], nums[x] = nums[x], nums[i]
                i += 1
                x -= 1
         # Reverse the entire array
        reverse(0, length - 1)
        # Reverse the elements before k
        reverse(0, k - 1)
        # Reverse the remaining elements after k
        reverse(k, length - 1)
