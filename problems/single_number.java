/*
 * 136. Single Number
 */

class Solution {

  public int singleNumber(int[] nums) {
    int single = 0;
    for (int i = 0; i < nums.length; i++) {
      // 0 XOR N = N
      // N XOR N = 0
      single ^= nums[i];
    }
    return single;
  }
}
