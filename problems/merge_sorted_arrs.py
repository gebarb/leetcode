"""88. Merge Sorted Array"""

from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        nums1_end = m - 1
        nums2_end = n - 1
        merge_end = m + n - 1
        while nums1_end >= 0 and nums2_end >= 0:
            if nums1[nums1_end] > nums2[nums2_end]:
                nums1[merge_end] = nums1[nums1_end]
                nums1_end -= 1
            else:
                nums1[merge_end] = nums2[nums2_end]
                nums2_end -= 1
            merge_end -= 1
        while nums1_end >= 0:
            nums1[merge_end] = nums1[nums1_end]
            nums1_end -= 1
            merge_end -= 1
        while nums2_end >= 0:
            nums1[merge_end] = nums2[nums2_end]
            nums2_end -= 1
            merge_end -= 1
