/*
 * 167. Two Sum II - Input Array Is Sorted
 */

class Solution {

  public int[] twoSum(int[] nums, int target) {
    // Since nums is sorted, split array and test (left_val + right_val == target)
    // (Two Pointers)
    int begin = 0;
    int end = nums.length - 1;

    while (nums[begin] + nums[end] != target) {
      // Follow relative difference to increment idx
      if (nums[begin] + nums[end] < target) {
        begin++;
      } else {
        end--;
      }
    }

    return new int[] { begin + 1, end + 1 }; // Instantiate array with list
  }
}
