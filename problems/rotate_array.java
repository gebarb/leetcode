/*
 * 189. Rotate Array
 */
class Solution {

  public void rotate(int[] nums, int k) {
    // BRUTE FORCE
    // int[] nums_right_rotate = new int[nums.length];
    // for (int i = 0; i < nums.length; i++) {
    //   nums_right_rotate[(i + k) % nums.length] = nums[i];
    // }
    // for (int i = 0; i < nums_right_rotate.length; i++) {
    //   nums[i] = nums_right_rotate[i];
    // }

    // TWO POINTER
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  public void reverse(int[] nums_rotate_right, int start, int end) {
    while (start < end) {
      int tmp = nums_rotate_right[start];
      nums_rotate_right[start] = nums_rotate_right[end];
      nums_rotate_right[end] = tmp;
      start++;
      end--;
    }
  }
}
