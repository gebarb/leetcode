/*
 * 283. Move Zeroes
 */

class Solution {

  public void moveZeroes(int[] nums) {
    int nonzero_idx = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[nonzero_idx] = nums[i];
        nonzero_idx++;
      }
    }

    int zero_idx = nonzero_idx;
    while (zero_idx < nums.length) {
      nums[zero_idx] = 0;
      zero_idx++;
    }
  }
}
