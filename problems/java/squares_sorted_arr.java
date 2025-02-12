/*
 * 977. Squares of a Sorted Array
 */
class Solution {

  public int[] sortedSquares(int[] nums) {
    int length = nums.length;
    if (length == 0) {
      return new int[0];
    }
    int[] nums_sq = new int[length];
    int j = 0, k = length - 1;
    for (int i = length - 1; i >= 0; i--) {
      int start = nums[j] * nums[j];
      int end = nums[k] * nums[k];
      if (start > end) {
        nums_sq[i] = start;
        j++;
      } else {
        nums_sq[i] = end;
        k--;
      }
    }
    return nums_sq;
  }
}
