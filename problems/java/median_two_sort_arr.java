/*
 * 4. Median of Two Sorted Arrays
 */

class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int i = 0;
    int tail = nums1.length;
    while (i <= tail) {
      int partition1 = (i + tail) / 2;
      int partition2 = (nums1.length + nums2.length + 1) / 2 - partition1;
      int maxLeft1 = partition1 == 0
        ? Integer.MIN_VALUE
        : nums1[partition1 - 1];
      int minRight1 = partition1 == nums1.length
        ? Integer.MAX_VALUE
        : nums1[partition1];
      int maxLeft2 = partition2 == 0
        ? Integer.MIN_VALUE
        : nums2[partition2 - 1];
      int minRight2 = partition2 == nums2.length
        ? Integer.MAX_VALUE
        : nums2[partition2];
      if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
        if ((nums1.length + nums2.length) % 2 == 0) {
          return (
            (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) /
            2.0
          );
        } else {
          return Math.max(maxLeft1, maxLeft2);
        }
      } else if (maxLeft1 > minRight2) {
        tail = partition1 - 1;
      } else {
        i = partition1 + 1;
      }
    }
    return 0;
  }
}
